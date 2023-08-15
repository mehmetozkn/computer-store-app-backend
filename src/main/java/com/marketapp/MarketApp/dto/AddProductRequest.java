package com.marketapp.MarketApp.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequest {


    private Long user_id;
    private Long product_id;
    private Long basket_id;
    private int quantity;

}
