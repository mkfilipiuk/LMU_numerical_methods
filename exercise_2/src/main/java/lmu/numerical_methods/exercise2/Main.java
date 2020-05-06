package lmu.numerical_methods.exercise2;

import com.andreamazzon.session5.abstractclasses.usingsimulators.BinomialModelUser;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task 1.1");
        var dailyInterestRate = InterestRate.computeDailyRate(0.027);
        var arithmeticalDailyInterestRate = 0.027 / 365;
        System.out.println("Daily rate:" + dailyInterestRate); // Daily rate:7.299425558504602E-5
        System.out.println("Daily arithmetical average rate:" + arithmeticalDailyInterestRate); // Daily arithmetical average rate:7.397260273972603E-5
        System.out.println();

        System.out.println("Task 1.2");
        var bankAccountAfter18Months = InterestRate.computeBankAccount(2700, 18 * 30, dailyInterestRate);
        System.out.println("Bank account after 18 months: " + bankAccountAfter18Months); // Bank account after 18 months: 2808.5469009438098
        System.out.println("Expected bank account after 18 months: " + 2808.546); // Expected bank account after 18 months: 2808.546
        System.out.println();

        System.out.println("Task 1.3");
        var bankAccountAfter18MonthsRounded = InterestRate.computeBankAccountRounded(2700, 18 * 30, dailyInterestRate);
        System.out.println("Bank account after 18 months with rounding: " + bankAccountAfter18MonthsRounded); // Bank account after 18 months with rounding: 2805.89
        System.out.println("Absolute difference: " + (bankAccountAfter18Months - bankAccountAfter18MonthsRounded)); //  Absolute difference: 2.6569009438098874
        System.out.println("Percentage difference: " + (bankAccountAfter18Months - bankAccountAfter18MonthsRounded) / bankAccountAfter18Months * 100); // Percentage difference: 0.0946005545756433
        System.out.println();


        System.out.println("Task 2");
        var digitalOption = new DigitalOption(new BinomialModelUser(100, 1.5, 0.5, 0, 1897, 10, 100000), 200);
        System.out.println("Price: " + digitalOption.getPrice(10)); // Price: 0.17076
        System.out.println();

        System.out.println("Task 3");
        var monteCarloWithBinomial = new MonteCarloWithBinomial(10);
        for (var e : monteCarloWithBinomial.getHistogram(10)) { // e.g. 0.7000000000000001 4.7 8.6 21.0 24.3 20.599999999999998 14.099999999999998 4.3999999999999995 1.4000000000000001 0.2
            System.out.print(e);
            System.out.print(" ");
        }
        System.out.println();
    }
}
