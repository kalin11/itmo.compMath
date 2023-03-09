package seocndLab.SystemOfEquations;


import java.util.Arrays;

public class SimpleIterationMethod extends AbstractSystem{
    private double[] x0;
    private double[] x;
    private double[] F;

    private void doZeroApproximationForTheFirst(){
        this.x[0] = this.x0[0];
        this.x[1] = this.x0[1];
        functionsForTheFirstSystem(this.F, this.x);
        this.x0[0] = this.x[0];
        this.x0[1] = this.x[1];
        this.x[0] = this.F[0];
        this.x[1] = this.F[1];
    }

    private void doZeroApproximationForTheSecond(){
        this.x[0] = this.x0[0];
        this.x[1] = this.x0[1];
        functionsForTheSecondSystem(this.F, this.x);
        this.x0[0] = this.x[0];
        this.x0[1] = this.x[1];
        this.x[0] = this.F[0];
        this.x[1] = this.F[1];
    }

    public void solveFirstSystem(){
        this.x0 = new double[]{-1.6, -3.7};
        this.x = new double[2];
        this.F = new double[2];
        doZeroApproximationForTheFirst();
        while (!(Math.max(Math.abs(x[0] - x0[0]), Math.abs(x[1] - x0[1])) < super.getEpsilon())){
            functionsForTheFirstSystem(F, x);
            x0[0] = x[0];
            x0[1] = x[1];
            x[0] = F[0];
            x[1] = F[1];
        }
    }

    private void functionsForTheFirstSystem(double[] F, double[] x){
        F[0] = Math.cbrt(x[1]);
        F[1] = Math.pow(x[0], 2) - 6;
    }

    public void solveSecondSystem(){
        this.x0 = new double[]{0.5, 0.5};
        this.x = new double[2];
        this.F = new double[2];
        doZeroApproximationForTheSecond();
        while (!(Math.max(Math.abs(x[0] - x0[0]), Math.abs(x[1] - x0[1])) < super.getEpsilon())){
            functionsForTheSecondSystem(F, x);
            x0[0] = x[0];
            x0[1] = x[1];
            x[0] = F[0];
            x[1] = F[1];
        }
    }

    private void functionsForTheSecondSystem(double[] F, double[] x){
        F[0] = (Math.pow(x[0], 3) + Math.pow(x[1], 3)) / 6 + 0.5;
        F[1] = (Math.pow(x[0], 3) - Math.pow(x[1], 3)) / 6 + 1/3D;
    }

    public void printSolution(){
        System.out.println("Корни данной системы - " + Arrays.toString(x));
    }
}
