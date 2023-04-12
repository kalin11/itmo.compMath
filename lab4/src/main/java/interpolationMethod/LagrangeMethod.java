package interpolationMethod;

import utils.dot.Dot;

import java.util.ArrayList;
import java.util.List;

public class LagrangeMethod {
    private final double step = 0.01;

    private double interpolateByLagrange(List<Dot> startDots, double x){
        double result = 0.0;
        int n = startDots.size();
        for (int i = 0; i < n; i++){
            double P = 1.0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    P *= (x - startDots.get(j).getX()) / (startDots.get(i).getX() - startDots.get(j).getX());
                }
            }
            result += P * startDots.get(i).getY();
        }

        return result;
    }

    public List<Dot> interpolatedDots(List<Dot> startDots) {
        int n = startDots.size();
        double start = startDots.get(0).getX();
        double end = startDots.get(startDots.size() - 1).getX();
        List<Dot> interpolatedDots = new ArrayList<>();
        for (double i = start; i <= end; i += step){
            interpolatedDots.add(new Dot(i, interpolateByLagrange(startDots, i)));
        }

        return interpolatedDots;
    }

}
