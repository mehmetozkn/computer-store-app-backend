package com.marketapp.MarketApp.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private Long price;
    private int ram;
    private int storage;
    private String processor;
    private String imageUrl;
}
