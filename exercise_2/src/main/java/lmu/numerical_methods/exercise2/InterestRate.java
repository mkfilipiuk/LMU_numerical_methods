package lmu.numerical_methods.exercise2;

public class InterestRate {

    public static double computeDailyRate(double annualRate) {
        return Math.pow(1 + annualRate, 1 / 365.0) - 1;
    }

    public static double computeBankAccount(double initialMoneyAmount, int numberOfDays, double dailyRate) {
        return initialMoneyAmount * Math.pow(1 + dailyRate, numberOfDays);
    }

    private static double roundDownToTwoDecimalPlaces(double number) {
        return ((int) (number * 100)) / 100.0;
    }

    public static double computeBankAccountRounded(double initialMoneyAmount, int numberOfDays, double dailyRate) {
        double result = initialMoneyAmount;
        for(int i = 0; i < numberOfDays; i++){
            result = roundDownToTwoDecimalPlaces(computeBankAccount(
                result,
                1,
                dailyRate
            ));
        }
        return result;
    }
}
