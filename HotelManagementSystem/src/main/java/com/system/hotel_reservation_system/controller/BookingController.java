//package com.system.hotel_reservation_system.controller;
//
//
//import com.system.hotel_reservation_system.pojo.BookPojo;
//import com.system.hotel_reservation_system.services.BookingService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.security.Principal;
//import java.text.ParseException;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping
//public class BookingController {
//    private final BookingService bookingService;
//
//    @PostMapping("/book")
//    public String bookBike(@Valid BookPojo bookingPojo) throws ParseException {
//        bookingService.saveBooking(bookingPojo);
//        return "redirect:/home";
//    }
//}
