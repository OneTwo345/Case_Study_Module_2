package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class DateFormat {
    private static final SimpleDateFormat dateFormatWithHours = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static Date parseDate(String strDate) {
        try {
            return (Date) simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            System.out.println("Invalid format");
            return null;
        }
    }
    public static String convertDateToString(Date date) {
        return simpleDateFormat.format(date);
    }
    public static Date parseDateWithHours(String strDate) {
        try {
            return (Date) dateFormatWithHours.parse(strDate);
        } catch (ParseException e) {
            System.out.println("Invalid format");
            System.out.println("dd-MM-yyyy hh:mm:ss");
            return null;
        }
    }
    public static String convertDateToStringWithHours(Date date) {
        return dateFormatWithHours.format(date);
    }
}
