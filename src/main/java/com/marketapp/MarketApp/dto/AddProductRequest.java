package com.marketapp.MarketApp.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequest {

    private Long userId;
    private Long productId;
    private Long basketId;
    private int quantity;

}
