package seocndLab.SystemOfEquations;

public enum SystemExamples {
//    FIRST_SYSTEM("x^2 + y^2 = 1\n   x^2 - 2xy - 1 = 0"),
//    SECOND_SYSTEM("x^3 + y^3 - 6x + 3 = 0\n   x^3 - y^3 - 6y + 2 = 0"),
    FIRST_SYSTEM("y = x^3\n   y = x^2 - 6"),
    SECOND_SYSTEM("x^3 + y^3 - 6x + 3 = 0\n   x^3 - y^3 - 6y + 2 = 0");
//    SECOND_SYSTEM("y = 0.1x^3\n   y = x^2 - 0.5");
    private final String example;
    SystemExamples(String example){
        this.example = example;
    }

    public String toString(){
        return this.example;
    }
}
