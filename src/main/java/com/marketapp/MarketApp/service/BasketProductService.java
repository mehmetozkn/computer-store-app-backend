package com.marketapp.MarketApp.service;

import com.marketapp.MarketApp.dto.AddProductRequest;
import com.marketapp.MarketApp.dto.BasketProductDto;
import com.marketapp.MarketApp.dto.converter.BasketProductDtoConverter;
import com.marketapp.MarketApp.model.Basket;
import com.marketapp.MarketApp.model.BasketProduct;
import com.marketapp.MarketApp.model.Product;
import com.marketapp.MarketApp.model.User;
import com.marketapp.MarketApp.repository.BasketProductRepository;
import org.springframework.stereotype.Service;

@Service
public class BasketProductService {

    private final BasketProductRepository basketProductRepository;
    private final BasketProductDtoConverter basketProductDtoConverter;
    private final ProductService productService;
    private final BasketService basketService;
    private final UserService userService;

    public BasketProductService(BasketProductRepository basketProductRepository,
                                BasketProductDtoConverter basketProductDtoConverter,
                                ProductService productService,
                                BasketService basketService,
                                UserService userService
    ) {
        this.basketProductRepository = basketProductRepository;
        this.basketProductDtoConverter = basketProductDtoConverter;
        this.productService = productService;
        this.basketService = basketService;
        this.userService = userService;
    }

    public BasketProductDto addProductToBasket(AddProductRequest addProductRequest) {
        Product product = productService.findProductById(addProductRequest.getProduct_id());
        User user = userService.findUserById(addProductRequest.getUser_id());

        Basket basket = new Basket();
        basket.setId(addProductRequest.getBasket_id());

        basketService.createBasket(user, basket);

        BasketProduct basketProduct = new BasketProduct();
        basketProduct.setProduct(product);
        basketProduct.setBasket(basket);
        basketProduct.setQuantity(addProductRequest.getQuantity());

        return basketProductDtoConverter
                .convertBasketProductToBasketProductDto(basketProductRepository.save(basketProduct));
    }

}






