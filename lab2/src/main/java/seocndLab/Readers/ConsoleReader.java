package seocndLab.Readers;

import seocndLab.messages.Message;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader extends AbstractReader implements Reader {

    public ConsoleReader(Scanner scanner) {
        super(scanner);
    }

    @Override
    public int getMatrixSize() {
        System.out.println("Введите размер матрицы (количество строк). Минимальный - 2, максимальный - 20");
        boolean okay = false;
        int n = 2;
        while (!okay) {
            try {
                n = scanner.nextInt();
                if (n < 2) {
                    System.err.println("минимальный размер матрицы - 2");
                } else if (n > 20) {
                    System.err.println("максимальный размер матрицы - 20");
                } else okay = true;
            } catch (InputMismatchException e) {
                System.err.println(Message.INCORRECT_TYPE);
                scanner.next();
            }
        }
        return n;
    }

    @Override
    public double getEpsilon() {
        return super.getEpsilon();
    }

    @Override
    public double[] getB(double[][] array, int size) {
        double[] B = new double[size];
        for (int i = 0; i < size; i++) {
            B[i] = array[i][size];
        }
        return B;
    }

    @Override
    public double[][] getMatrix(int n, double[][] array) {
        System.out.println();
        System.out.println("Введите матрицу размера " + n + "x" + (n + 1));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                boolean okay = false;
                while (!okay) {
                    try {
                        array[i][j] = scanner.nextDouble();
                        okay = true;
                    } catch (InputMismatchException e) {
                        System.err.println(Message.INCORRECT_TYPE);
                        scanner.next();
                    }
                }
            }
        }

        return array;
    }


}
