package utils.functions;

public class SinFunction implements Function {

    @Override
    public double getValue(double x) {
        return Math.sin(x - 2);
    }

    @Override
    public String toString(){
        return "sin(x - 2)";
    }
}
