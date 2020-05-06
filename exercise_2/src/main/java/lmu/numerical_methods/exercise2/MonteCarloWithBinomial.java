package lmu.numerical_methods.exercise2;

import com.andreamazzon.session5.abstractclasses.usingsimulators.BinomialModelUser;

import java.util.Arrays;
import java.util.Random;

import static com.andreamazzon.session4.usefulmatrices.UsefulMethodsMatricesVectors.getMax;
import static com.andreamazzon.session4.usefulmatrices.UsefulMethodsMatricesVectors.getMin;

public class MonteCarloWithBinomial {

    private int numberOfBins;
    public MonteCarloWithBinomial(int numberOfBins) {
        this.numberOfBins = numberOfBins;
    }

    public double[] getHistogram(int timeIndex) {
        var r = new Random();
        var numberOfIterations = 1000;
        var realizations = new double[numberOfIterations];
        for(int i = 0; i < numberOfIterations; ++i) {
            var digitalOption = new DigitalOption(new BinomialModelUser(100, 1.5, 0.5, 0, r.nextInt(), 10, 100000), 200);
            realizations[i] = digitalOption.getPrice(timeIndex);
        }
        return Arrays.stream(buildHistogram(realizations, getMin(realizations), getMax(realizations), numberOfBins)).map(x -> x/numberOfIterations*100).toArray();
    }

    private double[] buildHistogram(double[] realizations, double
        minBin, double maxBin, int binsNumber) {
        var histogram = new double[binsNumber];
        Arrays.stream(realizations).
            map(x -> x - minBin).
            map(x -> x/(maxBin-minBin)).
            map(x -> x*binsNumber).
            mapToInt(x -> (int)x).
            map(x -> x == binsNumber ? x-1 : x).
            forEach(x -> histogram[x]++);
        return histogram;
    }

}
