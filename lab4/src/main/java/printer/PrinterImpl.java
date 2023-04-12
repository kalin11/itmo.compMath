package printer;

public class PrinterImpl implements Printer{
    @Override
    public void printMessage(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printError(String msg) {
        System.err.println(msg);
    }
}
