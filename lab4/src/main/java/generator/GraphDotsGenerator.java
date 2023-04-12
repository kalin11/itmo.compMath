package generator;

import lombok.Getter;
import lombok.Setter;
import printer.Printer;
import utils.dot.Dot;
import utils.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class GraphDotsGenerator implements Generator {
    @Setter
    private Function function;
    @Setter
    private Printer printer;
    @Setter
    private double startPoint;
    @Setter
    private double endPoint;
    private final double step = 0.1;

    public GraphDotsGenerator(double startPoint, double endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public List<Dot> generate() {
        List<Dot> graphDots = new ArrayList<>();
        for (double i = startPoint; i <= endPoint; i += step){
            graphDots.add(new Dot(i, function.getValue(i)));
        }
        return graphDots;
    }
}
