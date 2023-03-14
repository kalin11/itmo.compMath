package thirdLab.functions;

import thirdLab.functions.releasedFunctions.*;

import java.util.ArrayList;
import java.util.List;

public class FunctionsExamples {
    public void printFunctionsExamples(){
        int counter = 0;
        List<AbstractFunction> list = new ArrayList<>();
           list.add(new HyperbolaFunction());
           list.add(new QuadraticFunction());
           list.add(new SimpleStraightLine());
           list.add(new SqrtFunction());
           list.add(new SinFunction());

        for (AbstractFunction function : list){
            System.out.println(++counter + ". " + function.toString());
        }
    }
}
