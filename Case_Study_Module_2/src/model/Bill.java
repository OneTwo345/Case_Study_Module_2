package model;




import model.enums.EBillStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Bill {


    private String id;
    private Room room;
    private Date roomRealTimeIn;
    private Date roomRealTimeOut;

    private final List<Bill> bills = new ArrayList<>();
    private EBillStatus eBillStatus;

    public Bill() {

    }

    public Bill(String id, Room room, Date roomRealTimeIn, Date roomRealTimeOut,   EBillStatus eBillStatus) {
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

    public Date getRoomRealTimeIn() {
        return roomRealTimeIn;
    }

    public void setRoomRealTimeIn(Date roomRealTimeIn) {
        this.roomRealTimeIn = roomRealTimeIn;
    }

    public Date getRoomRealTimeOut() {
        return roomRealTimeOut;
    }

    public void setRoomRealTimeOut(Date roomRealTimeOut) {
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




