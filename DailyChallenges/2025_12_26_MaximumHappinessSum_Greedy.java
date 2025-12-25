package DailyChallenges;

import java.util.Arrays;

/**
 * Problem: Maximum Happiness Sum
 * Date: 25-12-2025
 * Difficulty: Medium
 * Pattern: Greedy / Sorting
 *
 * Problem Link:
 * https://leetcode.com/problems/maximum-happiness-sum/
 *
 * Constraints:
 * 1 <= n <= 2 * 10^5
 * 1 <= happiness[i] <= 10^8
 * 1 <= k <= n
 *
 * Time Complexity:
 * O(n log n)
 *
 * Space Complexity:
 * O(1)
 */

public class _2025_12_25_MaximumHappinessSum_Greedy {

    public static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long sum = 0;
        int n = happiness.length;

        for (int i = 0; i < k; i++) {
            int value = happiness[n - 1 - i] - i;
            if (value <= 0) break;
            sum += value;
        }

        return sum;
    }

    // Test examples
    public static void main(String[] args) {
        int[] h1 = {1, 2, 3};
        System.out.println(maximumHappinessSum(h1, 2)); // 4

        int[] h2 = {1, 1, 1, 1};
        System.out.println(maximumHappinessSum(h2, 2)); // 1

        int[] h3 = {2, 3, 4, 5};
        System.out.println(maximumHappinessSum(h3, 1)); // 5
    }
}
