package utils.functions;

public class LogFunction implements Function {

    @Override
    public double getValue(double x) {
        return Math.log(3 * x + 1);
    }

    @Override
    public String toString() {
        return "lg(3 * x + 1)";
    }

}
