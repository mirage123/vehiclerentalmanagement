package com.vng.vehiclerentmanagement.services;

import com.vng.vehiclerentmanagement.entities.User;
import com.vng.vehiclerentmanagement.reqres.UserCreateRequest;

import java.util.List;

public interface UserService {
    Long create(UserCreateRequest userCreateRequest);

    List<User> getUsers();

    User getUserDetail(Long id);
}
