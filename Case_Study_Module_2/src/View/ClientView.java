package View;


import model.Reservation;
import model.Room;
import model.enums.EPath;
import model.enums.ERoomStatus;
import service.ClientService;
import service.RoomService;
import utils.AppUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.ListView;
import utils.SerializationUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import static service.ReservationService.reservationList;
import static service.RoomService.roomList;
import static service.RoomService.saveRoom;
import static utils.AppUtils.*;
import static utils.DisplayData.displayReservation;
import static utils.DisplayData.displayRoom;


public class ClientView {
    static RoomService roomService = new RoomService();
    static ClientService clientService = new ClientService();

    public static void clientMenu() {
        int choice;
        do {
            System.out.println("Room menu");
            System.out.println("1. Display room ");
            System.out.println("2. Book room");
            System.out.println("3. New song");
            System.out.println("4.Update Account");
            System.out.println("5.Order Food");

            System.out.println("0. Back to login menu");
            choice = getIntWithBound("Input choice", 0, 5);
            switch (choice) {
                case 1:


                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    getSong();
                    break;
                case 4:
                    updateAccount();
                    break;
                case 5:
                    updateAccount();
                    break;

                case 0:
                    System.out.println("Back to Login menu");
//                    loginMenu();
                    break;
            }
        }
        while (choice != 0);
    }


    public static void main(String[] args) throws IOException {
        clientMenu();
    }


    public static void bookRoom() {
        String customerId = getString("Nhập id khách");


        String customerName = getString("Nhập tên khách");


        int choice = getIntWithBound("1. Lấy mốc thời gian hiện tại \n" + "2.Nhập vào thời gian", 1, 2);
        switch (choice) {
            LocalDateTime timeExpected;


            case 1:
//
                timeExpected = getDateTimeNow();
            case 2:
                boolean validInput = false;

                while (!validInput) {
                    try {
                        String timeExpect = getString("Enter time yyyy-MM-dd HH:mm:ss");
                        getDateTime(timeExpect);
//
                        validInput = true;
                    } catch (DateTimeParseException e) {
                        System.out.println("Không thể đọc giờ được nhập vào. Vui lòng kiểm tra lại định dạng (yyyy-MM-dd HH:mm:ss).");
                    }

                }

                double downPayment = getDouble("Nhập vào số tiền khách cọc trước");

                int roomIdReservation = getInt("Nhập id phòng muốn đặt");
                boolean validInput2 = false;
                Room roomOrder = new Room();
                while (!validInput2) {
//            int roomIdReservation = getInt("Nhập id phòng muốn đặt");
                    boolean roomFound = false;
                    for (Room room : roomList) {
                        if (roomIdReservation == (room.getRoomId())) {
                            roomOrder = room;
                            roomFound = true;
                            if (room.getRoomStatus() == ERoomStatus.AVAILABLE) {
                                room.setRoomStatus(ERoomStatus.RESERVED);
                                validInput2 = true;
                                break;
                            } else {
                                System.out.println("Phòng này đang ở trạng thái: " + room.getRoomStatus());
                            }
                        }
                    }
                    if (!roomFound) {
                        System.out.println("Không tìm thấy Id phòng");
                    }
                }

                Reservation reservation1 = new Reservation(customerId, customerName, timeExpected, downPayment, roomOrder, ERoomStatus.RESERVED);
                // call RoomService for update status of Room
                reservationList.add(reservation1);


                SerializationUtil.serialize(reservationList, EPath.RESERVATION.getFilePath());

                displayRoom();
                displayReservation();


        }
    }


    //
    public static void getSong() {
        String url = "https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html";
        System.out.println("\n" +
                "Some music");
        try {
            Document doc = Jsoup.connect(url).get();
            Elements songList = doc.select(".name_song");
            for (Element song : songList) {
                String name = song.text();
                System.out.println(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateAccount() {
        ListView.printMenu(ListView.updateClientList);
        int choice = getIntWithBound("Input choice", 0, 3);
        switch (choice) {
            case 1:
                String name = getString("Input new name:");
                ClientService.currentClient.setName(name);
                break;
            case 2:
                String password;
                String confirmPassword;
                do {
                    password = getString("Input new password:");
                    confirmPassword = getString("Input confirm password:");
                } while (!Objects.equals(password, confirmPassword));
                ClientService.currentClient.setPassword(password);
                break;
            case 3:
                String phone = getString("Input new phone number:");
                ClientService.currentClient.setName(phone);
                break;
            case 0:
                System.out.println("Back to Login menu");
                clientMenu();
                break;

        }
        clientService.update(ClientService.currentClient);
    }


//
}