package com.marketapp.MarketApp.repository;

import com.marketapp.MarketApp.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
