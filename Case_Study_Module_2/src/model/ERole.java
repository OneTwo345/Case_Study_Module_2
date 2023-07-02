package model;

public enum ERole {
    admin(0,"admin"),
   employee(1,"employee"),
    customer(2,"customer");
    private int id;
    private String name;
    private ERole(int id, String name){
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
    public static ERole getRoleById(int id){
        ERole[] var1 = values();
        int var2 = var1.length;
        for (ERole role : var1) {
            if (role.getId() == id) {
                return role;

            }
        }
        return null;
    }
    public static ERole getRoleByName(String name){
        ERole[] var1 = values();
        int var2 = var1.length;
        for (ERole role : var1) {
            if (role.getName().equals(name)) {
                return role;
            }
        }
        return null;
    }
}
