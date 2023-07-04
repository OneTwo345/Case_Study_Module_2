package utils;

import model.ERoomStatus;

import java.util.Comparator;

public class SortRoomByStatus implements Comparator<ERoomStatus> {


    @Override
    public int compare(ERoomStatus o1, ERoomStatus o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
