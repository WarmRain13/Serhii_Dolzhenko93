public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        char[][] numbers = new char[size][size];

            for (int i = 0; i < numbers.length; i++){
                for (int j = 0; j < numbers.length; j++){

                    if(i == j || j == size - i - 1) {
                        numbers[i][j] = symbol;
                    }
                    else {
                        numbers[i][j] = ' ';
                    }

                    System.out.print(numbers[i][j]);
                    }
                System.out.println();
                }

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        return numbers;
    }
}
