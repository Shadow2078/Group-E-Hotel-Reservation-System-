package com.system.hotel_reservation_system.services.impl;

import com.system.hotel_reservation_system.config.PasswordEncoderUtil;
import com.system.hotel_reservation_system.entity.Review;
import com.system.hotel_reservation_system.entity.User;
import com.system.hotel_reservation_system.exception.AppException;
import com.system.hotel_reservation_system.pojo.ReviewPojo;
import com.system.hotel_reservation_system.pojo.UserPojo;
import com.system.hotel_reservation_system.repo.ReviewRepo;
import com.system.hotel_reservation_system.repo.UserRepo;
import com.system.hotel_reservation_system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ReviewRepo reviewRepo;

    @Override
    public String saveUser(UserPojo userPojo) {
        User user = new User();


        user.setEmail(userPojo.getEmail());
        user.setFullname(userPojo.getFullname());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        userRepo.save(user);
        return "Created";

    }

    @Override
    public UserPojo findByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return new UserPojo(user);
    }

//    @Override
//    public UserPojo findByEmail(String email) {
//        User user = (User) userRepo.findByEmail(email)
//                .orElseThrow(()-> new RuntimeException("Invalid User email"));
//        return new UserPojo(user);
//    }
//
//    @Override
//    public UserPojo findByPassword(String password) {
//        User user = (User) userRepo.findByPassword(password)
//                .orElseThrow(() -> new RuntimeException("Invalid User password"));
//        return new UserPojo(user);
//    }

    @Override
    public String submitReview(ReviewPojo reviewPojo) {
        Review review=new Review();
        review.setId(reviewPojo.getId());
        review.setLocation(reviewPojo.getLocation());
        review.setPricing(reviewPojo.getPricing());
        review.setComfort(reviewPojo.getComfort());
        review.setService(reviewPojo.getService());
        review.setName(reviewPojo.getName());
        review.setEmail(reviewPojo.getEmail());
        review.setDescription(reviewPojo.getDescription());
        reviewRepo.save(review);
        return "send";
    }
}
