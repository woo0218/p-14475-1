package com.ll;


import java.util.ArrayList;
import java.util.List;

public class Calc {
    public static int run(String expression) {

        while (expression.contains("(")) {
            int start = expression.lastIndexOf("(");
            int end = expression.indexOf(")", start);
            String innerExpression = expression.substring(start + 1, end);
            int result = run(innerExpression);  // 재귀 호출
            expression = expression.substring(0, start) + result + expression.substring(end + 1);
        }

        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        String[] expressionBits = expression.split(" ");

        for (int i = 0; i < expressionBits.length; i++) {
            if (i % 2 == 0) {
                numbers.add(Integer.parseInt(expressionBits[i]));
            } else {
                operators.add(expressionBits[i].charAt(0));
            }
        }

        for (int i = 0; i < operators.size(); i++){
            if(operators.get(i) == '*') {
                int result = multyply(numbers.get(i), numbers.get(i + 1));
                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }
        }

        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '+') {
                result = plus(result, numbers.get(i + 1));
            } else if (operators.get(i) == '-') {
                result = minus(result, numbers.get(i + 1));
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
