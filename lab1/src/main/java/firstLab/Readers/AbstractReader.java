package firstLab.Readers;

import firstLab.messages.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class AbstractReader implements Reader {
    protected Scanner scanner;

    protected AbstractReader(Scanner scanner) {
        this.scanner = scanner;
    }

    protected AbstractReader(File file) throws FileNotFoundException {
        this.scanner = new Scanner(file);
    }

    @Override
    public int getMatrixSize() {
        return 0;
    }

    @Override
    public double[][] getMatrix(int size, double[][] array) {
        return new double[0][];
    }

    @Override
    public double getEpsilon() {
        System.out.println("Введите погрешность");
        double epsilon = -1;
        boolean okay = false;
        while (!okay) {
            try {
                epsilon = scanner.nextDouble();
                if (epsilon <= 0) {
                    System.err.println("Погрешность должна быть больше нуля");
                } else okay = true;
            } catch (InputMismatchException e) {
                scanner.next();
                System.err.println(Message.INCORRECT_TYPE);
            }
        }

        System.out.println("Установлена погрешность - " + epsilon);

        return epsilon;
    }

    @Override
    public double[] getB(double[][] array, int size) {
        return new double[0];
    }
}
