package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.composition.Addition;
import edu.austral.ingsis.math.composite.composition.Division;
import edu.austral.ingsis.math.composite.composition.Multiplication;
import edu.austral.ingsis.math.composite.composition.Power;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final Function one = new Literal(1);
        final Function six = new Literal(6);
        final Function sum = new Addition(one, six);
        final List<String> result = sum.listVariables();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final Function twelve = new Literal(12);
        final Function div = new Variable("div", 3);
        final Function division = new Division(twelve, div);
        final List<String> result = division.listVariables();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final Function nine = new Literal(9);
        final Function x = new Variable("x", 3);
        final Function y = new Variable("y", 2);
        final Function division = new Division(nine, x);
        final Function multiplication = new Multiplication(division, y);
        final List<String> result = multiplication.listVariables();

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final Function twentySeven = new Literal(27);
        final Function a = new Variable("a", 3);
        final Function b = new Variable("b", 2);
        final Function division = new Division(twentySeven, a);
        final Function power = new Power(division, b);
        final List<String> result = power.listVariables();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final Function z = new Variable("z", 4);
        final Function pointFive = new Literal(0.5);
        final Function power = new Power(z, pointFive);
        final List<String> result = power.listVariables();

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final Function value = new Variable("value", 8);
        final Function absolute = new Absolute(value);
        final Function eight = new Literal(8);
        final Function subtraction = new Addition(absolute, eight);
        final List<String> result = subtraction.listVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final Function value = new Variable("value", 8);
        final Function absolute = new Absolute(value);
        final Function eight = new Literal(8);
        final Function subtraction = new Addition(absolute, eight);
        final List<String> result = subtraction.listVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final Function five = new Literal(5);
        final Function i = new Variable("i", 2);
        final Function subtraction = new Addition(five, i);
        final Function eight = new Literal(8);
        final Function multiplication = new Multiplication(subtraction, eight);
        final List<String> result = multiplication.listVariables();

        assertThat(result, containsInAnyOrder("i"));
    }
}
