package edu.austral.ingsis.math.visitor.visitor;

import edu.austral.ingsis.math.visitor.Absolute;
import edu.austral.ingsis.math.visitor.Literal;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.functions.*;

public class ResolutionVisitor implements Visitor{

    private double result = 0;

    @Override
    public void visitLiteral(Literal literal) {
        result = literal.getValue();
    }

    @Override
    public void visitVariable(Variable variable) {
        result = variable.getValue();
    }

    @Override
    public void visitAbsolute(Absolute absolute) {
        absolute.getFunction().accepts(this);
        result = Math.abs(result);
    }

    @Override
    public void visitAddition(Addition addition) {
        addition.getLeft().accepts(this);
        double left = result;
        addition.getRight().accepts(this);
        double right = result;
        result = left + right;
    }

    @Override
    public void visitSubtraction(Subtraction subtraction) {
        subtraction.getLeft().accepts(this);
        double left = result;
        subtraction.getRight().accepts(this);
        double right = result;
        result = left - right;
    }

    @Override
    public void visitMultiplication(Multiplication multiplication) {
        multiplication.getLeft().accepts(this);
        double left = result;
        multiplication.getRight().accepts(this);
        double right = result;
        result = left * right;
    }

    @Override
    public void visitDivision(Division division) {
        division.getLeft().accepts(this);
        double left = result;
        division.getRight().accepts(this);
        double right = result;
        result = left / right;
    }

    @Override
    public void visitPower(Power power) {
        power.getLeft().accepts(this);
        double left = result;
        power.getRight().accepts(this);
        double right = result;
        result = Math.pow(left, right);
    }

    public double getResult() {
        return result;
    }
}
