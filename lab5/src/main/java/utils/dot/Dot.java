package utils.dot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Dot {
    private double x;
    private double y;

    @Override
    public String toString() {
        return "(" + x + " ; " + y + ")";
    }
}