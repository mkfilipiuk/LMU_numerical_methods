package lmu.numerical_methods.exercise2;

import com.andreamazzon.session5.abstractclasses.usingsimulators.StochasticProcessUser;

import java.util.Arrays;

public class DigitalOption {

    private StochasticProcessUser stochasticProcessUser;
    private double threshold;

    public DigitalOption(StochasticProcessUser stochasticProcessUser, double threshold) {
        this.stochasticProcessUser = stochasticProcessUser;
        this.threshold = threshold;
    }

    public double[] getPayoff(int timeIndex) {
        return stochasticProcessUser.getRealizationsAtGivenTime(timeIndex);
    }

    public double getPrice(int timeIndex) {
        return Arrays.stream(stochasticProcessUser.getRealizationsAtGivenTime(timeIndex)).map(x -> x > threshold ? 1 : 0).average().getAsDouble();
    }
}
