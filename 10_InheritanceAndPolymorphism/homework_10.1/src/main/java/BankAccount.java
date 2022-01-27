public class BankAccount {
    private String name;
    protected double balance;

    public BankAccount() {
        name = "";
        balance = 0.0;
    }

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        //TODO: реализуйте метод и удалите todo
        return balance;
    }

    public void put(double amountToPut) {
        //TODO: реализуйте метод и удалите todo
        if (amountToPut <= 0) {
            System.out.println("Невозможная операция");
        } else {
            balance = balance + amountToPut;
        }
    }

    public void take(double amountToTake) {
        //TODO: реализуйте метод и удалите todo
        if (amountToTake > balance) {
            System.out.println("Недостаточно средств на счете");
        } else {
            balance = balance - amountToTake;
        }

    }

    public boolean send(BankAccount receiver, double amount) {

        if (balance >= amount) {
            take(amount);
            receiver.put(amount);
            return true;
        }
        return false;
    }

}
