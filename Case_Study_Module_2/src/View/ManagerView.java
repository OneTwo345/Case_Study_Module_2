package View;

import model.Contact;
import model.Reservation;
import service.ContactService;
import service.LoginService;
import service.ReservationService;
import utils.AppUtils;
import utils.DisplayData;
import utils.ListView;

import java.time.LocalDateTime;
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


            choice = getIntWithBound("Input choice", 0, 10);
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
}
