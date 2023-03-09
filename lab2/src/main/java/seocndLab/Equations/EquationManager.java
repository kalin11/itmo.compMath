package seocndLab.Equations;

import seocndLab.Equations.BisectionMethod.BisectionMethod;
import seocndLab.Equations.TangetMethod.TangetMethod;
import seocndLab.messages.Message;

import java.util.EnumSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EquationManager {
    private final Scanner scanner;

    public EquationManager(Scanner scanner) {
        this.scanner = scanner;
    }

    private void printEquationsExamples(){
        int counter = 0;
        for (EquationExamples examples : EnumSet.allOf(EquationExamples.class)){
            counter++;
            System.out.println(counter + ". " + examples);
        }
    }

    private double[] getBoundaries(){
        System.out.println("Введите границы для нахождения корня");
        double l = 0;
        double r = 0;
        boolean okay = false;
        while (!okay){
            try{
                l = scanner.nextDouble();
                r = scanner.nextDouble();
                okay = true;
            }catch (InputMismatchException e){
                System.err.println(Message.INCORRECT_TYPE + "\n");
                scanner.next();
            }
        }
        return new double[]{l,r};
    }

    private int getCoefficient(){
        int a = 0;
        boolean okay = false;
        while (!okay) {
            try {
                a = scanner.nextInt();
                okay = true;
            } catch (InputMismatchException e) {
                System.err.println(Message.INCORRECT_TYPE + "\n");
                scanner.next();
            }
        }
        return a;
    }

    private double[] getCoefficients(double... coefficients){
        System.out.println("Введите коэффициенты перед переменными. Их должно быть " + coefficients.length + " штуки.");
        double[] arr = new double[coefficients.length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = getCoefficient();
        }
        return arr;
    }

    private double getEpsilon(){
        System.out.println("Введите точность нахождения корня");
        boolean okay = false;
        double x = 0;
        while (!okay){
            try{
                x = scanner.nextDouble();
                okay = true;
            }catch (InputMismatchException e){
                System.err.println(Message.INCORRECT_TYPE + "\n");
                scanner.next();
            }
        }
        return x;
    }

    public void chooseEquationAndSolveIt(){
        BisectionMethod bisectionMethod = new BisectionMethod();
        TangetMethod tangetMethod = new TangetMethod();
        double[] arr = {0,0,0,0};
        double epsilon = 0;
        double[] boundaries = {0,0};
        double bisectionAnswer = 0;
        double tangetAnswer = 0;
        printEquationsExamples();
        boolean okay = false;
        int choice = 0;
        while (!okay){
            try {
                choice = scanner.nextInt();
                switch (choice){
                    case 1 -> {
                        arr = getCoefficients(arr[0], arr[1], arr[2]);
                        epsilon = getEpsilon();
                        boundaries = getBoundaries();
                        setMethods(bisectionMethod, tangetMethod, arr, epsilon, boundaries);
                        tangetAnswer = tangetMethod.solveQuadraticEquation();
                        bisectionAnswer = bisectionMethod.solveQuadraticEquation();
                        System.out.println("Разница между решениями разными способами = " + (Math.abs(bisectionAnswer - tangetAnswer)));
                        okay = true;
                    }
                    case 2 -> {
                        arr = getCoefficients(arr[0], arr[1], arr[2], arr[3]);
                        epsilon = getEpsilon();
                        boundaries = getBoundaries();
                        setMethods(bisectionMethod, tangetMethod, arr, epsilon, boundaries);
                        tangetAnswer = tangetMethod.solveCubicEquation();
                        bisectionAnswer = bisectionMethod.solveCubicEquation();
                        System.out.println("Разница между решениями разными способами = " + (Math.abs(bisectionAnswer - tangetAnswer)));
                        okay = true;
                    }
                    case 3 -> {
                        arr = getCoefficients(arr[0], arr[1]);
                        epsilon = getEpsilon();
                        boundaries = getBoundaries();
                        setMethods(bisectionMethod, tangetMethod, arr, epsilon, boundaries);
                        tangetAnswer = tangetMethod.solveSinEquation();
                        bisectionAnswer = bisectionMethod.solveSinEquation();
                        System.out.println("Разница между решениями разными способами = " + (Math.abs(bisectionAnswer - tangetAnswer)));
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

    private void setMethods(BisectionMethod bisectionMethod, TangetMethod tangetMethod, double[] arr, double epsilon, double[] boundaries){
        bisectionMethod.setCoefficients(arr);
        bisectionMethod.setEpsilon(epsilon);
        bisectionMethod.setLeft(boundaries[0]);
        bisectionMethod.setRight(boundaries[1]);
        tangetMethod.setCoefficients(arr);
        tangetMethod.setEpsilon(epsilon);
        tangetMethod.setLeft(boundaries[0]);
        tangetMethod.setRight(boundaries[1]);
    }

}
