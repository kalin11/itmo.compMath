package thirdLab.functions.releasedFunctions;

import thirdLab.functions.AbstractFunction;
import thirdLab.functions.Function;

public class SqrtFunction extends AbstractFunction implements Function {

    public SqrtFunction() {
        super("f(x) = √x", false, true);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public double getValue(double x){
        return Math.sqrt(x);
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
