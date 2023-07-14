package View;

import model.Contact;
import service.ContactService;
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
            System.out.println("2. Check message");
            System.out.println("3. New song");
            System.out.println("4. Update Account");

            choice = getIntWithBound("Input choice", 0, 10);
            switch (choice) {
                case 1:
                    displayRoom();
                    displayReservation();
                    break;
                case 2:
                    displayNotification();

                case 0:
                    System.out.println("Back to Login menu");
                    loginMenu();
                    break;
            }
        }
        while (choice != 0);

    }


    public static void displayNotification() {
        ContactService.loadContact();
        if (ContactService.contactList == null || ContactService.contactList.isEmpty()) {
            System.out.println("Bạn không có thông báo nào!");
        } else {
            System.out.println("Danh sách thông báo:");
            for (Contact contact : ContactService.contactList) {
                System.out.printf("ID: %d\n", contact.getId());
                System.out.printf("Người gửi: %s\n", contact());
                System.out.printf("Nội dung: %s\n", contact.getMessage());
                System.out.println("--------------------------------------------------");
            }
        }
    }
}
