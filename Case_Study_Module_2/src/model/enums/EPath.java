package model.enums;



public enum EPath {
    CLIENT("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\clients.txt"),

    Bill("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\Bills.txt"),

    MANAGER("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\managers.txt"),

    FOOD("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\foods.txt"),

    RESERVATION("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\reservations.txt"),

    ROOM("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt"),
    EMPLOYEE("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\employees.txt"),
    BOOKROOM("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\bookRoom.txt"),
    CONTACT("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\contact.txt"),
    MESSAGE("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\message.txt"),
    BILLDETAILS("D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\billdetails.txt");

    private final String filePath;

     EPath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
