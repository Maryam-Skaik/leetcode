import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/*
 ============================================================================
  HowSum - Dynamic Programming (Memoization / Top-Down DP)
 ============================================================================
  Problem:
  Write a function `howSum(targetSum, numbers)` that returns any combination 
  of numbers that add up exactly to targetSum. Return null if impossible.

  You may use elements multiple times. Return any valid combination.

  Examples:
  howSum(7, [5,3,4,7]) -> [3,4] or [7]
  howSum(8, [2,3,5]) -> [2,2,2,2] or [3,5]
  howSum(7, [2,4]) -> null
  howSum(0, [1,2,3]) -> []

 ============================================================================
  PART 1: NAIVE RECURSIVE SOLUTION
 ============================================================================
  - Time Complexity: O(n^m * m) (n = numbers.length, m = targetSum)
  - Space Complexity: O(m^2) (recursion + list copies)

  Recursion Tree Example: howSum(7, [5,3,4,7])
             7
      -5    -3    -4   -7
       2     4     3     0 <- 0 is base case, return empty list
      ...   ...   ...

  Base cases:
  - targetSum == 0 -> return empty list
  - targetSum < 0 -> return null
*/

public class HowSumMemoization {

    // Naive recursive solution
    public static List<Integer> howSum(int targetSum, int[] numbers) {
        if (targetSum == 0) return new ArrayList<>(); // exact sum
        if (targetSum < 0) return null;              // overshoot

        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderResult = howSum(remainder, numbers);
            if (remainderResult != null) {
                List<Integer> result = new ArrayList<>(remainderResult);
                result.add(num);
                return result;
            }
        }

        return null; // no combination found
    }

    /*
     ============================================================================
      PART 2: MEMOIZATION / TOP-DOWN DP
     ============================================================================
      Idea:
      - Subproblems repeat, e.g., howSum(7-3) appears multiple times
      - Use HashMap<Integer, List<Integer>> as memo
      - Store targetSum -> list (or null if impossible)
      - Avoid recomputation, improve time complexity
    */

    public static List<Integer> howSumMemo(int targetSum, int[] numbers, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);

        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderResult = howSumMemo(remainder, numbers, memo);
            if (remainderResult != null) {
                List<Integer> result = new ArrayList<>(remainderResult);
                result.add(num);
                memo.put(targetSum, result);
                return result;
            }
        }

        memo.put(targetSum, null);
        return null;
    }

    /*
     ============================================================================
      MEMO EXAMPLE: howSumMemo(7, [5,3,4,7])
     ============================================================================
      memo = {
        1 -> null,
        2 -> null,
        3 -> [3],
        4 -> [4],
        5 -> [5],
        6 -> [3,3],
        7 -> [3,4] or [7]
      }
      Each subproblem is computed once and reused
      Time complexity reduces from exponential to O(n * m^2)
      Space complexity: O(m^2)
    */

    public static void main(String[] args) {
        int[] nums1 = {2,3};
        int[] nums2 = {5,3,4,7};
        int[] nums3 = {2,4};
        int[] nums4 = {2,3,5};
        int[] nums5 = {7,14};

        System.out.println("=== Naive Recursive ===");
        System.out.println("howSum(7, [2,3]) = " + howSum(7, nums1)); // e.g., [3,2,2]
        System.out.println("howSum(7, [5,3,4,7]) = " + howSum(7, nums2)); // [3,4] or [7]
        System.out.println("howSum(7, [2,4]) = " + howSum(7, nums3)); // null
        System.out.println("howSum(8, [2,3,5]) = " + howSum(8, nums4)); // [2,2,2,2] or [3,5]

        System.out.println("\n=== Memoization / Top-Down DP ===");
        HashMap<Integer, List<Integer>> memo = new HashMap<>();
        System.out.println("howSumMemo(7, [2,3]) = " + howSumMemo(7, nums1, memo)); // fast

        memo.clear();
        System.out.println("howSumMemo(7, [5,3,4,7]) = " + howSumMemo(7, nums2, memo)); // fast

        memo.clear();
        System.out.println("howSumMemo(7, [2,4]) = " + howSumMemo(7, nums3, memo)); // fast

        memo.clear();
        System.out.println("howSumMemo(8, [2,3,5]) = " + howSumMemo(8, nums4, memo)); // fast

        memo.clear();
        System.out.println("howSumMemo(300, [7,14]) = " + howSumMemo(300, nums5, memo)); // fast
    }
}
