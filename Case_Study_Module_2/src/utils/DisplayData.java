package utils;


import model.Food;
import model.Reservation;
import model.Room;
import service.RoomService;

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
            System.out.printf("\t\t\t\t%-10d %-25s %-30s %-25s \n", food.getFoodId(), food.getFoodName(), food.geteTypeOfFood(),
                    CurrencyFormat.covertPriceToString(food.getFoodPrice()));
        }
        System.out.println("\t\t\t\t=========================================================================================================================\n\n");
//        menu.boss();
    }

    public static void displayRoom() {
//        List<Room> rooms = (List<Room>) SerializationUtil.deserialize
//                ("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt");
        System.out.println("Thông tin phòng:");
        System.out.println("\t\t\t\t===========================================================================================================");
        System.out.printf("\t\t\t\t%-10s %-25s %-20s %-20s %-10s %-15s \n", "ID", "Tên phòng", "Trạng thái", "Loại phòng", "Sức chứa", "Giá/1h");
        for (Room room : RoomService.roomList) {
            System.out.printf("\t\t\t\t%-10d %-25s %-20s %-20s %-10d %-15s \n", room.getRoomId(), room.getRoomName(), room.getRoomStatus().toString(), room.getRoomType().toString(), room.getCapacity(), CurrencyFormat.covertPriceToString(room.getRoomPricePerHour()));
        }
        System.out.println("\t\t\t\t===========================================================================================================\n\n");

    }

    public static void displayReservation() {
        List<Room> rooms  = (List<Room>) SerializationUtil.deserialize
                ("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt");
        List<Reservation> reservations = (List<Reservation>) SerializationUtil.deserialize("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\reservations.txt");
        if (reservations == null) {
            System.out.println("Không có đặt phòng nào.");
            return;
        }
        System.out.println("Thông tin cuộc hẹn:");
        System.out.println("\t\t\t\t===================================================================================================================================================");
        System.out.printf("\t\t\t\t%-10s %-10s %-20s %-25s %-20s %-10s %-15s %-30s \n", "ID ","ID Khách", "Tên khách", "Ngày giờ", "Tiền cọc", "Phòng", "Trạng thái","Loại");
        for (Reservation reservation : reservations) {
            DateFormat.convertDateTypeWithHours(reservation.getTimeExpected());
            System.out.printf("\t\t\t\t%-10d %-10s %-15s %-30s %-20s %-10s %-15s %-20s \n", reservation.getReservationId(),reservation.getCustomerId(), reservation.getCustomerName(),DateFormat.formatDateWithHours(reservation.getTimeExpected()),
                   CurrencyFormat.covertPriceToString(reservation.getDownPayment()) ,reservation.getRoom().getRoomName(), reservation.getReservationRoomStatus(),reservation.getRoom().getRoomType());
        }
        System.out.println("\t\t\t\t====================================================================================================================================================\n\n");

    }

    public static void main(String[] args) {
        displayReservation();
    }


}


