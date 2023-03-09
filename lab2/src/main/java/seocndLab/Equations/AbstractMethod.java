package seocndLab.Equations;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class AbstractMethod {
    private double[] coefficients;
    private double epsilon;
    private double left;
    private double right;

    public double getValueForQuadraticEquation(double x){
        return coefficients[0] * x * x + coefficients[1] * x + coefficients[2];
    }

    public double getValueForCubicEquation(double x){
        return coefficients[0] * x * x * x + coefficients[1] * x * x + coefficients[2] * x + coefficients[3];
    }

    public double getValueForSinEquation(double x){
        return coefficients[0] * Math.sin(x) + coefficients[1];
    }

}
