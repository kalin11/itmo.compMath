package thirdLab.functions.releasedFunctions;

import thirdLab.functions.AbstractFunction;
import thirdLab.functions.Function;

public class QuadraticFunction extends AbstractFunction implements Function {


    public QuadraticFunction() {
        super("f(x) = x^2", false, false);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public double getValue(double x){
        return Math.pow(x,2);
    }

    @Override
    public boolean hasBreakingPoint() {
        return super.hasBreakingPoint();
    }

    @Override
    public boolean hasToleranceRange() {
        return super.isHasToleranceRange();
    }



}
