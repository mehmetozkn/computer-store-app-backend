package com.marketapp.MarketApp.dto.converter;

import com.marketapp.MarketApp.dto.BasketDto;
import com.marketapp.MarketApp.model.Basket;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BasketDtoConverter {

    private final ModelMapper modelMapper;

    public BasketDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BasketDto convertBasketToBasketDto(Basket basket) {
        BasketDto basketDto = modelMapper.map(basket, BasketDto.class);
        return basketDto;
    }
}
