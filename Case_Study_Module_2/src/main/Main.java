package main;

import service.RoomService;

import java.security.Provider;

import static utils.DisplayData.*;
import static utils.InitData.*;

public class Main {
    public static void main(String[] args) {
        initRoom();
        initReservation();
        initCategory();
    RoomService roomService = new RoomService();
        System.out.println(roomService.getById(11).toString());

    }
}
