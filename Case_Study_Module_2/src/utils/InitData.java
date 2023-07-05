package utils;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitData {

    public static void init() {

    }

    public static void initRoom() {
        Room room1 = new Room(11, "T1-1", ERoomStatus.available, ERoomType.Normal, 30, 60000);
        Room room2 = new Room(12, "T1-2", ERoomStatus.available, ERoomType.Student, 20, 40000);
        Room room3 = new Room(13, "T1-3", ERoomStatus.available, ERoomType.VIP, 50, 100000);
        Room room4 = new Room(21, "T2-1", ERoomStatus.available, ERoomType.Normal, 30, 60000);
        Room room5 = new Room(22, "T2-2", ERoomStatus.available, ERoomType.Student, 20, 40000);
        Room room6 = new Room(23, "T2-3", ERoomStatus.available, ERoomType.VIP, 50, 100000);

        List<Room> rooms = new ArrayList<>(Arrays.asList(room1, room2, room3, room4, room5, room6));
        SerializationUtil.serialize(rooms, "D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt");


    }

    public static void initReservation() {
        List<Room> rooms = (List<Room>) SerializationUtil.deserialize("rooms.txt");

        Reservation reservation1 = new Reservation(121, "Duy",
                "05-06-2023 14:30:30", 200000, rooms.get(5), ERoomStatus.available);
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservation1);

        SerializationUtil.serialize(reservations, "D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\reservation.txt");
    }

    public static void initCategory() {
        List<Food> foods = new ArrayList<>();
        Food comboHuda1 = new Food("Bia/10 chai", 100000d, ETypeOfFood.drink);
        Food comboHuda2 = new Food("Bia/1 thung", 250000d, ETypeOfFood.drink);
        Food fruitDishBig = new Food("Dia trai cay lon", 100000d, ETypeOfFood.food);
        Food fruitDishSmall = new Food("Dia trai cay nho", 80000d, ETypeOfFood.food);
        Food grilledSquid = new Food("Muc nuong", 100000d, ETypeOfFood.food);
        Food grilledChicken = new Food("Ga nuong",  250000d, ETypeOfFood.other);
        foods.add(comboHuda1);
        foods.add(comboHuda2);
        foods.add(fruitDishBig);
        foods.add(fruitDishSmall);
        foods.add(grilledSquid);
        foods.add(grilledChicken);
        SerializationUtil.serialize(foods, "D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\foods.txt");

    }




}

