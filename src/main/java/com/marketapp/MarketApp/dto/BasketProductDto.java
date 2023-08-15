package com.marketapp.MarketApp.dto;

import com.marketapp.MarketApp.model.Basket;
import com.marketapp.MarketApp.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketProductDto {

    private Product product;
    private Basket basket;
    private int quantity;

}
