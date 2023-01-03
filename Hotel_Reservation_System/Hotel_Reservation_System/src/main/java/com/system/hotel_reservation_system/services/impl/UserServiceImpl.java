package com.system.hotel_reservation_system.services.impl;

import com.system.hotel_reservation_system.entity.User;
import com.system.hotel_reservation_system.pojo.UserPojo;
import com.system.hotel_reservation_system.repo.UserRepo;
import com.system.hotel_reservation_system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public String saveUser(UserPojo userPojo) {
        User user = new User();


        user.setEmail(userPojo.getEmail());
        user.setFullname(userPojo.getFullname());
        user.setPassword(userPojo.getPassword());

        userRepo.save(user);
        return "Created";

    }
}
