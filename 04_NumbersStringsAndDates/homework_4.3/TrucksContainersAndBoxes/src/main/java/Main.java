import java.util.Scanner;

public class Main {
    public static final int CONTAINER_VALUE = 12;
    public static final int BOX_VALUE = 27;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        int boxesAmount = Integer.parseInt(boxes);
        int containerAmount = 0;
        int truckAmount = 0;

        for (int i = 0; i < boxesAmount; i++) {
            if(i % (BOX_VALUE * CONTAINER_VALUE) == 0){
                truckAmount++;
                System.out.println("Грузовик: " + truckAmount);
            }
            if(i % BOX_VALUE == 0){
                containerAmount++;
                System.out.println("\tКонтейнер: " + containerAmount);
            }
            System.out.println("\t\tЯщик: " + (i + 1));


        }
        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + truckAmount + " шт.");
        System.out.println("контейнеров - " + containerAmount + " шт.");


        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
