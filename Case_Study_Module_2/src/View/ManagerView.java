package View;

import model.*;
import model.enums.ERoomStatus;
import service.*;
import utils.AppUtils;
import utils.CurrencyFormat;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static View.LoginView.loginMenu;
import static service.BillDetailService.billDetailsList;
import static service.ReservationService.findReservationById;
import static service.ReservationService.reservationList;
import static service.RoomService.roomList;
import static utils.AppUtils.*;
import static utils.DisplayData.*;

public class ManagerView {

    public static void managerMenu() {
        int choice;
        do {
//            System.out.println("Manager menu");
//            System.out.println("1. Xem danh sách cuộc hẹn ");
//            System.out.println("2. Kiểm tra tin nhắn ");
//            System.out.println("3. Thêm thức ăn vào phòng");
//            System.out.println("4. Tính doanh thu tổng theo khoảng ngày");
//            System.out.println("5. Tính doanh thu tiền phòng theo khoảng ngày");
//            System.out.println("0. Quay lại");
            System.out.println("                               ╔═══════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                               ║                              GIAO DIỆN QUẢN LÝ                                    ║");
            System.out.println("                               ║                       [1]  DANH SÁCH CUỘC HẸN                                     ║");
            System.out.println("                               ║                       [2] KIỂM TRA TIN NHẮN                                       ║");
            System.out.println("                               ║                       [3] THÊM THỨC ĂN VÀO PHÒNG                                  ║");
            System.out.println("                               ║                       [4] TÍNH DOANH THU TỔNG THEO KHOẢNG NGÀY                    ║");
            System.out.println("                               ║                       [5] TÍNH DOANH THU TIỀN PHÒNG THEO KHOẢNG NGÀY              ║");
            System.out.println("                               ║                       [0] QUAY LẠI                                                ║");
            System.out.println("                               ╚═══════════════════════════════════════════════════════════════════════════════════╝");


            choice = getIntWithBound("Input choice", 0, 5);
            switch (choice) {
                case 1:
                    reservationMenu();
                    break;
                case 2:
                    mailManagerMenu();
                    break;
                case 3:
                    addFoodToReservation();
                    break;
                case 4:
                    calculateRevenueByDateRangeAndPrintDetails();
                    break;
                case 5:
                    calculatePricePerHourByDateRangeAndPrintDetails();
                    break;

                case 0:
                    System.out.println("Back to Login menu");
                    loginMenu();
                    break;
            }
        }
        while (choice != 0);

    }

    public static void reservationMenu() {
        int choice;
        do {
//            System.out.println("Reservation menu");
//            System.out.println("1. Xem danh sách cuộc hẹn ");
//            System.out.println("2. Xóa cuộc hẹn");
//            System.out.println("3. Xem cuộc hẹn theo ngày");
//            System.out.println("4. Thay đổi trạng thái phòng theo ID cuộc hẹn");
//            System.out.println("5. Tính tiền theo ID cuộc hẹn");
//            System.out.println("6. Thêm cuộc hẹn mới");
//            System.out.println("7. Xem thông tin chi tiết cuộc hẹn");
//            System.out.println("8. Chuyển phòng");
//            System.out.println("0. Quay lại");
            System.out.println("                               ╔═══════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                               ║                              GIAO DIỆN CUỘC HẸN                                   ║");
            System.out.println("                               ║                       [1] XEM DANH SÁCH CUỘC HẸN                                  ║");
            System.out.println("                               ║                       [2] XÓA CUỘC HẸN                                            ║");
            System.out.println("                               ║                       [3] XEM CUỘC HẸN THEO NGÀY                                  ║");
            System.out.println("                               ║                       [4] THAY ĐỔI TRẠNG THÁI CUỘC HẸN                            ║");
            System.out.println("                               ║                       [5] TÍNH TIỀN                                               ║");
            System.out.println("                               ║                       [6] THÊM CUỘC HẸN MỚI                                       ║");
            System.out.println("                               ║                       [7] XEM THÔNG TIN CHI TIẾT CUỘC HẸN                         ║");
            System.out.println("                               ║                       [8] CHUYỂN PHÒNG                                            ║");
            System.out.println("                               ║                       [0] QUAY LẠI                                                ║");
            System.out.println("                               ╚═══════════════════════════════════════════════════════════════════════════════════╝");


            choice = getIntWithBound("Input choice", 0, 30);
            switch (choice) {
                case 1:
                    displayRoomClientView();
                    displayReservation();
                    break;
                case 2:
                    deleteReservation();
                    break;
                case 3:
                    displayReservationByDate();
                    break;
                case 4:
                    changeRoomStatusByReservationId();
                    break;
                case 5:
                    makeBill();
                    break;
                case 6:
                    createNewReservation();
                    break;
                case 7:
                    checkReservationDetails();
                    break;
                case 8:
                    changeRoomByReservationId();

                case 0:
                    managerMenu();
                    break;
            }
        }
        while (choice != 0);

    }

