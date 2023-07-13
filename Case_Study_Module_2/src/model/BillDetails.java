package model;

import java.io.Serializable;

public class BillDetails implements Serializable {
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



}
