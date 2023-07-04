package utils;

import model.Category;

import java.util.Comparator;


public class SortCategoryByType implements Comparator<Category> {


    @Override
    public int compare(Category o1, Category o2) {
        return o1.geteTypeOfFood().compareTo(o2.geteTypeOfFood());
    }
}
