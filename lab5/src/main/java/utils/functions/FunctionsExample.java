package utils.functions;

import java.util.ArrayList;
import java.util.List;

public class FunctionsExample {
    public void printExamples() {
        int counter = 0;
        List<Function> functions = new ArrayList<>();
        functions.add(new CombinationFunction());
        functions.add(new LinearFunction());
        functions.add(new MultiplyFunction());
        functions.add(new SinFunction());

        for (Function f : functions) {
            System.out.println(++counter + ". " + f.toString());
        }
    }
}
