package DailyChallenges;

/**
 * Problem: Find Unique Binary String
 * Date: 08-03-2026
 * Difficulty: Medium
 * Pattern: Cantor's Diagonalization / Constructive Algorithm
 *
 * Problem Link:
 * https://leetcode.com/problems/find-unique-binary-string/
 *
 * Special Note:
 * Today is International Women's Day (March 8).
 * A small reminder that women continue to make important contributions
 * in computer science, mathematics, and engineering.
 *
 * Key Idea:
 * We use a concept inspired by Cantor's Diagonal Argument.
 *
 * Construct a new binary string where the i-th bit is the opposite of nums[i][i].
 *
 * If nums[i][i] == '0' → put '1'
 * If nums[i][i] == '1' → put '0'
 *
 * Why this works:
 * The generated string differs from:
 * - nums[0] at index 0
 * - nums[1] at index 1
 * - nums[2] at index 2
 * ...
 *
 * Therefore it cannot be equal to any string in the array.
 *
 * This guarantees a unique binary string of length n that is not in nums.
 *
 * Time Complexity:
 * - O(n)
 *
 * Space Complexity:
 * - O(n)
 *
 */
public class _2026_03_08_FindUniqueBinaryString {

    /**
     * Optimal Solution (Diagonal Construction)
     *
     * Idea:
     * Build a new string by flipping the diagonal bits.
     * This ensures the result differs from every string in nums.
     */
    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {

            if (nums[i].charAt(i) == '0')
                result.append('1');
            else
                result.append('0');
        }

        return result.toString();
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {

        _2026_03_08_FindUniqueBinaryString solution =
                new _2026_03_08_FindUniqueBinaryString();

        String[] nums1 = {"01", "10"};
        String[] nums2 = {"00", "01"};
        String[] nums3 = {"111", "011", "001"};

        System.out.println("Unique string for nums1: "
                + solution.findDifferentBinaryString(nums1));

        System.out.println("Unique string for nums2: "
                + solution.findDifferentBinaryString(nums2));

        System.out.println("Unique string for nums3: "
                + solution.findDifferentBinaryString(nums3));
    }
}
