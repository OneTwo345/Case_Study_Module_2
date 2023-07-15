package service;

import model.Client;
import model.Contact;
import model.Food;
import model.enums.EPath;
import utils.SerializationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactService {
    public static List<Contact> contactList;
    public static List<Contact> messageList;
    public ContactService() {
        contactList = new ArrayList<>();
    }

    static {
        contactList = (List<Contact>) SerializationUtil.deserialize(EPath.CONTACT.getFilePath());
    }
    static {
        messageList = (List<Contact>) SerializationUtil.deserialize(EPath.MESSAGE.getFilePath());
    }
    public boolean isExist(int id) {
        Contact contact = contactList.stream()
                .filter(e -> Objects.equals(e.getMessage(), id))
                .findFirst()
                .orElse(null);
        return contact != null;
    }
    public static void saveContact() {
        SerializationUtil.serialize(contactList, EPath.CONTACT.getFilePath());
    }
    public static void loadContact() {
        SerializationUtil.deserialize( EPath.CONTACT.getFilePath());
    }
    public static void loadMessage() {
        SerializationUtil.deserialize( EPath.MESSAGE.getFilePath());
    }
    public static void saveMessage() {
        SerializationUtil.serialize(messageList, EPath.MESSAGE.getFilePath());
    }

}
