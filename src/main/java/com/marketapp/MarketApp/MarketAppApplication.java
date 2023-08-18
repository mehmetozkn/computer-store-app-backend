package com.marketapp.MarketApp;

import com.marketapp.MarketApp.model.Basket;
import com.marketapp.MarketApp.model.BasketProduct;
import com.marketapp.MarketApp.model.Product;
import com.marketapp.MarketApp.model.User;
import com.marketapp.MarketApp.repository.BasketRepository;
import com.marketapp.MarketApp.repository.ProductRepository;
import com.marketapp.MarketApp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class MarketAppApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final BasketRepository basketRepository;

    public MarketAppApplication(UserRepository userRepository, ProductRepository productRepository, BasketRepository basketRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.basketRepository = basketRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MarketAppApplication.class, args);

    }
    @Override
    public void run(String... args) {

        User user1 = userRepository.save(new User("Mehmet", "Özkan"));
        User user2 = userRepository.save(new User("Ahmet", "Ak"));

        Product product1 = productRepository.save(new Product("Keyboard", 100L));
        Product product2 = productRepository.save(new Product("Laptop", 1500L));
    }
}
