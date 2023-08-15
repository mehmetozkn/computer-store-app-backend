package com.marketapp.MarketApp.repository;

import com.marketapp.MarketApp.model.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {
}
