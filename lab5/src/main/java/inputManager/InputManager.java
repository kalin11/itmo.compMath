package inputManager;

import manager.Manager;
import messages.Message;
import printer.Printer;
import printer.PrinterImpl;
import utils.functions.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    private final Scanner scanner = new Scanner(System.in);
    private final Printer printer = new PrinterImpl();

    private void printFunctions(FunctionsExample examples){
        examples.printExamples();
    }

    private int getNumberOfFunction() {
        printer.printMessage("Введите номер функции: ");
        boolean okay = false;
        int number = 0;
        while (!okay){
            try {
                number = scanner.nextInt();
                okay = true;
            }catch (InputMismatchException e){
                printer.printError(Message.INCORRECT_TYPE.toString());
                scanner.next();
            }
        }
        return number;
    }

    private double getEpsilon() {
        printer.printMessage("Введите погрешность: ");
        double eps = 0;
        boolean okay = false;
        while (!okay) {
            try {
                eps = scanner.nextDouble();
                okay = true;
            } catch (InputMismatchException e) {
                printer.printError(Message.INCORRECT_TYPE.toString());
                scanner.next();
            }
        }
        return eps;
    }

    private double[] initialCondition() {
        printer.printMessage("Введите начальные условия: ");
        double a = 0;
        double y_a = 0;
        double b = 0;
        boolean okay = false;
        while (!okay) {
            try {
                printer.printMessage("Введите левую границу отрезка");
                a = scanner.nextDouble();
                printer.printMessage("Введите значение функции на левой границе отрезка");
                y_a = scanner.nextDouble();
                printer.printMessage("Введите правую границу отрезка");
                b = scanner.nextDouble();
                okay = true;
            }
            catch (InputMismatchException e) {
                printer.printError(Message.INCORRECT_TYPE.toString());
                scanner.next();
            }
        }

        return new double[] {a, y_a, b};
    }

    public void delegateToSource(FunctionsExample example) {
        printFunctions(example);
        int num = getNumberOfFunction();
        double epsilon = getEpsilon();
        double[] conditions = initialCondition();
        double a = conditions[0];
        double y_a = conditions[1];
        double b = conditions[2];

        Manager manager = new Manager(printer, a, b, y_a, epsilon);

        switch (num) {
            case 1 -> {
                manager.setFunction(new CombinationFunction());
                manager.manage();
            }
            case 2 -> {
                manager.setFunction(new LinearFunction());
                manager.manage();
            }
            case 3 -> {
                manager.setFunction(new MultiplyFunction());
                manager.manage();
            }
            case 4 -> {
                manager.setFunction(new SinFunction());
                manager.manage();
            }
            default -> {
                printer.printError(Message.INCORRECT_DATA.toString());
                scanner.next();
            }
        }

    }

}
