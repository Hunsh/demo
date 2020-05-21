package com.example.myproject.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.myproject.config.TestConfig;
import com.example.myproject.domain.User;
import com.example.myproject.domain.dto.UserDto;
import com.example.myproject.property.TestProperty;
import com.example.myproject.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    TestProperty testProperty;

    @Autowired
    TestConfig testConfig;

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public Map findByName(@PathVariable("name") String name) {
        User user = userService.findByName(name);



        Map resultMap = new HashMap();
        resultMap.put(resultMap, user);

        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.addAllObjects(resultMap);*/
        return resultMap;
}

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String findAll(
                            @RequestParam(required = false,name="where") String where,
                            @RequestParam(required = false,name="limit") Integer limit,
                          @RequestParam(required = false,name="skip") Integer skip,
                          @RequestParam(required = false,name="pageNum",defaultValue = "1") Integer pageNum,
                          @RequestParam(required = false,name="pageSize",defaultValue ="2") Integer pageSize
                          ) {
        PageHelper.startPage(pageNum,pageSize);

        List<User> listOfUser = new ArrayList<User>();
        if(where != null && !"".equals(where)){
            String[] whereClauses = where.split("&");

            JSONObject jsonObject = new JSONObject();
            for(String whereClause : whereClauses){
                jsonObject.  JSON.parseObject(whereClause);
            }




            JSON.

            UserDto userDto = JSON.parseObject(where, UserDto.class);

            listOfUser = userService.findAll(userDto);
        }else{
            listOfUser = userService.findAll();
        }






        PageInfo pageInfo=new PageInfo(listOfUser);

        /*Page<User> users = userService.findAll(pageable);

        Map resultMap = new HashMap();
        resultMap.put(resultMap, users);*/

        System.out.println("id:"+testProperty.getId());
        System.out.println("name:"+testProperty.getName());

        System.out.println("id:"+testConfig.getId());
        System.out.println("name:"+testConfig.getName());

        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.addAllObjects(resultMap);*/

        return "1";
    }

}
