package model;

import utils.CurrencyFormat;
import repository.IModel;

import java.io.Serializable;

public class Food implements IModel<Food>, Serializable {
    static int currentId = 1;
    private int foodId;
    private String foodName;

    private Double foodPrice;
    private ETypeOfFood eTypeOfFood;

    public Food() {

    }

    ;

    public Food(String foodName,  Double foodPrice, ETypeOfFood eTypeOfFood) {
        this.foodId = currentId++;
        this.foodName = foodName;

        this.foodPrice = foodPrice;
        this.eTypeOfFood = eTypeOfFood;
    }

    public int getFoodId() {
        return foodId;
    }



    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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

        this.foodPrice = obj.foodPrice;
        this.eTypeOfFood = obj.eTypeOfFood;

    }



    public String categoryView() {
        return String.format("            ║%7s║%-30s║ %-10s║ %-15s║ %-18s║", this.foodId, this.foodName,
                 CurrencyFormat.covertPriceToString(this.foodPrice), this.eTypeOfFood.getName());
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +

                ", foodPrice=" + foodPrice +
                ", eTypeOfFood=" + eTypeOfFood +
                '}';
    }
}
