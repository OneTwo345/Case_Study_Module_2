package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BillDetails implements Serializable {
    //food, bill, name food , price,quantity,
    Bill bill;
    Food food;
    Room room;
    String name;
    Reservation reservation;
    String customerName;
    LocalDateTime timeExpected;
    double thanhTienPhong;
    double thanhTien;
    int id;


    public BillDetails(Bill bill, Food food, Room room,Reservation reservation) {
        this.bill = bill;
        this.food = food;
        this.room = room;
        this.reservation = reservation;
    }

    public BillDetails(Bill bill, Food food, Room room, String name) {
        this.bill = bill;
        this.food = food;
        this.room = room;
        this.name = name;
    }

    public BillDetails(){

    }

    public BillDetails(String customerName, LocalDateTime timeExpected, double thanhTienPhong, double thanhTien, int id) {
       this.customerName = customerName;
       this.timeExpected = timeExpected;
       this.thanhTienPhong = thanhTienPhong;
       this.thanhTien = thanhTien;
       this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getTimeExpected() {
        return timeExpected;
    }

    public void setTimeExpected(LocalDateTime timeExpected) {
        this.timeExpected = timeExpected;
    }

    public double getThanhTienPhong() {
        return thanhTienPhong;
    }

    public void setThanhTienPhong(double thanhTienPhong) {
        this.thanhTienPhong = thanhTienPhong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
