package model;

public class Category {
    private String food, drink, other;

    public Category(String food, String drink, String other) {
        this.food = food;
        this.drink = drink;
        this.other = other;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
