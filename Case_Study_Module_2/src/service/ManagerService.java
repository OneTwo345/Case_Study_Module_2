package service;

import model.Manager;
import utils.SerializationUtil;

import java.util.List;

public class ManagerService {
    public static List<Manager> listManagers;
    public static Manager currentManager;

    static {
        listManagers = (List<Manager>) SerializationUtil.deserialize(EPath.MANAGERS.getFilePath());
        if (LoginService.currentUser instanceof Manager) {
            currentManager = (Manager) LoginService.currentUser;
        }
    }


    public ManagerService() {
    }

    public static Manager getByEmail(String email) {
        return listManagers.stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}
