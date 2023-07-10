package model;

import model.enums.ETypeOfFood;
import utils.CurrencyFormat;

import java.io.Serializable;

public class Food implements Serializable {
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
