package eulerMethod;

import generator.OriginalFunctionDotsGenerator;
import lombok.Getter;
import utils.dot.Dot;
import utils.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class EulerMethod {
    private final double a;
    private final double b;
    private final double y_a;
    private final double epsilon;
    private final Function function;
    @Getter
    private List<Dot> graphsDots;
    private double h;

    public EulerMethod(double a, double b, double y_a, double epsilon, Function function) {
        this.a = a;
        this.b = b;
        this.y_a = y_a;
        this.epsilon = epsilon;
        this.function = function;
    }

    private List<Dot> getGraphsDots(Function function, double a, double b, double y_a, double h) {
        OriginalFunctionDotsGenerator generator = new OriginalFunctionDotsGenerator(function, a, b, y_a, h);
        graphsDots = generator.generate();
        return graphsDots;
    }

    private double[] getFunctionValue() {
        h = (b - a) / 5;
        List<Dot> graphDots;
        double[] y_i;
        double[] x_i;
        do {
            h /= 2;
            graphDots = getGraphsDots(function, a, b, y_a, h);
            y_i = new double[graphDots.size()];
            x_i = new double[graphDots.size()];
            y_i[0] = y_a;
            x_i[0] = a;
            for (int i = 1; i < graphDots.size(); i++) {
                x_i[i] = x_i[i - 1] + h;
                y_i[i] = y_i[i - 1] + h * function.getValue(x_i[i - 1], y_i[i - 1]);
            }
        } while (Math.abs(graphDots.get(graphDots.size() - 1).getY() - y_i[graphDots.size() - 1]) >= epsilon);

        return y_i;
    }

    public List<Dot> eulerDots() {
        List<Dot> eulerDots = new ArrayList<>();
        double[] y_i = getFunctionValue();
        int k = 0;
        for (double i = a; i <= b; i += h) {
            eulerDots.add(new Dot(i, y_i[k++]));
        }

        return eulerDots;
    }

}
