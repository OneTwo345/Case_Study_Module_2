package service;

import model.ERoomStatus;
import model.ERoomType;
import model.Reservation;
import model.Room;
import repository.BasicCRUD;
import utils.DateFormat;
import utils.SerializationUtil;

import java.io.IOException;
import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static utils.AppUtils.*;
import static utils.AppUtils.getDouble;

public class ReservationService implements BasicCRUD {
    List<Reservation> reservationList = (List<Reservation>) SerializationUtil.deserialize
            ("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\reservations.txt");
    List<Room> rooms = (List<Room>) SerializationUtil.deserialize
            ("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt");


    public ReservationService() {

    }


    @Override
    public Object getById(int reservationId) {
        return reservationList.stream()
                .filter(reservation -> reservation.getReservationId() == reservationId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void create() throws IOException {
//        int customerId, String customerName, Date timeExpected,
//        double downPayment, Room room, ERoomStatus reservationRoomStatus


//
//        String customerId = getString("Nhập id khách");
//        String customerName = getString("Nhập tên khách");
//
//        int choice = getIntWithBound("1. Lấy mốc thời gian hiện tại \n" + "2.Nhập vào thời gian", 1, 2);
//        switch (choice) {
//
//            case 1:
//                ZoneId currentZone = ZoneId.systemDefault();
//                LocalDateTime localDateTime = LocalDateTime.now();
//                ZoneId targetZone = ZoneId.of("Asia/Ho_Chi_Minh");
//                ZonedDateTime targetDateTime = localDateTime.atZone(currentZone).withZoneSameInstant(targetZone);
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//                String formattedDateTime = targetDateTime.format(formatter);
//                System.out.println(formattedDateTime);
//                break;
//            case 2:
//                boolean validInput = false;
//
//                while (!validInput) {
//                    try {
//                        LocalTime localTime = LocalTime.parse(getString("Nhập giờ (hh:mm:ss)"));
//                        ZoneId currentZone1 = ZoneId.systemDefault();
//                        LocalDateTime localDateTime1 = LocalDateTime.now();
//                        ZonedDateTime currentDateTime1 = localDateTime1.atZone(currentZone1).with(LocalTime.from(localTime));
//                        ZoneId targetZone1 = ZoneId.of("Asia/Ho_Chi_Minh");
//                        ZonedDateTime targetDateTime1 = currentDateTime1.withZoneSameInstant(targetZone1);
//                        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//                        String formattedDateTime1 = targetDateTime1.format(formatter1);
//                        System.out.println("Mốc giờ đã chọn là: " + formattedDateTime1);
//                        validInput = true;
//                    } catch (DateTimeParseException e) {
//                        System.out.println("Không thể đọc giờ được nhập vào. Vui lòng kiểm tra lại định dạng (hh:mm:ss).");
//                    }
//                }
//        }
//        double downPayment = getDouble("Nhập vào số tiền khách cọc trước");





//


    }

    public static void main(String[] args) throws IOException {
        new ReservationService().create();
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) throws IOException {

    }
}
