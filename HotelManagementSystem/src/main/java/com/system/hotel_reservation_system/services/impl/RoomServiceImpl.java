package com.system.hotel_reservation_system.services.impl;

import com.system.hotel_reservation_system.entity.Room;
import com.system.hotel_reservation_system.pojo.RoomPojo;
import com.system.hotel_reservation_system.repo.RoomRepo;
import com.system.hotel_reservation_system.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepo RoomRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/hotel_mgmt";


    @Override
    public String saveRoom(RoomPojo RoomPojo) throws IOException {
        Room room = new Room();
        room.setHotelname(RoomPojo.getHotelname());
        room.setCity(RoomPojo.getCity());
        room.setAddress(RoomPojo.getAddress());
        room.setPrice(RoomPojo.getPrice());
        room.setRoom_description(RoomPojo.getRoom_description());
        room.setRoom_type(RoomPojo.getRoom_type());
        room.setPhone_number(RoomPojo.getPhone_number());
        room.setNo_of_people(RoomPojo.getNo_of_people());

        if(RoomPojo.getImage1()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, RoomPojo.getImage1().getOriginalFilename());
            fileNames.append(RoomPojo.getImage1().getOriginalFilename());
            Files.write(fileNameAndPath, RoomPojo.getImage1().getBytes());

            room.setImage1(RoomPojo.getImage1().getOriginalFilename());
        }

         if(RoomPojo.getImage2()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, RoomPojo.getImage2().getOriginalFilename());
            fileNames.append(RoomPojo.getImage2().getOriginalFilename());
            Files.write(fileNameAndPath, RoomPojo.getImage2().getBytes());

            room.setImage2(RoomPojo.getImage2().getOriginalFilename());
        }

         if(RoomPojo.getImage3()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, RoomPojo.getImage3().getOriginalFilename());
            fileNames.append(RoomPojo.getImage3().getOriginalFilename());
            Files.write(fileNameAndPath, RoomPojo.getImage3().getBytes());

            room.setImage3(RoomPojo.getImage3().getOriginalFilename());
        }

         if(RoomPojo.getImage4()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, RoomPojo.getImage4().getOriginalFilename());
            fileNames.append(RoomPojo.getImage4().getOriginalFilename());
            Files.write(fileNameAndPath, RoomPojo.getImage4().getBytes());

            room.setImage4(RoomPojo.getImage4().getOriginalFilename());
        }

         if(RoomPojo.getImage5()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, RoomPojo.getImage5().getOriginalFilename());
            fileNames.append(RoomPojo.getImage5().getOriginalFilename());
            Files.write(fileNameAndPath, RoomPojo.getImage5().getBytes());

            room.setImage5(RoomPojo.getImage5().getOriginalFilename());
        }

        RoomRepo.save(room);
        return "Created";

    }

    @Override
    public List<Room> fetchAll() {
        return RoomRepo.findAll();
    }
}
