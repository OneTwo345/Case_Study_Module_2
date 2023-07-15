package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Contact implements Serializable {
    private Reservation reservation;
    private Manager manager;
    Client client;
    private String message;
    private int id;
    private String name;
    private LocalDateTime localDateTime;
    private String username;


    public Contact(Reservation reservation, Manager manager, Client client, String message) {
        this.reservation = reservation;
        this.manager = manager;
        this.client = client;
        this.message = message;
    }
    public Contact(String username,String message){

        this.username = username;
        this.message = message;
    }

    public Contact() {

    }

    public Contact(int reservationid, String
            clientName, String message, LocalDateTime localDateTime) {
        this.id = reservationid;
        this.name = clientName;
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public Contact(int id, String name, String message, LocalDateTime localDateTime, String username) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.localDateTime = localDateTime;
        this.username = username;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getId() {
        return id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
