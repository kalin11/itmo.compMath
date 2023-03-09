package seocndLab.Equations.BisectionMethod;

import seocndLab.Equations.AbstractMethod;
import seocndLab.Equations.Method;

public class BisectionMethod extends AbstractMethod implements Method {

    public double solveQuadraticEquation() {
        double D = Math.pow(super.getCoefficients()[1],2) - 4 * super.getCoefficients()[0] * super.getCoefficients()[2];
        double r = Math.abs(super.getRight() - super.getLeft());
        double middle = 0;
        if (super.getValueForQuadraticEquation(super.getLeft()) * super.getValueForQuadraticEquation(super.getRight()) > 0){
            System.out.println("Извините, но данное уравнение нельзя решить методом деления пополам, так как изначальная функция должна иметь разный знак на концах выбранного отрезка");
        }
        else {
            if (D < 0) {
                System.err.println("У данного уравнения нет корней");
            } else {
                while (!(r < super.getEpsilon())) {
                    middle = (super.getLeft() + super.getRight()) / 2;
                    double k = super.getValueForQuadraticEquation(super.getLeft()) * super.getValueForQuadraticEquation(middle);
                    if (k > 0) {
                        super.setLeft(middle);
                    } else {
                        super.setRight(middle);
                    }
                    r = Math.abs(super.getRight() - super.getLeft());
                }
                System.out.println("Нашли корень методом деления пополам - " + middle);
            }
        }
        return middle;

    }

    public double solveCubicEquation() {
        double r = Math.abs(super.getRight() - super.getLeft());
        double middle = 0;
        while (!(r < super.getEpsilon())) {
            middle = (super.getLeft() + super.getRight()) / 2;
            double k = super.getValueForCubicEquation(super.getLeft()) * super.getValueForCubicEquation(middle);
            if (k > 0) {
                super.setLeft(middle);
            } else {
                super.setRight(middle);
            }
            r = Math.abs(super.getRight() - super.getLeft());
        }
        System.out.println("Нашли корень методом деления пополам  - " + middle);
        return middle;
    }

    public double solveSinEquation() {
        double r = Math.abs(super.getRight() - super.getLeft());
        double middle = 0;
        while (!(r < super.getEpsilon())) {
            middle = (super.getLeft() + super.getRight()) / 2;
            double k = super.getValueForSinEquation(super.getLeft()) * super.getValueForSinEquation(middle);
            if (k > 0) {
                super.setLeft(middle);
            } else {
                super.setRight(middle);
            }
            r = Math.abs(super.getRight() - super.getLeft());
        }
        System.out.println("Нашли корень методом деления пополам  - " + middle);
        return middle;
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
