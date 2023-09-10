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

        User user1 = userRepository.save(new User("Mehmet", "Özkan", "mehmet@gmail.com"));

        String lenovaUrl = "https://firebasestorage.googleapis.com/v0/b/marketapp-fd5d2.appspot.com/o/lenova.jpeg?alt=media&token=44d3417e-869f-4cdc-acdf-cfb0d07c786c";
        String macbookUrl = "https://firebasestorage.googleapis.com/v0/b/marketapp-fd5d2.appspot.com/o/macbook.jpeg?alt=media&token=ad9d1898-91d0-43ea-94b6-92e7129ddeb8";
        String msiUrl = "https://firebasestorage.googleapis.com/v0/b/marketapp-fd5d2.appspot.com/o/msi.png?alt=media&token=56d6a402-8363-4374-9987-53889289283f";

        Product product1 = productRepository.save(new Product("Lenova ThinkPad E15" , 1000L,  8, 256,"Intel i7-12555U", lenovaUrl));
        Product product2 = productRepository.save(new Product("Macbook Air", 1500L, 16, 512, "M1", macbookUrl));
        Product product3 = productRepository.save(new Product("MSI", 1200L,  16, 512,"Intel i7-110005H", msiUrl));
        Product product4 = productRepository.save(new Product("Lenova K12", 1400L,  16, 512,"Intel i7-13000K", lenovaUrl));
        Product product5 = productRepository.save(new Product("Macbook Pro", 2300L, 16, 512, "M1 Pro", macbookUrl));

    }
}