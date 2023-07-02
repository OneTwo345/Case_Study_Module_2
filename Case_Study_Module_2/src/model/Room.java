package model;
import Service.IModel;

public class Room implements IModel<Room> {
    private int roomId;
    private String roomName;
    private ERoomStatus roomStatus;
    private ERoomType roomType;
    private int capacity;
    private double roomPrice;
    public Room(){

    }

    public Room(int roomId, String roomName, ERoomStatus roomStatus, ERoomType roomType, int capacity, double roomPrice) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomStatus = roomStatus;
        this.roomType = roomType;
        this.capacity = capacity;
        this.roomPrice = roomPrice;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public ERoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(ERoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public ERoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(ERoomType roomType) {
        this.roomType = roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    @Override
    public int getId() {
        return this.roomId;
    }

    @Override
    public String getName() {
        return this.roomName;
    }

    @Override
    public void update(Room obj) {
        this.roomId = obj.roomId;
        this.roomName = obj.roomName;
        this.roomStatus = obj.roomStatus;
        this.roomType = obj.roomType;
        this.capacity = obj.capacity;
        this.roomPrice = obj.roomPrice;
    }

    @Override
    public Room parseData(String line) {
        Room room = new Room();
        String[] strings = line.split(",");
        int id = Integer.parseInt(strings[0]);
        String name = strings[1];
        int capacity = Integer.parseInt(strings[2]);

    }
}
