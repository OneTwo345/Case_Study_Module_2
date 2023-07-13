package service;

import model.Client;

public class RegisterService {
    public static boolean register(Client client) {
        return ClientService.getInstance().create(client);
    }
}
