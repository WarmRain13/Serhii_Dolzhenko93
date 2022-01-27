public class Main {

  public static void main(String[] args) {
      String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
      System.out.println(calculateSalarySum(text));

  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
      int sum = 0;
      String[] sumAll = text.split(" ");


      for (int i = 0; i < sumAll.length; i++){
          if(sumAll[i].matches("[0-9]+")){
              sum = sum + Integer.parseInt(sumAll[i]);

          }

      }
      return sum;

  }

}