package manager;

import eulerMethod.EulerMethod;
import graph.GraphBuilder;
import lombok.Getter;
import lombok.Setter;
import printer.Printer;
import utils.dot.Dot;
import utils.functions.Function;

import java.util.List;

public class Manager {
    @Setter
    private Function function;
    @Setter
    private Printer printer;
    @Getter
    private List<Dot> graphDots;
    @Getter
    private List<Dot> eulerDots;
    private final double a;
    private final double b;
    private final double y_a;
    private final double epsilon;

    public Manager(Printer printer, double a, double b, double y_a, double epsilon) {
        this.printer = printer;
        this.a = a;
        this.b = b;
        this.y_a = y_a;
        this.epsilon = epsilon;
    }

    public void manage() {
        EulerMethod method = new EulerMethod(a, b, y_a, epsilon, function);
        GraphBuilder builder = new GraphBuilder();
        List<Dot> eulerDots = method.eulerDots();
        builder.buildGraph(method.getGraphsDots(), eulerDots, a, y_a);
    }

}
