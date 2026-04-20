package com.ll;



public class Calc {
    public static int run(String expression) {
        String[] expressionBits = expression.split(" \\+|\\- ");
        int num1 = Integer.parseInt(expressionBits[0]);
        int num2 = Integer.parseInt(expressionBits[1]);

        int result = 0;
        for (String bit : expressionBits) {
            result = plus(result, Integer.parseInt(bit));
        }





        return result;
    }


    static int plus(int a, int b) {
        return a + b;
    }

    static int minus(int a, int b) {
        return a-b;
    }

    static int multyply(int a, int b) {
        return a*b;
    }

}
