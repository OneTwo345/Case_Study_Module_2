package model;

import model.enums.ERoomStatus;
import model.enums.ERoomType;

import java.io.Serializable;

public class Room implements  Serializable {
    private int roomId;
    private String roomName;
    private ERoomStatus roomStatus;
    private ERoomType roomType;
    private int capacity;
    private double roomPricePerHour;

    public Room() {

    }

    public Room(int roomId, String roomName, ERoomStatus roomStatus,
                ERoomType roomType, int capacity, double roomPricePerHour) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomStatus = roomStatus;
        this.roomType = roomType;
        this.capacity = capacity;
        this.roomPricePerHour = roomPricePerHour;
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

    public double getRoomPricePerHour() {
        return roomPricePerHour;
    }

    public void setRoomPricePerHour(double roomPricePerHour) {
        this.roomPricePerHour = roomPricePerHour;
    }









     public String roomView() {
        return String.format("  ║%6s║%-20s║ %-15s║ %-15s║ %-6s║ %-10s║", this.roomId, this.roomName,
                this.roomStatus, this.roomType, this.capacity,this.roomPricePerHour);
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomStatus=" + roomStatus +
                ", roomType=" + roomType +
                ", capacity=" + capacity +
                ", roomPricePerHour=" + roomPricePerHour +
                '}';
    }
}