    public static void mailManagerMenu() {
        int choice;
        do {
//            System.out.println("Mail Manager menu");
//            System.out.println("1. Kiểm tra tin nhắn ");
//            System.out.println("2. Xóa tin nhắn");
//            System.out.println("3. Liên lạc khách hàng");
//            System.out.println("4. Gửi tin nhắn cho những khách đặt trước");
//            System.out.println("5. Xóa toàn bộ tin nhắn ");
//            System.out.println("0. Quay lại");
            System.out.println("                               ╔═══════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                               ║                              GIAO DIỆN TIN NHẮN                                   ║");
            System.out.println("                               ║                       [1] KIỂM TRA TIN NHẮN                                       ║");
            System.out.println("                               ║                       [2] XÓA TIN NHẮN                                            ║");
            System.out.println("                               ║                       [3] LIÊN LẠC KHÁCH HÀNG                                     ║");
            System.out.println("                               ║                       [4] GỬI TIN NHẮN CHO NHỮNG KHÁCH HẸN TRƯỚC                  ║");
            System.out.println("                               ║                       [5] XÓA TOÀN BỘ TIN NHẮN                                    ║");
            System.out.println("                               ║                       [0] QUAY LẠI                                                ║");
            System.out.println("                               ╚═══════════════════════════════════════════════════════════════════════════════════╝");


            choice = getIntWithBound("Input choice", 0, 5);
            switch (choice) {

                case 1:
                    displayNotification();
                    break;
                case 2:
                    deleteMessage();
                    break;
                case 3:
                    contactCustomer();
                    break;
                case 4:
                    contactEachCustomer();
                    break;
                case 5:
                    deleteAllMessages();
                    break;
                case 0:
                    System.out.println("Back to Manager menu");
                    managerMenu();
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
        String confirmation = getString("Bạn có chắc chắn muốn xóa toàn bộ tin nhắn? (y/n): ");
        if (confirmation.equalsIgnoreCase("y")) {
            ContactService.contactList.clear();
            ContactService.saveContact();
            System.out.println("Đã xóa tất cả tin nhắn.");
        } else {
            System.out.println("Hủy xóa toàn bộ tin nhắn.");
        }
    }

    public static void contactCustomer() {
        ClientService.loadClient();

        String customerName = getString("Nhập tên khách hàng:");

        for (Client client : ClientService.clientList) {
            if (client.getName().equalsIgnoreCase(customerName)) {

                break;
            }
            if (customerName == null) {
                System.out.println("Không tìm thấy khách hàng có tên '" + customerName + "'. Vui lòng thử lại.");
                return;
            }
        }
        String message = getString("Nhập thông báo muốn gửi tới");
        Contact contact = new Contact(customerName, message);
        ContactService.messageList.add(contact);
        System.out.println("Gửi thông báo thành công");
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

//    public static void changeRoomStatus() {
//        RoomService.loadRoom();
//
//        int roomId = getInt("Nhập ID của phòng cần thay đổi trạng thái: ");
//
//        Room room = null;
//        for (Room r : RoomService.roomList) {
//            if (r.getRoomId() == roomId) {
//                room = r;
//                break;
//            }
//        }
//        if (room == null) {
//            System.out.println("Không tìm thấy phòng với ID tương ứng.");
//            return;
//        }
//        ERoomStatus newStatus = null;
//        while (newStatus == null) {
//
//            int choice = getIntWithBound("Chọn trạng thái cho phòng" +
//                    " 1: Trống" +
//                    " 2: Đang sử dụng" +
//                    " 3: Đã đặt trước" +
//                    " 4: Bảo trì" +
//                    " 5: Đang chờ", 1, 5);
//
//            switch (choice) {
//                case 1:
//                    newStatus = ERoomStatus.AVAILABLE;
//                    break;
//                case 2:
//                    newStatus = ERoomStatus.INUSE;
//                    break;
//                case 3:
//                    newStatus = ERoomStatus.RESERVED;
//                    break;
//                case 4:
//                    newStatus = ERoomStatus.MAINTENANCE;
//                    break;
//                case 5:
//                    newStatus = ERoomStatus.WAITING;
//                    break;
//                default:
//                    System.out.println("Chọn không hợp lệ.");
//            }
//        }
//        room.setRoomStatus(newStatus);
//        RoomService.saveRoom();
//        System.out.println("Trạng thái của phòng đã được cập nhật.");
//        displayRoom();
//    }

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
                    " 5: Đang chờ" +
                    " 6: Done", 1, 6);

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
                case 6:
                    newStatus = ERoomStatus.DONE;
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

    public static void makeBill() {
        String employee = getString("Nhập tên thu ngân");
        int reservationId = getInt("Nhập vào Id cuộc hẹn cần tính tiền");
        Reservation reservation = findReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Không tìm thấy cuộc hẹn với Id là " + reservationId);
            return;
        }
        Room room = reservation.getRoom();

        LocalDateTime gioVao;

        while (true) {
            String gioVaoStr = getString("Nhập giờ vào (yyyy-MM-dd HH:mm:ss): ");
            try {
                gioVao = parseDateTime(gioVaoStr);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi định dạng ngày giờ. Vui lòng nhập lại.");
                continue;
            }
            LocalDateTime gioTruoc30Phut = reservation.getTimeExpected().minusMinutes(30);
            if (gioVao.isBefore(gioTruoc30Phut)) {
                System.out.println("Giờ vào chỉ có thể đến trước 30 phút so với cuộc hẹn. Vui lòng nhập lại.");
                continue;
            }
            break;
        }

        LocalDateTime gioRa;
        while (true) {
            String gioRaStr = getString("Nhập giờ ra (yyyy-MM-dd HH:mm:ss): ");
            try {
                gioRa = parseDateTime(gioRaStr);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi định dạng ngày giờ. Vui lòng nhập lại.");
                continue;
            }
            if (gioRa.isBefore(gioVao)) {
                System.out.println("Giờ ra phải sau giờ vào. Vui lòng nhập lại.");
                continue;
            }
            break;
        }

        List<OrderedFood> doAn = reservation.getPreOrderedFoodList();
        String customer = reservation.getCustomerName();
        long soGioSuDung = Duration.between(gioVao, gioRa).toHours();
        long soPhutSuDung = Duration.between(gioVao, gioRa).toMinutes();

        long soPhutDuRa = soPhutSuDung - soGioSuDung * 60;
        double giaPhong = room.getRoomPricePerHour();
        double thanhTienPhong = giaPhong / 60 * soPhutSuDung;
        double thanhTienDoAn = 0;
        if (doAn != null) {
            for (OrderedFood mon : doAn) {
                thanhTienDoAn += mon.getQuantity() * mon.getFood().getFoodPrice();
            }
        }
        double thanhTien = thanhTienPhong + thanhTienDoAn - reservation.getDownPayment();
        BillDetails billDetails = new BillDetails(reservation.getCustomerName(), reservation.getTimeExpected(), thanhTienPhong, thanhTien, reservation.getReservationId());
        billDetailsList.add(billDetails);
        String note = getString("Nhập vào ghi chú");

//        System.out.println("HÓA ĐƠN PHÒNG HÁT KARAOKE DN");
//        System.out.println("Tên khách hàng: " + customer);
//        System.out.println("Phòng: " + room.getRoomName());
//        System.out.println("Giờ vào: " + gioVao);
//        System.out.println("Giờ ra: " + gioRa);
//        System.out.println("Thời gian sử dụng: " + soGioSuDung + "giờ " + soPhutDuRa + " phút");
//        System.out.println("Tiền thuê phòng: " + CurrencyFormat.covertPriceToString(thanhTienPhong));
//        if (doAn != null && !doAn.isEmpty()) {
//            System.out.println("Đồ ăn đã đặt:");
//            for (OrderedFood mon : doAn) {
//                System.out.println("- " + mon.getFood().getFoodName() + " " +
//                        "- Số lượng: " + mon.getQuantity() + "- Giá: " + CurrencyFormat.covertPriceToString(mon.getFood().getFoodPrice()) + " Tổng tiền: " +
//                        " " + CurrencyFormat.covertPriceToString(mon.getFood().getFoodPrice() * mon.getQuantity()));
//            }
//            System.out.println("Tiền đồ ăn: " + CurrencyFormat.covertPriceToString(thanhTienDoAn));
//        }
//        System.out.println("Tiền khách cọc trước " + CurrencyFormat.covertPriceToString(reservation.getDownPayment()));
//        System.out.println(note);
//        System.out.println("Tổng thành tiền: " + CurrencyFormat.covertPriceToString(thanhTien));
//
//        System.out.println("Nhân viên thu tiền: " + employee);
        System.out.println("                               ╔═══════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                               ║                              KARAOKE DUY NGUYỄN                                   ");
        System.out.println("                               ║      Địa chỉ: 01 Nguyễn Trường Tộ, Huế                                            ");
        System.out.println("                               ║      Số điện thoại: 076 997 3715                                                  ");
        System.out.println("                               ║                              PHIẾU TẠM TÍNH                                       ");
        System.out.println("                               ║                                                                                   ");
        System.out.println("                               ║      Tên khách hàng: " + customer + "                                              ");
        System.out.println("                               ║      Tên phòng: " + room.getRoomName() + "                                       ");
        System.out.println("                               ║      Giờ vào: " + gioVao + "                            ");
        System.out.println("                               ║      Giờ ra: " + gioRa + "              ");
        System.out.println("                               ║      Thời gian hát: " + soGioSuDung + "giờ " + soPhutDuRa + " phút                ");
        if (doAn != null && !doAn.isEmpty()) {
            System.out.println("                                  Đồ ăn đã đặt:");
            for (OrderedFood mon : doAn) {
                System.out.println("                                 - " + mon.getFood().getFoodName() +"\n"+
                        "                                            - Số lượng: " + mon.getQuantity() + "\n" +
                        "                                           - Giá: " + CurrencyFormat.covertPriceToString(mon.getFood().getFoodPrice()) + "\n" +
                        "                                          Tổng tiền: " + "\n" +
                        "                                            " + CurrencyFormat.covertPriceToString(mon.getFood().getFoodPrice() * mon.getQuantity()));
            }
            System.out.println("                                  Tiền đồ ăn: " + CurrencyFormat.covertPriceToString(thanhTienDoAn));
        }
        System.out.println("                               ║      Tiền phòng: " + CurrencyFormat.covertPriceToString(thanhTienPhong) + "        ");
        System.out.println("                               ║      Tiền khách cọc trước " + CurrencyFormat.covertPriceToString(reservation.getDownPayment()));
        ;
        System.out.println("                               ║      Tổng thành tiền: " + CurrencyFormat.covertPriceToString(thanhTien));
        System.out.println("                               ║      " + note + "                                                              ");
        System.out.println("                               ║      Nhân viên thu ngân: " + employee + "                                                              ");
        System.out.println("                               ╚═══════════════════════════════════════════════════════════════════════════════════");

        reservation.setReservationRoomStatus(ERoomStatus.MAINTENANCE);
        ReservationService.saveReservation();
    }

    public static void createNewReservation() {
        String customerName = getString("Nhập tên khách");
        LocalDateTime timeExpected = getDateTimeNow();
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


        Reservation reservation1 = new Reservation(customerName, timeExpected, downPayment, selectedRoom, ERoomStatus.INUSE

        );
        if (reservationList == null) {
            reservationList = new ArrayList<>();
        }
        reservationList.add(reservation1);
        ReservationService.saveReservation();
        System.out.println("Tạo phòng thành công");


    }

    public static void addFoodToReservation() {
        ReservationService.loadReservation();
        int reservationId = getInt("Nhập Id cuộc hẹn mà bạn muốn thêm đồ ăn");
        Reservation reservation = findReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Không tìm thấy cuộc hẹn có ID là " + reservationId + ".");
            return;
        }
        if (reservation.getPreOrderedFoodList() == null) {
            reservation.setPreOrderedFoodList(new ArrayList<>());
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
        List<OrderedFood> preOrderedFoodList = reservation.getPreOrderedFoodList();
        if (preOrderedFoodList == null) {
            preOrderedFoodList = new ArrayList<OrderedFood>();
        }
        preOrderedFoodList.addAll(orderedFoodList);
        reservation.setPreOrderedFoodList(preOrderedFoodList);

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
            preOrderedFoodList.addAll(orderedFoodList);
            reservation.setPreOrderedFoodList(preOrderedFoodList);
            System.out.println("Đã đặt trước đồ ăn cho cuộc hẹn có ID là " + reservationId + ".");
        } else {
            System.out.println("Bạn chưa đặt trước đồ ăn nào cho cuộc hẹn có ID là " + reservationId + ".");
        }
        ReservationService.saveReservation();
    }

