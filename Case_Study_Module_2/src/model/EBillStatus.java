package model;

public enum EBillStatus {
    pay(1,"pay"),
    unpay(2,"unpay");
    private int id;
    private String name;

    EBillStatus(int id, String name) {
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
    public static EBillStatus getBillStatusById(int id) {
        EBillStatus[] var1 = values();
        int var2 = var1.length;
        for (EBillStatus eBillStatus : var1) {
            if (eBillStatus.id == id) {
                return eBillStatus;
            }
        }
        return null;

    }

    //EGender gender = EGender.toGender(2); // gender sẽ có giá trị là EGender.FEMALE
    public static EBillStatus getBillStatusByName(String name) {
        for (EBillStatus eBillStatus : values()) {
            if (eBillStatus.getName().equals(name)) {
                return eBillStatus;
            }
        }
        throw new IllegalArgumentException("Please re-enter");
    }
}
