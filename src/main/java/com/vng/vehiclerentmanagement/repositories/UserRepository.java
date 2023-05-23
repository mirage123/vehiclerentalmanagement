package com.vng.vehiclerentmanagement.repositories;

import com.vng.vehiclerentmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
