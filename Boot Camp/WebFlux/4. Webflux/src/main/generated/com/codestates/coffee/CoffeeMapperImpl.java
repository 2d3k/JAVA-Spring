package com.codestates.coffee;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-14T17:15:38+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class CoffeeMapperImpl implements CoffeeMapper {

    @Override
    public Coffee coffeePostDtoToCoffee(CoffeeDto.Post coffeePostDto) {
        if ( coffeePostDto == null ) {
            return null;
        }

        Coffee coffee = new Coffee();

        coffee.setKorName( coffeePostDto.getKorName() );
        coffee.setEngName( coffeePostDto.getEngName() );
        coffee.setPrice( coffeePostDto.getPrice() );
        coffee.setCoffeeCode( coffeePostDto.getCoffeeCode() );

        return coffee;
    }

    @Override
    public Coffee coffeePatchDtoToCoffee(CoffeeDto.Patch coffeePatchDto) {
        if ( coffeePatchDto == null ) {
            return null;
        }

        Coffee coffee = new Coffee();

        coffee.setCoffeeId( coffeePatchDto.getCoffeeId() );
        coffee.setKorName( coffeePatchDto.getKorName() );
        coffee.setEngName( coffeePatchDto.getEngName() );
        coffee.setPrice( coffeePatchDto.getPrice() );
        coffee.setCoffeeStatus( coffeePatchDto.getCoffeeStatus() );

        return coffee;
    }

    @Override
    public CoffeeDto.Response coffeeToCoffeeResponseDto(Coffee coffee) {
        if ( coffee == null ) {
            return null;
        }

        long coffeeId = 0L;
        String korName = null;
        String engName = null;
        int price = 0;
        Coffee.CoffeeStatus coffeeStatus = null;

        if ( coffee.getCoffeeId() != null ) {
            coffeeId = coffee.getCoffeeId();
        }
        korName = coffee.getKorName();
        engName = coffee.getEngName();
        if ( coffee.getPrice() != null ) {
            price = coffee.getPrice();
        }
        coffeeStatus = coffee.getCoffeeStatus();

        CoffeeDto.Response response = new CoffeeDto.Response( coffeeId, korName, engName, price, coffeeStatus );

        return response;
    }

    @Override
    public List<CoffeeDto.Response> coffeesToCoffeeResponseDtos(List<Coffee> coffees) {
        if ( coffees == null ) {
            return null;
        }

        List<CoffeeDto.Response> list = new ArrayList<CoffeeDto.Response>( coffees.size() );
        for ( Coffee coffee : coffees ) {
            list.add( coffeeToCoffeeResponseDto( coffee ) );
        }

        return list;
    }
}
