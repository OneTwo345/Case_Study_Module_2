package main;

import model.enums.EPath;
import service.RoomService;

import java.io.IOException;
import java.security.Provider;

import static utils.DisplayData.*;
import static utils.InitData.*;

public class Main {
    public static void main(String[] args) throws IOException {

        initRoom();
        initReservation();
        initFood();




    }
}
