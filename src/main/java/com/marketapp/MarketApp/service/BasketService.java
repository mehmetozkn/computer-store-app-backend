package com.marketapp.MarketApp.service;

import com.marketapp.MarketApp.dto.BasketDto;
import com.marketapp.MarketApp.dto.converter.BasketDtoConverter;
import com.marketapp.MarketApp.exception.BasketNotFoundException;
import com.marketapp.MarketApp.model.Basket;
import com.marketapp.MarketApp.model.User;
import com.marketapp.MarketApp.repository.BasketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final BasketRepository basketRepository;
    private final BasketDtoConverter basketDtoConverter;
    private final UserService userService;

    public BasketService(BasketRepository basketRepository,
                         BasketDtoConverter basketDtoConverter,
                         UserService userService) {
        this.basketRepository = basketRepository;
        this.basketDtoConverter = basketDtoConverter;
        this.userService = userService;
    }


    public Basket createBasket(User user, Long basketId) {
        Basket existingBasket = findBasketById(basketId);

        if (existingBasket == null) {
            Basket basket = new Basket();
            basket.setId(basketId);
            basket.setUser(user);
            basketRepository.save(basket);

            return basketRepository.save(basket);

        } else {
            existingBasket.setUser(user);
            return basketRepository.save(existingBasket);

        }
    }

    public BasketDto getBasketByUserId(Long id) {
        User user = userService.findUserById(id);
        return basketDtoConverter.convertBasketToBasketDto(user.getBasket());
    }

    public List<BasketDto> getAllBaskets() {
        return basketRepository.findAll()
                .stream()
                .map(basketDtoConverter::convertBasketToBasketDto)
                .collect(Collectors.toList());
    }

    protected Basket findBasketById(Long id) {
        return basketRepository.findById(id)
                .orElse(null);

    }
}
