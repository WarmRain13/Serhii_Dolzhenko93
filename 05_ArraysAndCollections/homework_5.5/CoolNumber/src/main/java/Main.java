import java.util.*;

public class Main {
    static  List<String> list = CoolNumbers.generateCoolNumbers();

    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        while (true) {
            String stateNumber = scanner.nextLine();

            long a = System.nanoTime();
            if (list.contains(stateNumber)) {
                System.out.println("Поиск перебором: номер найден, поиск занял: " + (System.nanoTime() - a) + "нс");

            } else {
                System.out.println("Поиск перебором: номер не найден, поиск занял: " + (System.nanoTime() - a) + "нс");
            }
            Collections.sort(list);
            long b = System.nanoTime();
            if (CoolNumbers.binarySearchInList(list,stateNumber)) {
                System.out.println("Бинарный поиск: номер найден, поиск занял: " + (System.nanoTime() - b) + "нс");

            } else {
                System.out.println("Бинарный поиск: номер не найден, поиск занял: " + (System.nanoTime() - b) + "нс");
            }
            HashSet<String> set = new HashSet<>(list);
            long c = System.nanoTime();
            if (CoolNumbers.searchInHashSet(set,stateNumber)) {
                System.out.println("Поиск в HashSet: номер найден, поиск занял: " + (System.nanoTime() - c) + "нс");
            } else {
                System.out.println("Поиск в HashSet: номер не найден, поиск занял: " + (System.nanoTime() - c) + "нс");
            }
            TreeSet<String> set1 = new TreeSet<>(list);
            long d = System.nanoTime();
            if (CoolNumbers.searchInTreeSet(set1,stateNumber)) {
                System.out.println("Поиск в TreeSet: номер найден, поиск занял: " + (System.nanoTime() - d) + "нс");

            } else {
                System.out.println("Поиск в TreeSet: номер не найден, поиск занял: " + (System.nanoTime() - d) + "нс");

            }
    }

   }

}
