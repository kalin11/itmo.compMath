package seocndLab.SystemOfEquations;


import seocndLab.messages.Message;
import java.util.EnumSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SystemOfEquationManager {
    private final Scanner scanner;

    public SystemOfEquationManager(Scanner scanner){
        this.scanner = scanner;
    }

    private void printSystemExamples(){
        System.out.println("Выберите систему : ");
        int counter = 0;
        for (SystemExamples example : EnumSet.allOf(SystemExamples.class)){
            counter++;
            System.out.println(counter + ". " + example);
        }
    }

    public void chooseSystemAndSolveIt(){
        int choice = 0;
        boolean okay = false;
        printSystemExamples();
        SimpleIterationMethod method = new SimpleIterationMethod();
        double epsilon = 0;
        while (!okay){
            try{
                choice = scanner.nextInt();
                System.out.println("Введите погрешность");
                epsilon = scanner.nextDouble();
                method.setEpsilon(epsilon);
                switch (choice){
                    case 1 -> {
                        method.solveFirstSystem();
                        method.printSolution();
                        okay = true;
                    }
                    case 2 -> {
                        method.solveSecondSystem();
                        method.printSolution();
                        okay = true;
                    }
                    default -> System.err.println(Message.INCORRECT_DATA);
                }

            }catch (InputMismatchException e){
                System.err.println(Message.INCORRECT_TYPE + "\n");
                scanner.next();
            }
        }
    }
}
