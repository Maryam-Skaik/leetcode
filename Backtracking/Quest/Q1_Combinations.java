package Backtracking.Quest;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Combinations (Medium)
 * LeetCode: https://leetcode.com/problems/combinations/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Backtracking
 *
 * Pattern:
 * - Backtracking
 *
 * Idea:
 * 1. Use backtracking to generate all possible combinations.
 * 2. Start from a given number and try adding each possible next number.
 * 3. When the current combination size reaches k, add a copy to the result.
 * 4. After exploring, remove the last element (backtrack) to try the next possibility.
 *
 * Time Complexity: O(C(n, k) * k)
 * Space Complexity: O(k)
 */
public class Q1_Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(1, n, k, combination, result);
        return result;
    }

    private static void backtrack(int start, int n, int k,
                                  List<Integer> combination,
                                  List<List<Integer>> result) {

        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= n; i++) {
            combination.add(i);                      // choose
            backtrack(i + 1, n, k, combination, result); // explore
            combination.remove(combination.size() - 1);   // un-choose
        }
    }

    // Main method for testing
    public static void main(String[] args) {

        int n1 = 4, k1 = 2;
        List<List<Integer>> result1 = combine(n1, k1);
        System.out.println("Input: n = " + n1 + ", k = " + k1);
        System.out.println("Output: " + result1);
        System.out.println();

        int n2 = 1, k2 = 1;
        List<List<Integer>> result2 = combine(n2, k2);
        System.out.println("Input: n = " + n2 + ", k = " + k2);
        System.out.println("Output: " + result2);
    }
}
