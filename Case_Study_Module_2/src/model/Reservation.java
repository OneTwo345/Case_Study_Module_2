package model;

import utils.CurrencyFormat;
import repository.IModel;

import java.io.Serializable;


import java.util.Date;

public class Reservation implements IModel<Reservation>, Serializable {
    static int currentId = 0;

    private int reservationId;
    private int customerId;
    private String customerName;
Room room;
    private double downPayment;
    private String roomName;
    private Date timeExpected;

    private ERoomStatus reservationRoomStatus;

    public Reservation() {

    }

    public Reservation(int customerId, String customerName, Date timeExpected,
                       double downPayment, Room room, ERoomStatus reservationRoomStatus) {
        this.reservationId = ++currentId;
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

    public int getCustomerId() {
        return customerId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setCustomerId(int customerId) {
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


    @Override
    public int getId() {
        return reservationId;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void update(Reservation obj) {

        this.customerId = obj.customerId;
        this.customerName = obj.customerName;
        this.timeExpected = obj.timeExpected;
        this.downPayment = obj.downPayment;
        this.roomName = obj.roomName;
        this.reservationRoomStatus = obj.reservationRoomStatus;
    }


    public String reservationView() {
        return String.format("            ║ %-6s║ %-14s║ %-29s║ %-30s║ %-15s║ %-15s║ %-14s║", this.reservationId,
                this.customerId, this.customerName,this.timeExpected,
                this.reservationRoomStatus, this.roomName,
                CurrencyFormat.covertPriceToString(this.downPayment));
    }


}
