package DailyChallenges;

/**
 * Problem: Minimum Penalty for a Shop
 * Date: 26-12-2025
 * Difficulty: Medium
 * Pattern: Greedy / Prefix Sum
 *
 * Problem Link:
 * https://leetcode.com/problems/minimum-penalty-for-a-shop/
 *
 * Constraints:
 * 1 <= customers.length <= 10^5
 * customers[i] ∈ {'Y', 'N'}
 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 */

public class _2025_12_26_MinimumPenaltyForAShop {

    public static int bestClosingTime(String customers) {
        int penalty = 0;

        // Initial case: shop closed all the time (j = 0)
        // Penalty = number of 'Y'
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int bestHour = 0;

        // Move closing hour from left to right
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--;   // customer is now served
            } else {
                penalty++;   // shop open but no customer
            }

            // i + 1 is the new closing hour
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }

    // Test examples
    public static void main(String[] args) {
        System.out.println(bestClosingTime("YYNY"));   // 2
        System.out.println(bestClosingTime("NNNNN")); // 0
        System.out.println(bestClosingTime("YYYY"));  // 4
        System.out.println(bestClosingTime("YNYNN")); // 1
    }
}
