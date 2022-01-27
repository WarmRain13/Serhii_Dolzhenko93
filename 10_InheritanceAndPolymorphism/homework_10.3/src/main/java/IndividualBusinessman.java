public class IndividualBusinessman extends Client {
    public static final double PERCENT_1 = 0.01;
    public static final double PERCENT_2 = 0.005;


    public void put(double amountToPut) {

        double commission1 = amountToPut * PERCENT_1;
        double commission2 = amountToPut * PERCENT_2;

        if (amountToPut <= 0) {
            System.out.println("Невозможная операция");
        } else if (amountToPut >= 1000){
            balance = balance + amountToPut - commission2;

        }else if (amountToPut < 1000){
            balance = balance + amountToPut - commission1;
        }
    }

}
