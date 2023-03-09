package seocndLab.Equations.TangetMethod;

import seocndLab.Equations.AbstractMethod;
import seocndLab.Equations.Method;

public class TangetMethod extends AbstractMethod implements Method {

    public double solveQuadraticEquation() {
        double zeroApproximation = super.getRight();
        double nextApproximation = zeroApproximation - ((super.getValueForQuadraticEquation(zeroApproximation)) / (getDerivativeForQuadraticEquation(zeroApproximation)));
        while (!(Math.abs(nextApproximation - zeroApproximation) < super.getEpsilon())){
            zeroApproximation = nextApproximation;
            nextApproximation = zeroApproximation - ((super.getValueForQuadraticEquation(zeroApproximation)) / (getDerivativeForQuadraticEquation(zeroApproximation)));
        }
        System.out.println("Нашли корень методом касательных - " + nextApproximation);
        return nextApproximation;
    }

    public double solveCubicEquation() {
        double zeroApproximation = super.getRight();
        double nextApproximation = zeroApproximation - ((super.getValueForCubicEquation(zeroApproximation)) / (getDerivativeForCubicEquation(zeroApproximation)));
        while (!(Math.abs(nextApproximation - zeroApproximation) < super.getEpsilon())){
            zeroApproximation = nextApproximation;
            nextApproximation = zeroApproximation - ((super.getValueForCubicEquation(zeroApproximation)) / (getDerivativeForCubicEquation(zeroApproximation)));
        }
        System.out.println("Нашли корень методом касательных - " + nextApproximation);
        return nextApproximation;
    }

    public double solveSinEquation() {
        double zeroApproximation = super.getRight();
        double nextApproximation = zeroApproximation - ((super.getValueForSinEquation(zeroApproximation)) / (getDerivativeForSinEquation(zeroApproximation)));
        while (!(Math.abs(nextApproximation - zeroApproximation) < super.getEpsilon())){
            zeroApproximation = nextApproximation;
            nextApproximation = zeroApproximation - ((super.getValueForSinEquation(zeroApproximation)) / (getDerivativeForSinEquation(zeroApproximation)));
        }
        System.out.println("Нашли корень методом касательных - " + nextApproximation);
        return nextApproximation;
    }

    public double getDerivativeForQuadraticEquation(double x){
        return 2 * super.getCoefficients()[0] * x + super.getCoefficients()[1];
    }

    public double getDerivativeForCubicEquation(double x){
        return 3 * super.getCoefficients()[0]* Math.pow(x,2) + 2 * super.getCoefficients()[1] * x + super.getCoefficients()[2];
    }

    public double getDerivativeForSinEquation(double x) {
        return super.getCoefficients()[0] * Math.cos(x);
    }

    public void setCoefficients(double[] arr){
        super.setCoefficients(arr);
    }
    public void setEpsilon(double epsilon){
        super.setEpsilon(epsilon);
    }
    public void setLeft(double left){
        super.setLeft(left);
    }
    public void setRight(double right){
        super.setRight(right);
    }
    public double[] getCoefficients(){
        return super.getCoefficients();
    }
    public double getEpsilon(){
        return super.getEpsilon();
    }
    public double getLeft(){
        return super.getLeft();
    }
    public double getRight(){
        return super.getRight();
    }

}
