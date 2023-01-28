package com.system.hotel_reservation_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class NavigationController {
    @GetMapping("/about")
    public String GetAbout(){
        return "/about";
    }

    @GetMapping("/gallery")
    public String GetGallery(){
        return "/gallery";
    }

    @GetMapping("/news")
    public String GetNews(){
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
