package model;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Bill {
    static int currentId = 0;

    private int id;
    private Room room;
    private Date roomRealTimeIn;
    private Date roomRealTimeOut;
    private Food food;
    private User user;
    private final List<Bill> bills = new ArrayList<>();
    private EBillStatus eBillStatus;

    public Bill() {

    }

    public Bill(int id, Room room, Date roomRealTimeIn, Date roomRealTimeOut, Food food, User user, EBillStatus eBillStatus) {
        this.id = id;
        this.room = room;
        this.roomRealTimeIn = roomRealTimeIn;
        this.roomRealTimeOut = roomRealTimeOut;
        this.food = food;
        this.user = user;
        this.eBillStatus = eBillStatus;
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

    public Food getCategory() {
        return food;
    }

    public void setCategory(Food food) {
        this.food = food;
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

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public EBillStatus geteBillStatus() {
        return eBillStatus;
    }

    public void seteBillStatus(EBillStatus eBillStatus) {
        this.eBillStatus = eBillStatus;
    }
}




