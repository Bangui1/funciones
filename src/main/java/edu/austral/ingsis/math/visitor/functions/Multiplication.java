package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitor.Visitor;

public class Multiplication extends MultiFunction{

        public Multiplication(Function left, Function right) {
            super(left, right);
        }

        @Override
        String getOperator() {
            return "*";
        }

        @Override
        public void accepts(Visitor visitor) {
            visitor.visitMultiplication(this);
        }
}
