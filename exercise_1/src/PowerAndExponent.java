public class PowerAndExponent {
    private int exponent;
    private double power;

    public PowerAndExponent(int exponent, double power) {
        this.exponent = exponent;
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        return "PowerAndExponent{" +
                "exponent=" + exponent +
                ", power=" + power +
                '}';
    }
}
