
package com.calculator.github.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.calculator.github.Calculator;

public class CalculatorTest
{
    @Test
    public void shouldReturnZeroOnEmptyString()
    {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void shouldReturnNumberOnNumber()
    {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void shouldReturnSumonTwoNumbersDelimitedByComma()
    {
        assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    public void shouldReturnSumonMultipleNumbers()
    {
        assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void shouldAcceptNewLineAsValidDelimiter()
    {
        assertEquals(6, Calculator.add("1,2,\n3"));
    }

    @Test
    public void shouldAcceptCustomDelimiterSyntax()
    {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void customDelimiterCouldBeAlsoRegExpSpecialChar()
    {
        assertEquals(3, Calculator.add("//.\n1.2"));
    }

    @Test
    public void shouldRaiseExceptionOnNegatives()
    {

        try
        {
            Calculator.add("-1, 2 ,3");
            fail("Exception expected");
        }
        catch (RuntimeException ex)
        {
             
        }
    }
    
    @Test
    public void exceptionMessageShouldContainTheNegativeNumber()
    {

        try
        {
            Calculator.add("-1,-2,3");
            fail("Exception expected");
        }
        catch (RuntimeException ex)
        {
             assertEquals("Negatives not allowed: -1, -2", ex.getMessage());
        }
    }
}
