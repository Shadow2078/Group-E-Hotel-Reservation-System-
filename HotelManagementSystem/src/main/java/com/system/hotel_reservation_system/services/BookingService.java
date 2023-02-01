package com.system.hotel_reservation_system.services;

import com.system.hotel_reservation_system.entity.Book;
import com.system.hotel_reservation_system.pojo.BookPojo;

import java.util.List;

public interface BookingService {
    String save (BookPojo bookPojo);

    List<Book> fetchAll();
}
