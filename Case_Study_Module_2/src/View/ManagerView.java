package View;

import model.Contact;
import model.Reservation;
import model.Room;
import model.enums.ERoomStatus;
import service.ContactService;
import service.LoginService;
import service.ReservationService;
import service.RoomService;
import utils.AppUtils;
import utils.CurrencyFormat;
import utils.DisplayData;
import utils.ListView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static View.LoginView.loginMenu;
import static service.ReservationService.reservationList;
import static utils.AppUtils.*;
import static utils.DisplayData.*;

public class ManagerView {

    public static void managerMenu() {
        int choice;
        do {
            System.out.println("Room menu");
            System.out.println("1. Display room ");
            System.out.println("2. Check message");
            System.out.println("3. Delete message");
            System.out.println("4. Delete reservation");
            System.out.println("5. Contact customer");
            System.out.println("6. Sendmail all customer");
            System.out.println("7. Delete all mail");
            System.out.println("8. Change room status");
            System.out.println("9. Xem cuộc hẹn theo ngày");
            System.out.println("10. Thay đổi trạng thái phòng theo Id cuộc hẹn");


            choice = getIntWithBound("Input choice", 0, 30);
            switch (choice) {
                case 1:
                    displayRoom();
                    displayReservation();
                    break;
                case 2:
                    displayNotification();
                    break;
                case 3:
                    deleteMessage();
                    break;
                case 4:
                    deleteReservation();
                    break;
                case 5:
                    contactCustomer();
                    break;
                case 6:
                    contactEachCustomer();
                    break;
                case 7:
                    deleteAllMessages();
                    break;
                case 8:
                    changeRoomStatus();
                    break;
                case 9:
                    displayReservationByDate();
                    break;
                case 10:
                    changeRoomStatusByReservationId();
                    break;

                case 0:
                    System.out.println("Back to Login menu");
                    loginMenu();
                    break;
            }
        }
        while (choice != 0);

    }

    public static void main(String[] args) {
        managerMenu();
    }

