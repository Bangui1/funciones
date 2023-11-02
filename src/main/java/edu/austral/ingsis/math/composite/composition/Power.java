package edu.austral.ingsis.math.composite.composition;

import edu.austral.ingsis.math.composite.Function;

public class Power extends CompositeFunction{

    public Power(Function left, Function right) {
        super(left, right);
    }

    @Override
    public double resolution() {
        return Math.pow(getLeft().resolution(), getRight().resolution());
    }

    @Override
    public String operator() {
        return "^";
    }
}
