package service;


import Repository.BasicCRUD;
import model.Room;
import model.enums.EPath;
import utils.SerializationUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RoomService implements BasicCRUD<Room> {
    public static List<Room> roomList;


    static {
        roomList = (List<Room>) SerializationUtil.deserialize(EPath.ROOM.getFilePath());
    }

    public RoomService() {

    }


    @Override
    public Room getById(int id) {

        return roomList.stream()
                .filter(room -> room.getRoomId() == id)
                .findFirst()
                .orElse(null);
    }


    @Override
    public List<Room> getAll() {
        return roomList;
    }

    @Override
    public boolean create(Room room) {
        roomList.add(room);
        saveRoom();
        return true;
    }

    public static void saveRoom() {
        SerializationUtil.serialize(roomList, EPath.ROOM.getFilePath());
    }
    public static void loadRoom() {
        SerializationUtil.deserialize( EPath.ROOM.getFilePath());
    }

    @Override
    public void update(Room room) {
        roomList.stream()
                .map(existingRoom -> {
                    if (existingRoom.getRoomId() ==room.getRoomId()) {
                        return room;
                    } else {
                        return existingRoom;
                    }
                })
                .findFirst()
                .orElse(null);
    }


    @Override
    public void delete(int id) {
        roomList = roomList.stream()
                .filter(e -> !Objects.equals(e.getRoomId(), id))
                .collect(Collectors.toList());
        saveRoom();
    }

    @Override
    public boolean isExist(int id) {
        Room room = roomList.stream()
                .filter(e -> Objects.equals(e.getRoomId(), id))
                .findFirst()
                .orElse(null);
        return room != null;
    }

    @Override
    public void print() {
        for (Room room : roomList) {
            System.out.println(room.toString());
        }
    }
//

//    @Override
//    public void create() throws IOException {
////        int roomId, String roomName, ERoomStatus roomStatus,
////                ERoomType roomType, int capacity, double roomPricePerHour
//        int roomId;
//        while (true) {
//            roomId = getInt("Nhập ID phòng");
//            boolean isDuplicate = false;
//            for (Room room : roomList) {
//                if (room.getRoomId() == roomId) {
//                    System.out.println("ID đã tồn tại. Vui lòng nhập ID khác.");
//                    isDuplicate = true;
//                    break;
//                }
//            }
//            if (!isDuplicate) {
//                break;
//            }
//        }


//        String roomName = getString("Nhập tên phòng");
//
//        ERoomStatus roomStatus = ERoomStatus.getRoomStatusById(getIntWithBound("Nhập vào" +
//                " trạng thái phòng(1:Avaiable, 2: Maintenance, 3:In-use,4:reserved)", 1, 4));
//        ERoomType eRoomType = ERoomType.getRoomTypeById(getIntWithBound("Nhập vào loại phòng" +
//                "(1:Normal,2:VIP,3:Student)", 1, 3));
//        int capacity = getInt("Nhập vào sức chứa");
//        double pricePerHour = getDouble("Nhập vao giá tiền/1h");
//        Room room1 = new Room(roomId, roomName, roomStatus, eRoomType, capacity, pricePerHour);
//        roomList.add(room1);
//        SerializationUtil.serialize(roomList, "D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt");
//
//
//    }

//    @Override
//    public void update(int idRoom) {
//
//        Room roomToUpdate = getById(idRoom);
//        if (roomToUpdate != null) {
//            System.out.println("Nhập thông tin mới cho phòng:");
//            String roomName = getString("Nhập tên phòng");
//            ERoomStatus roomStatus = ERoomStatus.getRoomStatusById(getIntWithBound("Nhập vào" +
//                    " trạng thái phòng(1:Avaiable, 2: Maintenance, 3:In-use,4:reserved)", 1, 4));
//            ERoomType eRoomType = ERoomType.getRoomTypeById(getIntWithBound("Nhập vào loại phòng" +
//                    "(1:Normal,2:VIP,3:Student)", 1, 3));
//            int capacity = getInt("Nhập vào sức chứa");
//            double pricePerHour = getDouble("Nhập vào giá tiền/1h");
//
//
//            roomToUpdate.setRoomName(roomName);
//            roomToUpdate.setRoomStatus(roomStatus);
//            roomToUpdate.setRoomType(eRoomType);
//            roomToUpdate.setCapacity(capacity);
//            roomToUpdate.setRoomPricePerHour(pricePerHour);
//
//
//            SerializationUtil.serialize(roomList, "D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt");
//        } else {
//            System.out.println("Không tìm thấy phòng có ID là " + idRoom);
//        }
//    }


//    @Override
//    public void delete(int roomId) throws IOException {
//
//        Room roomToDelete = getById(roomId);
//        if (roomToDelete != null) {
//            roomList.remove(roomToDelete);
//            System.out.println("Phòng có ID " + roomId + " đã được xóa.");
//            SerializationUtil.serialize(roomList, "D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt");
//        } else {
//            System.out.println("Không tìm thấy phòng có ID là " + roomId);
//        }
//        InitData.initRoomData();
//    }




}
