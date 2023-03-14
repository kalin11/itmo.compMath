package thirdLab.functions.releasedFunctions;

import thirdLab.functions.AbstractFunction;
import thirdLab.functions.Function;

public class SimpleStraightLine extends AbstractFunction implements Function {

    public SimpleStraightLine(){
        super("f(x) = x", false, false);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double getValue(double x) {
        return x;
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
