package model;




import model.enums.EBillStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Bill implements Serializable
{


    private String id;
    private Room room;
    private LocalDateTime roomRealTimeIn;
    private LocalDateTime roomRealTimeOut;

    private final List<Bill> bills = new ArrayList<>();
    private EBillStatus eBillStatus;

    public Bill() {

    }

    public Bill(String id, Room room, LocalDateTime roomRealTimeIn, LocalDateTime roomRealTimeOut,   EBillStatus eBillStatus) {
        this.id = id;
        this.room = room;
        this.roomRealTimeIn = roomRealTimeIn;
        this.roomRealTimeOut = roomRealTimeOut;

        this.eBillStatus = eBillStatus;
    }





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getRoomRealTimeIn() {
        return roomRealTimeIn;
    }

    public void setRoomRealTimeIn(LocalDateTime roomRealTimeIn) {
        this.roomRealTimeIn = roomRealTimeIn;
    }

    public LocalDateTime getRoomRealTimeOut() {
        return roomRealTimeOut;
    }

    public void setRoomRealTimeOut(LocalDateTime roomRealTimeOut) {
        this.roomRealTimeOut = roomRealTimeOut;
    }





    public List<Bill> getBills() {
        return bills;
    }



    public EBillStatus geteBillStatus() {
        return eBillStatus;
    }

    public void seteBillStatus(EBillStatus eBillStatus) {
        this.eBillStatus = eBillStatus;
    }
}




