package utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

import static utils.DateFormat.DATE_TIME_FORMATTER;

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
    public static Date getCurrentTime(){
        ZoneId currentZone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId targetZone = ZoneId.of("Asia/Ho_Chi_Minh");
        ZonedDateTime targetDateTime = localDateTime.atZone(currentZone).withZoneSameInstant(targetZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = targetDateTime.format(formatter);
        System.out.println(formattedDateTime);
        return   DateFormat.parseDateWithHours(formattedDateTime);
    }

//    public static Date getDayTime(){
//        int choice = getIntWithBound("1. Lấy mốc thời gian hiện tại \n" + "2.Nhập vào thời gian", 1, 2);
//        switch (choice) {
//
//            case 1:
//                ZoneId currentZone = ZoneId.systemDefault();
//                LocalDateTime localDateTime = LocalDateTime.now();
//                ZoneId targetZone = ZoneId.of("Asia/Ho_Chi_Minh");
//                ZonedDateTime targetDateTime = localDateTime.atZone(currentZone).withZoneSameInstant(targetZone);
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//                String formattedDateTime = targetDateTime.format(formatter);
//                System.out.println(formattedDateTime);
//              return   DateFormat.parseDateWithHours(formattedDateTime);
//
//            case 2:
//                boolean validInput = false;
//
//                while (!validInput) {
//                    try {
//                        LocalTime localTime = LocalTime.parse(getString("Nhập giờ (hh:mm:ss)"));
//                        ZoneId currentZone1 = ZoneId.systemDefault();
//                        LocalDateTime localDateTime1 = LocalDateTime.now();
//                        ZonedDateTime currentDateTime1 = localDateTime1.atZone(currentZone1).with(LocalTime.from(localTime));
//                        ZoneId targetZone1 = ZoneId.of("Asia/Ho_Chi_Minh");
//                        ZonedDateTime targetDateTime1 = currentDateTime1.withZoneSameInstant(targetZone1);
//                        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//                        String formattedDateTime1 = targetDateTime1.format(formatter1);
//                        System.out.println(formattedDateTime1);
//
//                        return   DateFormat.parseDateWithHours(formattedDateTime1);
//
//                    } catch (DateTimeParseException e) {
//                        System.out.println("Không thể đọc giờ được nhập vào. Vui lòng kiểm tra lại định dạng (hh:mm:ss).");
//                    }
//                }
//        }return null;
//
//    }
public static LocalDateTime getDateTimeNow() {
    return LocalDateTime.now();
}
    public static String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM HH:mm");
        return dateTime.format(formatter);
    }

    public static LocalDateTime getDateTime(String str) {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(getString(str + " (yyyy-MM-dd HH:mm:ss):"), DATE_TIME_FORMATTER);
            LocalDateTime now = getDateTimeNow();
            if (getDuration(now, dateTime) < 0 || getDuration(now, dateTime) > 43200) {
                throw new RuntimeException("Invalid Date Range. Please enter a date and time within the last a month.");
            }
            return dateTime;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date and time in the format 'yyyy-MM-dd HH:mm:ss'.");
            return getDateTime(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getDateTime(str);
        }
    }
    public static int getDuration(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        return (int) duration.toMinutes();
    }
    public static LocalDateTime parseDateTime(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(input, formatter);
    }






    public static void main(String[] args) {



    }

}