package com.vng.vehiclerentmanagement.services.impl;

import com.vng.vehiclerentmanagement.entities.User;
import com.vng.vehiclerentmanagement.repositories.UserRepository;
import com.vng.vehiclerentmanagement.reqres.UserCreateRequest;
import com.vng.vehiclerentmanagement.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public Long create(UserCreateRequest userCreateRequest) {
        //validation

        User user = User.builder()
                .username(userCreateRequest.getUsername())
                .password(userCreateRequest.getPassword())
                .role("ADMIN")
                .build();

        User save = this.userRepository.save(user);
        return user.getId();
    }

    @Override
    public List<User> getUsers() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    @Override
    public User getUserDetail(Long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isEmpty()){
            throw new RuntimeException();
        }
        return userOptional.get();

    }


}
