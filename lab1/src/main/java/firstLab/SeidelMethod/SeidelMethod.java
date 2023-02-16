package firstLab.SeidelMethod;

import firstLab.matrix.Matrix;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SeidelMethod {
    private Matrix matrix;
    private double epsilon;
    private int counter = 0;
    private double[] zeroApproximation;
    private double[] prevApproximation;
    private double[] currentApproximation;
    private boolean stop = true;

    public boolean convergence() {
        return possible() && diagonallyDominant();
    }

    public SeidelMethod() {
        this.matrix = new Matrix();
    }

    public void swapRows(int a, int b) {
        for (int i = 0; i < matrix.getN(); i++) {
            double temp = matrix.getArray()[a][i];
            matrix.getArray()[a][i] = matrix.getArray()[b][i];
            matrix.getArray()[b][i] = temp;
        }
        double tempB = matrix.getB()[a];
        matrix.getB()[a] = matrix.getB()[b];
        matrix.getB()[b] = tempB;
    }

    public void makeItDiagonallyDominate() {
        Set<Integer> swapped = new HashSet<>();
        int count = 0;
        for (int i = 0; i < matrix.getN(); i++) {
            double max = Double.MIN_VALUE;
            int jIndex = -1;
            for (int j = 0; j < matrix.getN(); j++) {
                if (Math.abs(matrix.getArray()[i][j]) > max) {
                    max = Math.abs(matrix.getArray()[i][j]);
                    jIndex = j;
                }
            }
            if (!swapped.contains(jIndex)) {
                swapRows(i, jIndex);
                swapped.add(jIndex);
            }
            if (i == matrix.getN() - 1) {
                i = 0;
                if (count == matrix.getN() / 2) {
                    break;
                }
                count++;
            }
        }
    }


    private boolean possible() {
        int prevJ = -1;
        int currentJ = -1;
        for (int i = 0; i < matrix.getN(); i++) {
            double maxRow = -Double.MIN_VALUE;
            double maxColumn = -Double.MIN_VALUE;
            int rowCount = 0;
            int columnCount = 0;
            for (int j = 0; j < matrix.getN(); j++) {
                if (matrix.getArray()[i][j] > maxRow) {
                    maxRow = matrix.getArray()[i][j];
                    rowCount = 1;
                    currentJ = j;
                } else if (matrix.getArray()[i][j] == maxRow) {
                    rowCount++;
                }
                if (matrix.getArray()[j][i] > maxColumn) {
                    maxColumn = matrix.getArray()[j][i];
                    columnCount = 1;
                } else if (matrix.getArray()[j][i] == maxColumn) {
                    columnCount++;
                }
            }
            if (columnCount > 1 || rowCount > 1) {
                return false;
            }
            if (currentJ == prevJ && currentJ == matrix.getN()) {
                return false;
            } else {
                prevJ = currentJ;
            }


        }
        return true;
    }

    private boolean diagonallyDominant() {
        for (int i = 0; i < matrix.getN(); i++) {
            double sum = 0;
            for (int j = 0; j < matrix.getN(); j++) {
                if (i != j) {
                    sum += Math.abs(matrix.getArray()[i][j]);
                }
            }
            if (Math.abs(matrix.getArray()[i][i]) < sum) {
                return false;
            }
        }

        return true;
    }

    private boolean shouldStop() {
        int c = 0;
        for (int i = 0; i < matrix.getN(); i++) {
            stop = stop && (Math.abs(currentApproximation[i] - prevApproximation[i])) >= epsilon;
            if ((Math.abs(currentApproximation[i] - prevApproximation[i])) >= epsilon) {
                c += 1;
            }
        }
        if (c == 0) {
            return false;
        }
        return stop;

    }

    private void zeroApproximation() {
        for (int i = 0; i < matrix.getN(); i++) {
            currentApproximation[i] = matrix.getB()[i] / matrix.getArray()[i][i];
            zeroApproximation[i] = matrix.getB()[i] / matrix.getArray()[i][i];
            prevApproximation[i] = matrix.getB()[i] / matrix.getArray()[i][i];
        }
        counter++;
    }

    public void approximation() {
        zeroApproximation();
        while (stop) {
            double multiplier;
            for (int i = 0; i < matrix.getN(); i++) {
                for (int j = 0; j < matrix.getN(); j++) {
                    if (i > j) {
                        multiplier = currentApproximation[j];
                    } else {
                        multiplier = prevApproximation[j];
                    }
                    if (i != j) {
                        currentApproximation[i] += ((-1) * matrix.getArray()[i][j] * multiplier) / matrix.getArray()[i][i];
                    }
                }

            }
            stop = shouldStop();
            double[] deltas = new double[matrix.getN()];
            for (int i = 0; i < deltas.length; i++) {
                deltas[i] = Math.abs(currentApproximation[i] - prevApproximation[i]) / Math.abs(currentApproximation[i]);
            }
            if (!stop) {
                drawNewLine(counter, currentApproximation, deltas);
            }
            if (stop) {
                System.arraycopy(currentApproximation, 0, prevApproximation, 0, matrix.getN());
                System.arraycopy(zeroApproximation, 0, currentApproximation, 0, matrix.getN());
                counter++;
            }
        }
    }

    public void setN(int n) {
        this.matrix.setN(n);
        this.zeroApproximation = new double[n];
        this.prevApproximation = new double[n];
        this.currentApproximation = new double[n];
    }

    private void drawNewLine(int count, double[] array, double[] deltas) {
        System.out.printf("%6s", count);

        for (double v : array) {
            System.out.printf("%20s", new DecimalFormat("#.########").format(v));
        }
        for (double v : deltas) {
            System.out.printf("%20s", new DecimalFormat("#.########").format(v));
        }
        System.out.println();
    }

}
