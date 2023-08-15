package com.marketapp.MarketApp.repository;

import com.marketapp.MarketApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
