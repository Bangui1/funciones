package edu.austral.ingsis.math.composite.composition;

import edu.austral.ingsis.math.composite.Function;

public class Addition extends CompositeFunction{

    public Addition(Function left, Function right) {
        super(left, right);
    }

    @Override
    public double resolution() {
        return getLeft().resolution() + getRight().resolution();
    }


    @Override
    public String operator() {
        return "+";
    }

}
