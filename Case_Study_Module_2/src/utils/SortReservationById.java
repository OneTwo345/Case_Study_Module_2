package utils;

import model.Reservation;

import java.util.Comparator;

public class SortReservationById implements Comparator<Reservation> {

    @Override
    public int compare(Reservation o1, Reservation o2) {
        return o1.getReservationId() - o2.getReservationId();
    }
}
