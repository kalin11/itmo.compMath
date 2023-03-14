package thirdLab.functions.releasedFunctions;

import thirdLab.functions.AbstractFunction;
import thirdLab.functions.Function;

public class SinFunction extends AbstractFunction implements Function {
    public SinFunction() {
        super("f(x) = sin(x) / x", true, true);
    }

    @Override
    public double getValue(double x) {
        return Math.sin(x)/x;
    }

    @Override
    public String toString() {
        return super.toString();
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
