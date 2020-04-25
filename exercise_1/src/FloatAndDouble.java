public class FloatAndDouble {

    public PowerAndExponent computeBiggestEpsilon(double x, double x0) {
        double difference = Math.abs(x - x0);
        int exponent = Math.getExponent(difference);
        return new PowerAndExponent(exponent, Math.pow(2, exponent));
    }
}
