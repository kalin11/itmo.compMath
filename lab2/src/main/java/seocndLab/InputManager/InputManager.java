package seocndLab.InputManager;

import seocndLab.Equations.EquationManager;
import seocndLab.SystemOfEquations.SystemOfEquationManager;
import java.util.Scanner;

public class InputManager {
    private final Scanner scanner = new Scanner(System.in);

    public boolean isTheSystemOfLinearAlgebraicEquations() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - решить систему линейных уравнений методом простой итерации");
        System.out.println("2 - решить нелинейные уравнения");
        int answer = scanner.nextInt();
        return answer == 1;
    }

    public void delegateToSource() {
        if (!isTheSystemOfLinearAlgebraicEquations()){
            EquationManager manager = new EquationManager(scanner);
            manager.chooseEquationAndSolveIt();
        }
        else {
            SystemOfEquationManager manager = new SystemOfEquationManager(scanner);
            manager.chooseSystemAndSolveIt();
        }
    }
}
