package com.learn2code.vehicle.api.search.service.impl;

import com.learn2code.vehicle.api.search.exception.VehicleDetailsNotFound;
import com.learn2code.vehicle.api.search.payload.ClientVehicleDetailsDto;
import com.learn2code.vehicle.api.search.payload.VehicleDetailDto;
import com.learn2code.vehicle.api.search.payload.VehicleDetailPayLoad;
import com.learn2code.vehicle.api.search.payload.VehicleMarketPriceDto;
import com.learn2code.vehicle.api.search.service.VehicleDetailsService;
import com.learn2code.vehicle.api.search.service.VehicleMarketPriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleDetailsServiceImpl implements VehicleDetailsService {

    private RestTemplate restTemplate;

    private VehicleMarketPriceService vehicleMarketPriceService;


    @Override
    public List<ClientVehicleDetailsDto> getAllVehicleDetails() {

        VehicleDetailPayLoad vehicleDetailPayLoad = restTemplate.getForObject(
                "http://localhost:9090/api/v1/vehicle-details",
                VehicleDetailPayLoad.class);

        /*List<ClientVehicleDetailsDto> clientVehicleDetailsList =new ArrayList<>();
        ClientVehicleDetailsDto clientVehicleDetailsDto = null;
        for(VehicleDetailDto vehicleDetailDto : vehicleDetailPayLoad.getVehicleDetailsList()) {
            clientVehicleDetailsList.add(mapClientVehicleDetailsDtoFromVehicleDetailsDto(vehicleDetailDto));
        }
        return clientVehicleDetailsList; */
        List<ClientVehicleDetailsDto> clientVehicleDetailsList = vehicleDetailPayLoad
                .getVehicleDetailsList().stream().map(vehicle ->
                        mapClientVehicleDetailsDtoFromVehicleDetailsDto(vehicle))
                .collect(Collectors.toList());

        return clientVehicleDetailsList;
    }
    private ClientVehicleDetailsDto mapClientVehicleDetailsDtoFromVehicleDetailsDto(VehicleDetailDto vehicleDetailDto) {
        ClientVehicleDetailsDto clientVehicleDetailsDto = new ClientVehicleDetailsDto();
        clientVehicleDetailsDto.setId(vehicleDetailDto.getId());
        clientVehicleDetailsDto.setModelYear(vehicleDetailDto.getModelYear());
        clientVehicleDetailsDto.setBrandName(vehicleDetailDto.getBrandName());
        clientVehicleDetailsDto.setModelName(vehicleDetailDto.getModelName());
        clientVehicleDetailsDto.setTrimType(vehicleDetailDto.getTrimType());
        clientVehicleDetailsDto.setBodyType(vehicleDetailDto.getBodyType());
        clientVehicleDetailsDto.setPrice(vehicleDetailDto.getPrice());
        clientVehicleDetailsDto.setMiles(vehicleDetailDto.getMiles());
        clientVehicleDetailsDto.setLocation(vehicleDetailDto.getLocation());
        clientVehicleDetailsDto.setSellerName(vehicleDetailDto.getSellerName());
        clientVehicleDetailsDto.setSellerPhone(vehicleDetailDto.getSellerPhone());

        //calculate estimated monthly price
        //(price/(5*12)+price*interest rate/(100*12)
        double monthlyPrice = vehicleDetailDto.getPrice()/(5*12)
                + vehicleDetailDto.getPrice()
                * vehicleDetailDto.getInterestRate() / (100*12);
        //$312.56 / monthly est.
        clientVehicleDetailsDto.setEstimatedMonthly("$"+monthlyPrice+" / monthly est.");

        //Calculate Amount below or above market price

        //Calculate current market price
        //Market Price(New Vehicle) - (current year - model year)*market price*0.5/25 - current miles*market price*75/500000
        VehicleMarketPriceDto dbVehicleMarketPrice = vehicleMarketPriceService.getVehicleMarketPriceByBrandName(vehicleDetailDto.getBrandName(),
                vehicleDetailDto.getModelName());
        double priceReductionForAge = (LocalDate.now().getYear() - Integer.parseInt(vehicleDetailDto.getModelYear())
                * dbVehicleMarketPrice.getPrice() * 0.5/25);
        double priceReductionForMiles = (vehicleDetailDto.getMiles() * dbVehicleMarketPrice.getPrice() * 0.75/500000);
        double currentVehicleMarketPrice = dbVehicleMarketPrice.getPrice()
                - priceReductionForMiles
                -priceReductionForAge;

        if(currentVehicleMarketPrice < 0) {
            currentVehicleMarketPrice = 0;
        }

        double marketPriceComparison = currentVehicleMarketPrice - vehicleDetailDto.getPrice();

        if(marketPriceComparison > 0) {
            clientVehicleDetailsDto.setAmountBelowMarket("$ " + marketPriceComparison + " below market price");
        }else {
            clientVehicleDetailsDto.setAmountBelowMarket("$ " + Math.abs(marketPriceComparison) + " above market price");
        }

        //Saving > 800 then Great Deal, >350 and <== 800 Good deal, >-100 and <=350 Fair Deal else Bad deal
        // deal type determination

        if(marketPriceComparison > 800) {
            clientVehicleDetailsDto.setDealType("Great Deal");
        } else if (marketPriceComparison > 350 && marketPriceComparison <= 800 ) {
            clientVehicleDetailsDto.setDealType("Good Deal");
        } else if (marketPriceComparison > -100 && marketPriceComparison <= 350) {
            clientVehicleDetailsDto.setDealType("Fair Deal");
        }else {
            clientVehicleDetailsDto.setDealType("Bad Deal");
        }
        return clientVehicleDetailsDto;
    }

    @Override
    public VehicleDetailDto getVehicleById(int vehicleId) {
        VehicleDetailDto dbVehicle = null;
        try {
            dbVehicle = restTemplate.getForObject("http://localhost:9090/api/v1/vehicle-details/" + vehicleId, VehicleDetailDto.class);
        }catch (Exception e) {
            throw new VehicleDetailsNotFound("No vehicle details found in DB for ID- "+vehicleId);
        }
        return dbVehicle;
    }
}
