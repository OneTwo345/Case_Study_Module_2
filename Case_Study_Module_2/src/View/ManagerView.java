package View;

import utils.AppUtils;
import utils.DisplayData;
import utils.ListView;

public class ManagerView {
    public static void managerMenu() {
        System.out.println("-------------------------");
        System.out.println("Show room information and reservation");
//
        int choice = AppUtils.getIntWithBound("Input choice", 0, 4);
        switch (choice) {
            case 1:
                DisplayData.displayRoom();
                DisplayData.displayReservation();
                break;
            case 2:

                break;
            case 3:
                System.out.println("Upgrading...");
                break;
            case 4:
                System.out.println("Upgrading..");
                break;
            case 0:
                System.out.println("Back to Login menu");

                break;
        }

    }

    public static void main(String[] args) {
        managerMenu();
    }
}
