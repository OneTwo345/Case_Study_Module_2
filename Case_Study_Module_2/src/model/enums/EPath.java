package model.enums;



public enum EPath {
    ACCCOUNT("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\Account.txt"),

    Bill("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\Bills.txt"),

    DATE("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\Date.txt"),

    FOOD("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\foods.txt"),

    RESERVATION("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\reservations.txt"),

    ROOM("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt");

    private final String filePath;

     EPath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
