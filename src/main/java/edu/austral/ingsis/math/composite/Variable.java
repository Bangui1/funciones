package edu.austral.ingsis.math.composite;

import java.util.Collections;
import java.util.List;

public class Variable implements Function{

    private final String name;
    private final long value;

    public Variable(String name, long value){
        this.name = name;
        this.value = value;
    }

    @Override
    public double resolution() {
        return value;
    }

    @Override
    public String print() {
        return name;
    }

    @Override
    public List<String> listVariables() {
        return Collections.singletonList(name);
    }
}
