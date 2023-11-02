package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.visitor.Visitor;

public class Literal implements Function{

        private final double value;

        public Literal(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public void accepts(Visitor visitor) {
            visitor.visitLiteral(this);
        }
}
