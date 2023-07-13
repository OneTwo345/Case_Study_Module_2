package model;

import model.enums.ERoomStatus;
import utils.CurrencyFormat;

import java.io.Serializable;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Reservation implements Serializable {
    static int currentId = 0;

    private int reservationId = (int) (Math.random() * 100000) + 1;
    private String customerId;
    private String customerName;
    Room room;
    private double downPayment;
    private String roomName;
    private LocalDateTime timeExpected;

    private ERoomStatus reservationRoomStatus;
    private List<OrderedFood> preOrderedFoodList;

    public Reservation() {

    }

    public Reservation(String customerId, String customerName, LocalDateTime timeExpected,
                       double downPayment, Room room, ERoomStatus reservationRoomStatus) {
        this.reservationId = ++currentId + (int) (Math.random() * 1000) + 1;
        this.customerId = customerId;
        this.customerName = customerName;
        this.timeExpected = timeExpected;
        this.downPayment = downPayment;
        this.room = room;

        this.reservationRoomStatus = reservationRoomStatus;
    }

    public Reservation(int reservationId, String customerId, String customerName, Room room, double downPayment, String roomName, LocalDateTime timeExpected, ERoomStatus reservationRoomStatus, List<OrderedFood> preOrderedFoodList) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.room = room;
        this.downPayment = downPayment;
        this.roomName = roomName;
        this.timeExpected = timeExpected;
        this.reservationRoomStatus = reservationRoomStatus;
        this.preOrderedFoodList = preOrderedFoodList;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        Reservation.currentId = currentId;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<OrderedFood> getPreOrderedFoodList() {
        return preOrderedFoodList;
    }

    public void setPreOrderedFoodList(List<OrderedFood> preOrderedFoodList) {
        this.preOrderedFoodList = preOrderedFoodList;
    }

    public Room getRoom() {
        return room;
    }

    public Reservation(String customerName, LocalDateTime timeExpected,
                       double downPayment, Room room,ERoomStatus reservationRoomStatus) {
        this.customerName = customerName;
        this.timeExpected = timeExpected;
        this.downPayment = downPayment;
        this.room = room;
        this.reservationRoomStatus = reservationRoomStatus;


    }
//    public Reservation(int reservationId,String customerId, String customerName,Date timeExpected,double downPayment,Room roomName, ERoomStatus eRoomStatus,ERoomType eRoomType){
//
//    };
//    public Reservation(int customerId, String name, String dateFormat, double downPayment, Room roomName, ERoomStatus eRoomStatus) {
//    }

    public int getReservationId() {
        return reservationId;
    }


    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDateTime getTimeExpected() {
        return timeExpected;
    }

    public void setTimeExpected(LocalDateTime timeExpected) {
        this.timeExpected = timeExpected;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }


    public ERoomStatus getReservationRoomStatus() {
        return reservationRoomStatus;
    }

    public void setReservationRoomStatus(ERoomStatus reservationRoomStatus) {
        this.reservationRoomStatus = reservationRoomStatus;
    }


    public String reservationView() {
        return String.format("            ║ %-6s║ %-14s║ %-29s║ %-30s║ %-15s║ %-15s║ %-14s║", this.reservationId,
                this.customerId, this.customerName, this.timeExpected,
                this.reservationRoomStatus, this.roomName,
                CurrencyFormat.covertPriceToString(this.downPayment));
    }
    public void displayPreOrderedFoodList() {
        System.out.println("Danh sách các món ăn đã đặt trước:");
        System.out.println("\t\t\t\t=====================================================================================================");
        System.out.printf("\t\t\t\t%-30s %-20s %-10s %-20s\n", "Tên món ăn", "Giá tiền", "Số lượng", "Số tiền dự kiến");
        for (OrderedFood orderedFood : preOrderedFoodList) {
            double expectedTotalPrice = orderedFood.getFood().getFoodPrice() * orderedFood.getQuantity();
            System.out.printf("\t\t\t\t%-30s %-20s %-10d %-20s\n", orderedFood.getFood().getFoodName(), CurrencyFormat.covertPriceToString(orderedFood.getFood().getFoodPrice()), orderedFood.getQuantity(),
                    CurrencyFormat.covertPriceToString(expectedTotalPrice));
        }
    }



}
