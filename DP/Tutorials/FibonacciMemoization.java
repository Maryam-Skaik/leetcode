import java.util.HashMap;

/*
 ============================================================================
  Fibonacci - Dynamic Programming (Memoization)
 ============================================================================
  Problem:
  Write a function fib(n) that returns the n-th Fibonacci number.

  Fibonacci Sequence:
  n:        1  2  3  4  5  6  7  ...
  fib(n):   1  1  2  3  5  8  13 ...

  Rule:
  fib(n) = fib(n - 1) + fib(n - 2)

 ============================================================================
  IMPORTANT DP TERMINOLOGY (DO NOT SKIP)
 ============================================================================
  There are TWO ways to implement Dynamic Programming:

  1️⃣ Top-Down DP  = Recursion + Memoization
  2️⃣ Bottom-Up DP = Iteration + DP table

  In this file, we are using:
  ✅ TOP-DOWN DYNAMIC PROGRAMMING

  Why?
  - We start from the FINAL problem: fib(n)
  - We break it down into smaller subproblems: fib(n-1), fib(n-2)
  - We use recursion
  - We store results in memory (memo)

 ============================================================================
*/

public class FibonacciMemoization {

    /*
     ============================================================================
      PART 1: NAIVE RECURSIVE SOLUTION (NO DP)
     ============================================================================
      This solution recalculates the same subproblems many times.

      Time Complexity: O(2^n)
      Space Complexity: O(n)  (recursive call stack)

      Example:
      fib(6)

      Recursive Tree (simplified):

                      fib(6)
                   /            \
              fib(5)            fib(4)
             /      \           /      \
         fib(4)   fib(3)    fib(3)   fib(2)
          /   \      ...
      fib(3) fib(2)

      Notice:
      - fib(4), fib(3), fib(2) are calculated MULTIPLE times
      - Same subtrees appear again and again
      - This causes exponential runtime
    */

    // Naive recursive Fibonacci (INEFFICIENT)
    public int fibRecursive(int n) {
        if (n == 1 || n == 2) return 1;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    /*
     ============================================================================
      PART 2: MEMOIZATION (TOP-DOWN DP)
     ============================================================================
      Why this is TOP-DOWN DP:

      1️⃣ We start from fib(n)  → the TOP (final answer)
      2️⃣ We recursively go DOWN to smaller subproblems
      3️⃣ We use memo to store results
      4️⃣ Each subproblem is solved ONCE

      Flow example:
      fibMemo(6)
        → fibMemo(5)
          → fibMemo(4)
            → fibMemo(3)
              → fibMemo(2)
              → fibMemo(1)

      Then results are reused from memo instead of recomputed.

      Memory Structure:
      HashMap<Integer, Integer>
      key   → n
      value → fib(n)

      Time Complexity: O(n)
      Space Complexity: O(n)
      - O(n) recursion depth
      - O(n) stored values in memo
    */

    public int fibMemo(int n, HashMap<Integer, Integer> memo) {

        // 1️⃣ If value already computed, reuse it (core DP idea)
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // 2️⃣ Base cases
        if (n == 1 || n == 2) {
            return 1;
        }

        // 3️⃣ Recursive calls (TOP-DOWN)
        int result = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);

        // 4️⃣ Store result in memory for future reuse
        memo.put(n, result);

        return result;
    }

    /*
     ============================================================================
      MEMORY STORE EXPLANATION
     ============================================================================
      Example: fibMemo(6)

      During execution, memo will contain:

      memo = {
        3 -> 2,
        4 -> 3,
        5 -> 5,
        6 -> 8
      }

      Each value is:
      - Computed once
      - Stored once
      - Reused many times

      This removes duplicate subtrees from the recursion tree.
    */

    public static void main(String[] args) {

        FibonacciMemoization fib = new FibonacciMemoization();

        /*
         ============================================================================
          INPUT / OUTPUT EXAMPLES
         ============================================================================
        */

        // Naive recursion (only safe for small n)
        System.out.println("fibRecursive(6) = " + fib.fibRecursive(6)); // Output: 8

        // ⚠️ Very slow (exponential)
        // System.out.println(fib.fibRecursive(50));

        // Top-Down DP (Memoization)
        HashMap<Integer, Integer> memo = new HashMap<>();

        System.out.println("fibMemo(6) = " + fib.fibMemo(6, memo));   // Output: 8
        System.out.println("fibMemo(10) = " + fib.fibMemo(10, memo)); // Output: 55
        System.out.println("fibMemo(50) = " + fib.fibMemo(50, memo)); // Output: 12586269025

        /*
         ============================================================================
          FINAL SUMMARY (VERY IMPORTANT)
         ============================================================================
          - Naive recursion → repeated work → O(2^n)
          - Memoization → store results → O(n)
          - This approach is called TOP-DOWN DP
          - Bottom-Up DP will do the same logic using loops
          - Both are Dynamic Programming
        */
    }
}
