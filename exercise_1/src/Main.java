public class Main {

    private static void exercise1() {
        double x = 3 * 0.1;
        float x0_float = (float) 0.3;
        System.out.println("Are x and x0 equal: " + (x == x0_float)); //prints "Are x and x0 equal: false"
        System.out.println(new FloatAndDouble().computeBiggestEpsilon(x, x0_float)); //prints "PowerAndExponent{exponent=-27, power=7.450580596923828E-9}"

        double x0_double = 0.3;
        System.out.println("Are x and x0 equal: " + (x == x0_double)); //prints "Are x and x0 equal: false"
        System.out.println(new FloatAndDouble().computeBiggestEpsilon(x, x0_double)); //prints "PowerAndExponent{exponent=-54, power=5.551115123125783E-17}"
    }

    private static double cosineByTaylor(double x) {
        double sum = 0;
        double factorial = 1;
        for (int i = 0; i < 150; ++i) {
            sum += Math.pow(-1, i) * Math.pow(x, 2 * i) / factorial; // We have to watch out not to divide inf by inf, because we would get NaN. That's why number of iteration cannot be too big
            factorial *= (2 * i + 1);
            factorial *= (2 * i + 2);
        }
        return sum;
    }

    private static void exercise2() {
        System.out.println("Our implementation, x = 1: " + cosineByTaylor(1)); //prints Our implementation, x = 1: 0.5403023058681397
        System.out.println("Library implementation, x = 1: " + Math.cos(1)); //prints Library implementation, x = 1: 0.5403023058681398
        System.out.println("Our implementation, x = 7: " + cosineByTaylor(7)); //prints Our implementation, x = 7: 0.7539022543432953
        System.out.println("Library implementation, x = 7: " + Math.cos(7)); //prints Library implementation, x = 7: 0.7539022543433046

        /*
            Explanation: The series converges slower for x = 7, what leads to higher error of the result
            To solve this issue we could change Maclaurin series to Taylor series in 2*\Pi
        */
    }

    private static float floatHarmonicSumForward(int N) {
        float sum = 0;
        int i = 1;
        while (1.0 / i > 0 && i < N) {
            sum += (1.0 / i);
            ++i;
        }
        return sum;
    }

    private static double doubleHarmonicSumForward(int N) {
        double sum = 0;
        int i = 1;
        while (1.0 / i > 0 && i < N) {
            sum += (1.0 / i);
            ++i;
        }
        return sum;
    }

    private static float floatHarmonicSumBackward(int N) {
        float sum = 0;
        int i = N;
        while (1.0 / i > 0 && i > 0) {
            sum += (1.0 / i);
            --i;
        }
        return sum;
    }

    private static double doubleHarmonicSumBackward(int N) {
        float sum = 0;
        int i = N;
        while (1.0 / i > 0 && i > 0) {
            sum += (1.0 / i);
            --i;
        }
        return sum;
    }


    private static void exercise3() {
        System.out.println("Float, forward: " + floatHarmonicSumForward(100000));
        System.out.println("Double, forward: " + doubleHarmonicSumForward(100000));
        System.out.println("Float, backward: " + floatHarmonicSumBackward(100000));
        System.out.println("Double, backward: " + doubleHarmonicSumBackward(100000));

        /*
            Explanation: in forward case, we are loosing a lot of precision as we add a big sum with smaller and smaller elements of the series.
         */
    }

    public static void main(String[] args) {
        System.out.println("Exercise 1");
        System.out.println();
        exercise1();
        System.out.println();
        System.out.println("Exercise 2");
        System.out.println();
        exercise2();
        System.out.println();
        System.out.println("Exercise 3");
        System.out.println();
        exercise3();
    }
}
