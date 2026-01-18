package Strings.Quest;

/**
 * Problem: License Key Formatting (Easy)
 * LeetCode: https://leetcode.com/problems/license-key-formatting/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Strings I
 *
 * Pattern: String manipulation / Grouping
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class StringsI_Q2_LicenseKeyFormatting {

    public static String licenseKeyFormatting(String s, int k) {
        String withoutDash = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                withoutDash += Character.toUpperCase(s.charAt(i));
            }
        }

        // Handle empty result (e.g. "---")
        if (withoutDash.length() == 0) return "";

        int mod = withoutDash.length() % k;

        String result = "";
        int index = 0;

        // First group (may be shorter than k)
        if (mod != 0) {
            result = withoutDash.substring(0, mod);
            index = mod;
        }

        // Remaining groups of size k
        while (index < withoutDash.length()) {
            if (!result.equals("")) result += "-";
            result += withoutDash.substring(index, index + k);
            index += k;
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4)); // 5F3Z-2E9W
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));   // 2-5G-3J
        System.out.println(licenseKeyFormatting("---", 3));        // ""
    }
}
