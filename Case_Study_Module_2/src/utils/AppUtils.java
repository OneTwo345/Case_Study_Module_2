package utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
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

    public static Date getDayTime(){
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
        int choice = getIntWithBound("1. Lấy mốc thời gian hiện tại \n" + "2. Nhập vào thời gian", 1, 2);
        switch (choice) {
            case 1:
                ZoneId currentZone = ZoneId.systemDefault();
                LocalDateTime localDateTime = LocalDateTime.now();
                ZoneId targetZone = ZoneId.of("Asia/Ho_Chi_Minh");
                ZonedDateTime targetDateTime = localDateTime.atZone(currentZone).withZoneSameInstant(targetZone);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDateTime = targetDateTime.format(formatter);
                System.out.println(formattedDateTime);
                return DateFormat.parseDateWithHours(formattedDateTime);
            case 2:
                Scanner scanner = new Scanner(System.in);
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalDate localDate;
                LocalTime localTime;
                LocalDateTime localDateTime2;
                boolean validInput = false;
                while (!validInput) {
                    System.out.print("Nhập ngày (dd-mm-yyyy): ");
                    String dateInput = scanner.nextLine();
                    localDate = LocalDate.parse(dateInput, dateFormatter);
                    if (localDate.isBefore(LocalDate.now())) {
                        System.out.println("Ngày không được bé hơn ngày hiện tại!");
                        continue;
                    }
                    System.out.print("Nhập giờ (hh:mm:ss): ");
                    String timeInput = scanner.nextLine();
                    localTime = LocalTime.parse(timeInput, timeFormatter);
                    localDateTime = LocalDateTime.of(localDate, localTime);
                    if (localDateTime.isBefore(LocalDateTime.now())) {
                        System.out.println("Ngày giờ không được bé hơn ngày giờ hiện tại!");
                        continue;
                    }
                    validInput = true;
                }
                ZoneId currentZone1 = ZoneId.systemDefault();
                ZonedDateTime currentDateTime1 = localDateTime2.atZone(currentZone1);
                ZoneId targetZone1 = ZoneId.of("Asia/Ho_Chi_Minh");
                ZonedDateTime targetDateTime1 = currentDateTime1.withZoneSameInstant(targetZone1);
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDateTime1 = targetDateTime1.format(formatter1);
                System.out.println(formattedDateTime1);
                return DateFormat.parseDateWithHours(formattedDateTime1);
            default:
                return null;
        }
    }





    public static void main(String[] args) {

        //118800000

    }

}