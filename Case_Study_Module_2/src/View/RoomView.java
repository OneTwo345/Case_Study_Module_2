package View;

import service.RoomService;
import utils.AppUtils;
import utils.ListView;

import java.io.IOException;

import static utils.ListView.loginMenuList;


public class RoomView {
    static RoomService roomService = new RoomService();
    public static void clientMenu() throws IOException {
        int choice;
        do {
            System.out.println("Room menu");
            System.out.println("1. Display room ");
            System.out.println("2. Book room");


            System.out.println("0. Back to login menu");
            choice = AppUtils.getIntWithBound("Input choice", 0, 5);
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;


                case 0:
                    System.out.println("Back to Login menu");
                    loginMenu();
                    break;
            }
        }
        while (choice != 0);
    }
    public static void loginMenu() {
        public static void loginMenu() {
            try {
                ListView.printMenu(loginMenuList);
                int choice = AppUtils.getIntWithBound("Input choice", 0, 2);
                if (choice == 0) System.exit(1);
                if (choice == 1) {
                    LoginService.login();
                } else {
                    register();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                loginMenu();
            }
    }

}