    public static void checkReservationDetails() {
        ReservationService.loadReservation();
        displayReservation();
        int reservationId = getInt("Nhập ID cuộc hẹn bạn muốn xem:");
        Reservation reservation = findReservationById(reservationId);

        if (reservation == null) {
            System.out.println("Không tìm thấy cuộc hẹn có ID là " + reservationId);
            return;
        }
        Room room = reservation.getRoom();

        LocalDateTime gioVao;

        while (true) {
            String gioVaoStr = getString("Nhập giờ vào (yyyy-MM-dd HH:mm:ss): ");
            try {
                gioVao = parseDateTime(gioVaoStr);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi định dạng ngày giờ. Vui lòng nhập lại.");
                continue;
            }
            LocalDateTime gioTruoc30Phut = reservation.getTimeExpected().minusMinutes(30);
            if (gioVao.isBefore(gioTruoc30Phut)) {
                System.out.println("Giờ vào chỉ có thể đến trước 30 phút so với cuộc hẹn. Vui lòng nhập lại.");
                continue;
            }
            break;
        }

        LocalDateTime gioRa;
        while (true) {
            String gioRaStr = getString("Nhập giờ ra (yyyy-MM-dd HH:mm:ss): ");
            try {
                gioRa = parseDateTime(gioRaStr);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi định dạng ngày giờ. Vui lòng nhập lại.");
                continue;
            }
            if (gioRa.isBefore(gioVao)) {
                System.out.println("Giờ ra phải sau giờ vào. Vui lòng nhập lại.");
                continue;
            }
            break;
        }

        List<OrderedFood> doAn = reservation.getPreOrderedFoodList();
        String customer = reservation.getCustomerName();
        long soGioSuDung = Duration.between(gioVao, gioRa).toHours();
        long soPhutSuDung = Duration.between(gioVao, gioRa).toMinutes();

        long soPhutDuRa = soPhutSuDung - soGioSuDung * 60;
        double giaPhong = room.getRoomPricePerHour();
        double thanhTienPhong = giaPhong / 60 * soPhutSuDung;
        double thanhTienDoAn = 0;
        if (doAn != null) {
            for (OrderedFood mon : doAn) {
                thanhTienDoAn += mon.getQuantity() * mon.getFood().getFoodPrice();
            }
        }
        double thanhTien = thanhTienPhong + thanhTienDoAn - reservation.getDownPayment();
        System.out.println("Tên khách hàng: " + customer);
        System.out.println("Phòng: " + room.getRoomName());
        System.out.println("Giờ vào: " + gioVao);
        System.out.println("Giờ ra: " + gioRa);
        System.out.println("Thời gian sử dụng: " + soGioSuDung + "giờ " + soPhutDuRa + " phút");
        System.out.println("Tiền thuê phòng: " + CurrencyFormat.covertPriceToString(thanhTienPhong));
        if (doAn != null && !doAn.isEmpty()) {
            System.out.println("Đồ ăn đã đặt:");
            for (OrderedFood mon : doAn) {
                System.out.println("- " + mon.getFood().getFoodName() + " " +
                        "- Số lượng: " + mon.getQuantity() + "- Giá: " + CurrencyFormat.covertPriceToString(mon.getFood().getFoodPrice()) + " Tổng tiền: " +
                        " " + CurrencyFormat.covertPriceToString(mon.getFood().getFoodPrice() * mon.getQuantity()));
            }
            System.out.println("Tiền đồ ăn: " + CurrencyFormat.covertPriceToString(thanhTienDoAn));
        }
        System.out.println("Tiền khách cọc trước " + CurrencyFormat.covertPriceToString(reservation.getDownPayment()));
        System.out.println("Tổng thành tiền: " + CurrencyFormat.covertPriceToString(thanhTien));
    }

