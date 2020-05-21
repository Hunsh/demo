package com.example.myproject.service;


import com.example.myproject.domain.User;
import com.example.myproject.domain.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface UserService {

    User findByName(String name);

    List<User> findAll();

    List<User> findAll(UserDto userDto);
}
