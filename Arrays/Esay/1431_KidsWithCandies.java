package Arrays.Easy;

/**
 * Problem: Kids With the Greatest Number of Candies (Easy)
 * LeetCode: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * Pattern: Array / Iteration
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;
import java.util.List;

public class _1431_KidsWithCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = max(candies);
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }

    // Helper method to find maximum value in array
    private static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] candies1 = {2,3,5,1,3};
        int extra1 = 3;
        System.out.println(kidsWithCandies(candies1, extra1)); // [true, true, true, false, true]

        int[] candies2 = {4,2,1,1,2};
        int extra2 = 1;
        System.out.println(kidsWithCandies(candies2, extra2)); // [true, false, false, false, false]

        int[] candies3 = {12,1,12};
        int extra3 = 10;
        System.out.println(kidsWithCandies(candies3, extra3)); // [true, false, true]
    }
}
