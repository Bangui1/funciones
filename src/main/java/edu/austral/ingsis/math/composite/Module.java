package edu.austral.ingsis.math.composite;

import java.util.List;

public class Module implements Function{

    private final Function containedFunction;

    public Module (Function containedFunction){
        this.containedFunction = containedFunction;
    }

    @Override
    public double resolution() {
        return Math.abs(containedFunction.resolution());
    }

    @Override
    public String print() {
        return "| " + containedFunction.print() + " |";
    }

    @Override
    public List<String> listVariables() {
        return containedFunction.listVariables();
    }
}
