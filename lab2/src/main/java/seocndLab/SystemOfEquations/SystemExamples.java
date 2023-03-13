package seocndLab.SystemOfEquations;

public enum SystemExamples {
    FIRST_SYSTEM("y = x^3\n   y = x^2 - 6"),
    SECOND_SYSTEM("x^3 + y^3 - 6x + 3 = 0\n   x^3 - y^3 - 6y + 2 = 0");
    private final String example;
    SystemExamples(String example){
        this.example = example;
    }

    public String toString(){
        return this.example;
    }
}
