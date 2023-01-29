package com.system.hotel_reservation_system.controller;

import com.system.hotel_reservation_system.pojo.NewsPojo;
import com.system.hotel_reservation_system.pojo.ReviewPojo;
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
@RequestMapping("/dashboard")
public class NavigationController {

    private final UserService userService;
    @GetMapping("/about")
    public String GetAbout(){
        return "/about";
    }

    @GetMapping("/gallery")
    public String GetGallery(){
        return "/gallery";
    }

    @GetMapping("/news")
    public String GetNews(Model model){
        model.addAttribute("news",new NewsPojo());
        return "/news";
    }

    @GetMapping("/contact")
    public String GetContact(){
        return "/contacts";
    }

    @GetMapping("/payment")
    public String GetPayment(){
        return "/payment";
    }

    @GetMapping("/dash")
    public String GetDash(){
        return "/Dashboard";
    }

    @GetMapping("/rooml")
    public String GetRoomList(){
        return "/room-list";
    }



}
