package model;

public class Service {
    private int quantity, otherServicePrice,price;
    private Room room;
    private Category category;
    private String name;

    public Service(int quantity, int otherServicePrice, int price, Room room, Category category, String name) {
        this.quantity = quantity;
        this.otherServicePrice = otherServicePrice;
        this.price = price;
        this.room = room;
        this.category = category;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOtherServicePrice() {
        return otherServicePrice;
    }

    public void setOtherServicePrice(int otherServicePrice) {
        this.otherServicePrice = otherServicePrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
