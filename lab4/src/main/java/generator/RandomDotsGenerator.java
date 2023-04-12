package generator;

import lombok.Setter;
import printer.Printer;
import utils.dot.Dot;
import utils.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class RandomDotsGenerator implements Generator {
    @Setter
    private Function function;
    @Setter
    private Printer printer;
    @Setter
    private boolean addingNoise;

    public List<Dot> generate(){
        List<Dot> firstSet = new ArrayList<>();
        List<Dot> secondSet = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            firstSet.add(new Dot(i, function.getValue(i)));
        }
        for (int i = 2; i < 8; i++){
            secondSet.add(new Dot(i, function.getValue(i)));
        }

        if (addingNoise){
            for (Dot dot : firstSet){
                dot.setY(dot.getY() + Math.random() / 100);
            }
            for (Dot dot : secondSet){
                dot.setY(dot.getY() + Math.random() / 100);
            }
        }
        int setNum = (int) (Math.random() * 10) + 1;
        return (setNum % 2 == 0) ? firstSet : secondSet;
    }

}
