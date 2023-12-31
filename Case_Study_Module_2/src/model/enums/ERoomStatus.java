package model.enums;

public enum ERoomStatus {
    // full UPPER CASE
    AVAILABLE(1,"available"),
    MAINTENANCE(2,"maintenance"),
    INUSE(3,"in-use"),
    RESERVED(4,"reserved"),
    WAITING(5,"waiting");

   private int id;
   private String name;

    ERoomStatus(int id, String name) {
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

    public static ERoomStatus getRoomStatusById(int id){
        ERoomStatus[] var1 = values();
        int var2 = var1.length;
        for (ERoomStatus roomStatus : var1) {
            if (roomStatus.getId() == id) {
                return roomStatus;

            }
        }
        return null;
    }
    public static ERoomStatus getRoomStatusByName(String name){
        ERoomStatus[] var1 = values();
        int var2 = var1.length;
        for (ERoomStatus roomStatus : var1) {
            if (roomStatus.getName().equals(name)) {
                return roomStatus;

            }
        }
        throw new IllegalArgumentException("Please re-enter");
    }
}
