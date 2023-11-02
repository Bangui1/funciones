package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.visitor.Visitor;

public interface Function {

    public void accepts(Visitor visitor);
}
