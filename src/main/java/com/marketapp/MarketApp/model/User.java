package com.marketapp.MarketApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @OneToMany
    @JoinColumn(name  = "list")
    private List<BasketProduct> productList;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }

}
