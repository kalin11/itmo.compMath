package utils.functions;

public class SinFunction extends AbstractFunction implements Function {

    @Override
    public double getValue(double x, double y) {
        return Math.sin(x);
    }

    @Override
    public double getSolutionValue(double x) {
        return super.getC() - Math.cos(x);
    }

    @Override
    public void setConstant(double x_0, double y_0) {
        super.setC(y_0 + Math.cos(x_0));
    }

    @Override
    public String toString() {
        return "sin(x)";
    }
}
