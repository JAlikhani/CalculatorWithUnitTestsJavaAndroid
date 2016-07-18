package com.alikhani.jalal.calculatorwithunittestsjavaandroid;

/**
 * Created by J.Alikhani on 18/07/16.
 */
public class CalculatorModel {

    private Double savedOperand = 0.0;
    private String operator = "=";

    public String Operator(String accumulator, String operator) {

        // this method can be implemented in more readable and maintainable way but the goal here is MVC Model and Test Units
        Double acc;
        try {
            acc = Double.parseDouble(accumulator);
        } catch (Exception e) {
            this.operator = operator;
            return savedOperand.toString();
        }

        if(operator.equals("SQR")) {
            if(acc > 0.0)
                savedOperand = Math.sqrt(acc);
            return savedOperand.toString();

        } else if(operator.equals("SIN")) {
            savedOperand = Math.sin(acc);
            return savedOperand.toString();

        } else if(operator.equals("COS")) {
            savedOperand = Math.cos(acc);
            return savedOperand.toString();
        } else  {

            if(this.operator.equals("+"))      { savedOperand = acc + savedOperand; }
            else if(this.operator.equals("-")) { savedOperand = savedOperand - acc; }
            else if(this.operator.equals("*")) { savedOperand = acc * savedOperand; }
            else if(this.operator.equals("/")) {
                if(acc > 0.0)
                    savedOperand = savedOperand / acc;
            }  else { savedOperand = acc;}

            this.operator = operator;

            if(operator.equals("=")) return savedOperand.toString();
            else return operator;
        }
    }
}
