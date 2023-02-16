package firstLab.InputManager;

import firstLab.Readers.ConsoleReader;
import firstLab.Readers.FilesReader;
import firstLab.Readers.Reader;
import firstLab.SeidelMethod.SeidelMethod;
import firstLab.messages.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    private final Scanner scanner = new Scanner(System.in);
    private final SeidelMethod method;
    private Reader reader;

    public void identifySource() {
        System.out.println("выбери, как ввести входные данные\n" +
                Source.FILE + "\n" +
                Source.CONSOLE + "\n" +
                Source.RANDOM + "\n");
    }

    public InputManager() {
        method = new SeidelMethod();
    }

    public void delegateToSource() {
        boolean okay = false;
        identifySource();
        while (!okay) {
            int sourceID;
            try {
                sourceID = scanner.nextInt();
                switch (sourceID) {
                    case 1 -> {
                        // file reader
                        handleFilesReader();
                        System.out.println();
                        test(method.getMatrix().getN(), method.getMatrix().getArray());
                        System.out.println();
                        System.out.println();
                        invokeMethod();
                        okay = true;
                    }
                    case 2 -> {
                        handleConsoleReader();
                        System.out.println();
//                        test(n, array);
                        test(method.getMatrix().getN(), method.getMatrix().getArray());
                        System.out.println();
                        System.out.println();
                        invokeMethod();
                        okay = true;
                    }
                    case 3 -> {
                        handleRandom();
                        System.out.println();
//                        test(n, array);
                        test(method.getMatrix().getN(), method.getMatrix().getArray());
                        okay = true;
                        invokeMethod();
                    }
                    default -> System.err.println("Такое я еще не придумал...");
                }
            } catch (InputMismatchException e) {
                System.err.println(Message.INCORRECT_TYPE + "\n");
                identifySource();
                scanner.next();
            }
        }
    }

    public void test(int n, double[][] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
                if (j == n - 1) {
                    System.out.print("  " + method.getMatrix().getB()[i]);
                }
            }
            System.out.println();
        }
    }

    private void randomArray(int n) {
        method.getMatrix().setArray(new double[n][n]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    method.getMatrix().getArray()[i][j] = (Math.random() * 95 + 95);
                } else {
                    method.getMatrix().getArray()[i][j] = (Math.random() * 10 - 5);
                }
            }
        }
    }

    private void randomB(int n) {
        method.getMatrix().setB(new double[n]);
        for (int i = 0; i < n; i++) {
            method.getMatrix().getB()[i] = (Math.random() * 20 - 10);
        }
    }

    private void handleRandom() {
        reader = new ConsoleReader(scanner);
        method.setEpsilon(reader.getEpsilon());
        int random = (int) (Math.random() * 19 + 2);
        method.getMatrix().setN(random);
        method.setN(random);
        System.out.println("Случайный размер матрицы - " + method.getMatrix().getN());
        randomArray(method.getMatrix().getN());
        randomB(method.getMatrix().getN());

    }

    private void handleConsoleReader() {
        reader = new ConsoleReader(scanner);
        method.setN(reader.getMatrixSize());
        method.setEpsilon(reader.getEpsilon());
//        array = reader.getMatrix(n, new double[n][n]);
        method.getMatrix().setArray(reader.getMatrix(method.getMatrix().getN(), new double[method.getMatrix().getN()][method.getMatrix().getN() + 1]));
        method.getMatrix().setB(reader.getB(method.getMatrix().getArray(), method.getMatrix().getN()));
//        B = reader.getB(n);
    }

    private void handleFilesReader() {
        boolean foundFile = false;
        String path = "";
        System.out.println("Введите путь к файлу (полный или относительный)");
        System.out.println("Изначально рассматривается директория проекта. " + new File(".").getAbsolutePath());
        while (!foundFile) {
            path = scanner.next();
            try {
                File file = new File(path);
                if (!file.exists()) {
                    System.out.println("Указанный файл не существует");
                    System.out.println("Введите путь еще раз\n");
                } else if (!file.canRead()) {
                    System.out.println("Файл не доступен для чтения");
                    System.out.println("Введите путь еще раз\n");
                } else if (file.isDirectory()) {
                    System.out.println("Вы указали директорию");
                    System.out.println("Введите путь еще раз\n");
                } else {
                    reader = new ConsoleReader(scanner);
                    method.setEpsilon(reader.getEpsilon());
                    reader = new FilesReader(file);
                    method.setN(reader.getMatrixSize());
//                    array = reader.getMatrix(n, new double[n][n]);
//                    B = reader.getB(n);
                    method.getMatrix().setArray(reader.getMatrix(method.getMatrix().getN(), new double[method.getMatrix().getN()][method.getMatrix().getN() + 1]));
                    method.getMatrix().setB(reader.getB(method.getMatrix().getArray(), method.getMatrix().getN()));
                    foundFile = true;
                }
            } catch (FileNotFoundException e) {
                System.err.println("Не смогли найти файл, попробуйте снова");
            }
        }
    }

    public void invokeMethod() {
        method.makeItDiagonallyDominate();
        if (method.convergence()) {
            System.out.println("Преобразованная к диагональному преобладанию матрица: \n");
            test(method.getMatrix().getN(), method.getMatrix().getArray());
            System.out.println();
            printTableHead();
            System.out.println();
            method.approximation();
        } else {
            System.out.println("Извини, но матрица не имеет диагонального преобладания");
        }
    }

    public void printTableHead() {
        System.out.printf("%6s", "i");
        for (int i = 0; i < method.getMatrix().getN(); i++) {
            System.out.printf("%20s", "X" + (i + 1));
        }
        for (int i = 0; i < method.getMatrix().getN(); i++) {
            System.out.printf("%20s", "delta X" + (i + 1));
        }
    }

}
