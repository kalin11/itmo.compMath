package firstLab.Readers;

public interface Reader {
    int getMatrixSize();

    double[][] getMatrix(int size, double[][] array);

    double getEpsilon();


    double[] getB(double[][] array, int size);
}
