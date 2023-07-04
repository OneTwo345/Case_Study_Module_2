package utils;

import model.Category;

import java.util.Comparator;

public class SortCategoryById implements Comparator<Category> {

    @Override
    public int compare(Category o1, Category o2) {
        return o1.getCategoryId() - o2.getCategoryId();
    }
}
