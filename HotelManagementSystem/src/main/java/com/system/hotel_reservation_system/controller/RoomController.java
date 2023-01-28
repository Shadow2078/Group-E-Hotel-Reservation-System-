package com.system.hotel_reservation_system.controller;

import com.system.hotel_reservation_system.entity.Room;
import com.system.hotel_reservation_system.pojo.ReviewPojo;
import com.system.hotel_reservation_system.pojo.RoomPojo;
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

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.HashMap;
import org.springframework.validation.FieldError;

@Controller
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;
    private final UserService userService;


    @GetMapping("/rooms")
    public String GetRooms(Model model){
        List<Room> rooms = roomService.fetchAll();
        model.addAttribute("rooms", rooms);
        return  "room-list";
    }

    @GetMapping("/add")
    public String getRegister(Model model) {
        model.addAttribute("room", new RoomPojo());
        return "addRoom";
    }

    @PostMapping("/create")
    public String createRoom(@Valid RoomPojo roomPojo,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            System.out.println(requestError);
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/add";
        }

        roomService.saveRoom(roomPojo);
        redirectAttributes.addFlashAttribute("successMsg", "Room saved successfully");


        return "redirect:room/rooms";
    }

     public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;

    }

    @GetMapping("roomind/{id}")
    public String getRoom(@PathVariable ("id") Integer id, Model model, Principal principal){
        model.addAttribute("review", new ReviewPojo());
        Room room= roomService.fetchById(id);
        model.addAttribute("roomss",room);
        return "Penthouse";
    }
    @PostMapping("/submit")
    public String SubmitReview(@Valid ReviewPojo reviewPojo){
        userService.submitReview(reviewPojo);
        return "redirect:/room/rooms";
    }

}
