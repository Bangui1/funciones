package edu.austral.ingsis.math.visitor.visitor;

import edu.austral.ingsis.math.visitor.Absolute;
import edu.austral.ingsis.math.visitor.Literal;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.functions.*;

public interface Visitor {
    void visitLiteral(Literal literal);
    void visitVariable(Variable variable);
    void visitAbsolute(Absolute absolute);
    void visitAddition(Addition addition);
    void visitSubtraction(Subtraction subtraction);
    void visitMultiplication(Multiplication multiplication);
    void visitDivision(Division division);
    void visitPower(Power power);
}
