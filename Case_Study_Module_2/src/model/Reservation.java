package model;

import model.enums.ERoomStatus;
import utils.CurrencyFormat;

import java.io.Serializable;


import java.util.Date;

public class Reservation implements  Serializable {
    static int currentId = 0;

    private int reservationId =(int) (Math.random() * 100000) + 1;
    private String customerId;
    private String customerName;
Room room;
    private double downPayment;
    private String roomName;
    private Date timeExpected;

    private ERoomStatus reservationRoomStatus;

    public Reservation() {

    }

    public Reservation(String customerId, String customerName, Date timeExpected,
                       double downPayment, Room room, ERoomStatus reservationRoomStatus) {
        this.reservationId = ++currentId + (int) (Math.random() * 1000) + 1;
        this.customerId = customerId;
        this.customerName = customerName;
        this.timeExpected = timeExpected;
        this.downPayment = downPayment;
        this.room = room;

        this.reservationRoomStatus = reservationRoomStatus;
    }

    public Room getRoom() {
        return room;
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

    public Date getTimeExpected() {
        return timeExpected;
    }

    public void setTimeExpected(Date timeExpected) {
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
                this.customerId, this.customerName,this.timeExpected,
                this.reservationRoomStatus, this.roomName,
                CurrencyFormat.covertPriceToString(this.downPayment));
    }


}
