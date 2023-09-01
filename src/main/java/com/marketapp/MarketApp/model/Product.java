package com.marketapp.MarketApp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    private int ram;

    private int storage;

    private String processor;

    private String imageUrl;

    public Product(String name, Long price, int ram, int storage, String processor, String imageUrl) {
        this.name = name;
        this.price = price;
        this.ram = ram;
        this.storage = storage;
        this.processor = processor;
        this.imageUrl = imageUrl;
    }
}
