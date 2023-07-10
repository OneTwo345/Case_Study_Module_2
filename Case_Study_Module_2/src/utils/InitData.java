package utils;

import model.*;
import model.enums.EPath;
import model.enums.ERoomStatus;
import model.enums.ERoomType;
import model.enums.ETypeOfFood;
import service.FoodService;
import service.RoomService;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import static service.RoomService.roomList;


public class InitData {



    public static void initRoom() {
        Room room1 = new Room(11, "T1-1", ERoomStatus.AVAILABLE, ERoomType.NORMAL, 30, 60000);
        Room room2 = new Room(12, "T1-2", ERoomStatus.AVAILABLE, ERoomType.STUDENT, 20, 40000);
        Room room3 = new Room(13, "T1-3", ERoomStatus.AVAILABLE, ERoomType.VIP, 50, 150000);
        Room room4 = new Room(21, "T2-1", ERoomStatus.AVAILABLE, ERoomType.NORMAL, 30, 60000);
        Room room5 = new Room(22, "T2-2", ERoomStatus.AVAILABLE, ERoomType.STUDENT, 20, 50000);
        Room room6 = new Room(23, "T2-3", ERoomStatus.AVAILABLE, ERoomType.VIP, 50, 120000);
        Room room7 = new Room(31, "T3-1", ERoomStatus.AVAILABLE, ERoomType.NORMAL, 30, 80000);
        Room room8 = new Room(32, "T3-2", ERoomStatus.AVAILABLE, ERoomType.STUDENT, 20, 50000);
        Room room9 = new Room(33, "T3-3", ERoomStatus.AVAILABLE, ERoomType.VIP, 50, 200000);
        Room room10 = new Room(41, "T4-1", ERoomStatus.AVAILABLE, ERoomType.NORMAL, 30, 60000);
        Room room11 = new Room(42, "T4-2", ERoomStatus.AVAILABLE, ERoomType.STUDENT, 20, 40000);
        Room room12 = new Room(43, "T4-3", ERoomStatus.AVAILABLE
                , ERoomType.VIP, 50, 100000);

        List<Room> roomList = new ArrayList<>(Arrays.asList(room1, room2, room3, room4, room5, room6,room7,room8,room9,room10,room11,room12));

        SerializationUtil.serialize(roomList, "D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt");


    }


    public static void initReservation() {
        List<Reservation> reservationList  = new ArrayList<>();
       loadRooms();
//
        Date date1 = DateFormat.parseDateWithHours("12-12-2022 14:30:30");
        Date date2 = DateFormat.parseDateWithHours("12-12-2022 17:30:30");
        Date date3 = DateFormat.parseDateWithHours("12-12-2022 20:30:30");
        Reservation reservation1 = new Reservation("S123","Duy",date1, 150000,roomList.get(0),ERoomStatus.getRoomStatusById(1));
        Reservation reservation2 = new Reservation("S125","Nam",date2,
                0,roomList.get(2),ERoomStatus.getRoomStatusById(1));
        Reservation reservation3 = new Reservation("S153","Khoa",date3,
                50000,roomList.get(3),ERoomStatus.getRoomStatusById(1));

        List<Reservation> re = new ArrayList<>();
        reservationList.add(reservation1);
        reservationList.add(reservation2);
        reservationList.add(reservation3);
        SerializationUtil.serialize(reservationList,EPath.RESERVATION.toString());
    }


    public static void initFood() {
        List<Food> foodList = new ArrayList<>();
        Food comboHuda1 = new Food("Bia/10 chai", 100000d, ETypeOfFood.DRINK);
        Food comboHuda2 = new Food("Bia/1 thung", 250000d, ETypeOfFood.DRINK);
        Food fruitDishBig = new Food("Dia trai cay lon", 100000d, ETypeOfFood.FOOD);
        Food fruitDishSmall = new Food("Dia trai cay nho", 80000d, ETypeOfFood.FOOD);
        Food grilledSquid = new Food("Muc nuong", 100000d, ETypeOfFood.FOOD);
        Food grilledChicken = new Food("MC",  250000d, ETypeOfFood.OTHER);
        foodList.add(comboHuda1);
        foodList.add(comboHuda2);
        foodList.add(fruitDishBig);
        foodList.add(fruitDishSmall);
        foodList.add(grilledSquid);
        foodList.add(grilledChicken);
        SerializationUtil.serialize(foodList,EPath.FOOD.toString());
    }
    public static void loadRooms(){
        roomList = (List<Room>)  SerializationUtil.deserialize(EPath.ROOM.getFilePath());
    }
    public static void loadFoods(){
        FoodService.listFoods =(List<Food>) SerializationUtil.deserialize(EPath.FOOD.getFilePath());
    }
    public static void loadReservation(){
        roomList = (List<Room>)  SerializationUtil.deserialize(EPath.RESERVATION.getFilePath());
    }





}

