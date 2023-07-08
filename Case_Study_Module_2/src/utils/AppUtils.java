package utils;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AppUtils {
    private static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    public static String getString(String str) {
        System.out.println(str);
        return sc.nextLine();
    }

    public static int getInt(String str) {
        try {
            return Integer.parseInt(getString(str));
        } catch (Exception e) {
            System.out.println("Input invalid");
            return getInt(str);
        }
    }

    public static double getDouble(String str) {
        try {
            return Double.parseDouble(getString(str));
        } catch (Exception e) {
            System.out.println("Input invalid");
            return getDouble(str);
        }
    }

    public static int getIntWithBound(String str, int begin, int end) {
        try {
            int number = getInt(str);
            if (number < begin || number > end) {
                throw new NumberFormatException(String.format("Please input number between %d and %d", begin, end));
            }
            return number;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getIntWithBound(str, begin, end);
        }
    }

    public static Date getDate(String str) {
        try {
            System.out.println("Please enter date with format YYYY-MM-DD");
            return Date.valueOf(getString(str));
        } catch (Exception e) {
            System.out.println("Invalid Date Format");
            return getDate(str);
        }
    }





    public static void main(String[] args) {

        //118800000

    }
}