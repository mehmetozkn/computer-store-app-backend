package com.marketapp.MarketApp.dto;

import com.marketapp.MarketApp.model.Product;
import com.marketapp.MarketApp.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketProductDto {

    private Product product;
    private User user;
    private int quantity;

}
