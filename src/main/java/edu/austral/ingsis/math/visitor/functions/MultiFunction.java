package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.Function;

public abstract class MultiFunction implements Function {

    private final Function left;
    private final Function right;

    public MultiFunction(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    public Function getLeft() {
        return left;
    }

    public Function getRight() {
        return right;
    }

    abstract String getOperator();
}
