package edu.austral.ingsis.math.composite;

import java.util.List;

public class Literal implements Function{

    private final double value;

    public Literal(double value){
        this.value = value;
    }


    @Override
    public double resolution() {
        return value;
    }

    @Override
    public String print() {
        if (value == (long) value)
            return Integer.toString((int) value);
        else return Double.toString(value);
    }

    @Override
    public List<String> listVariables() {
        return List.of();
    }
}
