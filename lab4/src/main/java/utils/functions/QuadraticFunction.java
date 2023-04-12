package utils.functions;

public class QuadraticFunction implements Function {

    @Override
    public double getValue(double x) {
        return 2 * Math.pow(x, 2) + 1;
    }

    @Override
    public String toString() {
        return "2 * x^2 + 1";
    }
}
