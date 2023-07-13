package service;

import model.Manager;
import model.enums.EPath;
import utils.SerializationUtil;

import java.util.List;

public class ManagerService {
    public static List<Manager> listManagers;
    public static Manager currentManager;

    static {
        listManagers = (List<Manager>) SerializationUtil.deserialize(EPath.MANAGER.getFilePath());

    }


    public ManagerService() {
    }

    public static Manager getByEmail(String email) {
        return listManagers.stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
    public static Manager getUserByName(String username) {
        return listManagers.stream()
                .filter(e -> e.getName().equals(username))
                .findFirst()
                .orElse(null);
    }
}
