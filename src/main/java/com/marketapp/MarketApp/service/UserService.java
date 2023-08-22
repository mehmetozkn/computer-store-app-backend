package com.marketapp.MarketApp.service;

import com.marketapp.MarketApp.dto.UserDto;
import com.marketapp.MarketApp.dto.converter.UserDtoConverter;
import com.marketapp.MarketApp.exception.UserNotFoundException;
import com.marketapp.MarketApp.model.BasketProduct;
import com.marketapp.MarketApp.model.User;
import com.marketapp.MarketApp.repository.BasketProductRepository;
import com.marketapp.MarketApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private final BasketProductRepository basketProductRepository;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter, BasketProductRepository basketProductRepository) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
        this.basketProductRepository = basketProductRepository;
    }

    public List<BasketProduct> getProductsByUserId(Long userId) {
        User user = findUserById(userId);
        return basketProductRepository.findAll().stream()
                .filter(e -> e.getUser().getId().equals(userId))
                .collect(Collectors.toList());

    }
    public UserDto createUser(User user){
        return userDtoConverter.convertUserToUserDto(userRepository.save(user));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<UserDto> getAllUsers(){
        List<UserDto> collect = userRepository.findAll()
                .stream()
                .map(userDtoConverter::convertUserToUserDto)
                .collect(Collectors.toList());
        return collect;
    }

    public UserDto getUserById(Long id) {
        return userDtoConverter.convertUserToUserDto(findUserById(id));
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        User updateUser = findUserById(id);
        updateUser.setName(userDto.getName());
        updateUser.setSurname(userDto.getSurname());
        return userDtoConverter.convertUserToUserDto(userRepository.save(updateUser));

    }

    public UserDto deleteUser(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);
        return  userDtoConverter.convertUserToUserDto(user);

    }

    protected User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException("User could not find by id: " + id));

    }

}
