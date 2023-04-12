package utils.functions;

public class LinearFunction implements Function {

    @Override
    public double getValue(double x) {
        return 2 * x + 5;
    }

    @Override
    public String toString() {
        return "2 * x + 5";
    }
}
