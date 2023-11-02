package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.visitor.ListVariablesVisitor;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final ListVariablesVisitor visitor = new ListVariablesVisitor();
        final Function function = new Addition(new Literal(1), new Literal(6));
        function.accepts(visitor);
        final List<String> result = visitor.getVariables();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final ListVariablesVisitor visitor = new ListVariablesVisitor();
        final Function function = new Division(new Literal(12), new Variable("div", 4));
        function.accepts(visitor);
        final List<String> result = visitor.getVariables();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final ListVariablesVisitor visitor = new ListVariablesVisitor();
        final Function nine = new Literal(9);
        final Function x = new Variable("x", 3);
        final Function y = new Variable("y", 4);
        final Function division = new Division(nine, x);
        final Function multiplication = new Addition(division, y);
        multiplication.accepts(visitor);
        final List<String> result = visitor.getVariables();


        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final ListVariablesVisitor visitor = new ListVariablesVisitor();
        final Function twentySeven = new Literal(27);
        final Function a = new Variable("a", 9);
        final Function b = new Variable("b", 3);
        final Function division = new Division(twentySeven, a);
        final Function power = new Power(division, b);
        power.accepts(visitor);
        final List<String> result = visitor.getVariables();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final ListVariablesVisitor visitor = new ListVariablesVisitor();
        final Function z = new Variable("z", 36);
        final Function half = new Literal(0.5);
        final Function power = new Power(z, half);
        power.accepts(visitor);
        final List<String> result = visitor.getVariables();

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final ListVariablesVisitor visitor = new ListVariablesVisitor();
        final Function value = new Variable("value", 8);
        final Function abs = new Absolute(value);
        final Function eight = new Literal(8);
        final Function subtraction = new Subtraction(abs, eight);
        subtraction.accepts(visitor);
        final List<String> result = visitor.getVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final ListVariablesVisitor visitor = new ListVariablesVisitor();
        final Function value = new Variable("value", 8);
        final Function abs = new Absolute(value);
        final Function eight = new Literal(8);
        final Function subtraction = new Subtraction(abs, eight);
        subtraction.accepts(visitor);
        final List<String> result = visitor.getVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final ListVariablesVisitor visitor = new ListVariablesVisitor();
        final Function five = new Literal(5);
        final Function i = new Variable("i", 2);
        final Function subtraction = new Subtraction(five, i);
        final Function eight = new Literal(8);
        final Function multiplication = new Multiplication(subtraction, eight);
        multiplication.accepts(visitor);
        final List<String> result = visitor.getVariables();

        assertThat(result, containsInAnyOrder("i"));
    }
}
