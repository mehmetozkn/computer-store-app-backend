package com.marketapp.MarketApp;

import com.marketapp.MarketApp.model.Product;
import com.marketapp.MarketApp.model.User;
import com.marketapp.MarketApp.repository.ProductRepository;
import com.marketapp.MarketApp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketAppApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public MarketAppApplication(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
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
