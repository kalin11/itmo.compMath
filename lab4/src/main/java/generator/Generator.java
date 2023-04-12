package generator;

import printer.Printer;
import utils.dot.Dot;
import utils.functions.Function;

import java.util.List;

public interface Generator {
    List<Dot> generate();
    void setFunction(Function function);
    void setPrinter(Printer printer);
}