    public static void changeRoomByReservationId() {
        ReservationService.loadReservation();
        int reservationId = getInt("Nhập ID cuộc hẹn");

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
        int roomId = getInt("Nhập ID phòng mới");

        Room oldRoom = reservation.getRoom();
        Room newRoom = null;
        for (Room room : RoomService.roomList) {
            if (room.getRoomId() == roomId) {
                newRoom = room;
                break;
            }
        }
        if (newRoom == null) {
            System.out.println("Không tìm thấy phòng với ID tương ứng.");
            return;
        }

        if (oldRoom.equals(newRoom)) {
            System.out.println("Phòng cũ và phòng mới giống nhau.");
            return;
        }

        reservation.setRoom(newRoom);


        oldRoom.setRoomStatus(ERoomStatus.MAINTENANCE);
        newRoom.setRoomStatus(ERoomStatus.INUSE);
        LocalDateTime gioVao;

        while (true) {
            String gioVaoStr = getString("Nhập giờ vào (yyyy-MM-dd HH:mm:ss): ");
            try {
                gioVao = parseDateTime(gioVaoStr);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi định dạng ngày giờ. Vui lòng nhập lại.");
                continue;
            }
            LocalDateTime gioTruoc30Phut = reservation.getTimeExpected().minusMinutes(30);
            if (gioVao.isBefore(gioTruoc30Phut)) {
                System.out.println("Giờ vào chỉ có thể đến trước 30 phút so với cuộc hẹn. Vui lòng nhập lại.");
                continue;
            }
            break;
        }

        LocalDateTime gioRa;
        while (true) {
            String gioRaStr = getString("Nhập giờ ra (yyyy-MM-dd HH:mm:ss): ");
            try {
                gioRa = parseDateTime(gioRaStr);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi định dạng ngày giờ. Vui lòng nhập lại.");
                continue;
            }
            if (gioRa.isBefore(gioVao)) {
                System.out.println("Giờ ra phải sau giờ vào. Vui lòng nhập lại.");
                continue;
            }
            break;
        }
        long soPhutSuDung = Duration.between(gioVao, gioRa).toMinutes();
        double giaPhongCu = oldRoom.getRoomPricePerHour();
        double thanhTienPhongCu = giaPhongCu / 60 * soPhutSuDung;
        System.out.println("Giá tiền hát phòng cũ là: " + CurrencyFormat.covertPriceToString(thanhTienPhongCu));


        ReservationService.saveReservation();
        System.out.println("Đã chuyển phòng thành công.");
        displayReservation();
    }

