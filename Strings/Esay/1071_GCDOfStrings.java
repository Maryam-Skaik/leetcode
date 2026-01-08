package Strings.Easy;

/**
 * Problem: GCD of Strings (Easy)
 * LeetCode: https://leetcode.com/problems/greatest-common-divisor-of-strings/
 * Pattern: Math / String Manipulation
 * Time Complexity: O(n + m), where n = str1.length, m = str2.length
 * Space Complexity: O(1)
 */

public class _1071_GCDOfStrings {

    public static String gcdOfStrings(String str1, String str2) {
        // Check if concatenation in both orders is equal
        if (!(str1 + str2).equals(str2 + str1)) return "";
        
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    // Helper method to find gcd of two numbers
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Test the solution
    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2)); // Output: "ABC"

        String str3 = "ABABAB", str4 = "ABAB";
        System.out.println(gcdOfStrings(str3, str4)); // Output: "AB"

        String str5 = "LEET", str6 = "CODE";
        System.out.println(gcdOfStrings(str5, str6)); // Output: ""

        String str7 = "AAAAAB", str8 = "AAA";
        System.out.println(gcdOfStrings(str7, str8)); // Output: ""
    }
}
