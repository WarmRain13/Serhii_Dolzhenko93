public class Main {

    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008> 1234 <5678> 8912", "***");
        System.out.println(safe);
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        if (!text.contains("0")) {
            return text;
        }
        if(!text.contains("<") || !text.contains(">")){
            return text;
        }

        text.indexOf("<");
        text.indexOf(">");
        String c = text.substring(text.indexOf("<"), text.indexOf(">") + 1);
        String d = text.replace(c, placeholder);

        if(!d.contains("<") || !d.contains(">")){
            return d;
        }
        String e = d.substring(d.indexOf("<"), d.indexOf(">") + 1);
        String f = d.replace(e, placeholder);

        return f;




    }
}
//Номер кредитной карты <4008> 1234 <5678> 8912
//Номер паспорта <<45 08 36513
