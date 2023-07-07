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
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static utils.AppUtils.*;
import static utils.AppUtils.getDouble;

public class ReservationService implements BasicCRUD {
    List<Reservation> reservationList  = (List<Reservation>) SerializationUtil.deserialize
            ("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\reservation.txt");

    public ReservationService(){

    }



    @Override
    public Object getById(int reservationId) {
        return reservationList.stream()
                .filter(reservation -> reservation.getReservationId() == reservationId )
                .findFirst()
                .orElse(null);
    }

    @Override
    public void create() throws IOException {
//        int customerId, String customerName, Date timeExpected,
//        double downPayment, Room room, ERoomStatus reservationRoomStatus



        String customerId = getString("Nhập id khách");
        String customerName = getString("Nhập tên khách");
       Date date1 = DateFormat.parseDateWithHours("12-12-2022 14:30:30");
        int choice = getIntWithBound("1. Lấy mốc thời gian hiện tại \n"+"2.Nhập vào thời gian",1,2);
        switch (choice){
            case 1:
                LocalDateTime localDateTime = LocalDateTime.now();
                Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
                Date date = Date.from(instant);
                System.out.println(date.toString());
                break;
        }
        String dateReservation = getString("Nhập ngày theo dạng DD-MM-YYYY HH:MM:SS");


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
