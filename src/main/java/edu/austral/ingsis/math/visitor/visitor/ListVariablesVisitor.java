package edu.austral.ingsis.math.visitor.visitor;

import edu.austral.ingsis.math.visitor.Absolute;
import edu.austral.ingsis.math.visitor.Literal;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.functions.*;

import java.util.ArrayList;
import java.util.List;

public class ListVariablesVisitor implements Visitor{
    private List<String> variables = new ArrayList<>();

    public List<String> getVariables() {
        return variables;
    }

    public void visitMultiFunction(MultiFunction multiFunction) {
        multiFunction.getLeft().accepts(this);
        multiFunction.getRight().accepts(this);
    }

    @Override
    public void visitLiteral(Literal literal) {
        // Do nothing
    }

    @Override
    public void visitVariable(Variable variable) {
        variables.add(variable.getName());
    }

    @Override
    public void visitAbsolute(Absolute absolute) {
        absolute.getFunction().accepts(this);
    }

    @Override
    public void visitAddition(Addition addition) {
        visitMultiFunction(addition);
    }

    @Override
    public void visitSubtraction(Subtraction subtraction) {
        visitMultiFunction(subtraction);
    }

    @Override
    public void visitMultiplication(Multiplication multiplication) {
        visitMultiFunction(multiplication);
    }

    @Override
    public void visitDivision(Division division) {
        visitMultiFunction(division);
    }

    @Override
    public void visitPower(Power power) {
        visitMultiFunction(power);
    }

}
