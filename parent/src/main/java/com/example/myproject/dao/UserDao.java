package com.example.myproject.dao;

import com.example.myproject.domain.User;
import com.example.myproject.domain.dto.UserDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Map;

public interface UserDao{

    User findByName(String name);

    List<User> findAll();
    List<User> findAll(@Param("userDto") UserDto userDto);

}
