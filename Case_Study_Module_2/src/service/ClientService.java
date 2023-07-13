package service;

import model.Client;
import model.Food;
import model.Manager;
import model.enums.EPath;
import utils.SerializationUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClientService implements BasicCRUD<Client> {
    public static List<Client> clientList;

    static {
        clientList = (List<Client>) SerializationUtil.deserialize(EPath.CLIENT.getFilePath());
    }

    public static Client currentClient;
    private static ClientService instance;

    public static ClientService getInstance() {
        if (instance == null) {
            instance = new ClientService();
        }
        return instance;
    }

    @Override
    public Client getById(int id) {

        return clientList.stream()
                .filter(client -> client.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Client> getAll() {
        return clientList;
    }

    @Override
    public boolean create(Client client) {
        if (clientList.stream().anyMatch(e -> e.getName().equals(client.getName())) || ManagerService.listManagers.stream().anyMatch(e -> e.getName().equals(client.getName()))||
                clientList.stream().anyMatch(e -> e.getEmail().equals(client.getEmail()))||ManagerService.listManagers.stream().anyMatch(e -> e.getEmail().equals(client.getEmail()))) {
            return false;
        }
        clientList.add(client);
        saveClient();
        return true;
    }

    @Override
    public void update(Client client) {
        clientList.stream()
                .map(existingClient -> {
                    if (existingClient.getId() == client.getId()) {
                        return client;
                    } else {
                        return existingClient;
                    }
                })
                .findFirst()
                .orElse(null);
    }

    public static void saveClient() {
        SerializationUtil.serialize(clientList, EPath.CLIENT.getFilePath());
    }

    public static void loadClient() {
        SerializationUtil.deserialize(EPath.CLIENT.getFilePath());
    }



    @Override
    public void delete(int id) {
        clientList = clientList.stream()
                .filter(e -> !Objects.equals(e.getId(), id))
                .collect(Collectors.toList());
        saveClient();
    }

    @Override
    public boolean isExist(int id) {
        Client client = clientList.stream()
                .filter(e -> Objects.equals(e.getId(), id))
                .findFirst()
                .orElse(null);
        return client != null;
    }

    @Override
    public void print() {
        for (Client client : clientList) {
            System.out.println(client.toString());
        }
    }

    public static Client getByEmail(String email) {
        return clientList.stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
    public static Client getUsername(String username) {
        return clientList.stream()
                .filter(e -> e.getName().equals(username))
                .findFirst()
                .orElse(null);
    }


}
