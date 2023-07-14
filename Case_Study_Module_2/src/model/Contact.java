package model;

import java.io.Serializable;

public class Contact implements Serializable {
    private Reservation reservation;
    private Manager manager;
    Client client;
    private String message;
    private int id;
    private String name;

    public Contact(Reservation reservation, Manager manager, Client client, String message) {
        this.reservation = reservation;
        this.manager = manager;
        this.client = client;
        this.message = message;
    }

    public Contact() {

    }

    public Contact(int reservationid, String
            clientName, String message) {
        this.id = reservationid;
        this.name = clientName;
        this.message = message;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
