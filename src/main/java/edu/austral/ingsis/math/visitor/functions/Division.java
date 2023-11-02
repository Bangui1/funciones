package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitor.Visitor;

public class Division extends MultiFunction{

        public Division(Function left, Function right) {
            super(left, right);
        }

        @Override
        String getOperator() {
            return "/";
        }

        @Override
        public void accepts(Visitor visitor) {
            visitor.visitDivision(this);
        }
}
