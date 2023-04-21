package utils.functions;

public class LinearFunction extends AbstractFunction implements Function {

    @Override
    public double getValue(double x, double y) {
        return x + y;
    }

    @Override
    public double getSolutionValue(double x) {
        return super.getC() * Math.pow(Math.E, x) - x - 1;
    }

    @Override
    public void setConstant(double x_0, double y_0) {
        super.setC((y_0 + x_0 + 1) / (Math.pow(Math.E, x_0)));
    }

    @Override
    public String toString(){
        return "x + y";
    }
}
