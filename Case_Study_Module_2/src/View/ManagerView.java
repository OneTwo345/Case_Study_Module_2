package View;

import utils.AppUtils;
import utils.DisplayData;
import utils.ListView;

import static View.LoginView.loginMenu;
import static utils.AppUtils.getIntWithBound;
import static utils.DisplayData.*;

public class ManagerView {
    public static void managerMenu() {
        int choice;
        do {
            System.out.println("Room menu");
            System.out.println("1. Display room ");
            System.out.println("2. Book room");
            System.out.println("3. New song");
            System.out.println("4. Update Account");

            choice = getIntWithBound("Input choice", 0, 10);
            switch (choice) {
                case 1:
                    displayRoom();
                    displayReservation();

                    break;
                case 2:


                case 0:
                    System.out.println("Back to Login menu");
                    loginMenu();
                    break;
            }
        }
        while (choice != 0);

    }

    public static void main(String[] args) {
        managerMenu();
    }
}
