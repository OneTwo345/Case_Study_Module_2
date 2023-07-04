package Utils;

import model.Room;

import java.util.Comparator;

public class SortRoomByName implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        return o1.getRoomName().compareTo(o2.getRoomName());
    }
}
