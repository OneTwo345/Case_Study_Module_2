package Utils;

import model.Food;

import java.util.Comparator;


public class SortFoodByType implements Comparator<Food> {


    @Override
    public int compare(Food o1, Food o2) {
        return o1.geteTypeOfFood().compareTo(o2.geteTypeOfFood());
    }
}
