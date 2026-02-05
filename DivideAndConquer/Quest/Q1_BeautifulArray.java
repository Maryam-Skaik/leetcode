package DivideAndConquer.Quest;

/**
 * Problem: Beautiful Array (Medium)
 * LeetCode: https://leetcode.com/problems/beautiful-array/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Arrays I
 *
 * Pattern: Divide and Conquer / Recursive Construction
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class Q1_BeautifulArray {

    public static int[] beautifulArray(int n) {
        return build(n);
    }

    private static int[] build(int n) {
        if (n == 1) {
            return new int[]{1};
        }

        int[] odds = build((n + 1) / 2);
        int[] evens = build(n / 2);

        int[] res = new int[n];
        int idx = 0;

        // Map odds: 2*x - 1
        for (int x : odds) {
            res[idx++] = 2 * x - 1;
        }

        // Map evens: 2*x
        for (int x : evens) {
            res[idx++] = 2 * x;
        }

        return res;
    }

    // Test the solution
    public static void main(String[] args) {
        int n1 = 4;
        System.out.print("Beautiful array for n = " + n1 + ": ");
        printArray(beautifulArray(n1)); // e.g., [2, 1, 4, 3]

        int n2 = 5;
        System.out.print("Beautiful array for n = " + n2 + ": ");
        printArray(beautifulArray(n2)); // e.g., [1, 3, 5, 2, 4]
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
