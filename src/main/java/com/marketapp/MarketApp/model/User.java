package com.marketapp.MarketApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

    private String email;

    @OneToMany
    @JoinColumn(name  = "list")
    private List<BasketProduct> productList = new ArrayList<>();

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;

    }

}
