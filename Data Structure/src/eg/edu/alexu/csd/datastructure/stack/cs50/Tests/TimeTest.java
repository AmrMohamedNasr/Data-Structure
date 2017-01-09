package eg.edu.alexu.csd.datastructure.stack.cs50.Tests;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
import eg.edu.alexu.csd.datastructure.stack.cs50.MyEvaluater;

public class TimeTest {

    public static void main(String[] args) {
        IExpressionEvaluator testMe = new MyEvaluater();
        StringBuilder string = new StringBuilder();
     
        for (int i = 0; i < 1000000000; i++) {
            string = string.append("1+");
        }
        string = string.append("1");
        long start = System.currentTimeMillis();
        String ev = testMe.infixToPostfix(string.toString());
        long first = System.currentTimeMillis();
        testMe.evaluate(ev);
        long second = System.currentTimeMillis();
        System.out.println(first-start);
        System.out.println(second-first);
        System.out.println(second-start);
        }

}
