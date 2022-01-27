public class CardAccount extends BankAccount {


    @Override
    public void take(double amountToTake) {

        double commission = amountToTake * 0.01;

        if (amountToTake > balance) {
            System.out.println("Недостаточно средств на счете");
        } else {
            balance = balance - amountToTake - commission;
        }
    }
}
