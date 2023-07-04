package model;

public class BillDetails {
    //food, bill, name food , price,quantity,
    Bill bill;
    Category category;
    Room room;

    public BillDetails(Bill bill, Category category, Room room) {
        this.bill = bill;
        this.category = category;
        this.room = room;
    }
    public BillDetails(){

    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public static void main(String[] args) {
        BillDetails billDetails = new BillDetails();
       String roomName =  billDetails.getRoom().getName();

    }

}
