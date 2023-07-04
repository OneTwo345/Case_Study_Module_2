package model;



import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Bill  {
    static int currentId = 0;

    private int id;
    private Room room;
    private Date roomRealTimeIn;
    private Date roomRealTimeOut;
    private Category category;
    private User user;
    private final List<Bill> bills = new ArrayList<>();
    private String status = "Unpaid";
    public Bill(){

    }

    public Bill(int id, Room room, Date roomRealTimeIn, Date roomRealTimeOut, Category category, User user, String status) {
        this.id = id;
        this.room = room;
        this.roomRealTimeIn = roomRealTimeIn;
        this.roomRealTimeOut = roomRealTimeOut;
        this.category = category;
        this.user = user;
        this.status = status;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        Bill.currentId = currentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
