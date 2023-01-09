package com.system.hotel_reservation_system.services;

import com.system.hotel_reservation_system.pojo.UserPojo;

public interface UserService {

    String saveUser(UserPojo userPojo);

    UserPojo findByEmail(String email);

    UserPojo findByPassword(String password);
}
