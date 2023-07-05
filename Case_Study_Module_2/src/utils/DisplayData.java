package utils;


import model.Food;
import model.Room;

import java.util.List;

public class DisplayData {
    public static void displayCategories() {
        List<Food> foods = (List<Food>) SerializationUtil.deserialize
                ("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\foods.txt");
//

        System.out.println("Danh sách sản phẩm : ");
        System.out.println("\t\t\t\t=========================================================================================================================");
        System.out.printf("\t\t\t\t%-10s %-25s %-30s %-15s  \n", "ID", "Loại sản phẩm", "Tên sản phẩm", "Giá");
        for (Food food : foods) {
            System.out.printf("\t\t\t\t%-10d %-25s %-30s %-25s \n", food.getId(), food.getFoodName(), food.geteTypeOfFood(),
                    CurrencyFormat.covertPriceToString(food.getFoodPrice()));
        }
        System.out.println("\t\t\t\t=========================================================================================================================\n\n");
//        menu.boss();
    }

    public static void displayRoom() {
        List<Room> rooms = (List<Room>) SerializationUtil.deserialize
                ("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt");
        System.out.println("Thông tin phòng:");
        System.out.println("\t\t\t\t===========================================================================================================");
        System.out.printf("\t\t\t\t%-10s %-25s %-20s %-20s %-10s %-15s \n", "ID", "Tên phòng", "Trạng thái", "Loại phòng", "Sức chứa", "Giá/1h");
        for (Room room : rooms) {
            System.out.printf("\t\t\t\t%-10d %-25s %-20s %-20s %-10d %-15s \n", room.getRoomId(), room.getRoomName(), room.getRoomStatus().toString(), room.getRoomType().toString(), room.getCapacity(), CurrencyFormat.covertPriceToString(room.getRoomPricePerHour()));
        }
            System.out.println("\t\t\t\t===========================================================================================================\n\n");

    }


}


