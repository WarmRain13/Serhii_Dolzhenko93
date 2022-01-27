import java.util.Calendar;

public class Main {


    public static void main(String[] args) {


        BankAccount accountNew = new BankAccount();
        System.out.println("Текущий баланс " + accountNew.getAmount());

        accountNew.put(100);
        System.out.println("Текущий баланс " + accountNew.getAmount());


        accountNew.take(50);
        System.out.println("Текущий баланс " + accountNew.getAmount());

        BankAccount maxKrasaucheg = new BankAccount();
        CardAccount ya = new CardAccount();

        accountNew.send(ya, 25);
        System.out.println("На счету " + ya.getAmount());

        accountNew.send(maxKrasaucheg, 25);
        System.out.println("У Макса  на балансе " + maxKrasaucheg.getAmount());

        ya.send(accountNew, 15);
        System.out.println("Текущий баланс " + accountNew.getAmount());
        System.out.println("Бласанс Я " + ya.getAmount());
    }
}
