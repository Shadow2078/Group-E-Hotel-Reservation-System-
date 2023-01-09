package com.system.hotel_reservation_system.repo;

import com.system.hotel_reservation_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<Object> findByPassword(String password);

    Optional<Object> findByEmail(String email);
}
