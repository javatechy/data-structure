package javatechy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class DateFormatFinder {

    static Logger logger = Logger.getLogger("dateFormatter");

    private static final String[] formats = { "MMM dd yyyy 'at' HH:mm a ZZZ","yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd HH:mm:ss", "MM/dd/yyyy HH:mm:ss",
            "MM/dd/yyyy'T'HH:mm:ss.SSS'Z'", "MM/dd/yyyy'T'HH:mm:ss.SSSZ", "MM/dd/yyyy'T'HH:mm:ss.SSS", "MM/dd/yyyy'T'HH:mm:ssZ", "MM/dd/yyyy'T'HH:mm:ss", "yyyy:MM:dd HH:mm:ss", "yyyyMMdd", };

    public static void main(String[] args) {
        String yyyyMMdd = "January 18 2018 at 11:00 AM IST";
        parse(yyyyMMdd);
    }

    public static void parse(String d) {
        if (d != null) {
            for (String parse : formats) {
                SimpleDateFormat sdf = new SimpleDateFormat(parse);
                try {
                    sdf.parse(d);
                    System.out.println("Printing the value of " + parse);
                } catch (ParseException e) {
                    // e.printStackTrace();
                }
            }
        }
    }
}
