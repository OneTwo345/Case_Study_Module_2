package main;

import service.RoomService;

import java.io.IOException;
import java.security.Provider;

import static utils.DisplayData.*;
import static utils.InitData.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        initRoom();
//        initRoomDate();
//        initReservation();
//        initCategory();
    RoomService roomService = new RoomService();

//        System.out.println(roomService.getById(11).toString());
//        roomService.update(22);
//        roomService.create();
        displayReservation();
        displayRoom();


    }
}
