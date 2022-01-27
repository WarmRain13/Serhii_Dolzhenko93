import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;
    protected LocalDate depositIncome;


    @Override
    public void put(double amountToPut) {
        //TODO: реализуйте метод и удалите todo
        if (amountToPut <= 0){
            System.out.println("Невозможная операция");

        }else {
            balance = balance + amountToPut;
            System.out.println("Счет пополнен на " + amountToPut);
            lastIncome = LocalDate.now();
            System.out.println("Дата пополнения " + lastIncome);
        }

    }
    @Override
    public void take(double amountToTake) {
        depositIncome = LocalDate.now();
        //TODO: реализуйте метод и удалите todo
        if (amountToTake > balance){
            System.out.println("Недостаточно средств на счете");
        }else if (depositIncome.isAfter(lastIncome.plusMonths(1))){
            balance = balance -  amountToTake;
        }

    }
}

