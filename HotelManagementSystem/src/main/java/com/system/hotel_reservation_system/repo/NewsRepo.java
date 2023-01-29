package com.system.hotel_reservation_system.repo;

import com.system.hotel_reservation_system.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NewsRepo extends JpaRepository<News,Integer> {
}
