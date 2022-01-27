import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    private static TreeSet<String> mail = new TreeSet<>();
    private static List<String> newList = new ArrayList<>();
    private static final String REGEX_FOR_MAIL = "(^.+@.+\\..+$)";
    private static final Pattern pattern = Pattern.compile(REGEX_FOR_MAIL);
    private static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    public static void add(String email) {
        // TODO: валидный формат email добавляется
        if(validation(email)) {
            mail.add(email.toLowerCase());
            System.out.println("Добавлен email" + " " + "\"" + email + "\"");
        } else {
            System.out.println(WRONG_EMAIL_ANSWER);
        }
    }
    private static boolean validation(final String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        newList.clear();
        newList.addAll(mail);
        mail.clear();

        return newList;
    }

}
