import java.util.*;

/*
 ============================================================================
  BestSum - Memoization (Top-Down Dynamic Programming)
 ============================================================================
  Problem:
  Write a function `bestSum(targetSum, numbers)` that returns the
  SHORTEST combination of numbers that add up exactly to targetSum.

  If there is a tie, return any one of the shortest combinations.
  If no combination exists, return null.

  Examples:
  bestSum(7, [5,3,4,7]) -> [7]
  bestSum(8, [2,3,5])   -> [3,5]
*/

public class BestSumMemoization {

    // ------------------------------------------------------------------------
    // Brute Force Solution (NO DP)
    // ------------------------------------------------------------------------
    public static List<Integer> bestSum(int targetSum, int[] numbers) {
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Integer> shortestCombination = null;

        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderCombination =
                    bestSum(remainder, numbers);

            if (remainderCombination != null) {
                List<Integer> combination =
                        new ArrayList<>(remainderCombination);
                combination.add(num);

                if (shortestCombination == null ||
                        combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }
        return shortestCombination;
    }

    // ------------------------------------------------------------------------
    // Memoized Solution (Top-Down DP)
    // ------------------------------------------------------------------------
    public static List<Integer> bestSum(
            int targetSum,
            int[] numbers,
            HashMap<Integer, List<Integer>> memo
    ) {

        // 1️⃣ Return cached result if exists
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);

        // 2️⃣ Base cases
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Integer> shortestCombination = null;

        // 3️⃣ Try all choices
        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderCombination =
                    bestSum(remainder, numbers, memo);

            if (remainderCombination != null) {
                List<Integer> combination =
                        new ArrayList<>(remainderCombination);
                combination.add(num);

                if (shortestCombination == null ||
                        combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }

        // 4️⃣ Store result in memo
        memo.put(targetSum, shortestCombination);
        return shortestCombination;
    }

    // ------------------------------------------------------------------------
    // Main
    // ------------------------------------------------------------------------
    public static void main(String[] args) {

        System.out.println(bestSum(
                7, new int[]{5, 3, 4, 7})); // [7]

        System.out.println(bestSum(
                8, new int[]{2, 3, 5})); // [3,5]

        System.out.println(bestSum(
                8, new int[]{1, 4, 5})); // [4,4]

        // Memoized call (FAST)
        System.out.println(bestSum(
                100, new int[]{1, 2, 5, 25},
                new HashMap<>())); // [25,25,25,25]
    }
}
