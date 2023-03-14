package thirdLab.functions.releasedFunctions;

import thirdLab.functions.AbstractFunction;
import thirdLab.functions.Function;

public class HyperbolaFunction extends AbstractFunction implements Function {
    public HyperbolaFunction() {
        super("f(x) = 1/x", true, true);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public double getValue(double x){
        return 1/x;
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
