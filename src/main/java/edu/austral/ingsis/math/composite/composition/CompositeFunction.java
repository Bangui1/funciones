package edu.austral.ingsis.math.composite.composition;

import edu.austral.ingsis.math.composite.Function;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeFunction implements Function {

    private final Function left;
    private final Function right;


    public CompositeFunction(Function left, Function right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String print() {
        return "( " + left.print() + " " + operator() + " " + right.print() + " )";
    }

    @Override
    public List<String> listVariables() {
        List<String> leftVariables = left.listVariables();
        List<String> rightVariables = right.listVariables();
        List<String> variables = new ArrayList<>(leftVariables);
        variables.addAll(rightVariables);
        return variables;
    }

    public Function getLeft() {
        return left;
    }

    public Function getRight() {
        return right;
    }

    abstract String operator();

}
