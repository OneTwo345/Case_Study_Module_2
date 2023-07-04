package utils;

import model.Reservation;

import java.util.Comparator;

public class SortByDateTime implements Comparator<Reservation> {

    @Override
    public int compare(Reservation o1, Reservation o2) {
        return o1.getTimeExpected().compareTo(o2.getTimeExpected());
    }
}
