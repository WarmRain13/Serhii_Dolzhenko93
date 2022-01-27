import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        String regexForAddMethod = "^ADD\\s+\\D+";
        String regexForPrintTodoList = "LIST";
        String regexForMail = "(^.+@.+\\..+$)";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.matches(regexForAddMethod)) {

                if (input.matches(regexForMail)) {
                    EmailList.add(input.substring(4,input.length()));
                } else {
                    System.out.println(WRONG_EMAIL_ANSWER);
                }
            }
            if (input.matches(regexForPrintTodoList)) {
                System.out.println(EmailList.getSortedEmails());
            }
            if (!input.matches(regexForAddMethod) && !input.matches(regexForPrintTodoList)) {
                System.out.println("Несоответствующая команда");
            }

            //TODO: write code here
        }
    }



}