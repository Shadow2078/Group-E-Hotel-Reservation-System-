package com.system.hotel_reservation_system.controller;

import com.system.hotel_reservation_system.pojo.UserPojo;
import com.system.hotel_reservation_system.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
//@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new UserPojo());
        return "/register";
    }

    @PostMapping("/save")
    public String SaveUser(@Valid UserPojo userPojo){
        userService.saveUser(userPojo);
        return "login";
    }

    //Temporary
    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }
}