    public static double calculateTotalRevenue() {
        BillDetailService.loadBillDetails();
        double totalRevenue = 0;
        for (BillDetails billDetails : billDetailsList) {
            totalRevenue += billDetails.getThanhTien();
        }
        return totalRevenue;
    }

    public static double calculateRevenueByDateRangeAndPrintDetails() {
        LocalDateTime startDate;
        LocalDateTime endDate;
        while (true) {
            String startDateStr = getString("Nhập ngày bắt đầu (yyyy-MM-dd HH:mm:ss): ");
            try {
                startDate = parseDateTime(startDateStr);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi định dạng ngày giờ. Vui lòng nhập lại.");
                continue;
            }
            break;
        }

        while (true) {
            String endDateStr = getString("Nhập ngày kết thúc (yyyy-MM-dd HH:mm:ss): ");
            try {
                endDate = parseDateTime(endDateStr);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi định dạng ngày giờ. Vui lòng nhập lại.");
                continue;
            }
            if (endDate.isBefore(startDate)) {
                System.out.println("Ngày kết thúc phải sau ngày bắt đầu. Vui lòng nhập lại.");
                continue;
            }
            break;
        }
        BillDetailService.loadBillDetails();
        double totalRevenue = 0;
        for (BillDetails billDetails : billDetailsList) {
            LocalDateTime billDate = billDetails.getTimeExpected();
            if (billDate.isEqual(startDate) || billDate.isEqual(endDate) ||
                    (billDate.isAfter(startDate) && billDate.isBefore(endDate))) {
                totalRevenue += billDetails.getThanhTien();
                System.out.println("Hóa đơn ngày " + billDetails.getTimeExpected() + " của khách hàng " + billDetails.getCustomerName() + " có tổng tiền là " + CurrencyFormat.covertPriceToString(billDetails.getThanhTien()));
            }
        }
        System.out.println("Tổng doanh thu từ " + startDate + " đến " + endDate + " là: " + CurrencyFormat.covertPriceToString(totalRevenue));
        return totalRevenue;
    }

