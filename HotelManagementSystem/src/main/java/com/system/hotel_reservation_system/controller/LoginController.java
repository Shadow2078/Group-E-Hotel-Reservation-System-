package com.system.hotel_reservation_system.controller;

import com.system.hotel_reservation_system.entity.User;
import com.system.hotel_reservation_system.pojo.UserPojo;
import com.system.hotel_reservation_system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class LoginController {


    private final UserService userService;

//    @GetMapping("/login")
//    public ModelAndView login() {
//        ModelAndView mav = new ModelAndView("login");
//        mav.addObject("users", new User());
//        return mav;
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute("users") User user) {
//
//        UserPojo authUser = userService.findByEmail(user.getEmail());
//        UserPojo authUserPassword = userService.findByPassword(user.getPassword());
//
//
//        System.out.print(authUser);
//        System.out.print(authUserPassword);
//
//        if (Objects.nonNull(authUser) && (Objects.nonNull(authUserPassword))) {
//            return "redirect:/index";
//        } else {
//            return "redirect:/login";
//        }
//    }

    @GetMapping("/login")
    public String showLoginPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/user/index";
    }
}
