package Model;

import java.util.Date;

public class Employee extends Customer{
private Role role;
private int salary;



    public Employee(String id, String name, String address, String phoneNumber, String gender, int numberOfGuess, Date dob, Role role, int salary) {
        super(id, name, address, phoneNumber, gender, numberOfGuess, dob);
        this.role = role;
        this.salary = salary;
    }
}
