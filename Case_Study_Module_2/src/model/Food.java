package model;

import Utils.CurrencyFormat;
import repository.IModel;

public class Food implements IModel<Food> {
    private int foodId;
    private String foodName;
    private int quantity;
    private Double foodPrice;
    private ETypeOfFood eTypeOfFood;

    public Food() {

    }

    ;

    public Food(int foodId, String foodName, int quantity, Double foodPrice, ETypeOfFood eTypeOfFood) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.quantity = quantity;
        this.foodPrice = foodPrice;
        this.eTypeOfFood = eTypeOfFood;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public ETypeOfFood geteTypeOfFood() {
        return eTypeOfFood;
    }

    public void seteTypeOfFood(ETypeOfFood eTypeOfFood) {
        this.eTypeOfFood = eTypeOfFood;
    }


    @Override
    public int getId() {
        return foodId;
    }

    @Override
    public String getName() {
        return foodName;
    }

    @Override
    public void update(Food obj) {
        this.foodId = obj.foodId;
        this.foodName = obj.foodName;
        this.quantity = obj.quantity;
        this.foodPrice = obj.foodPrice;
        this.eTypeOfFood = obj.eTypeOfFood;

    }

    @Override
    public Food parseData(String line) {
        Food food = new Food();
        String[] strings = line.split(",");
        int id = Integer.parseInt(strings[0]);
        String name = strings[1];
        int quantity = Integer.parseInt(strings[2]);
        double price = Double.parseDouble(strings[3]);
        ETypeOfFood typeOfFood = ETypeOfFood.getTypeOfFoodByName(strings[4]);
        food.setFoodId(id);
        food.setFoodName(name);
        food.setQuantity(quantity);
        food.setFoodPrice(price);
        food.seteTypeOfFood(typeOfFood);
        return food;

    }
    public String foodView() {
        return String.format("            ║%7s║%-30s║ %-10s║ %-15s║ %-18s║", this.foodId, this.foodName,
                this.quantity, CurrencyFormat.covertPriceToString(this.foodPrice), this.eTypeOfFood.getName());
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", quantity=" + quantity +
                ", foodPrice=" + foodPrice +
                ", eTypeOfFood=" + eTypeOfFood +
                '}';
    }
}
