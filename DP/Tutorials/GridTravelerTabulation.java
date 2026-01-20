// GridTraveler Tabulation (Bottom-Up DP)
//
// Problem:
// You are a traveler on a 2D grid. You begin in the top-left corner and your goal 
// is to travel to the bottom-right corner. You may only move down or right. 
// Write a function `gridTraveler(m, n)` that calculates the number of ways to travel
// to the goal on an m x n grid.
//
// Examples:
// gridTraveler(3, 3) -> 6
// gridTraveler(1, 1) -> 1
// gridTraveler(2, 3) -> 3
// gridTraveler(18, 18) -> 2333606220 (large example, fast with tabulation)

// Complexity:
// Time: O(m * n)
// Space: O(m * n)

public class GridTravelerTabulation {

    public static long gridTraveler(int m, int n) {
        long[][] table = new long[m + 1][n + 1];

        // Base case: starting point
        table[1][1] = 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                long current = table[i][j];
                if (i + 1 <= m) table[i + 1][j] += current; // down
                if (j + 1 <= n) table[i][j + 1] += current; // right
            }
        }

        return table[m][n];
    }

    public static void main(String[] args) {
        System.out.println("gridTraveler(1,1) -> " + gridTraveler(1, 1)); // 1
        System.out.println("gridTraveler(2,3) -> " + gridTraveler(2, 3)); // 3
        System.out.println("gridTraveler(3,2) -> " + gridTraveler(3, 2)); // 3
        System.out.println("gridTraveler(3,3) -> " + gridTraveler(3, 3)); // 6
        System.out.println("gridTraveler(18,18) -> " + gridTraveler(18, 18)); // 2333606220
    }
}

/*
Explanation / Table Idea:

Example: gridTraveler(3, 3)

Initial table (3x3, indices 0 to 3):

   0 1 2 3
0 [0 0 0 0]
1 [0 1 0 0]
2 [0 0 0 0]
3 [0 0 0 0]

Iteration:
- table[1][1] = 1
- Add value down → table[2][1] += 1
- Add value right → table[1][2] += 1
- Continue iteratively filling all cells
- Final table[3][3] = 6

Notes:
- Tabulation builds the solution iteratively using a table.
- Avoids recursion and stack overflow issues.
- Efficient even for large grids.
*/
