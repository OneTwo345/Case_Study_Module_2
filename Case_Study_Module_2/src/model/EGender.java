package model;

public enum EGender {
    MALE(1, "male"),
    FEMALE(2, "female"),
    OTHER(3, "other");
    private int id;
    private String name;

    private EGender(int id, String name) {
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

    public static EGender toGender(int id) {
        EGender[] var1 = values();
        int var2 = var1.length;
        for (EGender gender : var1) {
            if (gender.id == id) {
                return gender;
            }
        }
        return null;

    }

    //EGender gender = EGender.toGender(2); // gender sẽ có giá trị là EGender.FEMALE
    public static EGender getEGenderByName(String name) {
        for (EGender gender : values()) {
            if (gender.getName().equals(name)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Please re-enter");
    }
}



