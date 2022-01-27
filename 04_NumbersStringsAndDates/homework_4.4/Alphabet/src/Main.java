public class Main {
    public static void main(String[] args){
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("Количество букв: " + alphabet.length());

        for (int i = 0; i < alphabet.length(); i++){
            System.out.println(alphabet.charAt(i) + " - " + alphabet.codePointAt(i));
        }
    }
}
