package model;

public class Reservation {
    private String reservationId, timeInExpected, timeOutExpected,customerStatus;
    private Room room;
    private Customer customer;

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getTimeInExpected() {
        return timeInExpected;
    }

    public void setTimeInExpected(String timeInExpected) {
        this.timeInExpected = timeInExpected;
    }

    public String getTimeOutExpected() {
        return timeOutExpected;
    }

    public void setTimeOutExpected(String timeOutExpected) {
        this.timeOutExpected = timeOutExpected;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Reservation(String reservationId, String timeInExpected, String timeOutExpected, String customerStatus, Room room, Customer customer) {
        this.reservationId = reservationId;
        this.timeInExpected = timeInExpected;
        this.timeOutExpected = timeOutExpected;
        this.customerStatus = customerStatus;
        this.room = room;
        this.customer = customer;


    }
}
