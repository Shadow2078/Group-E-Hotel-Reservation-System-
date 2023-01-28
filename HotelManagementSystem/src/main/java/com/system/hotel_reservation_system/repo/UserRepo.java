package com.system.hotel_reservation_system.repo;

import com.system.hotel_reservation_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
<<<<<<< HEAD
    Optional<Object> findByPassword(String password);

    Optional<Object> findByEmail(String email);


    @Query(value = "UPDATE users SET password =?1 WHERE email = ?2", nativeQuery = true)
    void updatePassword(String password, String email);
=======
    @Query(value = "select * from USERS where email=?1", nativeQuery = true)
    Optional<User> findByEmail(String email);
>>>>>>> 17123dc8ac4276e53f0c0efd260a6fe44cc48168
}
