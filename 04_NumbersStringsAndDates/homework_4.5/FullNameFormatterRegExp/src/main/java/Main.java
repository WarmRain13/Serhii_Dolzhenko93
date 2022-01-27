import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class Main {

  public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in)) {

      String input = scanner.nextLine();
      boolean cyrillic = false;
      boolean formatText = false;

      for (char a : input.toCharArray()) {
        if (Character.UnicodeBlock.of(a) == Character.UnicodeBlock.CYRILLIC) {
          cyrillic = true;
        }
      }
      String[] words = input.split(" ");
      String x = "\\b[А-Я][а-яА-Я-]*[а-я]\\b";


      for (int i = 0; i < words.length; i++) {
        if (words[i].matches(x)) {
          formatText = true;
        }
        else if(!words[i].matches(x)){
          formatText = false;
          break;
        }



        }

      for (int i = 0; i < words.length; i++) {

        if (input.equals("0") || words.length != 3 || cyrillic != true || formatText != true) {
          System.out.println("Введенная строка не является ФИО");
          break;
        }
        if (i == 0) {
          System.out.println("Фамилия: " + words[i]);
        }
        if (i == 1) {
          System.out.println("Имя: " + words[i]);
        }
        if (i == 2 && words.length == 3) {
          System.out.println("Отчество: " + words[i]);
        } else if (i == 2 && words.length > 3) {
          System.out.println("Отчество: " + words[i] + " " + words[i + 1]);
        }

      }

      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
      }
  }

}