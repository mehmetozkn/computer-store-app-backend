package com.marketapp.MarketApp.service;

import com.marketapp.MarketApp.dto.AddProductRequest;
import com.marketapp.MarketApp.dto.BasketProductDto;
import com.marketapp.MarketApp.dto.converter.BasketProductDtoConverter;
import com.marketapp.MarketApp.model.BasketProduct;
import com.marketapp.MarketApp.model.Product;
import com.marketapp.MarketApp.model.User;
import com.marketapp.MarketApp.repository.BasketProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

@Service
public class BasketProductService {

    private final BasketProductRepository basketProductRepository;
    private final BasketProductDtoConverter basketProductDtoConverter;
    private final ProductService productService;
    private final UserService userService;

    public BasketProductService(BasketProductRepository basketProductRepository,
                                BasketProductDtoConverter basketProductDtoConverter,
                                ProductService productService,
                                UserService userService
    ) {
        this.basketProductRepository = basketProductRepository;
        this.basketProductDtoConverter = basketProductDtoConverter;
        this.productService = productService;
        this.userService = userService;
    }

    public BasketProductDto addProduct(AddProductRequest addProductRequest) {
        Product product = productService.findProductById(addProductRequest.getProductId());
        User user = userService.findUserById(addProductRequest.getUserId());

        BasketProduct basketProduct = user.getProductList().stream()
                .filter(item -> item.getProduct().getId() == product.getId())
                .findFirst()
                .map(item -> {
                    item.setQuantity(item.getQuantity() + addProductRequest.getQuantity());
                    return item;
                })
                .orElseGet(() -> createBasketProduct(addProductRequest.getQuantity(), product, user));

        List<BasketProduct> productList = user.getProductList();
        productList.add(basketProduct);


        return basketProductDtoConverter
                .convertBasketProductToBasketProductDto(basketProductRepository.save(basketProduct));
    }

    private BasketProduct createBasketProduct(int quantity, Product product, User user) {
        BasketProduct basketProduct = new BasketProduct();
        basketProduct.setProduct(product);
        basketProduct.setUser(user);
        basketProduct.setQuantity(quantity);
        return basketProduct;
    }




}






