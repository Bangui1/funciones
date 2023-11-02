package edu.austral.ingsis.math.visitor.visitor;

import edu.austral.ingsis.math.visitor.Absolute;
import edu.austral.ingsis.math.visitor.Literal;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.functions.*;

public class PrintVisitor implements Visitor{

    private String result;

    @Override
    public void visitLiteral(Literal literal) {
        if (literal.getValue() == (long) literal.getValue()){
            result = Integer.toString((int) literal.getValue());
        } else {
            result = Double.toString(literal.getValue());
        }
    }

    @Override
    public void visitVariable(Variable variable) {
        result = variable.getName();
    }

    @Override
    public void visitAbsolute(Absolute absolute) {
        absolute.getFunction().accepts(this);
        result = "|" + result + "|";
    }

    private void visitMultiFunction(String operator, MultiFunction multiFunction) {
        multiFunction.getLeft().accepts(this);
        String left = result;
        multiFunction.getRight().accepts(this);
        String right = result;
        result = "( " + left + " " + operator + " " + right + " )";
    }

    @Override
    public void visitAddition(Addition addition) {
        visitMultiFunction("+", addition);
    }

    @Override
    public void visitSubtraction(Subtraction subtraction) {
        visitMultiFunction("-", subtraction);
    }

    @Override
    public void visitMultiplication(Multiplication multiplication) {
        visitMultiFunction("*", multiplication);
    }

    @Override
    public void visitDivision(Division division) {
        visitMultiFunction("/", division);
    }

    @Override
    public void visitPower(Power power) {
        visitMultiFunction("^", power);
    }

    public String getResult() {
        return result;
    }
}
