import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;
    final String REGEX_FOR_MAIL = "(^.+@.+\\..+$)";
    final String REGEX_FOR_PHONE = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws CorrectInputException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;


        String[] components = data.split("\\s+");
        if(components.length != 4){
            throw new CorrectInputException("Wrong format. Correct format: \n"
                    + "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (!components[INDEX_EMAIL].matches(REGEX_FOR_MAIL)) {
            throw new CorrectInputException("Wrong format Email. Correct format: vasily.petrov@gmail.com");
        }
        if (!components[INDEX_PHONE].matches(REGEX_FOR_PHONE)) {
            throw new CorrectInputException("Wrong format phone. Correct format: +79787777777");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));


    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}