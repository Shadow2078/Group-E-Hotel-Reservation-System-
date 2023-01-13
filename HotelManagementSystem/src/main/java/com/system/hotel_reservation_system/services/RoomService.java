package com.system.hotel_reservation_system.services;

import com.system.hotel_reservation_system.pojo.RoomPojo;

import java.io.IOException;

public interface RoomService {

    String saveRoom(RoomPojo roomPojo) throws IOException;
}
