package com.alikhani.jalal.calculatorwithunittestsjavaandroid;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * Created by J.Alikhani on 18/07/16.
 */
public class CalculatorModelUnitTests extends ApplicationTestCase<Application> {

    CalculatorModel calculatorModel;

    public CalculatorModelUnitTests() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
        calculatorModel = new CalculatorModel();
    }

    public void testCalculatorModelClass() throws Exception {
        assertNotNull(calculatorModel);
        assertNotSame(calculatorModel, new CalculatorModel());
    }

    public void testCalculatorModelOperator() {
        assertTrue("1 + ->", "+".equals(calculatorModel.Operator("1", "+")));
        assertEquals("5 = ->", "6.0", calculatorModel.Operator("5", "="));
        assertFalse("1 - ->", "/".equals(calculatorModel.Operator("1", "-")));
        assertEquals("3 = ->", "-2.0", calculatorModel.Operator("3", "="));
        assertTrue("4 * ->", "*".equals(calculatorModel.Operator("4", "*")));
        assertEquals("2 = ->", "8.0", calculatorModel.Operator("2", "="));
        assertTrue("6 / ->", "/".equals(calculatorModel.Operator("6", "/")));
        assertEquals("3 = ->", "2.0", calculatorModel.Operator("3", "="));
    }

    public void testCalculatorModelSomeOtherOperator() {
        assertTrue("SQURE Test - >", "3.0".equals(calculatorModel.Operator("9", "SQR")));
        assertEquals("COS Test - >", "1.0", calculatorModel.Operator("0", "COS"));
        assertEquals("COS Test - >", "0.0", calculatorModel.Operator("0", "SIN"));
    }

    public void testCalculatorModelSomeCriticalError() {
        assertEquals("Negative SQR Test - >", "0.0", calculatorModel.Operator("-1", "SQR"));
        assertTrue("1 + ->", "/".equals(calculatorModel.Operator("0", "/")));
        assertEquals("Divide by zero- >", "0.0", calculatorModel.Operator("0", "="));
    }
}
