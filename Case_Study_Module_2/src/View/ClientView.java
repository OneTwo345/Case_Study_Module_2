package View;


import model.*;
import model.enums.EPath;
import model.enums.ERoomStatus;
import service.*;
import utils.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static View.LoginView.loginMenu;
import static service.ReservationService.reservationList;
import static service.RoomService.roomList;
import static service.RoomService.saveRoom;
import static utils.AppUtils.*;
import static utils.DisplayData.*;


public class ClientView {
    static RoomService roomService = new RoomService();
    static Reservation reservation = new Reservation();
    static ClientService clientService = new ClientService();

    public static void clientMenu() {
        int choice;
        do {
            System.out.println("Room menu");
            System.out.println("1. Display room ");
            System.out.println("2. Book room");
            System.out.println("3. New song");
            System.out.println("4. Update Account");
            System.out.println("5. Cancel reservation");
            System.out.println("6. Show your room");
            System.out.println("7. Pre-order food");
            System.out.println("8. Show Pre-order food");
            System.out.println("0. Back to login menu");
            choice = getIntWithBound("Input choice", 0, 10);
            switch (choice) {
                case 1:
                    displayRoomClientView();

                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    getSong();
                    break;
                case 4:
                    updateAccount();
                    break;
                case 5:
                    cancelReservation();
                    break;
                case 6:
                    viewMyReservations();
                    break;
                case 7:
                    preOrderFood();
                    break;
                case 8:
                    showPreOrderFood();
                    break;

                case 0:
                    System.out.println("Back to Login menu");
                    loginMenu();
                    break;
            }
        }
        while (choice != 0);
    }


    public static void main(String[] args) throws IOException {
        clientMenu();
    }


    public static void bookRoom() {


        String customerName = LoginService.getUserName();
        LocalDateTime timeReservation = getDateTimeNow();
        LocalDateTime timeExpected = getDateTime("Nhập ngày giờ dưới dạng YYYY-MM-DD HH:MM:SS");
        double downPayment = getDouble("Nhập vào số tiền  cọc trước");


        int roomIdReservation;
        Room selectedRoom = null;
        boolean validRoomId = false;

        while (!validRoomId) {
            roomIdReservation = getInt("Nhập Id phòng");
            for (Room room : roomList) {
                if (room.getRoomId() == roomIdReservation) {
                    selectedRoom = room;
                    validRoomId = true;
                    break;
                }
            }
            if (!validRoomId) {
                System.out.println("Mã phòng không hợp lệ. Vui lòng nhập lại.");
            }
        }


        Reservation reservation1 = new Reservation(customerName, timeExpected, downPayment, selectedRoom, ERoomStatus.WAITING

        );
        if (reservationList == null) {
            reservationList = new ArrayList<>();
        }
        reservationList.add(reservation1);
        ReservationService.saveReservation();


    }

