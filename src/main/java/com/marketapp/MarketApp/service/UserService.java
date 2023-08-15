package com.marketapp.MarketApp.service;
import com.marketapp.MarketApp.dto.UserDto;
import com.marketapp.MarketApp.dto.converter.UserDtoConverter;
import com.marketapp.MarketApp.exception.UserNotFoundException;
import com.marketapp.MarketApp.model.Basket;
import com.marketapp.MarketApp.model.User;
import com.marketapp.MarketApp.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public UserDto createUser(User user){
        return userDtoConverter.convertUserToUserDto(userRepository.save(user));
    }

    public UserDto saveBasket(User user,Basket basket){
        user.setBasket(basket);
        return userDtoConverter.convertUserToUserDto(userRepository.save(user));
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(userDtoConverter::convertUserToUserDto)
                .collect(Collectors.toList());
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
