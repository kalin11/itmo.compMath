package thirdLab.functions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractFunction {
    private final String type;
    private final boolean hasBreakingPoint;
    private final boolean hasToleranceRange;

    public AbstractFunction(String type, boolean hasBreakingPoint, boolean hasToleranceRange){
        this.type = type;
        this.hasBreakingPoint = hasBreakingPoint;
        this.hasToleranceRange = hasToleranceRange;
    }

    public String toString(){
        return this.type;
    }

    public boolean hasBreakingPoint(){
        return hasBreakingPoint;
    }

    public boolean hasToleranceRange(){
        return hasToleranceRange;
    }
}
