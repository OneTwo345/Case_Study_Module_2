package model;

public class Admin {
    private Room room;
    private Bill bill;
    private Employee employee;
    private int totalPrice;
    private Role role;

    public Admin(Room room, Bill bill, Employee employee, int totalPrice, Role role) {
        this.room = room;
        this.bill = bill;
        this.employee = employee;
        this.totalPrice = totalPrice;
        this.role = role;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
