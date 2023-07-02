package model;

public class Bill {
    private Customer customerName;
    private Room roomName;
    private Service service;
    private Employee employee;
    private String roomTimeIn, roomTimeOut,reservationId,other;

    public Bill(Customer customerName, Room roomName, Service service, Employee employee, String roomTimeIn, String roomTimeOut, String reservationId, String other) {
        this.customerName = customerName;
        this.roomName = roomName;
        this.service = service;
        this.employee = employee;
        this.roomTimeIn = roomTimeIn;
        this.roomTimeOut = roomTimeOut;
        this.reservationId = reservationId;
        this.other = other;
    }

    public Customer getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Customer customerName) {
        this.customerName = customerName;
    }

    public Room getRoomName() {
        return roomName;
    }

    public void setRoomName(Room roomName) {
        this.roomName = roomName;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getRoomTimeIn() {
        return roomTimeIn;
    }

    public void setRoomTimeIn(String roomTimeIn) {
        this.roomTimeIn = roomTimeIn;
    }

    public String getRoomTimeOut() {
        return roomTimeOut;
    }

    public void setRoomTimeOut(String roomTimeOut) {
        this.roomTimeOut = roomTimeOut;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
