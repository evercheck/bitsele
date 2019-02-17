import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class run {
    public static void main(String arg[]) {
/*        String str = "2019 FEB 17 23:51:55";
        boolean is = isValidDateFormat("yyyy MMM dd HH:mm:ss", str);
        System.out.println(is);*/
        System.out.println(System.getProperty("os.name"));
    }

    public static boolean isValidDateFormat(String format, String value) {
        System.out.println("TESTING - isValidDateFormat " + value);
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
}
