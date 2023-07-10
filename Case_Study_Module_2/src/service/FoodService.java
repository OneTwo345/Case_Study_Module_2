package service;

import model.Food;
import model.enums.EPath;
import utils.SerializationUtil;

import java.io.IOException;
import java.util.List;

public class FoodService implements BasicCRUD<Food> {
   public static List<Food> listFoods;
    public FoodService(){

    }


    @Override
    public Food getById(int id) {
        return null;
    }

    @Override
    public List<Food> getAll() {
        return null;
    }

    @Override
    public void create(Food obj) throws IOException {

    }

    @Override
    public void update(Food obj) {

    }





    @Override
    public void delete(int id) throws IOException {

    }

    @Override
    public boolean isExist(int id) {
        return false;
    }

    @Override
    public void print() {

    }
}
