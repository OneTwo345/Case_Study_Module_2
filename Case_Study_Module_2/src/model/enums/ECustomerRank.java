package model.enums;

public enum ECustomerRank {
    SILVER(1, "silver"),
    GOLD(2, "gold"),

    PLATINUM(3, "platinum");
    private int id;
    private String name;


    ECustomerRank(int id, String name) {
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
    public static ECustomerRank getRankById(int id) {
        ECustomerRank[] var1 = values();
        int var2 = var1.length;
        for (ECustomerRank eCustomerRank : var1) {
            if (eCustomerRank.id == id) {
                return eCustomerRank;
            }
        }
        return null;

    }

    //EGender gender = EGender.toGender(2); // gender sẽ có giá trị là EGender.FEMALE
    public static ECustomerRank getRankByName(String name) {
        for (ECustomerRank rank : values()) {
            if (rank.getName().equals(name)) {
                return rank;
            }
        }
        throw new IllegalArgumentException("Please re-enter");
    }
}
