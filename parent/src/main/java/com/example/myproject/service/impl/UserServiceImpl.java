package com.example.myproject.service.impl;

import com.example.myproject.dao.UserDao;
import com.example.myproject.domain.User;
import com.example.myproject.domain.dto.UserDto;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public User findByName(String name) {
        return userDao.findByName(name);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public List<User> findAll(UserDto userDto) {
            return userDao.findAll(userDto);
    }

}
