package model;

import java.util.Date;

public class Employee extends Customer{
private Role role;
private int salary;



    public Employee(String id, String name, String address, String phoneNumber, String gender, int numberOfGuess, Date dob, Role role, int salary) {
        super(id, name, address, phoneNumber, gender, numberOfGuess, dob);
        this.role = role;
        this.salary = salary;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
