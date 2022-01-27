import org.checkerframework.checker.units.qual.A;

import java.text.DecimalFormat;
import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        List<String> collNumbers = new ArrayList<>();
        ArrayList<String> letter = new ArrayList<>(Arrays.asList("А","В","Е","К","М","Н","О","Р","С","Т","У","Х"));
        DecimalFormat reg = new DecimalFormat("00");
        for (int i = 0; i < 2000000; i++){
            int X = (int)(Math.random() * 12);
            int Y = (int)(Math.random() * 12);
            int Z = (int)(Math.random() * 12);
            int N = (int)(Math.random() * 10);
            String NS = String.valueOf(N);
            int regionNumber = (int)(Math.random() * 200);
            collNumbers.add(letter.get(X) + NS + NS + NS + letter.get(Y) + letter.get(Z) + reg.format(regionNumber));

        }

        return collNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).equals(number)){
                return true;
            }
        }

        return false;


    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {

    Collections.sort(sortedList);
    int index = Collections.binarySearch(sortedList, number);

    if(index >= 0){
        return true;
    }

        return false;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {

        for (int i = 0; i < hashSet.size(); i++){
            if (hashSet.contains(number)){
                return true;
            }
        }

        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {


        return treeSet.contains(number);
    }

}
