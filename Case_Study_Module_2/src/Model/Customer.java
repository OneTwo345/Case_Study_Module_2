package Model;

import java.util.Date;

public class Customer {
    private String id,name, address,phoneNumber,gender;
    private int numberOfGuess;
    private Date dob;

    public Customer(String id, String name, String address, String phoneNumber, String gender, int numberOfGuess, Date dob) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.numberOfGuess = numberOfGuess;
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumberOfGuess() {
        return numberOfGuess;
    }

    public void setNumberOfGuess(int numberOfGuess) {
        this.numberOfGuess = numberOfGuess;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
