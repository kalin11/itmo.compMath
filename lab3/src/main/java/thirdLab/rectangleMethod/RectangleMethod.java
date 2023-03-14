package thirdLab.rectangleMethod;

import thirdLab.functions.Function;


public class RectangleMethod {
    private final int numberOfPartition = 100;
    private final double l;
    private final double r;
    private final double epsilon = Math.pow(10, -6);

    public RectangleMethod (double l, double r) {
        this.l = l;
        this.r = r;
    }

    public double solveIntegralForFunction(Function f) {
        double h;
        double nextPartition;
        double sumOfValuesOnBoundaries;
        double sum;
        if (!f.hasBreakingPoint() && f.hasToleranceRange()){
            if (l < 0 || r < 0){
                System.err.println("Извините, но выбранный отрезок не подходит под ОДЗ");
                System.exit(1);
            }
        }
        h = (r - l) / numberOfPartition;
        nextPartition = l + h;
        if (l == 0){
            sumOfValuesOnBoundaries = (f.getValue(l + epsilon) + f.getValue(r)) / 2;
        }
        else if (r == 0){
            sumOfValuesOnBoundaries = (f.getValue(l) + f.getValue(r - epsilon)) / 2;
        }
        else {
            sumOfValuesOnBoundaries = (f.getValue(l) + f.getValue(r)) / 2;
        }
        sum = 0;
        if (f.hasBreakingPoint() && f.hasToleranceRange()){
            for (int i = 1; i < numberOfPartition; i++){
                double middleValue = 0;
                if ((nextPartition > -epsilon) && (nextPartition < epsilon)){
                    if (r == 0){
                        middleValue = f.getValue(nextPartition - epsilon);
                    }
                    else if (l == 0){
                        middleValue = f.getValue(nextPartition + epsilon);
                    }
                    else {
                        middleValue = (f.getValue(nextPartition - epsilon) + f.getValue(nextPartition + epsilon)) / 2;
                    }
                    sum += middleValue;
                    nextPartition += h;
                }
                else {
                    sum += f.getValue(nextPartition);
                    nextPartition += h;
                }
            }
        }
        else {
            for (int i = 1; i < numberOfPartition; i++) {
                sum += f.getValue(nextPartition);
                nextPartition += h;
            }
        }

        return h * (sumOfValuesOnBoundaries + sum);
    }
}