    public static void viewMyReservations() {
        String customerName = LoginService.getUserName();
        List<Reservation> myReservations = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            if (reservation.getCustomerName().equals(customerName)) {
                myReservations.add(reservation);
            }
        }
        if (myReservations.isEmpty()) {
            System.out.println("Bạn chưa đặt phòng nào.");
        } else {
            System.out.println("Danh sách các phòng bạn đã đặt:");
            System.out.println("\t\t\t\t===================================================================================================================================================");
            System.out.printf("\t\t\t\t%-10s %-20s %-25s %-20s %-10s %-15s %-30s \n", "ID ", "Tên khách", "Ngày giờ", "Tiền cọc", "Phòng", "Trạng thái", "Loại");
            for (Reservation reservation : myReservations) {


                System.out.printf("\t\t\t\t%-10d  %-15s %-30s %-20s %-10s %-15s %-20s \n", reservation.getReservationId(), reservation.getCustomerName(), reservation.getTimeExpected(),
                        CurrencyFormat.covertPriceToString(reservation.getDownPayment()), reservation.getRoom().getRoomName(), ERoomStatus.WAITING, reservation.getRoom().getRoomType());

            }
        }

    }

    public static void cancelReservation() {
        String customerName = LoginService.getUserName();
        List<Reservation> myReservations = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            if (reservation.getCustomerName().equals(customerName)) {
                myReservations.add(reservation);
            }
        }
        if (myReservations.isEmpty()) {
            System.out.println("Bạn chưa đặt phòng nào.");
        } else {
            System.out.println("Danh sách các phòng bạn đã đặt:");
            System.out.println("\t\t\t\t===================================================================================================================================================");
            System.out.printf("\t\t\t\t%-10s %-20s %-25s %-20s %-10s %-15s %-30s \n", "ID ", "Tên khách", "Ngày giờ", "Tiền cọc", "Phòng", "Trạng thái", "Loại");
            for (Reservation reservation : myReservations) {
                System.out.printf("\t\t\t\t%-10d  %-15s %-30s %-20s %-10s %-15s %-20s \n", reservation.getReservationId(), reservation.getCustomerName(), reservation.getTimeExpected(),
                        CurrencyFormat.covertPriceToString(reservation.getDownPayment()), reservation.getRoom().getRoomName(), ERoomStatus.WAITING, reservation.getRoom().getRoomType());
            }
            int reservationId = getInt("Nhập ID của đặt phòng bạn muốn hủy:");
            Reservation reservationToCancel = null;
            for (Reservation reservation : myReservations) {
                if (reservation.getReservationId() == reservationId) {
                    reservationToCancel = reservation;
                    break;
                }
            }
            if (reservationToCancel != null) {
                reservationList.remove(reservationToCancel);
                System.out.println("Hủy đặt phòng thành công.");
            } else {
                System.out.println("Không tìm thấy đặt phòng có ID là " + reservationId + ".");
            }
        }
    }


    //
    public static void getSong() {
        String url = "https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html";
        System.out.println("\n" +
                "Some music");
        try {
            Document doc = Jsoup.connect(url).get();
            Elements songList = doc.select(".name_song");
            for (Element song : songList) {
                String name = song.text();
                System.out.println(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateAccount() {
        ListView.printMenu(ListView.updateClientList);
        int choice = getIntWithBound("Input choice", 0, 3);
        switch (choice) {
            case 1:
                while (true) {
                    String name = getString("Input new name:");
                    boolean isValid = ValidateUtils.isUserName(name);
                    if (isValid) {
                        ClientService.currentClient.setName(name);
                        break;
                    } else {
                        System.out.println("Invalid name. Please try again.");
                    }
                }
                break;
            case 2:
                while (true) {
                    String password = getString("Input new password:");
                    boolean isValid = ValidateUtils.isPassWord(password);
                    if (isValid) {
                        ClientService.currentClient.setPassword(password);
                        break;
                    } else {
                        System.out.println("Invalid password. Please try again.");
                    }
                }
                break;
            case 3:
                while (true) {
                    String phoneNumber = getString("Input new phone number:");
                    boolean isValid = ValidateUtils.isPhoneNumber(phoneNumber);
                    if (isValid) {
                        ClientService.currentClient.setPhoneNumber(phoneNumber);
                        break;
                    } else {
                        System.out.println("Invalid phone number. Please try again.");
                    }
                }
                break;
            case 0:
                System.out.println("Back to Login menu");
                clientMenu();
                break;

        }
        clientService.update(ClientService.currentClient);
    }

    public static void preOrderFood() {

        String customerName = LoginService.getUserName();
        List<Reservation> myReservations = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            if (reservation.getCustomerName().equals(customerName)) {
                myReservations.add(reservation);
            }
        }
        if (myReservations.isEmpty()) {
            System.out.println("Bạn chưa đặt phòng nào.");
            return;
        }
        System.out.println("Danh sách các phòng bạn đã đặt:");
        System.out.println("\t\t\t\t===================================================================================================================================================");
        System.out.printf("\t\t\t\t%-10s %-20s %-25s %-20s %-10s %-15s %-30s \n", "ID ", "Tên khách", "Ngày giờ", "Tiền cọc", "Phòng", "Trạng thái", "Loại");
        for (Reservation reservation : myReservations) {
            System.out.printf("\t\t\t\t%-10d  %-15s %-30s %-20s %-10s %-15s %-20s \n", reservation.getReservationId(), reservation.getCustomerName(), reservation.getTimeExpected(),
                    CurrencyFormat.covertPriceToString(reservation.getDownPayment()), reservation.getRoom().getRoomName(), ERoomStatus.WAITING, reservation.getRoom().getRoomType());
        }
        int reservationId = getInt("Nhập ID của đặt phòng bạn muốn đặt trước đồ ăn:");
        Reservation reservationToPreOrder = null;
        for (Reservation reservation : myReservations) {
            if (reservation.getReservationId() == reservationId) {
                reservationToPreOrder = reservation;
                break;
            }
        }
        if (reservationToPreOrder == null) {
            System.out.println("Không tìm thấy đặt phòng có ID là " + reservationId + ".");
            return;
        }
        List<Food> foodList = FoodService.listFoods;
        if (foodList.isEmpty()) {
            System.out.println("Hiện tại không có đồ ăn nào để đặt.");
            return;
        }
        System.out.println("Danh sách các món ăn:");
        System.out.println("\t\t\t\t===========================================================================");
        System.out.printf("\t\t\t\t%-10s %-30s %-20s \n", "ID", "Tên món ăn", "Giá tiền");
        for (Food food : foodList) {
            System.out.printf("\t\t\t\t%-10d %-30s %-20s \n", food.getFoodId(), food.getFoodName(), CurrencyFormat.covertPriceToString(food.getFoodPrice()));
        }

        List<OrderedFood> orderedFoodList = new ArrayList<>();
        List<OrderedFood> preOrderedFoodList = reservationToPreOrder.getPreOrderedFoodList();
        if (preOrderedFoodList == null) {
            preOrderedFoodList = new ArrayList<OrderedFood>();
        }
        preOrderedFoodList.addAll(orderedFoodList);
        reservationToPreOrder.setPreOrderedFoodList(preOrderedFoodList);
        while (true) {
            int foodId = getInt("Nhập ID của món ăn bạn muốn đặt (nhập 0 để kết thúc đặt đồ ăn):");
            if (foodId == 0) {
                break;
            }
            Food foodToOrder = null;
            for (Food food : foodList) {
                if (food.getFoodId() == foodId) {
                    foodToOrder = food;
                    break;
                }
            }
            if (foodToOrder == null) {
                System.out.println("Không tìm thấy món ăn có ID là " + foodId + ".");
            } else {
                int quantity = getInt("Nhập số lượng món ăn bạn muốn đặt:");
                if (quantity > 0) {
                    OrderedFood orderedFood = new OrderedFood(foodToOrder, quantity);
                    orderedFoodList.add(orderedFood);
                    System.out.println("Đã đặt trước " + quantity + " phần của món " + foodToOrder.getFoodName() + ".");
                } else {
                    System.out.println("Số lượng phải lớn hơn 0.");
                }
            }
        }
        if (!orderedFoodList.isEmpty()) {
            preOrderedFoodList = reservationToPreOrder.getPreOrderedFoodList();
            preOrderedFoodList.addAll(orderedFoodList);
            reservationToPreOrder.setPreOrderedFoodList(preOrderedFoodList);
            System.out.println("Đã đặt trước đồ ăn cho đặt phòng có ID là " + reservationId + ".");
        } else {
            System.out.println("Bạn chưa đặt trước đồ ăn nào cho đặt phòng có ID là " + reservationId + ".");
        }

    }

    public static void showPreOrderFood() {

        String customerName = LoginService.getUserName();
        List<Reservation> myReservations = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            if (reservation.getCustomerName().equals(customerName)) {
                myReservations.add(reservation);
            }
        }
        if (myReservations.isEmpty()) {
            System.out.println("Bạn chưa đặt phòng nào.");
            return;
        }
        System.out.println("Danh sách các phòng bạn đã đặt:");
        System.out.println("\t\t\t\t===================================================================================================================================================");
        System.out.printf("\t\t\t\t%-10s %-20s %-25s %-20s %-10s %-15s %-20s %-20s\n", "ID ", "Tên khách", "Ngày giờ", "Tiền cọc", "Phòng", "Trạng thái", "Loại", "Số tiền hát 1h");
        for (Reservation reservation : myReservations) {
            System.out.printf("\t\t\t\t%-10d  %-15s %-30s %-20s %-10s %-15s %-20s %-20s\n", reservation.getReservationId(), reservation.getCustomerName(), reservation.getTimeExpected(),
                    CurrencyFormat.covertPriceToString(reservation.getDownPayment()), reservation.getRoom().getRoomName(), ERoomStatus.WAITING, reservation.getRoom().getRoomType(),
                    CurrencyFormat.covertPriceToString(reservation.getRoom().getRoomPricePerHour()));
        }
        int reservationId = getInt("Nhập ID của đặt phòng bạn muốn xem:");
        boolean foundReservation = false;
        for (Reservation reservation : myReservations) {
            if (reservationId == reservation.getReservationId()) {
                reservation.displayPreOrderedFoodList();
                foundReservation = true;
                break;
            }
        }
        if (!foundReservation) {
            System.out.println("ID nhập vào không hợp lệ.");
        }
    }
}


//
