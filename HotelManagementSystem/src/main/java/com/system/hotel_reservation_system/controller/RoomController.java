package com.system.hotel_reservation_system.controller;

import com.system.hotel_reservation_system.entity.Review;
import com.system.hotel_reservation_system.entity.Room;
import com.system.hotel_reservation_system.pojo.BookPojo;
import com.system.hotel_reservation_system.pojo.ReviewPojo;
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
    private final BookingService bookingService;



    @GetMapping("/rooms")
    public String GetRooms(Model model){
        List<Room> rooms = roomService.fetchAll();
        model.addAttribute("rooms", rooms);
        return  "rooms";
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
        model.addAttribute("booking", new BookPojo());
//        model.addAttribute("getuser", userService.findByEmail(principal.getName()));
        Room room= roomService.fetchById(id);
        Review review= userService.fetchbyid(id);
        model.addAttribute("roomss",room);
        model.addAttribute("revs",review);
        return "Penthouse";
    }


//    @PostMapping("/savebook")
//    public String bookBike(@Valid BookPojo bookingPojo) {
//        bookingService.save(bookingPojo);
//        return "redirect:dashboard/dash";
//    }

    @PostMapping("/submit")
    public String SubmitReview(@Valid ReviewPojo reviewPojo){
        userService.submitReview(reviewPojo);
        return "redirect:/rooms";
    }

    @GetMapping("/roomlist")
    public String GetRoomlist(Model model){
        List<Room> rooms = roomService.fetchAll();
//        model.addAttribute("roomlist", rooms.stream().map(room ->
//                Room.builder()
//                        .room_type(room.getRoom_type())
//                        .price(room.getPrice())
//                        .beds(room.getBeds())
//                        .build()
//
//        ));
        model.addAttribute("roomData",rooms);
        return  "room-list";
    }

    @GetMapping("/reviews")
    public String GetRevs(Model model) {
        List<Review> reviews = userService.fetchAll();
        model.addAttribute("revData", reviews);
        return "reviews";
    }

    @GetMapping("/delete/{id}")
    public String DelRev(@PathVariable("id")Integer id){
        userService.deletebyid(id);

        return "redirect:/room/reviews";
    }

    @GetMapping("/deletes/{id}")
    public String DelRoom(@PathVariable("id")Integer id){
        roomService.deletebyid(id);
        return "redirect:/room/roomlist";
    }

    @GetMapping("/editroom/{id}")
    public String EditRoom(@PathVariable("id") Integer id,Model model){
        Room room=roomService.fetchById(id);
        model.addAttribute("erooms",new RoomPojo(room));
        model.addAttribute("edrooms",room);
        return "editroom";
    }

    @GetMapping("/editrooms/{id}")
    public String EditRooms(@PathVariable("id") Integer id,Model model){
        Room room=roomService.fetchById(id);
        model.addAttribute("eroomss",new RoomPojo(room));
        return "redirect:room/roomlist";
    }

}

