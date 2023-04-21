package generator;

import lombok.Setter;
import printer.Printer;
import utils.dot.Dot;
import utils.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class OriginalFunctionDotsGenerator implements Generator{
    @Setter
    private Function function;
    @Setter
    private Printer printer;
    @Setter
    private double a;
    @Setter
    private double b;
    @Setter
    private double y_a;
    private final double step;

    public OriginalFunctionDotsGenerator(Function function, double a, double b, double y_a, double step) {
        this.function = function;
        this.a = a;
        this.b = b;
        this.y_a = y_a;
        this.step = step;
    }

    @Override
    public List<Dot> generate() {
        List<Dot> graphDots = new ArrayList<>();
        for (double i = a; i <= b; i += step) {
            function.setConstant(a, y_a);
            graphDots.add(new Dot(i, function.getSolutionValue(i)));
        }
        return graphDots;
    }
}
