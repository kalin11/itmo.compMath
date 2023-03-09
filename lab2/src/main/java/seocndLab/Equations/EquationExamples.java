package seocndLab.Equations;

public enum EquationExamples {
    SIMPLE_QUADRATIC_EQUATION ("ax^2 + bx + c = 0"),
    SIMPLE_CUBIC_EQUATION ("ax^3 + bx^2 + cx + d = 0"),
    SIMPLE_SIN_EQUATION ("a*sin(x) + c = 0");

    private final String example;

    EquationExamples(String example){
        this.example = example;
    }

    @Override
    public String toString(){
        return this.example;
    }
}
