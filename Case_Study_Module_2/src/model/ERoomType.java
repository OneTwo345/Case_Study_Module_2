package model;

public enum ERoomType {
    Normal(1,"Normal"),
    VIP(2,"Vip"),
    Student(3,"Student");
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
