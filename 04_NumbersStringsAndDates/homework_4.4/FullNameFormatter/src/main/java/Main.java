import net.sf.saxon.lib.SchemaURIResolver;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

      String input = scanner.nextLine();
      String cleanInput = input.trim();
      boolean ru = true;

      int utfMin = 1040;
      int utfMax = 1103;
      for (int i = 0; i < input.length(); i++) {
      int symbol = input.codePointAt(i);
      if ( utfMin <= symbol && symbol <= utfMax || symbol == 45 || symbol == 32) {
        ru = true;
      } else {
        ru = false;
        System.out.println("Введенная строка не является ФИО");
        return;
      }
    }

      if (cleanInput.equals("0") || !cleanInput.contains(" ")) {
        System.out.println("Введенная строка не является ФИО");
        return;
      }

      String firstPart = cleanInput.substring(cleanInput.indexOf(" "), cleanInput.length());
      String cleanFirstPart = firstPart.trim();

      if (!cleanFirstPart.contains(" ")) {
        System.out.println("Введенная строка не является ФИО");
        return;
      }
      String secondPart = cleanFirstPart.substring(cleanFirstPart.indexOf(" "), cleanFirstPart.length());
      String cleanSecondPart = secondPart.trim();

      if (cleanSecondPart.contains(" ")) {
        System.out.println("Введенная строка не является ФИО");
        return;
      }
      String lastName = cleanInput.substring(0, cleanInput.indexOf(" "));
      String firstName = cleanFirstPart.substring(0, cleanFirstPart.indexOf(" "));
      String middleName = cleanSecondPart;
      System.out.println("Фамилия: " + lastName);
      System.out.println("Имя: " + firstName);
      System.out.println("Отчество: " + middleName);






        //TODO:напишите ваш код тут, результат вывести в консоль.
        //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
      }
    }

