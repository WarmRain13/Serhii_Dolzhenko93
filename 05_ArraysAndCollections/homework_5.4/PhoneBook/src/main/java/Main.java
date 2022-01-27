import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        String regexForPhone = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        String regexForName = "\\b[А-Я][а-яА-Я-]*[а-я]\\b";
        String regexForCommand = "LIST";
        phoneBook.addContact("79001234567", "Маша");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер, имя или команду: ");

        while (true){
            String input = scanner.nextLine();

            if(input.matches(regexForName)){
                TreeSet<String> test = (TreeSet<String>) phoneBook.getPhonesByName(input);
                if(test.size() > 0 ){
                    System.out.println(test);
                }else {
                    System.out.println("Такого имени в телефонной книге нет.");
                    System.out.println("Введите номер телефона для абонента " + input + " :");
                    String name = input;
                    input = scanner.nextLine();
                    if (input.matches(regexForPhone)){
                        phoneBook.addContact(input,name);
                        System.out.println("Контакт сохранен");
                    }else {
                        System.out.println("Неверный формат номера");
                    }
                }

            }

            if(input.matches(regexForPhone)){
                String test2 = phoneBook.getNameByPhone(input);
                if (test2 != ""){
                    System.out.println(test2);
                } else{
                    System.out.println("Такого номера нет в телефонной книге");
                    System.out.println("Введите имя абонента для номера " + input + " :");
                    String phone = input;
                    input = scanner.nextLine();
                    if (input.matches(regexForName)){
                        phoneBook.addContact(phone,input);
                        System.out.println("Контакт сохранен");
                    } else {
                        System.out.println("Невалидное имя");
                    }
                }
            }
            if(input.matches(regexForCommand)) {
                System.out.println(phoneBook.getAllContacts());
            }
            if(input.equals(regexForCommand) && !input.matches(regexForName) && !input.matches(regexForPhone)){
                System.out.println("Неверный формат ввода");
            }

        }


    }
}
