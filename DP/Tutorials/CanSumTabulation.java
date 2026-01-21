/*
 * ============================
 * canSum — Tabulation (Bottom-Up DP)
 * ============================
 *
 * Write a function `canSum(targetSum, numbers)` that takes:
 * - targetSum: an integer
 * - numbers: an array of non-negative integers
 *
 * The function returns a boolean indicating whether it is possible
 * to generate the targetSum using numbers from the array.
 *
 * You may use an element of the array as many times as needed.
 *
 * Example:
 * canSum(7, [5, 3, 4]) -> true
 *
 * ------------------------------------------------------------
 * TABULATION IDEA (Bottom-Up)
 * ------------------------------------------------------------
 *
 * We use a boolean table where:
 *   table[i] = true  → it is possible to generate sum i
 *   table[i] = false → it is NOT possible to generate sum i
 *
 * Table size = targetSum + 1
 *
 * Why +1?
 * Because we need indices from 0 up to targetSum inclusive.
 *
 * ------------------------------------------------------------
 * STEP 1: Initialize the table
 * ------------------------------------------------------------
 *
 * For targetSum = 7
 *
 * index:  0 1 2 3 4 5 6 7
 * table:  f f f f f f f f
 *
 * We start with all values = false
 *
 * ------------------------------------------------------------
 * STEP 2: Seed the base case
 * ------------------------------------------------------------
 *
 * canSum(0, numbers) = true
 *
 * This means:
 * It is always possible to generate sum 0 (by choosing no numbers)
 *
 * So:
 * table[0] = true
 *
 * index:  0 1 2 3 4 5 6 7
 * table:  t f f f f f f f
 *
 * ------------------------------------------------------------
 * STEP 3: Fill the table
 * ------------------------------------------------------------
 *
 * We iterate from left to right over the table.
 *
 * For each index i:
 *   - If table[i] == true
 *     → we know sum i is reachable
 *     → we try to add each number from the numbers array
 *
 * For each num in numbers:
 *   - if (i + num <= targetSum)
 *       table[i + num] = true
 *
 * Meaning:
 * If I can reach i, then I can also reach (i + num)
 *
 * ------------------------------------------------------------
 * EXAMPLE WALKTHROUGH
 * ------------------------------------------------------------
 *
 * targetSum = 7
 * numbers = [5, 3, 4]
 *
 * Start:
 * index:  0 1 2 3 4 5 6 7
 * table:  t f f f f f f f
 *
 * From index 0 (true):
 *   0 + 5 = 5 → true
 *   0 + 3 = 3 → true
 *   0 + 4 = 4 → true
 *
 * index:  0 1 2 3 4 5 6 7
 * table:  t f f t t t f f
 *
 * Index 1 → false → skip
 * Index 2 → false → skip
 *
 * From index 3 (true):
 *   3 + 5 = 8 → out of bounds → skip
 *   3 + 3 = 6 → true
 *   3 + 4 = 7 → true
 *
 * index:  0 1 2 3 4 5 6 7
 * table:  t f f t t t t t
 *
 * Now table[7] == true
 * → targetSum can be generated
 *
 * ------------------------------------------------------------
 * FINAL ANSWER
 * ------------------------------------------------------------
 *
 * Return table[targetSum]
 *
 * ------------------------------------------------------------
 * COMPLEXITY
 * ------------------------------------------------------------
 *
 * m = targetSum
 * n = numbers.length
 *
 * Time Complexity:  O(m * n)
 * Space Complexity: O(m)
 *
 */

public class CanSumTabulation {

    public static boolean canSum(int targetSum, int[] numbers) {
        // table size = targetSum + 1 (to avoid off-by-one errors)
        boolean[] table = new boolean[targetSum + 1];

        // base case
        table[0] = true;

        for (int i = 0; i <= targetSum; i++) {
            if (table[i]) {
                // if sum i is reachable, try extending it
                for (int num : numbers) {
                    if (i + num <= targetSum) {
                        table[i + num] = true;
                    }
                }
            }
        }

        return table[targetSum];
    }

    public static void main(String[] args) {
        // small examples
        System.out.println(canSum(7, new int[]{5, 3, 4})); // true
        System.out.println(canSum(7, new int[]{2, 4}));    // false

        // large example (to show tabulation efficiency)
        System.out.println(canSum(300, new int[]{7, 14})); // false
    }
}
