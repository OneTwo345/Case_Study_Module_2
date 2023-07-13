package main;

import model.enums.EPath;
import service.ManagerService;
import service.RoomService;
import utils.InitData;

import java.io.IOException;
import java.security.Provider;

import static utils.DisplayData.*;
import static utils.InitData.*;

public class Main {
    public static void main(String[] args) throws IOException {


        System.out.println(ManagerService.listManagers.get(0).toString());

    }
}
