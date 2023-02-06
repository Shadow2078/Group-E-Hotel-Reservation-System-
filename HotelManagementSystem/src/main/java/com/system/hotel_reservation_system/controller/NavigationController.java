package com.system.hotel_reservation_system.controller;
import com.system.hotel_reservation_system.entity.Book;
import com.system.hotel_reservation_system.entity.Room;
import com.system.hotel_reservation_system.pojo.BookPojo;
import com.system.hotel_reservation_system.pojo.RoomPojo;
import com.system.hotel_reservation_system.services.BookingService;
import com.system.hotel_reservation_system.services.RoomService;
import com.system.hotel_reservation_system.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class NavigationController {
    private  final RoomService roomService;
    private  final BookingService bookingService;

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

    @GetMapping("/books/{id}")
    public String GetBook(@PathVariable Integer id, Model model, Principal principal){
        Room room=roomService.fetchById(id);
        model.addAttribute("rooms",new RoomPojo(room));
        model.addAttribute("booking" ,new BookPojo());
        model.addAttribute("userlog",userService.findByEmail(principal.getName()));
        return "/booking-form";
    }
        @PostMapping("/savebook")
    public String bookBike(@Valid BookPojo bookingPojo) {
        bookingService.save(bookingPojo);
        return "payment";
    }

}
