package service;

import Repository.BasicCRUD;
import model.enums.EPath;

import model.Reservation;
import utils.SerializationUtil;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class ReservationService implements BasicCRUD<Reservation> {
    public static List<Reservation> reservationList;


    public ReservationService() {

    }

    static {
        reservationList = (List<Reservation>) SerializationUtil.deserialize(EPath.RESERVATION.getFilePath());
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
        return reservationList;
    }

    @Override
    public boolean create(Reservation reservation) {
        reservationList.add(reservation);
        saveReservation();
        return true;
    }

    public static void saveReservation() {
        SerializationUtil.serialize(reservationList, EPath.RESERVATION.getFilePath());
    }
    public static void loadReservation(){
        SerializationUtil.deserialize(EPath.RESERVATION.getFilePath());
    }
    public static Reservation findReservationById(int reservationId) {
        for (Reservation reservation : ReservationService.reservationList) {
            if (reservation.getReservationId()==(reservationId)) {
                return reservation;
            }
        }
        return null;
    }


    @Override
    public void update(Reservation reservation) {
        reservationList.stream()
                .map(existingReservation -> {
                    if (existingReservation.getReservationId() == reservation.getReservationId() ) {
                        return reservation;
                    } else {
                        return existingReservation;
                    }
                })
                .findFirst()
                .orElse(null);
    }




    @Override
    public void delete(int id) {
        reservationList = reservationList.stream()
                .filter(e -> !Objects.equals(e.getReservationId(), id))
                .collect(Collectors.toList());
        saveReservation();
    }

    @Override
    public boolean isExist(int id) {
        Reservation reservation = reservationList.stream()
                .filter(e -> Objects.equals(e.getReservationId(), id))
                .findFirst()
                .orElse(null);
        return reservation != null;
    }

    @Override
    public void print() {
        for (Reservation reservation : reservationList) {
            System.out.println(reservation.toString());
        }
    }
}
