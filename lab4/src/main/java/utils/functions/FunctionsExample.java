package utils.functions;

import java.util.ArrayList;
import java.util.List;

public class FunctionsExample {
    public void printExamples(){
        int counter = 0;
        List<Function> list = new ArrayList<>();
        list.add(new LinearFunction());
        list.add(new LogFunction());
        list.add(new QuadraticFunction());
        list.add(new SinFunction());

        for (Function f : list){
            System.out.println(++counter + ". " + f.toString());
        }
    }
}
