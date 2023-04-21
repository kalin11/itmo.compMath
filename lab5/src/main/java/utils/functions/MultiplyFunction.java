package utils.functions;

public class MultiplyFunction extends AbstractFunction implements Function {
    @Override
    public double getValue(double x, double y) {
        return (x * y)/2;
    }

    @Override
    public double getSolutionValue(double x) {
        return super.getC() * Math.pow(Math.E, 0.25 * x * x);
    }

    @Override
    public void setConstant(double x_0, double y_0) {
        super.setC((y_0) / (Math.pow(Math.E, 0.25 * x_0 * x_0)));
    }

    @Override
    public String toString() {
        return "(x * y)/2";
    }
}
