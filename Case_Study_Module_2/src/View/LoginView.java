package View;

import model.User;
import Utils.AppUltis;

public class LoginView {
    public User login() {
       String username =AppUltis.getString("Enter username");
       String password = AppUltis.getString("Enter password");

    }
}
