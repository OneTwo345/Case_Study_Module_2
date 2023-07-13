package View;

import model.Client;
import service.ClientService;
import service.LoginService;
import service.RegisterService;
import utils.AppUtils;
import utils.ListView;
import utils.ValidateUtils;

import java.io.IOException;
import java.util.List;

import static utils.ListView.loginMenuList;

public class
LoginView {
    public static void register() {
        String name;
        String email = "";
        String password ="";
        String phoneNumber = "";
        boolean isValid;

        do {
            name = AppUtils.getString("Input Username");
            isValid = ValidateUtils.isUserName(name);
            if (!isValid) {
                System.out.println("Invalid username, please try again!");
                continue;
            }

            email = AppUtils.getString("Input Email");
            isValid = ValidateUtils.isEmail(email);
            if (!isValid) {
                System.out.println("Invalid email, please try again!");
                continue;
            }

            password = AppUtils.getString("Input Password");
            isValid = ValidateUtils.isPassWord(password);
            if (!isValid) {
                System.out.println("Invalid password, please try again!");
                continue;
            }

            phoneNumber = AppUtils.getString("Input Phone number");
            isValid = ValidateUtils.isPhoneNumber(phoneNumber);
            if (!isValid) {
                System.out.println("Invalid phone number, please try again!");
                continue;
            }
        } while (!isValid);

        Client client = new Client(name, email, password, phoneNumber);
        if (RegisterService.register(client)) {
            System.out.println("Register successful!!");
            loginMenu();
        } else {
            System.out.println("Register error!! Please try again");
            register();
        }
        ClientService.clientList.add(client);
        ClientService.saveClient();
    }

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
            System.out.println(e.getMessage() + " LOGINVIEW");
            loginMenu();
        }

    }


    public static void main(String[] args) {
        loginMenu();
    }


}
