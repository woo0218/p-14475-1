package com.ll;



public class Calc {
    public static int run(String expression) {
        String[] tokens = expression.split("(?= \\+| \\-| \\*)");

        int result = Integer.parseInt(tokens[0].trim());

        for (int i = 1; i < tokens.length; i++) {
            String token = tokens[i].trim();
            char op = token.charAt(0);
            int num = Integer.parseInt(token.substring(1).trim());

            switch(op) {
                case '+':
                    result = plus(result, num);
                    break;
                case '-':
                    result = minus(result, num);
                    break;
                case '*':
                    result = multyply(result, num);
                    break;
            }
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
