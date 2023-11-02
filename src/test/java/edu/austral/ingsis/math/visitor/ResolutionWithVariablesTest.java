package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.visitor.ResolutionVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function one = new Literal(1);
        final Function x = new Variable("x", 3);
        final Function function = new Addition(one, x);
        function.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function twelve = new Literal(12);
        final Function div = new Variable("div", 4);
        final Function function = new Division(twelve, div);
        function.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function nine = new Literal(9);
        final Function x = new Variable("x", 3);
        final Function y = new Variable("y", 4);
        final Function division = new Division(nine, x);
        final Function multiplication = new Multiplication(division, y);
        multiplication.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function twentySeven = new Literal(27);
        final Function a = new Variable("a", 9);
        final Function b = new Variable("b", 3);
        final Function division = new Division(twentySeven, a);
        final Function power = new Power(division, b);
        power.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function z = new Variable("z", 36);
        final Function half = new Literal(0.5);
        final Function power = new Power(z, half);
        power.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function value = new Variable("value", 8);
        final Function absolute = new Absolute(value);
        final Function subtraction = new Subtraction(absolute, new Literal(8));
        subtraction.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function value = new Variable("value", 8);
        final Function absolute = new Absolute(value);
        final Function subtraction = new Subtraction(absolute, new Literal(8));
        subtraction.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function five = new Literal(5);
        final Function i = new Variable("i", 2);
        final Function eight = new Literal(8);
        final Function subtraction = new Subtraction(five, i);
        final Function multiplication = new Multiplication(subtraction, eight);
        multiplication.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(24d));
    }
}
