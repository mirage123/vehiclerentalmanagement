package com.vng.vehiclerentmanagement.controllers;

import com.vng.vehiclerentmanagement.entities.User;
import com.vng.vehiclerentmanagement.reqres.UserCreateRequest;
import com.vng.vehiclerentmanagement.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * create user
     * @param userCreateRequest create user request
     * @return id of created user
     */
    @PostMapping
    public Long create(@RequestBody UserCreateRequest userCreateRequest){
        return userService.create(userCreateRequest);
    }

    /**
     * give list of users
     * @return list of users
     */
    @GetMapping
    public List<User> users(){
        List<User> users = this.userService.getUsers();
        return users;
    }

    /**
     * give detail of given user id
     * @param id user id
     * @return user detail
     */
    @GetMapping("/{id}")
    public User users(@PathVariable Long id){
        return this.userService.getUserDetail(id);
    }
}
