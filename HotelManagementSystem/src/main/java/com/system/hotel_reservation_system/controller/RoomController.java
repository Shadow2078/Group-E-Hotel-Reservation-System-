package com.system.hotel_reservation_system.controller;

import com.system.hotel_reservation_system.pojo.RoomPojo;
import com.system.hotel_reservation_system.services.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Map;
import java.io.IOException;
import java.util.HashMap;
import org.springframework.validation.FieldError;

@Controller
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/add")
    public String getRegister(Model model) {
        model.addAttribute("room", new RoomPojo());
        return "addRoom";
    }

    @PostMapping("/create")
    public String createUser(@Valid RoomPojo roomPojo,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/register";
        }

        roomService.saveRoom(roomPojo);
        redirectAttributes.addFlashAttribute("successMsg", "Room saved successfully");


        return "redirect:/register";
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

}
