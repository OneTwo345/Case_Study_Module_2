package model;

import utils.CurrencyFormat;
import repository.IModel;

public class Category implements IModel<Category> {
    private int categoryId;
    private String categoryName;
    private int quantity;
    private Double categoryPrice;
    private ETypeOfFood eTypeOfFood;

    public Category() {

    }

    ;

    public Category(int categoryId, String categoryName, int quantity, Double categoryPrice, ETypeOfFood eTypeOfFood) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.quantity = quantity;
        this.categoryPrice = categoryPrice;
        this.eTypeOfFood = eTypeOfFood;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getCategoryPrice() {
        return categoryPrice;
    }

    public void setCategoryPrice(Double categoryPrice) {
        this.categoryPrice = categoryPrice;
    }

    public ETypeOfFood geteTypeOfFood() {
        return eTypeOfFood;
    }

    public void seteTypeOfFood(ETypeOfFood eTypeOfFood) {
        this.eTypeOfFood = eTypeOfFood;
    }


    @Override
    public int getId() {
        return categoryId;
    }

    @Override
    public String getName() {
        return categoryName;
    }

    @Override
    public void update(Category obj) {
        this.categoryId = obj.categoryId;
        this.categoryName = obj.categoryName;
        this.quantity = obj.quantity;
        this.categoryPrice = obj.categoryPrice;
        this.eTypeOfFood = obj.eTypeOfFood;

    }



    public String foodView() {
        return String.format("            ║%7s║%-30s║ %-10s║ %-15s║ %-18s║", this.categoryId, this.categoryName,
                this.quantity, CurrencyFormat.covertPriceToString(this.categoryPrice), this.eTypeOfFood.getName());
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", quantity=" + quantity +
                ", categoryPrice=" + categoryPrice +
                ", eTypeOfFood=" + eTypeOfFood +
                '}';
    }
}
