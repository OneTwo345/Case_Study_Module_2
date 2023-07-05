package main;

import static utils.DisplayData.displayCategories;
import static utils.DisplayData.displayRoom;
import static utils.InitData.*;

public class Main {
    public static void main(String[] args) {
        initRoom();
        initReservation();
        initCategory();
        displayRoom();
    }
}