    public static double calculatePricePerHourByDateRangeAndPrintDetails() {
        LocalDateTime startDate;
        LocalDateTime endDate;
        while (true) {
            String startDateStr = getString("Nhập ngày bắt đầu (yyyy-MM-dd HH:mm:ss): ");
            try {
                startDate = parseDateTime(startDateStr);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi định dạng ngày giờ. Vui lòng nhập lại.");
                continue;
            }
            break;
        }

        while (true) {
            String endDateStr = getString("Nhập ngày kết thúc (yyyy-MM-dd HH:mm:ss): ");
            try {
                endDate = parseDateTime(endDateStr);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi định dạng ngày giờ. Vui lòng nhập lại.");
                continue;
            }
            if (endDate.isBefore(startDate)) {
                System.out.println("Ngày kết thúc phải sau ngày bắt đầu. Vui lòng nhập lại.");
                continue;
            }
            break;
        }
        BillDetailService.loadBillDetails();
        double totalRevenue = 0;
        for (BillDetails billDetails : billDetailsList) {
            LocalDateTime billDate = billDetails.getTimeExpected();
            if (billDate.isEqual(startDate) || billDate.isEqual(endDate) ||
                    (billDate.isAfter(startDate) && billDate.isBefore(endDate))) {
                totalRevenue += billDetails.getThanhTienPhong();
                System.out.println("Hóa đơn ngày " + billDetails.getTimeExpected() + " của khách hàng " + billDetails.getCustomerName() + " có tổng tiền là " + CurrencyFormat.covertPriceToString(billDetails.getThanhTienPhong()));
            }
        }
        System.out.println("Tổng doanh thu từ " + startDate + " đến " + endDate + " là: " + CurrencyFormat.covertPriceToString(totalRevenue));
        return totalRevenue;
    }


}
