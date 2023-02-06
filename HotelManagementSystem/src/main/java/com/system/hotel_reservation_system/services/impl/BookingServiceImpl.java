package com.system.hotel_reservation_system.services.impl;

import com.system.hotel_reservation_system.config.PasswordEncoderUtil;
import com.system.hotel_reservation_system.entity.Book;
import com.system.hotel_reservation_system.entity.User;
import com.system.hotel_reservation_system.pojo.BookPojo;
import com.system.hotel_reservation_system.repo.BookRepo;
import com.system.hotel_reservation_system.repo.RoomRepo;
import com.system.hotel_reservation_system.repo.UserRepo;
import com.system.hotel_reservation_system.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private  final RoomRepo roomRepo;
    private  final BookRepo bookRepo;
    private  final UserRepo userRepo;
    @Override
    public String save(BookPojo bookPojo) {
        Book book = new Book();


        book.setCheckin(bookPojo.getCheckin());
        book.setCheckout(bookPojo.getCheckout());
        book.setPeople(bookPojo.getPeople());
        book.setPhone(bookPojo.getPhone());
        book.setUserId(userRepo.findById(bookPojo.getUserId()).orElseThrow());
        book.setRoomId(roomRepo.findById(bookPojo.getRoomId()).orElseThrow());
        bookRepo.save(book);
        return "Created";    }
}
