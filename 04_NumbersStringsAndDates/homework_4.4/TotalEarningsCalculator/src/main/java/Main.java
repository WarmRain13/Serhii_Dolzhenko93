public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль
    int a = Integer.parseInt((text.substring(15, 19)));
    int b = Integer.parseInt((text.substring(35, 39)));
    int c = Integer.parseInt((text.substring(56, 61)));
    System.out.println(a+b+c);
  }

}