package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.composition.Addition;
import edu.austral.ingsis.math.composite.composition.Division;
import edu.austral.ingsis.math.composite.composition.Multiplication;
import edu.austral.ingsis.math.composite.composition.Power;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Function one = new Literal(1);
        final Function six = new Literal(6);
        final Function sum = new Addition(one, six);
        final Double result = sum.resolution();

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Function twelve = new Literal(12);
        final Function two = new Literal(2);
        final Function division = new Division(twelve, two);
        final Double result = division.resolution();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Function nine = new Literal(9);
        final Function two = new Literal(2);
        final Function three = new Literal(3);
        final Function division = new Division(nine, two);
        final Function multiplication = new Multiplication(division, three);
        final Double result = multiplication.resolution();

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Function twentySeven = new Literal(27);
        final Function six = new Literal(6);
        final Function division = new Division(twentySeven, six);
        final Function power = new Power(division, new Literal(2));
        final Double result = power.resolution();

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Function thirtySix = new Literal(36);
        final Function power = new Power(thirtySix, new Division(new Literal(1), new Literal(2)));
        final Double result = power.resolution();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Function oneHundredThirtySix = new Literal(136);
        final Function absolute = new Absolute(oneHundredThirtySix);
        final Double result = absolute.resolution();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Function oneHundredThirtySix = new Literal(-136);
        final Function absolute = new Absolute(oneHundredThirtySix);
        final Double result = absolute.resolution();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Function five = new Literal(5);
        final Function subtraction = new Addition(five, new Literal(-5));
        final Function eight = new Literal(8);
        final Function multiplication = new Multiplication(subtraction, eight);
        final Double result = multiplication.resolution();

        assertThat(result, equalTo(0d));
    }
}