    public static void deleteReservation() {
        int reservationIdDelete = getInt("Nhập ID cuộc hẹn bạn muốn xóa ");
        ReservationService.loadReservation();
        boolean found = false;
        for (Reservation reservation : reservationList) {
            if (reservation.getReservationId() == reservationIdDelete) {
                reservationList.remove(reservation);
                ReservationService.saveReservation();
                System.out.println("Đã xóa cuộc hẹn có ID là " + reservationIdDelete + ".");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy cuộc hẹn có ID là " + reservationIdDelete + ".");
        }
    }


    public static void displayNotification() {
        ContactService.loadContact();
        if (ContactService.contactList == null || ContactService.contactList.isEmpty()) {
            System.out.println("Bạn không có thông báo nào!");
        } else {
            System.out.println("Danh sách thông báo:");
            for (Contact contact : ContactService.contactList)
                if (!contact.getName().equals("Duy Nguyen")) {
                    System.out.printf("ID: %d\n", contact.getId());
                    System.out.printf("Người gửi: %s\n", contact.getName());
                    System.out.printf("Nội dung: %s\n", contact.getMessage());
                    System.out.printf("Giờ gửi: %s\n", AppUtils.formatDateTime(contact.getLocalDateTime()));

                    System.out.println("--------------------------------------------------");
                }
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

    public static void contactCustomer() {
        ContactService.loadContact();
        String customerName = getString("Nhập tên khách hàng:");
        List<Reservation> customerReservations = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            if (reservation.getCustomerName().equals(customerName)) {
                customerReservations.add(reservation);
            }
        }
        if (customerReservations.isEmpty()) {
            System.out.println("Khách hàng không có đặt phòng nào.");
            return;
        }
        displayReservation();
        int reservationId = getInt("Nhập ID đặt phòng của khách hàng:");
        boolean foundReservation = false;
        for (Reservation reservation : customerReservations) {
            if (reservationId == reservation.getReservationId()) {
                foundReservation = true;
                String message = getString("Nhập vào thông báo của chủ quán hát:");
                Contact contact = new Contact(reservationId, "Duy Nguyen", message, LocalDateTime.now());
                ContactService.contactList.add(contact);
                ContactService.saveContact();
                System.out.println("Thông báo đã được gửi đến khách hàng.");
                break;
            }
        }
        if (!foundReservation) {
            System.out.println("ID đặt phòng không hợp lệ.");
        }
    }

    public static void contactEachCustomer() {
        ContactService.loadContact();
        String message = getString("Nhập vào thông báo của chủ quán hát:");
        LocalDateTime now = LocalDateTime.now();
        Map<String, String> customerMessages = new HashMap<>();

        for (Reservation reservation : reservationList) {
            if (reservation.getTimeExpected().isAfter(now)) {
                String username = reservation.getCustomerName();
                if (!customerMessages.containsKey(username)) {
                    customerMessages.put(username, message);
                }
            }
        }

        for (Map.Entry<String, String> entry : customerMessages.entrySet()) {
            Contact contact = new Contact(0, "Duy Nguyen", entry.getValue(), now, entry.getKey());
            ContactService.contactList.add(contact);
        }

        ContactService.saveContact();
        System.out.println("Thông báo đã được gửi đến từng khách hàng.");

    }

    public static void changeRoomStatus() {
        RoomService.loadRoom();

        int roomId = getInt("Nhập ID của phòng cần thay đổi trạng thái: ");

        Room room = null;
        for (Room r : RoomService.roomList) {
            if (r.getRoomId() == roomId) {
                room = r;
                break;
            }
        }
        if (room == null) {
            System.out.println("Không tìm thấy phòng với ID tương ứng.");
            return;
        }
        ERoomStatus newStatus = null;
        while (newStatus == null) {

            int choice = getIntWithBound("Chọn trạng thái cho phòng" +
                    " 1: Trống" +
                    " 2: Đang sử dụng" +
                    " 3: Đã đặt trước" +
                    " 4: Bảo trì" +
                    " 5: Đang chờ", 1, 5);

            switch (choice) {
                case 1:
                    newStatus = ERoomStatus.AVAILABLE;
                    break;
                case 2:
                    newStatus = ERoomStatus.INUSE;
                    break;
                case 3:
                    newStatus = ERoomStatus.RESERVED;
                    break;
                case 4:
                    newStatus = ERoomStatus.MAINTENANCE;
                    break;
                case 5:
                    newStatus = ERoomStatus.WAITING;
                    break;
                default:
                    System.out.println("Chọn không hợp lệ.");
            }
        }
        room.setRoomStatus(newStatus);
        RoomService.saveRoom();
        System.out.println("Trạng thái của phòng đã được cập nhật.");
        displayRoom();
    }

    public static void displayReservationByDate() {
        ReservationService.loadReservation();
        LocalDate localDate = null;

        while (localDate == null) {
            String date = getString("Nhập ngày cần xem (dd/MM/yyyy): ");
            try {
                localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng ngày không đúng. Vui lòng nhập lại!");
            }
        }

        System.out.println("Thông tin cuộc hẹn ngày " + localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ":");
        System.out.println("\t\t\t\t===================================================================================================================================================");
        System.out.printf("\t\t\t\t%-10s %-20s %-25s %-20s %-10s %-15s %-30s \n", "ID ", "Tên khách", "Ngày giờ", "Tiền cọc", "Phòng", "Trạng thái", "Loại");
        int count = 1;
        for (Reservation reservation : ReservationService.reservationList) {
            LocalDate reservationDate = reservation.getTimeExpected().toLocalDate();
            if (reservationDate.isEqual(localDate)) {
                System.out.printf("\t\t\t\t%-10d  %-15s %-30s %-20s %-10s %-15s %-20s \n", reservation.getReservationId(), reservation.getCustomerName(), reservation.getTimeExpected(),
                        CurrencyFormat.covertPriceToString(reservation.getDownPayment()), reservation.getRoom().getRoomName(), reservation.getReservationRoomStatus(), reservation.getRoom().getRoomType());
                count++;
            }
        }
        if (count == 1) {
            System.out.println("Không có cuộc hẹn nào vào ngày này.");
        }
        System.out.println("\t\t\t\t====================================================================================================================================================\n\n");

    }
    public static void changeRoomStatusByReservationId() {
        ReservationService.loadReservation();

        int reservationId = getInt("Nhập ID của cuộc hẹn: ");

        Reservation reservation = null;
        for (Reservation r : ReservationService.reservationList) {
            if (r.getReservationId() == reservationId) {
                reservation = r;
                break;
            }
        }
        if (reservation == null) {
            System.out.println("Không tìm thấy cuộc hẹn với ID tương ứng.");
            return;
        }

        Room room = reservation.getRoom();
        ERoomStatus newStatus = null;
        while (newStatus == null) {

            int choice = getIntWithBound("Chọn trạng thái cho phòng" +
                    " 1: Trống" +
                    " 2: Đang sử dụng" +
                    " 3: Đã đặt trước" +
                    " 4: Bảo trì" +
                    " 5: Đang chờ", 1, 5);

            switch (choice) {
                case 1:
                    newStatus = ERoomStatus.AVAILABLE;
                    break;
                case 2:
                    newStatus = ERoomStatus.INUSE;
                    break;
                case 3:
                    newStatus = ERoomStatus.RESERVED;
                    break;
                case 4:
                    newStatus = ERoomStatus.MAINTENANCE;
                    break;
                case 5:
                    newStatus = ERoomStatus.WAITING;
                    break;
                default:
                    System.out.println("Chọn không hợp lệ.");
            }
        }
        reservation.setReservationRoomStatus(newStatus);
        ReservationService.saveReservation();
        System.out.println("Trạng thái của phòng đã được cập nhật.");
        displayReservation();
    }



}
