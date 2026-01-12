package Stack.Quest;

import java.util.Stack;

/**
 * Problem: Evaluate Reverse Polish Notation (Medium)
 * LeetCode: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Stack II
 *
 * Pattern: Stack / Simulation
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class StackII_Q2_EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                // it's a number
                stack.push(Integer.parseInt(token));
            } else {
                // it's an operator
                int b = stack.pop(); // second operand
                int a = stack.pop(); // first operand
                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "*" -> stack.push(a * b);
                    case "/" -> stack.push(a / b); // integer division truncates toward zero
                }
            }
        }

        return stack.pop(); // result is last remaining element
    }

    // Test the solution
    public static void main(String[] args) {
        String[] tokens1 = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens1)); // Output: 9

        String[] tokens2 = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens2)); // Output: 6

        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens3)); // Output: 22
    }
}
