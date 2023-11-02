package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.visitor.Visitor;

public class Absolute implements Function{

    private final Function function;

    public Absolute(Function function) {
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }

    @Override
    public void accepts(Visitor visitor) {
        visitor.visitAbsolute(this);
    }
}
