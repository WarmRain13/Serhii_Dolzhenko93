import java.util.Scanner;

public class Main {
  public static final int FULLNOMBER = 10;
  public static final int CODCOUNTRY = 7;
  public static final int CODMOBILE = 8;
  public static final int FIRSTSYMBOL = 7;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      String phone = input.replaceAll("[^0-9]", "");


      if(phone.length() == FULLNOMBER){
        StringBuilder sb = new StringBuilder(phone);
        sb.insert(0,FIRSTSYMBOL);

        phone = sb.toString();

      }
      if(phone.length() < FULLNOMBER || phone.length() > FULLNOMBER + 1){
        System.out.println("Неверный формат номера");
        break;
      }
      int firstSymbol = Character.getNumericValue(phone.charAt(0));

      if(firstSymbol != CODCOUNTRY && firstSymbol != CODMOBILE){
        System.out.println("Неверный формат номера");
        break;
      }
      if(firstSymbol == CODMOBILE){
        phone =  phone.replaceFirst("8", "7");
        System.out.println(phone);
      }
      else
        System.out.println(phone);

    }
  }

}
