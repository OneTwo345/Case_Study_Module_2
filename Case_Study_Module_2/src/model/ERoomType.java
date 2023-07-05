package model;

public enum ERoomType {
    Normal(1,"normal"),
    VIP(2,"vip"),
    Student(3,"student");
    private int id;
    private String name;

    ERoomType(int id, String name) {
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
    public static ERoomType getRoomTypeById(int id){
        ERoomType[] var1 = values();
        int var2 = var1.length;
        for (ERoomType roomType : var1) {
            if (roomType.getId() == id) {
                return roomType;

            }
        }
        return null;
    }
    public static ERoomType getRoomTypeByName(String name){
        ERoomType[] var1 = values();
        int var2 = var1.length;
        for (ERoomType roomType : var1) {
            if (roomType.getName().equals(name)) {
                return roomType;

            }
        }
        throw new IllegalArgumentException("Please re-enter");
    }
}
