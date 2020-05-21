package com.example.myproject.domain.dto;

import java.util.List;

public class UserDto {
    private List<Long> ids;
    private String name;


    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
