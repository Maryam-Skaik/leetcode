import java.util.*;

/*
 ============================================================================
  Fibonacci — Tabulation (Bottom-Up DP)
 ============================================================================
*/

/*
 (Bottom-Up DP)

 write a function 'fib(n)` that takes a number as an argument.
 The function should return the n-th number of the Fibonacci sequence.

 The 0th number of the sequence is 0.
 The 1th number of the sequence is 1.

 To generate the next number of the sequence, we sum the previous two.

 n:      0, 1, 2, 3, 4, 5, 6, 7, 8, .......
 fib(n): 0, 1, 1, 2, 3, 5, 8, 13, 21, .......
*/

/*
 ---------------------------------------------------------------------------
  What does Tabulation mean?
 ---------------------------------------------------------------------------

 ok, let's go to what tabulation mean, it focus on build a table.

 fib(6) -> 8

 so instead of building it recursivly, we build it iterativly using a table.

 ok, in our example, we have f(6), so we will make an array up to 6,
 mean from 0 - 6

This avoids the off-by-one error:
- Using size n would miss index n
- Using size n + 1 is correct
*/

/*
 ---------------------------------------------------------------------------
  How the table is filled
 ---------------------------------------------------------------------------

 ok, what we will fill in this array

 we know that when we initialize an array,
 all it's value at start is 0s,
 and that will help us here where we need summition

 so the first index will keep it 0,
 the second mean index number 1, we will fill with 1
*/

/*
 ---------------------------------------------------------------------------
  Iteration logic (very important)
 ---------------------------------------------------------------------------

 on our iteration,
 we will start with index 0,
 find 0,
 and add the value to index 1, and 2,
 in this iteration the array won't change.

 the second iteration,
 we will take index 1
 and add it's value to index 2, and 3,
 so their values will become 1.

 the third iteration
 will add value in index 2,
 to index 3, and 4
 so it's values will be: 2, 1

 and so on
*/

/*
 ---------------------------------------------------------------------------
  Final observations
 ---------------------------------------------------------------------------

 so it's clear that we will iterat rather than recursive

 the time complexity is O(n)
*/

public class FibonacciTabulation {

    public static long fib(int n) {

        // table size = n + 1 (from 0 to n)
        int[] table = new int[n + 1];

        // base case
        table[1] = 1;

        // build the table iteratively
        for (int i = 0; i <= n; i++) {

            // we rely on default zeros in the array
            if (i + 1 <= n) table[i + 1] += table[i];
            if (i + 2 <= n) table[i + 2] += table[i];
        }

        return table[n];
    }

    public static void main(String[] args) {

        System.out.println(fib(6));  // 8
        System.out.println(fib(7));  // 13
        System.out.println(fib(8));  // 21
        System.out.println(fib(50)); // 12586269025
    }
}
