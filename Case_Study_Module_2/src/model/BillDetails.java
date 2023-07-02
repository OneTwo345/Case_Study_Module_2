package model;

public class BillDetails {
    private int quantity, otherServicePrice,price;
    private Room room;
    private Category category;

    public BillDetails(int quantity, int otherServicePrice, int price, Room room, Category category) {
        this.quantity = quantity;
        this.otherServicePrice = otherServicePrice;
        this.price = price;
        this.room = room;
        this.category = category;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
