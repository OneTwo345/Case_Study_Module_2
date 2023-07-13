package service;

import utils.AppUtils;

import java.io.IOException;
import java.util.Objects;

import static View.ClientView.clientMenu;
import static View.ManagerView.managerMenu;

public class LoginService {
    public static void login() throws IOException {
        String username = AppUtils.getString("Input username: ");
        String password = AppUtils.getString("Input password");
        if (ManagerService.getUserByName(username) != null && Objects.equals(ManagerService.getUserByName(username).getPassword(), password)) {
            ManagerService.currentManager = ManagerService.getUserByName(username);
            System.out.println("Welcome Duy");
            managerMenu();

        } else if (ClientService.getUsername(username) != null && Objects.equals(ClientService.getUsername(username).getPassword(), password)) {
            ClientService.currentClient = ClientService.getUsername(username);
            clientMenu();

        } else {
            System.out.println("Invalid account!");
            login();
        }

    }

}
