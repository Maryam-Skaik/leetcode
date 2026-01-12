package DailyChallenges;

/**
 * Problem: Minimum Time to Visit All Points
 * Date: 12-01-2026
 * Difficulty: Easy
 * Pattern: Math / Geometry / Simulation
 *
 * Problem Link:
 * https://leetcode.com/problems/minimum-time-visiting-all-points/
 *
 * Time Complexity:
 * O(n) where n = number of points
 *
 * Space Complexity:
 * O(1)
 */

public class _2026_01_12_MinTimeVisitPoints {

    /**
     * Solution:
     * - For each consecutive pair of points, compute the absolute difference
     *   in x and y coordinates (dx and dy).
     * - Minimum time to move from one point to another is max(dx, dy),
     *   because you can move diagonally in 1 second (which covers both x and y).
     * - Sum these times for all consecutive pairs of points.
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int dx = Math.abs(points[i + 1][0] - points[i][0]);
            int dy = Math.abs(points[i + 1][1] - points[i][1]);
            totalTime += Math.max(dx, dy);
        }
        return totalTime;
    }

    // Test examples
    public static void main(String[] args) {
        _2026_01_12_MinTimeVisitPoints solution = new _2026_01_12_MinTimeVisitPoints();

        // Example 1: points = [[1,1],[3,4],[-1,0]] → output = 7
        int[][] ex1 = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println("Example 1 Output: " + solution.minTimeToVisitAllPoints(ex1)); // 7

        // Example 2: points = [[3,2],[-2,2]] → output = 5
        int[][] ex2 = {{3, 2}, {-2, 2}};
        System.out.println("Example 2 Output: " + solution.minTimeToVisitAllPoints(ex2)); // 5
    }
}
