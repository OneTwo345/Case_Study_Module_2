package service;

import Repository.BasicCRUD;
import model.Food;
import model.enums.EPath;
import utils.SerializationUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FoodService implements BasicCRUD<Food> {
    public static List<Food> listFoods;


    static {
        listFoods = (List<Food>) SerializationUtil.deserialize(EPath.FOOD.getFilePath());
    }

    public FoodService() {

    }


    @Override
    public Food getById(int id) {

        return listFoods.stream()
                .filter(food -> food.getFoodId() == id)
                .findFirst()
                .orElse(null);
    }


    @Override
    public List<Food> getAll() {
        return listFoods;
    }

    @Override
    public boolean create(Food food) {

        listFoods.add(food);
        saveFood();
        return true;
    }

    public static void saveFood() {
        SerializationUtil.serialize(listFoods, EPath.FOOD.getFilePath());
    }

    @Override
    public void update(Food food) {
        listFoods.stream()
                .map(existingFood -> {
                    if (existingFood.getFoodId() == food.getFoodId()) {
                        return food;
                    } else {
                        return existingFood;
                    }
                })
                .findFirst()
                .orElse(null);
    }


    @Override
    public void delete(int id) {
        listFoods = listFoods.stream()
                .filter(e -> !Objects.equals(e.getFoodId(), id))
                .collect(Collectors.toList());
        saveFood();
    }

    @Override
    public boolean isExist(int id) {
        Food food = listFoods.stream()
                .filter(e -> Objects.equals(e.getFoodId(), id))
                .findFirst()
                .orElse(null);
        return food != null;
    }

    @Override
    public void print() {
        for (Food food : listFoods) {
            System.out.println(food.toString());
        }
    }
}
