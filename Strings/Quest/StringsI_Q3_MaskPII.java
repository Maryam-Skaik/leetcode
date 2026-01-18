package Strings.Quest;

/**
 * Problem: Masking Personal Information (Medium)
 * LeetCode: https://leetcode.com/problems/masking-personal-information/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Strings I
 *
 * Pattern: String manipulation / Conditional masking
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class StringsI_Q3_MaskPII {

    public static String maskPII(String s) {

        // Case 1: Email
        if (s.contains("@")) {
            s = s.toLowerCase();
            int index = s.indexOf('@');
            String result = s.charAt(0) + "*****" + s.charAt(index - 1) + s.substring(index);
            return result;

        // Case 2: Phone number
        } else {
            StringBuilder result = new StringBuilder();

            // Keep only digits
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) result.append(s.charAt(i));
            }

            int length = result.length();

            // Mask based on country code length
            switch (length) {
                case 10:
                    result = new StringBuilder("***-***-" + result.substring(6));
                    break;
                case 11:
                    result = new StringBuilder("+*-***-***-" + result.substring(7));
                    break;
                case 12:
                    result = new StringBuilder("+**-***-***-" + result.substring(8));
                    break;
                case 13:
                    result = new StringBuilder("+***-***-***-" + result.substring(9));
                    break;
            }

            return result.toString();
        }
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(maskPII("LeetCode@LeetCode.com")); // l*****e@leetcode.com
        System.out.println(maskPII("AB@qq.com"));              // a*****b@qq.com
        System.out.println(maskPII("1(234)567-890"));         // ***-***-7890
        System.out.println(maskPII("+1(234)567-8901"));       // +*-***-***-8901
    }
}
