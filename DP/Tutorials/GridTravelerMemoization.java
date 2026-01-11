import java.util.HashMap;

/*
 ============================================================================
  Grid Traveler - Dynamic Programming (Memoization / Top-Down DP)
 ============================================================================
  Problem:
  You are a traveler on a 2D grid.
  You start in the top-left corner.
  You can only move down or right.
  Your goal is to reach the bottom-right corner.

  Question:
  How many unique ways can you travel to the goal on a grid of size m * n?

 ============================================================================
  EXAMPLES
 ============================================================================
  gridTraveler(1,1) -> 1
  gridTraveler(2,3) -> 3
  gridTraveler(3,2) -> 3
  gridTraveler(3,3) -> 6
  gridTraveler(0,1) -> 0
  gridTraveler(1,0) -> 0
  gridTraveler(0,0) -> 0
*/

public class GridTravelerMemoization {

    /*
     ============================================================================
      PART 1: NAIVE RECURSION (NO DP)
     ============================================================================
      Recalculates the same subproblems multiple times.
      Time Complexity: Exponential
      Space Complexity: O(m + n) (recursion stack)
    */
    public int gridTraveler(int m, int n){
        if(m == 1 && n == 1) return 1; // Base case: reached destination
        if(m == 0 || n == 0) return 0; // Base case: invalid grid
        return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
    }

    /*
     ============================================================================
      PART 2: MEMOIZATION (TOP-DOWN DP)
     ============================================================================
      Idea:
      - Each gridTraveler(m,n) is computed ONCE
      - Stored in a memo HashMap for reuse
      - Avoids recomputation of overlapping subproblems

      Memo key: "m,n"
      Memo value: number of ways to travel the m*n grid
    */
    public long gridTravelerMemo(int m, int n, HashMap<String, Long> memo) {
        String key = m + "," + n;

        // 1️⃣ Return stored value if already computed
        if(memo.containsKey(key)) return memo.get(key);

        // 2️⃣ Base cases
        if(m == 1 && n == 1) return 1; // Reached destination
        if(m == 0 || n == 0) return 0; // Invalid path

        // 3️⃣ Recursive calculation + store in memo
        long result = gridTravelerMemo(m - 1, n, memo) + gridTravelerMemo(m, n - 1, memo);
        memo.put(key, result); // Corrected typo 'memp' -> 'memo'

        return result;
    }

    /*
     ============================================================================
      MEMORY STORE EXAMPLE
     ============================================================================
      Example: gridTravelerMemo(3,3)

      memo after computation:

      "1,1" -> 1
      "1,2" -> 1
      "2,1" -> 1
      "2,2" -> 2
      "2,3" -> 3
      "3,2" -> 3
      "3,3" -> 6

      Each grid state is computed only once.
      Complexity reduced from exponential to O(m*n).
    */

    public static void main(String[] args){
        GridTravelerMemoization gt = new GridTravelerMemoization();

        // Naive recursion
        System.out.println("gridTraveler(1,1) = " + gt.gridTraveler(1,1)); // 1
        System.out.println("gridTraveler(2,3) = " + gt.gridTraveler(2,3)); // 3
        System.out.println("gridTraveler(3,2) = " + gt.gridTraveler(3,2)); // 3
        System.out.println("gridTraveler(3,3) = " + gt.gridTraveler(3,3)); // 6

        // Memoization (fast even for large grids)
        HashMap<String, Long> memo = new HashMap<>();
        System.out.println("gridTravelerMemo(3,3) = " + gt.gridTravelerMemo(3,3,memo));   // 6
        System.out.println("gridTravelerMemo(18,18) = " + gt.gridTravelerMemo(18,18,memo)); // 2333606220
    }
}
