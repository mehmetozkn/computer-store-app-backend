package com.marketapp.MarketApp.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequest {

    private Long userId;
    private Long productId;
    private int quantity;

}
