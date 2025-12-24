package DailyChallenges;

import java.util.Arrays;

/**
 * Problem: Minimum Number of Boxes to Redistribute Apples
 * Date: 25-12-2025
 * Difficulty: Medium
 * Pattern: Greedy / Sorting
 * 
 * Problem Link: (Add LeetCode or custom problem link if available)
 * 
 * Description:
 * You are given an array apple of size n and an array capacity of size m.
 * There are n packs where the ith pack contains apple[i] apples. There are m boxes as well,
 * and the ith box has a capacity of capacity[i] apples.
 * Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.
 * Apples from the same pack can be distributed into different boxes.
 *
 * Constraints:
 * 1 <= n == apple.length <= 50
 * 1 <= m == capacity.length <= 50
 * 1 <= apple[i], capacity[i] <= 50
 * The input is generated such that redistribution is always possible.
 * 
 * Time Complexity: O(m log m + n) -> sorting + sum
 * Space Complexity: O(1)
 */

public class _2025_12_25_MinimumBoxes_Greedy {

    public static int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int a : apple) sum += a;

        Arrays.sort(capacity);
        int count = 0;

        for(int i = capacity.length - 1; i >= 0; i--) {
            sum -= capacity[i];
            count++;
            if(sum <= 0) return count;
        }

        return count;
    }

    // Test examples
    public static void main(String[] args) {
        int[] apple1 = {1,3,2};
        int[] capacity1 = {4,3,1,5,2};
        System.out.println(minimumBoxes(apple1, capacity1)); // Output: 2

        int[] apple2 = {5,5,5};
        int[] capacity2 = {2,4,2,7};
        System.out.println(minimumBoxes(apple2, capacity2)); // Output: 4

        int[] apple3 = {10,5,3};
        int[] capacity3 = {8,7,5,3,2};
        System.out.println(minimumBoxes(apple3, capacity3)); // Example custom test
    }
}
