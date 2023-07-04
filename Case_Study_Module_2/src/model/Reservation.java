package model;

import Utils.CurrencyFormat;
import Utils.DateFormat;
import repository.IModel;

import java.sql.Date;

public class Reservation implements IModel<Reservation> {

    private int reservationId;
    private int customerId;
    private String customerName;
    private Date timeExpected;
    private double downPayment;
    private String roomName;

    private ERoomStatus reservationRoomStatus;

    public Reservation() {

    }

    public Reservation(int reservationId, int customerId, String customerName, Date timeExpected,
                       double downPayment, Room roomName, ERoomStatus reservationRoomStatus) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.timeExpected = timeExpected;
        this.downPayment = downPayment;
        this.roomName = String.valueOf(roomName);

        this.reservationRoomStatus = reservationRoomStatus;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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

    public Date getTimeExpected() {
        return timeExpected;
    }

    public void setTimeExpected(Date timeExpected) {
        this.timeExpected = timeExpected;
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
        this.reservationId = obj.reservationId;
        this.customerId = obj.customerId;
        this.customerName = obj.customerName;
        this.timeExpected = obj.timeExpected;
        this.downPayment = obj.downPayment;
        this.roomName = obj.roomName;
        this.reservationRoomStatus = obj.reservationRoomStatus;
    }

    @Override
    public Reservation parseData(String line) {
        Reservation reservation = new Reservation();
        String[] strings = line.split(",");
        int reservationId = Integer.parseInt(strings[0]);
        int customerId = Integer.parseInt(strings[1]);
        String customerName = strings[2];
        Date timeExpect = DateFormat.parseDateWithHours(strings[3]);
        double downPayment = Double.parseDouble(strings[4]);
        String roomName = strings[5];
        ERoomStatus reservationRoomStatus = ERoomStatus.getRoomStatusByName(strings[6]);
        reservation.setReservationId(reservationId);
        reservation.setCustomerId(customerId);
        reservation.setCustomerName(customerName);
        reservation.setTimeExpected(timeExpect);
        reservation.setDownPayment(downPayment);
        reservation.setRoomName(roomName);
        reservation.setReservationRoomStatus(reservationRoomStatus);
        return reservation;

    }

    public String reservationView() {
        return String.format("            ║ %-6s║ %-14s║ %-29s║ %-30s║ %-15s║ %-15s║ %-14s║", this.reservationId,
                this.customerId, this.customerName, this.timeExpected,
                this.reservationRoomStatus, this.roomName,
                CurrencyFormat.covertPriceToString(this.downPayment));
    }


}
