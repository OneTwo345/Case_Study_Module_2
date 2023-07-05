package model;

public class BillDetails {
    //food, bill, name food , price,quantity,
    Bill bill;
    Food food;
    Room room;

    public BillDetails(Bill bill, Food food, Room room) {
        this.bill = bill;
        this.food = food;
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

    public Food getCategory() {
        return food;
    }

    public void setCategory(Food food) {
        this.food = food;
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
