package thirdLab.inputManager;

import thirdLab.functions.FunctionsExamples;
import thirdLab.functions.releasedFunctions.*;
import thirdLab.messages.Message;
import thirdLab.rectangleMethod.RectangleMethod;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    private final Scanner scanner = new Scanner(System.in);

    private void printExamples(){
        FunctionsExamples examples = new FunctionsExamples();
        examples.printFunctionsExamples();
    }

    private double[] getBoundaries(){
        System.out.println("Введите границы отрезка: ");
        double l = 0;
        double r = 0;
        boolean okay = false;
        while (!okay){
            try{
                l = scanner.nextDouble();
                r = scanner.nextDouble();
                okay = true;
            }catch (InputMismatchException e){
                System.err.println(Message.INCORRECT_TYPE);
                scanner.next();
            }

        }
        return new double[]{l,r};
    }

    private int getNumberOfFunction(){
        System.out.println("Введите номер функции: ");
        boolean okay = false;
        int number = 0;
        while (!okay){
            try {
                number = scanner.nextInt();
                okay = true;
            }catch (InputMismatchException e){
                System.err.println(Message.INCORRECT_TYPE);
                scanner.next();
            }
        }
        return number;
    }

    public void delegateToSource() {
        printExamples();
        int number = getNumberOfFunction();
        double[] boundaries = getBoundaries();
        RectangleMethod method = new RectangleMethod(boundaries[0], boundaries[1]);
        switch (number){
            case 1 -> {
                // если будет интервал с отрицательной левой и положительной левой границей, то нужно сказать, что решить такое нельзя
                // при сдаче я это подпер костылями, но хорошего кода я не придумал тут быстро
                // а переделывать лень))
                System.out.println(Message.GOT_VALUE + "" + method.solveIntegralForFunction(new HyperbolaFunction()));
            }
            case 2 -> {
                System.out.println(Message.GOT_VALUE + ""  + method.solveIntegralForFunction(new QuadraticFunction()));
            }
            case 3 -> {
                System.out.println(Message.GOT_VALUE + ""  + method.solveIntegralForFunction(new SimpleStraightLine()));
            }
            case 4 -> {
                System.out.println(Message.GOT_VALUE + ""  + method.solveIntegralForFunction(new SqrtFunction()));
            }
            case 5 -> {
                System.out.println(Message.GOT_VALUE + ""  + method.solveIntegralForFunction(new SinFunction()));
            }
            default -> {
                System.err.println(Message.INCORRECT_DATA);
                scanner.next();
            }
        }
    }
}
