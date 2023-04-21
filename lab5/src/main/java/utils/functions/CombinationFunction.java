package utils.functions;

public class CombinationFunction extends AbstractFunction implements Function {
    @Override
    public double getValue(double x, double y) {
        return y - (2 * x)/y;
    }

    @Override
    public double getSolutionValue(double x) {
        return Math.sqrt(super.getC() * Math.pow(Math.E, 2 * x) + 2 * x + 1);
    }

    @Override
    public void setConstant(double x_0, double y_0) {
        super.setC((y_0 * y_0 - 2 * x_0 - 1) / (Math.pow(Math.E, 2 * x_0)));
    }

    @Override
    public String toString() {
        return "y - (2 * x)/y;";
    }
}
