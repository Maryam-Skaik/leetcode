package DP.Medium;

import java.util.List;

/**
 * Problem: 120. Triangle (Medium)
 * LeetCode: https://leetcode.com/problems/triangle/
 * Pattern: Dynamic Programming (2D DP / Triangle Minimum Path)
 *
 * Idea:
 * Each cell can be reached from either of the two adjacent cells above it.
 * DP State:
 * dp[r][i] = minimum path sum to reach triangle[r][i]
 *
 * Transition:
 * dp[r][i] = triangle[r][i] + min(dp[r-1][i-1], dp[r-1][i])
 * (handling edges separately)
 *
 * Base Case:
 * dp[0][0] = triangle.get(0).get(0)
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */
public class _120_Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] table = new int[n][n]; 

        table[0][0] = triangle.get(0).get(0);

        for(int r = 1; r < n; r++){
            for(int i = 0; i <= r; i++){
                int val = triangle.get(r).get(i);
                if(i == 0){
                    table[r][i] = table[r - 1][0] + val;
                }else if (i == r) {
                    table[r][i] = table[r - 1][i - 1] + val;
                }else {
                    table[r][i] = Math.min(table[r - 1][i - 1], table[r - 1][i]) + val;
                } 
            }
        }

        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPath = Math.min(minPath, table[n - 1][i]);
        }

        return minPath;
    }

    // Test the solution
    public static void main(String[] args) {
        List<List<Integer>> triangle1 = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        System.out.println(minimumTotal(triangle1)); // 11

        List<List<Integer>> triangle2 = List.of(
                List.of(-10)
        );
        System.out.println(minimumTotal(triangle2)); // -10
    }
}
