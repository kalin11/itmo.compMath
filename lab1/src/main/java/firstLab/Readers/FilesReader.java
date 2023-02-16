package firstLab.Readers;

import firstLab.messages.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class FilesReader extends AbstractReader implements Reader {

    public FilesReader(File file) throws FileNotFoundException {
        super(file);
    }

    @Override
    public int getMatrixSize() {
        System.out.println("Считываем размер матрицы");
        int n = -1;
        try {
            n = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Не удалось считать размер матрицы. Проверьте корректность данных");
        }
        return n;
    }

//    @Override
//    public double[][] getMatrix(int n, double[][] array) {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                try {
//                    array[i][j] = scanner.nextDouble();
//                } catch (InputMismatchException e) {
//                    System.err.println(Message.INCORRECT_TYPE);
//                    scanner.next();
//                }
//            }
//
//        }
//
//        return array;
//    }

    @Override
    public double[][] getMatrix(int n, double[][] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                try {
                    array[i][j] = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.err.println(Message.INCORRECT_TYPE);
                    scanner.next();
                }
            }

        }

        return array;
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

//    @Override
//    public double[] getB(int size) {
//        double[] B = new double[size];
//        for (int i = 0; i < size; i++) {
//            try {
//                B[i] = scanner.nextDouble();
//            } catch (InputMismatchException e) {
//                System.err.println(Message.INCORRECT_TYPE);
//                scanner.next();
//            }
//        }
//        return B;
//    }

}
