package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.visitor.ResolutionVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function one = new Literal(1);
        final Function six = new Literal(6);
        final Function function = new Addition(one, six);
        function.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function twelve = new Literal(12);
        final Function two = new Literal(2);
        final Function function = new Division(twelve, two);
        function.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function nine = new Literal(9);
        final Function two = new Literal(2);
        final Function three = new Literal(3);
        final Function division = new Division(nine, two);
        final Function multiplication = new Multiplication(division, three);
        multiplication.accepts(visitor);
        final Double result = visitor.getResult();


        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function twentySeven = new Literal(27);
        final Function six = new Literal(6);
        final Function two = new Literal(2);
        final Function division = new Division(twentySeven, six);
        final Function power = new Power(division, two);
        power.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function thirtySix = new Literal(36);
        final Function pointFive = new Literal(0.5);
        final Function power = new Power(thirtySix, pointFive);
        power.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function oneHundredThirtySix = new Literal(136);
        final Function absolute = new Absolute(oneHundredThirtySix);
        absolute.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function oneHundredThirtySix = new Literal(-136);
        final Function absolute = new Absolute(oneHundredThirtySix);
        absolute.accepts(visitor);
        final Double result = visitor.getResult();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final ResolutionVisitor visitor = new ResolutionVisitor();
        final Function five = new Literal(5);
        final Function eight = new Literal(8);
        final Function subtraction = new Subtraction(five, five);
        final Function multiplication = new Multiplication(subtraction, eight);
        multiplication.accepts(visitor);
        final Double result = visitor.getResult();


        assertThat(result, equalTo(0d));
    }
}
