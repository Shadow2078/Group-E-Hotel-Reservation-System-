package com.system.hotel_reservation_system.repo;

import com.system.hotel_reservation_system.entity.Book;
import com.system.hotel_reservation_system.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
}
