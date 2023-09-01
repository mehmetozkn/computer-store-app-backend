package com.marketapp.MarketApp.service;

import com.marketapp.MarketApp.dto.AddProductRequest;
import com.marketapp.MarketApp.dto.BasketProductDto;
import com.marketapp.MarketApp.dto.ProductDto;
import com.marketapp.MarketApp.dto.converter.BasketProductDtoConverter;
import com.marketapp.MarketApp.exception.ProductNotFoundException;
import com.marketapp.MarketApp.model.BasketProduct;
import com.marketapp.MarketApp.model.Product;
import com.marketapp.MarketApp.model.User;
import com.marketapp.MarketApp.repository.BasketProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
        if(basketProduct.getQuantity() == 0)
            deleteBasketProduct(basketProduct.getId());


        return basketProductDtoConverter
                .convertBasketProductToBasketProductDto(basketProductRepository.save(basketProduct));
    }

    public void clearBasket() {

        basketProductRepository.deleteAll();


    }

    public BasketProductDto deleteBasketProduct(Long id) {
        BasketProduct basketProduct = findProductById(id);
        basketProductRepository.delete(basketProduct);
        return basketProductDtoConverter.convertBasketProductToBasketProductDto(basketProduct);

    }

    protected BasketProduct findProductById(Long id) {
        return basketProductRepository.findById(id)
                .orElseThrow(
                        () -> new ProductNotFoundException("Product could not find by id: " + id));
    }

    private BasketProduct createBasketProduct(int quantity, Product product, User user) {
        BasketProduct basketProduct = new BasketProduct();
        basketProduct.setProduct(product);
        basketProduct.setUser(user);
        basketProduct.setQuantity(quantity);
        return basketProduct;
    }




}






