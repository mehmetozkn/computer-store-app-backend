package com.marketapp.MarketApp.service;

import com.marketapp.MarketApp.dto.BasketDto;
import com.marketapp.MarketApp.dto.converter.BasketDtoConverter;
import com.marketapp.MarketApp.model.Basket;
import com.marketapp.MarketApp.model.User;
import com.marketapp.MarketApp.repository.BasketRepository;
import com.marketapp.MarketApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final BasketRepository basketRepository;
    private final BasketDtoConverter basketDtoConverter;
    private final UserService userService;
    private final UserRepository userRepository;

    public BasketService(BasketRepository basketRepository,
                         BasketDtoConverter basketDtoConverter,
                         UserService userService, UserRepository userRepository) {
        this.basketRepository = basketRepository;
        this.basketDtoConverter = basketDtoConverter;
        this.userService = userService;
        this.userRepository = userRepository;
    }


    public Basket createBasket(User user, Long basketId) {
        Basket basket = findBasketById(basketId);
        if (basket == null) {
            basket = new Basket();
            basket.setId(basketId);
            basket.setUser(user);
            user.setBasket(basket);
        } else {
            basket.setUser(user);
            user.setBasket(basket);
        }
        return basketRepository.save(basket);
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
