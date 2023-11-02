package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.composition.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "( 1 + 6 )";
        final Function one = new Literal(1);
        final Function six = new Literal(6);
        final Function sum = new Addition(one, six);
        final String result = sum.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "( 12 / 2 )";
        final Function twelve = new Literal(12);
        final Function two = new Literal(2);
        final Function division = new Division(twelve, two);
        final String result = division.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "( ( 9 / 2 ) * 3 )";
        final Function nine = new Literal(9);
        final Function two = new Literal(2);
        final Function three = new Literal(3);
        final Function division = new Division(nine, two);
        final Function multiplication = new Multiplication(division, three);
        final String result = multiplication.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "( ( 27 / 6 ) ^ 2 )";
        final Function twentySeven = new Literal(27);
        final Function six = new Literal(6);
        final Function two = new Literal(2);
        final Function division = new Division(twentySeven, six);
        final Function power = new Power(division, two);
        final String result = power.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "( | value | - 8 )";
        final Function value = new Variable("value", 10);
        final Function eight = new Literal(8);
        final Function absolute = new Absolute(value);
        final Function subtraction = new Subtraction(absolute, eight);
        final String result = subtraction.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "( | value | - 8 )";
        final Function value = new Variable("value", 10);
        final Function eight = new Literal(8);
        final Function absolute = new Absolute(value);
        final Function subtraction = new Subtraction(absolute, eight);
        final String result = subtraction.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "( ( 5 - i ) * 8 )";
        final Function five = new Literal(5);
        final Function i = new Variable("i", 2);
        final Function subtraction = new Subtraction(five, i);
        final Function eight = new Literal(8);
        final Function multiplication = new Multiplication(subtraction, eight);
        final String result = multiplication.print();

        assertThat(result, equalTo(expected));
    }
}
