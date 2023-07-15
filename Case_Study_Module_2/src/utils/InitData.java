package utils;

import model.*;
import model.enums.*;
import service.*;

import java.time.LocalDateTime;
import java.util.*;

import static service.ReservationService.reservationList;
import static service.RoomService.roomList;
import static utils.AppUtils.getString;

public class InitData {
    public static void initData() {
//        if (FoodService.listFoods.isEmpty()) {
//            initFood();
//        }
//        if (ManagerService.listManagers.isEmpty()) {
//            initManager();
//        }
//        if (roomList.isEmpty()) {
//            initRoom();
//        }
//        if (ClientService.clientList.isEmpty()) {
//            initClients();
//        }
//        if (reservationList.isEmpty()) {
//            initReservation();
//        }
        initRoom();
        initFood();
        initReservation();
        initManager();
        initClients();
        initMessage();
        initReceiveMessage();



    }


    public static void initRoom() {
        Room room1 = new Room(11, "T1-1", ERoomStatus.AVAILABLE, ERoomType.NORMAL, 30, 60000);
        Room room2 = new Room(12, "T1-2", ERoomStatus.AVAILABLE, ERoomType.STUDENT, 20, 40000);
        Room room3 = new Room(13, "T1-3", ERoomStatus.AVAILABLE, ERoomType.VIP, 50, 150000);
        Room room4 = new Room(21, "T2-1", ERoomStatus.AVAILABLE, ERoomType.NORMAL, 30, 60000);
        Room room5 = new Room(22, "T2-2", ERoomStatus.AVAILABLE, ERoomType.STUDENT, 20, 50000);
        Room room6 = new Room(23, "T2-3", ERoomStatus.AVAILABLE, ERoomType.VIP, 50, 120000);
        Room room7 = new Room(31, "T3-1", ERoomStatus.AVAILABLE, ERoomType.NORMAL, 30, 80000);
        Room room8 = new Room(32, "T3-2", ERoomStatus.AVAILABLE, ERoomType.STUDENT, 20, 50000);
        Room room9 = new Room(33, "T3-3", ERoomStatus.AVAILABLE, ERoomType.VIP, 50, 200000);
        Room room10 = new Room(41, "T4-1", ERoomStatus.AVAILABLE, ERoomType.NORMAL, 30, 60000);
        Room room11 = new Room(42, "T4-2", ERoomStatus.AVAILABLE, ERoomType.STUDENT, 20, 40000);
        Room room12 = new Room(43, "T4-3", ERoomStatus.AVAILABLE
                , ERoomType.VIP, 50, 100000);

        roomList = new ArrayList<>(Arrays.asList(room1, room2, room3, room4, room5, room6, room7, room8, room9, room10, room11, room12));

        SerializationUtil.serialize(roomList, "D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\rooms.txt");


    }


    public static void initReservation() {
        List<Reservation> reservations = new ArrayList<>();
        SerializationUtil.deserialize(EPath.ROOM.getFilePath());

//
        LocalDateTime date1 = AppUtils.parseDateTime("2023-07-15 14:30:30");
        LocalDateTime date2 = AppUtils.parseDateTime("2023-07-16 17:30:30");
        LocalDateTime date3 = AppUtils.parseDateTime("2023-07-15 20:30:30");
        Reservation reservation1 = new Reservation("S123", "Duy", date1, 150000, roomList.get(0), ERoomStatus.getRoomStatusById(1));
        Reservation reservation2 = new Reservation("S125", "Nam", date2,
                0, roomList.get(2), ERoomStatus.getRoomStatusById(1));
        Reservation reservation3 = new Reservation("S153", "Khoa", date3,
                50000, roomList.get(3), ERoomStatus.getRoomStatusById(1));
        reservations.add(reservation1);
        reservations.add(reservation2);
        reservations.add(reservation3);
        SerializationUtil.serialize(reservations, "D:\\Case_Study_Module_2\\Case_Study_Module_2\\src\\file\\reservations.txt");


    }


