//package com.example.hotelmanagementsystem.Controller;
//
//import com.system.travelmanagement.Entity.User;
//import com.system.travelmanagement.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/user")
//public class User_Controller {
//    private final UserService userService;
//    @GetMapping("/register")
//    public String getPage(){
//        return "register";
//    }
//
//    @GetMapping("/list")
//    public String getUserist(Model model){
//        List<User> users =userService.fetchAll();
//        model.addAttribute("userlist",users);
//        return "user/index";
//    }
//}