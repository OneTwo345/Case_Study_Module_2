package utils;

import java.util.Arrays;
import java.util.List;

public class ListView {
    public static List<String> loginMenuList = Arrays.asList("Welcome to DN Karaoke", "1. Login", "2. Sign up", "0. Quit");
    public static List<String> clientMenuList = Arrays.asList("Client menu", "1. Book room", "2. Cancel room", "3. Get room detail", "4. Get music list ", "5. Edit profile", "0. Back to login menu");

    public static List<String> updateClientList = Arrays.asList("Select field you want to update: ",
            "1. Name", "2. Password", "3. Phone number", "0. Back to Client menu");
    public static void printMenu(List<String> menu) {
        for (String str : menu) {
            System.out.println(str);
        }
    }
}