    public static void initFood() {
        List<Food> foodList = new ArrayList<>();
        Food comboHuda1 = new Food("1 thùng Huda", 280000d, ETypeOfFood.DRINK);
        Food comboHuda2 = new Food("1 chai huda", 13000d, ETypeOfFood.DRINK);
        Food comboTiger = new Food("1 thùng Tiger bạc", 400000d, ETypeOfFood.DRINK);
        Food comboHeineken = new Food("1 thùng Heineken", 460000d, ETypeOfFood.DRINK);
        Food orangeDrink = new Food("1 lon nước cam ", 10000d, ETypeOfFood.DRINK);
        Food cocacolaDrink = new Food("1 lon Cocacola", 13000d, ETypeOfFood.DRINK);
        Food water  = new Food("1 nước suối Aquafina", 6000d, ETypeOfFood.DRINK);
        Food fruitDishBig = new Food("1 dĩa trái cây lớn", 100000d, ETypeOfFood.FOOD);
        Food fruitDishSmall = new Food("1 dĩa trái cây nhỏ", 80000d, ETypeOfFood.FOOD);
        Food grilledSquid = new Food("Mực nướng", 100000d, ETypeOfFood.FOOD);
        Food oshi  = new Food("1 gói Oshi ", 10000d, ETypeOfFood.OTHER);
        foodList.add(comboHuda1);
        foodList.add(comboHuda2);
        foodList.add(comboTiger);
        foodList.add(comboHeineken);
        foodList.add(orangeDrink);
        foodList.add(cocacolaDrink);
        foodList.add(water);
        foodList.add(fruitDishBig);
        foodList.add(fruitDishSmall);
        foodList.add(grilledSquid);
        foodList.add(oshi);

        SerializationUtil.serialize(foodList, EPath.FOOD.getFilePath());
    }

    public static void initBill() {
//
        List<Bill> billList = new ArrayList<>();
        LocalDateTime date1 = AppUtils.parseDateTime("2023-07-16 14:30:30");
        LocalDateTime date2 = AppUtils.parseDateTime("2023-07-15 17:30:30");
        LocalDateTime date3 = AppUtils.parseDateTime(("2023-07-15 20:30:30"));

        Bill bill1 = new Bill("12345", roomList.get(1), AppUtils.getDateTimeNow(), date1, EBillStatus.PAY);
        Bill bill2 = new Bill("B0811", roomList.get(0), AppUtils.getDateTimeNow(), date2, EBillStatus.PAY);
        Bill bill3 = new Bill("B0911", roomList.get(2), AppUtils.getDateTimeNow(), date3, EBillStatus.PAY);
        billList.add(bill1);
        billList.add(bill2);
        billList.add(bill3);
        SerializationUtil.serialize(billList, EPath.Bill.getFilePath());

    }

    public static void initManager() {
        Manager manager = new Manager("duy123", "duy@gmail.com", "123456", "0769973715");
        List<Manager> listManagers = new ArrayList<>();
        listManagers.add(manager);
        ManagerService.listManagers = listManagers;
        SerializationUtil.serialize(listManagers, EPath.MANAGER.getFilePath());
    }

    public static void initClients() {
        Client client1 = new Client("tuan123", "anhtuan@gmail.com", "123456",
                "0123456789");
        Client client2 = new Client("phuc123", "siphuc@gmail.com", "123456",
                "0123456789");
        List<Client> clientList = new ArrayList<>();
        clientList.add(client1);
        clientList.add(client2);
        ClientService.clientList = clientList;
        SerializationUtil.serialize(clientList, EPath.CLIENT.getFilePath());

    }
    public static void initMessage(){
        String message = "Thank you";
        Client client1 = new Client();
        Contact contact = new Contact(15,"Dat",message,LocalDateTime.now());
        List<Contact> contactList1 = new ArrayList<>();
        SerializationUtil.serialize(contactList1, EPath.CONTACT.getFilePath());
    }
    public static void initReceiveMessage(){
        Contact contact1 = new Contact("tuan123","okok");
        Contact contact2 = new Contact("phuc123", "okok");
        List<Contact> receiveList = new ArrayList<>();
        SerializationUtil.serialize(receiveList,EPath.MESSAGE.getFilePath());
    }



    public static void main(String[] args) {
        initData();



    }

}
