package inputManager;

import generator.RandomDotsGenerator;
import manager.Manager;
import messages.Message;
import printer.Printer;
import printer.PrinterImpl;
import utils.functions.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    private final Scanner scanner = new Scanner(System.in);
    private Printer printer = new PrinterImpl();

    private void printFunctions(FunctionsExample examples){
        examples.printExamples();
    }

    private int getNumberOfFunction() {
        System.out.println("Введите номер функции: ");
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

    private boolean addNoise(){
        System.out.println("Нужно ли добавить шум?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        int number = 0;
        boolean okay = false;
        while (!okay){
            try{
                number = scanner.nextInt();
                okay = true;
            }catch (InputMismatchException e){
                printer.printError(Message.INCORRECT_TYPE.toString());
                scanner.next();
            }
        }
        return number == 1;
    }

    public void delegateToSource(FunctionsExample example) {
        printFunctions(example);
        int number = getNumberOfFunction();
        boolean addingNoise = addNoise();
        Manager manager = new Manager(addingNoise, printer, new RandomDotsGenerator());
        switch (number){
            case 1:
                manager.setFunction(new LinearFunction());
                manager.manage();
                break;
            case 2:
                manager.setFunction(new LogFunction());
                manager.manage();
                break;
            case 3:
                manager.setFunction(new QuadraticFunction());
                manager.manage();
                break;
            case 4:
                manager.setFunction(new SinFunction());
                manager.manage();
                break;
            default:
                printer.printError(Message.INCORRECT_DATA.toString());
                scanner.next();
                break;
        }
    }
}
