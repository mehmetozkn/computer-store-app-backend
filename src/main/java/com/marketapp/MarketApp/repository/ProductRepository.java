package com.marketapp.MarketApp.repository;

import com.marketapp.MarketApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
