package Arrays.Medium;

/**
 * Problem: Container With Most Water (Medium)
 * LeetCode: https://leetcode.com/problems/container-with-most-water/
 * Pattern: Two Pointers
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _011_ContainerWithMostWater_TwoPointers {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) left++;
            else right--;
        }

        return maxArea;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        System.out.println("Max area: " + maxArea(height1)); // 49

        int[] height2 = {1,1};
        System.out.println("Max area: " + maxArea(height2)); // 1
    }
}
