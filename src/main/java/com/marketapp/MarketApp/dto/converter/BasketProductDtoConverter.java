package com.marketapp.MarketApp.dto.converter;

import com.marketapp.MarketApp.dto.BasketProductDto;
import com.marketapp.MarketApp.model.BasketProduct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BasketProductDtoConverter {
    private final ModelMapper modelMapper;
    public BasketProductDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BasketProductDto convertBasketProductToBasketProductDto(BasketProduct basketProduct){
        return modelMapper.map(basketProduct, BasketProductDto.class);

    }
}
