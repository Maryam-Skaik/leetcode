package StackQueue.Quest;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Build an Array With Stack Operations (Medium)
 * LeetCode: https://leetcode.com/problems/build-an-array-with-stack-operations/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Stack I
 *
 * Pattern: Stack Simulation
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class StackI_Q1_BuildArrayWithStackOperations {

    public static List<String> buildArray(int[] target, int n) {
        List<String> ops = new ArrayList<>();
        int j = 0; // index for target
        
        for (int i = 1; i <= n && j < target.length; i++) {
            if (target[j] == i) {
                ops.add("Push");
                j++;
            } else {
                ops.add("Push");
                ops.add("Pop");
            }
        }
        
        return ops;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] target1 = {1, 3};
        int n1 = 3;
        System.out.println(buildArray(target1, n1)); 
        // Output: [Push, Push, Pop, Push]

        int[] target2 = {1, 2, 3};
        int n2 = 3;
        System.out.println(buildArray(target2, n2)); 
        // Output: [Push, Push, Push]

        int[] target3 = {1, 2};
        int n3 = 4;
        System.out.println(buildArray(target3, n3)); 
        // Output: [Push, Push]
    }
}
