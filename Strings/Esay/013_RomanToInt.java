package Strings.Easy;

/**
 * Problem: Roman to Integer (Easy)
 * LeetCode: https://leetcode.com/problems/roman-to-integer/
 * Pattern: Mapping / Iteration
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _013_RomanToInt {

    public static int romanToInt(String s) {
        int answer = 0, prev = 0, num = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            switch(s.charAt(i)){
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }

            if(num < prev){
                answer -= num;
            } else {
                answer += num;
            }

            prev = num;
        }
        return answer;
    }

    // Test the solution
    public static void main(String[] args) {
        String s1 = "III";
        System.out.println(romanToInt(s1)); // 3

        String s2 = "LVIII";
        System.out.println(romanToInt(s2)); // 58

        String s3 = "MCMXCIV";
        System.out.println(romanToInt(s3)); // 1994
    }
}
