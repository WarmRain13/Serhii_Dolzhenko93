import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.Entry;

public class PhoneBook {

    Map<String, String> phoneBook = new HashMap<>();
    private static final String REGEX_FOR_PHONE = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    private static  final Pattern pattern = Pattern.compile(REGEX_FOR_PHONE);


    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента

        Matcher matcher = pattern.matcher(phone);
        if(matcher.matches() && !name.equals("") && !phone.equals(name)) {
            phoneBook.put(phone,name);

        }

    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String name = phoneBook.get(phone);
        if(name == null){
            return "";
        }
        return name + " - " + phone;
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet<String>phoneAndName = new TreeSet<>();

        for (Entry<String, String> nameItem : phoneBook.entrySet()){
            if(nameItem.getValue().equals(name)){
                phoneAndName.add(nameItem.getValue() + " - " + nameItem.getKey());
                return phoneAndName;
            }
        }
        return new TreeSet<>();
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        TreeSet<String> allPhoneBook = new TreeSet<>();

        for (Entry<String,String> contactItem : phoneBook.entrySet()){
            allPhoneBook.add(contactItem.getValue() + " - " + contactItem.getKey());
        }

        return allPhoneBook;
    }

}