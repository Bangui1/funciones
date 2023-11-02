package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.visitor.Visitor;

public class Variable implements Function{

    private final String name;
    private final long value;

    public Variable(String name, long value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public long getValue() {
        return value;
    }

    @Override
    public void accepts(Visitor visitor) {
        visitor.visitVariable(this);
    }
}
