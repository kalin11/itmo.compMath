package manager;

import generator.Generator;
import generator.GraphDotsGenerator;
import graph.GraphBuilder;
import interpolationMethod.LagrangeMethod;
import lombok.Getter;
import lombok.Setter;
import printer.Printer;
import utils.dot.Dot;
import utils.functions.Function;

import java.util.List;

public class Manager {
    @Setter
    private Function function;
    @Getter
    private final boolean addingNoise;
    @Setter
    private Printer printer;
    @Getter
    private Generator graphs;
    @Getter
    private List<Dot> graphList;
    @Getter
    private final Generator random;
    @Getter
    private List<Dot> randomList;

    public Manager(boolean addingNoise, Printer printer, Generator random) {
        this.addingNoise = addingNoise;
        this.printer = printer;
        this.random = random;

    }

    private List<Dot> randomDots() {
        random.setFunction(function);
        random.setPrinter(printer);
        this.randomList = random.generate();
        return this.randomList;
    }

    private List<Dot> graphDots() {
        List<Dot> random = this.randomList;
        Generator graphs = new GraphDotsGenerator(random.get(0).getX(), random.get(random.size() - 1).getX());
        graphs.setFunction(function);
        graphs.setPrinter(printer);
        this.graphs = graphs;
        this.graphList = graphs.generate();
        return this.graphList;
    }

    public void manage(){
        this.randomList = randomDots();
        this.graphList = graphDots();
        LagrangeMethod lagrangeMethod = new LagrangeMethod();
        List<Dot> dots = lagrangeMethod.interpolatedDots(randomList);
        printer.printMessage("Выбран следующий набор изначальных точек:");
        printer.printMessage(randomList.toString());
        GraphBuilder graphBuilder = new GraphBuilder();
        graphBuilder.buildGraph(graphList, dots, randomList);
    }


}
