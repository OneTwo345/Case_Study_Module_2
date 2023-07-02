package model;

public enum ETypeOfFood {
    drink(1,"drink"),
    food(2,"food"),
    other(3,"other");

    private int id;
    private String name;

    ETypeOfFood(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static ETypeOfFood getTypeOfFoodById(int id){
        ETypeOfFood[] var1 = values();
        int var2 = var1.length;
        for (ETypeOfFood typeOfFood : var1) {
            if (typeOfFood.getId() == id) {
                return typeOfFood;

            }
        }
        return null;
    }
    public static ETypeOfFood getTypeOfFoodByName(String name){
        ETypeOfFood[] var1 = values();
        int var2 = var1.length;
        for (ETypeOfFood typeOfFood : var1) {
            if (typeOfFood.getName().equals(name)) {
                return typeOfFood;

            }
        }
        throw new IllegalArgumentException("Please re-enter");
    }
}
