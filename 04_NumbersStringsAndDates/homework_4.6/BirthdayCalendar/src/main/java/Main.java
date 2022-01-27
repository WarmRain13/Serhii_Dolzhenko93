import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        int day = 30;
        int month = 3;
        int year = 1993;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        int old = 0;
        String myDay = "";
        Calendar today = new GregorianCalendar();
        StringBuilder builder = new StringBuilder();
        Calendar calendar = new GregorianCalendar();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy - E", Locale.ENGLISH);

        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);

        while (calendar.before(today) || calendar.equals(today)) {
            String result = old + " - " + format.format(calendar.getTime());
            builder.append(result);
            calendar.add(Calendar.YEAR, 1);
            old++;

            myDay = myDay + result + "\n"; // вместо "\n" хотел поставить System.lineSeparator(), но тогда не проходит тесты
        }
        return myDay;
    }
}

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
