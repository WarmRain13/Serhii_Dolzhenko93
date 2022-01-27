public abstract class Client {
    protected double balance;

    public double getAmount() {
        return balance;
    }

    public void put(double amountToPut) {

        if (amountToPut <= 0) {
            System.out.println("Невозможная операция");
        } else {
            balance = balance + amountToPut;
        }
    }

    public void take(double amountToTake) {

        if (amountToTake > balance) {
            System.out.println("Недостаточно средств на счете");
        } else {
            balance = balance - amountToTake;
        }
    }

}
