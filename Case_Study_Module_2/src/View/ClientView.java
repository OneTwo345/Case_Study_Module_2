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

import java.util.*;

import static View.LoginView.loginMenu;
import static service.ReservationService.loadReservation;
import static service.ReservationService.reservationList;
import static service.RoomService.roomList;
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
            System.out.println("1. Xem danh sách phòng hát");
            System.out.println("2. Đặt phòng");
            System.out.println("3. Xem bài hát gợi ý");
            System.out.println("4. Liên lạc chủ quán hát");
            System.out.println("5. Hủy cuộc hẹn");
            System.out.println("6. Xem cuộc hẹn của bạn");
            System.out.println("7. Đặt trước đồ ăn");
            System.out.println("8. Xem đồ ăn đã đặt");
            System.out.println("9. Hủy đồ ăn đã đặt");
            System.out.println("10. Cật nhập tài khoản");
            System.out.println("11. Hộp thư tin nhắn");
            System.out.println("12. Xem tin nhắn đã gửi");
            System.out.println("13. Xóa tin nhắn");
            System.out.println("14. Xóa toàn bộ tin nhắn");
            System.out.println("0. Quay lại");
            choice = getIntWithBound("Input choice", 0, 30);
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

                    contactOwner();
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
                case 9:
                    cancelPreOrderFood();
                    break;
                case 10:
                    updateAccount();
                    break;
                case 11:
                    viewMessagesFromOwner();
                    break;
                case 12:
                    viewSentMessages();
                    break;
                case 13:
                    deleteMessage();
                    break;
                case 14:
                    deleteAllMessages();
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
        System.out.println("Đặt phòng thành công");


    }

    public static void viewMyReservations() {
        loadReservation();
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


                System.out.printf("\t\t\t\t%-10d  %-15s %-30s %-20s %-10s %-15s %-20s \n", reservation.getReservationId(), reservation.getCustomerName(),AppUtils.formatDateTime(reservation.getTimeExpected()) ,
                        CurrencyFormat.covertPriceToString(reservation.getDownPayment()), reservation.getRoom().getRoomName(), reservation.getReservationRoomStatus(), reservation.getRoom().getRoomType());

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
            System.out.printf("\t\t\t\t%-10d  %-15s %-30s %-20s %-10s %-15s %-20s \n", reservation.getReservationId(), LoginService.getUserName(), reservation.getTimeExpected(),
                    CurrencyFormat.covertPriceToString(reservation.getDownPayment()), reservation.getRoom().getRoomName(), reservation.getReservationRoomStatus(), reservation.getRoom().getRoomType());
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
                    CurrencyFormat.covertPriceToString(reservation.getDownPayment()), reservation.getRoom().getRoomName(), reservation.getReservationRoomStatus(), reservation.getRoom().getRoomType(),
                    CurrencyFormat.covertPriceToString(reservation.getRoom().getRoomPricePerHour()));
        }
        int reservationId = getInt("Nhập ID của phòng bạn muốn xem:");
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

    public static void contactOwner() {
        System.out.println("Thông tin liên lạc của chủ quán hát:");
        System.out.println("- Tên: Duy Nguyen");
        System.out.println("- Số điện thoại: 0769973715");
        System.out.println("- Địa chỉ email: duy@gmail.com");

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
        int reservationId = getInt("Nhập ID của phòng bạn muốn gửi lời nhắn:");
        boolean foundReservation = false;
        for (Reservation reservation : myReservations) {
            if (reservationId == reservation.getReservationId()) {
              Reservation reservationContactId = reservation;
              String message = getString("Nhập vào thông báo bạn muốn gửi");
              Client client1 = new Client();
              Contact contact = new Contact(reservationContactId.getReservationId(),reservation.getCustomerName(),message, LocalDateTime.now());
              ContactService.contactList.add(contact);
              ContactService.saveContact();
                foundReservation = true;
                break;
            }
        }
        if (!foundReservation) {
            System.out.println("ID nhập vào không hợp lệ.");
        }



    }
    public static void cancelPreOrderFood() {
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
            System.out.printf("\t\t\t\t%-10d  %-15s %-30s %-20s %-10s %-15s %-20s \n", reservation.getReservationId(), LoginService.getUserName(), reservation.getTimeExpected(),
                    CurrencyFormat.covertPriceToString(reservation.getDownPayment()), reservation.getRoom().getRoomName(), ERoomStatus.WAITING, reservation.getRoom().getRoomType());
        }
        int reservationId = getInt("Nhập ID của đặt phòng bạn muốn hủy đồ ăn:");
        Reservation reservationToCancelPreOrder = null;
        for (Reservation reservation : myReservations) {
            if (reservation.getReservationId() == reservationId) {
                reservationToCancelPreOrder = reservation;
                break;
            }
        }
        if (reservationToCancelPreOrder == null) {
            System.out.println("Không tìm thấy đặt phòng có ID là " + reservationId + ".");
            return;
        }
        List<OrderedFood> preOrderedFoodList = reservationToCancelPreOrder.getPreOrderedFoodList();
        if (preOrderedFoodList == null || preOrderedFoodList.isEmpty()) {
            System.out.println("Đặt phòng này không có đồ ăn nào để hủy.");
            return;
        }
        System.out.println("Danh sách đồ ăn đã đặt trước của đặt phòng có ID là " + reservationId + ":");
        System.out.println("\t\t\t\t===========================================================================");
        System.out.printf("\t\t\t\t%-10s %-30s %-20s %-20s \n", "ID", "Tên món ăn", "Số lượng", "Giá");
        for (OrderedFood orderedFood : preOrderedFoodList) {
            System.out.printf("\t\t\t\t%-10d %-30s %-20d %-20s \n", orderedFood.getFood().getFoodId(), orderedFood.getFood().getFoodName(),
                    orderedFood.getQuantity(), CurrencyFormat.covertPriceToString(orderedFood.getFood().getFoodPrice()));
        }
        int foodId = getInt("Nhập ID của món ăn bạn muốn hủy đặt trước:");
        boolean foundFood = false;
        for (OrderedFood orderedFood : preOrderedFoodList) {
            if (orderedFood.getFood().getFoodId() == foodId) {
                preOrderedFoodList.remove(orderedFood);
                System.out.println("Đã hủy đặt trước đồ ăn có ID là " + foodId + ".");
                foundFood = true;
                break;
            }
        }
        if (!foundFood) {
            System.out.println("Không tìm thấy món ăn có ID là " + foodId + ".");
        }
    }
    public static void viewMessagesFromOwner() {
        ContactService.loadContact();
        ContactService.loadMessage();

        Set<String> uniqueMessages = new HashSet<>();
        for (Contact contact : ContactService.contactList) {
            if (contact.getName().equals("Duy Nguyen")) {
                uniqueMessages.add(contact.getMessage());
            }
        }
        for (Contact contact : ContactService.messageList) {
            if (contact.getUsername().equals(LoginService.getUserName())) {
                uniqueMessages.add(contact.getMessage());
            }
        }
        if (uniqueMessages.isEmpty()) {
            System.out.println("Không có thông báo nào từ chủ quán hát.");
            return;
        }
        System.out.println("Danh sách thông báo từ chủ quán hát:");
        int count = 1;
        for (String message : uniqueMessages) {
            System.out.println("--------------------------------------------------");
            System.out.printf("STT: %d\n", count);
            System.out.printf("Nội dung: %s\n", message);
            System.out.println("--------------------------------------------------");
            count++;
        }
    }
    public static void viewSentMessages() {
        ContactService.loadContact();
        String senderName = LoginService.getUserName();
        List<Contact> sentMessages = new ArrayList<>();
        for (Contact contact : ContactService.contactList) {
            if (contact.getUsername().equals(senderName)) {
                sentMessages.add(contact);
            }
        }
        if (sentMessages.isEmpty()) {
            System.out.println("Bạn chưa gửi tin nhắn nào.");
            return;
        }
        System.out.println("Danh sách tin nhắn đã gửi:");
        for (Contact contact : sentMessages) {
            System.out.println("--------------------------------------------------");
            System.out.printf("Người nhận: %s\n", "Duy Nguyen");
            System.out.printf("Nội dung: %s\n", contact.getMessage());
            System.out.printf("Giờ gửi: %s\n",AppUtils.formatDateTime(contact.getLocalDateTime()) );
            System.out.println("--------------------------------------------------");
        }
    }
    public static void deleteMessage() {
        int messageId = getInt("Nhập ID tin nhắn muốn xóa");
        ContactService.loadContact();
        boolean found = false;
        for (Contact contact : ContactService.contactList) {
            if (contact.getId() == messageId) {
                ContactService.contactList.remove(contact);
                ContactService.saveContact();
                System.out.println("Đã xóa tin nhắn có ID là " + messageId + ".");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy tin nhắn có ID là " + messageId + ".");
        }
    }
    public static void deleteAllMessages() {
        ContactService.loadContact();
        if (ContactService.contactList.isEmpty()) {
            System.out.println("Không có tin nhắn nào để xóa.");
            return;
        }
        ContactService.contactList.clear();
        ContactService.saveContact();
        System.out.println("Đã xóa tất cả tin nhắn.");
    }



}


//
