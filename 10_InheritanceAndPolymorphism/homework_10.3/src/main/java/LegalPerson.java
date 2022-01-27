public class LegalPerson extends Client {
    public static final double PERCENT_1 = 0.01;

    public void take(double amountToTake) {

        double commission = amountToTake * PERCENT_1;

        if (amountToTake > balance) {
            System.out.println("Недостаточно средств на счете");
        } else {
            balance = balance - amountToTake - commission;
        }
    }

}
