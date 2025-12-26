package StackQueue.Easy;

import java.util.Stack;

/**
 * Problem: Valid Parentheses (Easy)
 * LeetCode: https://leetcode.com/problems/valid-parentheses/
 * Topic: Stack
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _020_ValidParentheses {

    private static boolean isMatch(char open, char close) {
        if (open == '(' && close == ')') return true;
        if (open == '[' && close == ']') return true;
        if (open == '{' && close == '}') return true;
        return false;
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isMatch(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println(isValid("()"));       // true
        System.out.println(isValid("()[]{}"));   // true
        System.out.println(isValid("(]"));       // false
        System.out.println(isValid("([])"));     // true
        System.out.println(isValid("([)]"));     // false
    }
}
