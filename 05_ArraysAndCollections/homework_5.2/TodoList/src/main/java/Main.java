import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static TodoList todoList;

    public static void main(String[] args) {

        String regexForAddMethod = "^ADD\\s+\\D+";
        String regexForAddMethodIndex = "^ADD\\s+\\d+\\s+.+";
        String regexForPrintTodoList = "LIST";
        String regexForEditMethod = "^EDIT\\s+\\d+\\s+\\D+";
        String regexForDeleteMethod = "^DELETE\\s+\\d+";

        todoList = new TodoList();

        Scanner input = new Scanner(System.in);


        while (true) {

            String inputCommand = input.nextLine();

            if (inputCommand.matches(regexForAddMethod)) {
                todoList.add(inputCommand.replaceAll("^ADD\\s+", ""));
            }
            if (inputCommand.matches(regexForAddMethodIndex)) {
                int index = Integer.parseInt(inputCommand.replaceAll("^ADD\\s+|\\s+\\D+", ""));
                todoList.add(index, inputCommand.replaceAll("^ADD\\s+\\d+\\s+", ""));

            }
            if (inputCommand.matches(regexForPrintTodoList)) {
                printTodoList();
            }
            if (inputCommand.matches(regexForEditMethod)) {
                int index = Integer.parseInt(inputCommand.replaceAll("EDIT\\s+|\\s+\\D+", ""));
                todoList.edit(inputCommand.replaceAll("^EDIT\\s+\\d+\\s+", ""), index);
            }
            if (inputCommand.matches(regexForDeleteMethod)) {
                int index = Integer.parseInt(inputCommand.replaceAll("^DELETE\\s+", ""));
                todoList.delete(index);
            }
        }
    }

    public static void printTodoList() {
        ArrayList<String> todoListForPrint = todoList.getTodos();
        int index = 0;
        for (String item : todoListForPrint) {
            System.out.println(index + " - " + item);
            index++;
        }
        // TODO: написать консольное приложение для работы со списком дел todoList
    }
}
