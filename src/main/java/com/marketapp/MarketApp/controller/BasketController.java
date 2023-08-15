package com.marketapp.MarketApp.controller;
import com.marketapp.MarketApp.dto.AddProductRequest;
import com.marketapp.MarketApp.dto.BasketDto;
import com.marketapp.MarketApp.dto.UserDto;
import com.marketapp.MarketApp.model.Basket;
import com.marketapp.MarketApp.model.BasketProduct;
import com.marketapp.MarketApp.service.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BasketDto>> getAllBaskets() {
        return ResponseEntity.ok(basketService.getAllBaskets());
    }

    @GetMapping("/getBasketByUserId/{id}")
    public ResponseEntity<BasketDto> getBasketByUserId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(basketService.getBasketByUserId(id));
    }

}
