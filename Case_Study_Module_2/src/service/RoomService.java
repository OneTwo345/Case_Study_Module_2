package service;

import model.Room;
import repository.BasicCRUD;
import utils.CurrencyFormat;

import java.io.IOException;
import java.util.List;

public class RoomService implements BasicCRUD<Room> {
    public static List<Room> roomList;
    public RoomService() {
    }

    @Override
    public Room getById(int roomId) {
        Room foundRoom = null;
        for (Room room : roomList) {
            if (room.getRoomId() == roomId) {
                foundRoom = room;
                break;
            }
        }

        return foundRoom;
    }

    @Override
    public void create(Room obj) throws IOException {

    }

    @Override
    public void update(Room obj) {

    }

    @Override
    public void delete(int id) throws IOException {

    }


}
