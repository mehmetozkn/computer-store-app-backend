package com.marketapp.MarketApp.dto;
import com.marketapp.MarketApp.model.BasketProduct;
import com.marketapp.MarketApp.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDto {

    private Long id;
    private List<BasketProduct> products;
    private User user;
}
