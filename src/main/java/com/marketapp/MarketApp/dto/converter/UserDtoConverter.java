package com.marketapp.MarketApp.dto.converter;

import com.marketapp.MarketApp.dto.UserDto;
import com.marketapp.MarketApp.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    private final ModelMapper modelMapper;

    public UserDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDto convertUserToUserDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
