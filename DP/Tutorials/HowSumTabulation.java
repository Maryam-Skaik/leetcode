/*
 * ============================
 * howSum — Tabulation (Bottom-Up DP)
 * ============================
 *
 * Write a function `howSum(targetSum, numbers)` that:
 * - returns any combination of numbers that add up exactly to targetSum
 * - returns null if no combination exists
 *
 * Example:
 * howSum(7, [5, 3, 4]) -> [3, 4]  (or [4,3])
 *
 * ------------------------------------------------------------
 * TABULATION IDEA
 * ------------------------------------------------------------
 *
 * We use a table (array of List<Integer> objects) where:
 *   table[i] = a combination of numbers that sums to i
 *   table[i] = null → sum i is not reachable
 *
 * Table size = targetSum + 1
 *
 * ------------------------------------------------------------
 * STEP 1: Initialize the table
 * ------------------------------------------------------------
 *
 * Start all indices as null
 * table[0] = empty list (base case)
 *
 * Example targetSum = 7:
 * index:  0 1 2 3 4 5 6 7
 * table:  [] null null null null null null null
 *
 * ------------------------------------------------------------
 * STEP 2: Fill the table
 * ------------------------------------------------------------
 *
 * Iterate from left to right:
 *   - If table[i] != null → sum i is reachable
 *     → for each num in numbers:
 *         - if i + num <= targetSum:
 *             - copy table[i] into table[i + num]
 *             - add num to table[i + num]
 *
 * This builds combinations incrementally.
 *
 * ------------------------------------------------------------
 * WALKTHROUGH EXAMPLE
 * ------------------------------------------------------------
 *
 * targetSum = 7
 * numbers = [5, 3, 4]
 *
 * Start table:
 * [] null null null null null null null
 *
 * Index 0:
 * 0 + 5 → table[5] = [5]
 * 0 + 3 → table[3] = [3]
 * 0 + 4 → table[4] = [4]
 *
 * Index 3:
 * 3 + 3 = 6 → table[6] = [3, 3]
 * 3 + 4 = 7 → table[7] = [3, 4]
 *
 * Result: table[7] = [3, 4]
 *
 * ------------------------------------------------------------
 * COMPLEXITY
 * ------------------------------------------------------------
 *
 * m = targetSum
 * n = numbers.length
 *
 * Time Complexity:  O(m * n)
 * Space Complexity: O(m^2) — because each index may store up to O(m) numbers
 *
 */

import java.util.ArrayList;
import java.util.List;

public class HowSumTabulation {

    // I wrote the function alone, and I know it contains error, so fix gpt
    public static List<Integer> howSum(int targetSum, int[] numbers) {
        // table of size targetSum + 1
        List<Integer>[] table = new List[targetSum + 1];

        // base case: 0 sum -> empty combination
        table[0] = new ArrayList<>();

        for (int i = 0; i <= targetSum; i++) {
            if (table[i] != null) {
                for (int num : numbers) {
                    int nextIndex = i + num;
                    if (nextIndex <= targetSum) {
                        // copy current combination to new index
                        List<Integer> combination = new ArrayList<>(table[i]);
                        combination.add(num);
                        table[nextIndex] = combination;
                    }
                }
            }
        }

        return table[targetSum];
    }

    public static void main(String[] args) {
        // examples
        System.out.println(howSum(7, new int[]{5, 3, 4})); // [3,4] or [4,3]
        System.out.println(howSum(7, new int[]{2, 3}));    // [3,2,2] or similar
        System.out.println(howSum(7, new int[]{2, 4}));    // null
        System.out.println(howSum(8, new int[]{2, 3, 5})); // [3,5] or [2,2,2,2]
        System.out.println(howSum(300, new int[]{7, 14})); // null
    }
}
