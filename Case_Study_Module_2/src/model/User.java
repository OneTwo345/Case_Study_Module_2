package model;

import model.enums.EGender;
import model.enums.ERole;
import utils.DateFormat;
import utils.ValidateUtils;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private EGender gender;
    private String CCCD;
    private Date birthDay;
    private String email;
    private String address;
    private ERole eRole;

    public User(int id, String username, String password, String fullName, String phoneNumber,
                EGender gender, String CCCD, Date birthDay, String email, String address, ERole eRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.CCCD = CCCD;
        this.birthDay = birthDay;
        this.email = email;
        this.address = address;
        this.eRole = eRole;
    }
    public User(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ERole geteRole() {
        return eRole;
    }

    public void seteRole(ERole eRole) {
        this.eRole = eRole;
    }







    public String userView() {
        return String.format("            ║%7s║%-15s║ %-20s║ %-15s║ %-15s║%-15s║ %-15s║ %-36s║ %-30s║", this.id, this.username, this.fullName, this.phoneNumber, this.gender.getName(), this.CCCD, DateFormat.convertDateToString((java.sql.Date) this.birthDay), this.email, this.address);
    }

    @Override
    public String toString() {
        return id + "," + username + "," + password + "," + fullName + "," + phoneNumber + "," + gender.getName() + "," + CCCD + "," + DateFormat.convertDateToString((java.sql.Date) birthDay) + "," + email + "," + ValidateUtils.parseCommaToChar(address) + "," + eRole.getName();
    }
}
