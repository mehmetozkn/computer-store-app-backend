package com.marketapp.MarketApp;

import com.marketapp.MarketApp.model.Product;
import com.marketapp.MarketApp.model.User;
import com.marketapp.MarketApp.repository.ProductRepository;
import com.marketapp.MarketApp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
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

     /*
       User user1 = userRepository.save(new User("Mehmet", "Özkan"));
        User user2 = userRepository.save(new User("Ahmet", "Ak"));

        String keyboardUrl = "https://firebasestorage.googleapis.com/v0/b/marketapp-fd5d2.appspot.com/o/keyboard.jpeg?alt=media&token=0e40a51b-cc31-430f-a582-b3dcdb1f54aa";
        String macbookUrl = "https://firebasestorage.googleapis.com/v0/b/marketapp-fd5d2.appspot.com/o/macbook.jpeg?alt=media&token=03aead29-e825-4c14-88b1-10abfb2ea014";

        Product product1 = productRepository.save(new Product("Keyboard", 200L, keyboardUrl));
        Product product2 = productRepository.save(new Product("Macbook", 1500L, macbookUrl));

        */
    }
}
