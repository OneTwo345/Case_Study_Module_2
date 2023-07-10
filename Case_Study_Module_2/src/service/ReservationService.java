package service;

import model.enums.ERoomStatus;
import model.Reservation;
import model.Room;
import utils.InitData;
import utils.SerializationUtil;

import java.io.IOException;
import java.util.List;
import static utils.DisplayData.displayReservation;
import static utils.DisplayData.displayRoom;

public class ReservationService implements BasicCRUD<Reservation> {
    List<Reservation> reservationList;
    List<Room> roomList;


    public ReservationService() {

    }


    @Override
    public Reservation getById(int reservationId) {
        return reservationList.stream()
                .filter(reservation -> reservation.getReservationId() == reservationId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reservation> getAll() {
        return null;
    }

    @Override
    public void create(Reservation obj) throws IOException {

    }

    @Override
    public void update(Reservation obj) {

    }

//    @Override
//    public void create() throws IOException {
//
//
//        String customerId = getString("Nhập id khách");
//
//
//        String customerName = getString("Nhập tên khách");
//        Date timeExpected = getDayTime();
//
////        int choice = getIntWithBound("1. Lấy mốc thời gian hiện tại \n" + "2.Nhập vào thời gian", 1, 2);
////        switch (choice) {
////
////            case 1:
////                ZoneId currentZone = ZoneId.systemDefault();
////                LocalDateTime localDateTime = LocalDateTime.now();
////                ZoneId targetZone = ZoneId.of("Asia/Ho_Chi_Minh");
////                ZonedDateTime targetDateTime = localDateTime.atZone(currentZone).withZoneSameInstant(targetZone);
////                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
////                String formattedDateTime = targetDateTime.format(formatter);
////                System.out.println(formattedDateTime);
////                break;
////            case 2:
////                boolean validInput = false;
////
////                while (!validInput) {
////                    try {
////                        LocalTime localTime = LocalTime.parse(getString("Nhập giờ (hh:mm:ss)"));
////                        ZoneId currentZone1 = ZoneId.systemDefault();
////                        LocalDateTime localDateTime1 = LocalDateTime.now();
////                        ZonedDateTime currentDateTime1 = localDateTime1.atZone(currentZone1).with(LocalTime.from(localTime));
////                        ZoneId targetZone1 = ZoneId.of("Asia/Ho_Chi_Minh");
////                        ZonedDateTime targetDateTime1 = currentDateTime1.withZoneSameInstant(targetZone1);
////                        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
////                        String formattedDateTime1 = targetDateTime1.format(formatter1);
////                        System.out.println("Mốc giờ đã chọn là: " + formattedDateTime1);
////                        validInput = true;
////                    } catch (DateTimeParseException e) {
////                        System.out.println("Không thể đọc giờ được nhập vào. Vui lòng kiểm tra lại định dạng (hh:mm:ss).");
////                    }
////                }
////        }
//        double downPayment = getDouble("Nhập vào số tiền khách cọc trước");
//
//        int roomIdReservation = getInt("Nhập id phòng muốn đặt");
//        boolean validInput2 = false;
//        Room roomOrder = new Room();
//        while (!validInput2) {
////            int roomIdReservation = getInt("Nhập id phòng muốn đặt");
//            boolean roomFound = false;
//            for (Room room : rooms) {
//                if (roomIdReservation == (room.getRoomId())) {
//                    roomOrder = room;
//                    roomFound = true;
//                    if (room.getRoomStatus() == ERoomStatus.available) {
//                        room.setRoomStatus(ERoomStatus.reserved);
//                        validInput2 = true;
//                        break;
//                    } else {
//                        System.out.println("Phòng này đang ở trạng thái: " + room.getRoomStatus());
//                    }
//                }
//            }
//            if (!roomFound) {
//                System.out.println("Không tìm thấy Id phòng");
//            }
//        }
//
//        Reservation reservation1 = new Reservation(customerId, customerName, timeExpected, downPayment, roomOrder, ERoomStatus.reserved);
//        // call RoomService for update status of Room
//        reservationList.add(reservation1);
//        //"D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt" => magic String
//        SerializationUtil.serialize(rooms, "D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt");
//
//        SerializationUtil.serialize(reservationList, "D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\reservations.txt");
//
//        displayRoom();
//        displayReservation();
//
////
//
//
//    }

    public static void main(String[] args) throws IOException {

        InitData.initRoom();
        displayRoom();

        displayReservation();

        ReservationService reservationService = new ReservationService();



    }



    @Override
    public void delete(int id) throws IOException {

    }

    @Override
    public boolean isExist(int id) {
        return false;
    }

    @Override
    public void print() {

    }
}
