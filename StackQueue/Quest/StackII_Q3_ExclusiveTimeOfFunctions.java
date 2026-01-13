package StackQueue.Quest;

import java.util.*;

/**
 * Problem: Exclusive Time of Functions (Medium)
 * LeetCode: https://leetcode.com/problems/exclusive-time-of-functions/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Stack II
 *
 * Pattern: Stack / Simulation
 *
 * Time Complexity: O(m) where m = number of logs
 * Space Complexity: O(n) where n = number of functions
 */

public class StackII_Q3_ExclusiveTimeOfFunctions {

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];       // result array to store exclusive time of each function
        Stack<Integer> stack = new Stack<>(); // stack to track active function calls
        int prevTime = 0;             // previous timestamp

        for (String log : logs) {
            String[] parts = log.split(":"); // split log into id, type, timestamp
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    // update the running time of function currently at top of stack
                    res[stack.peek()] += time - prevTime;
                }
                stack.push(id);       // push new function call
                prevTime = time;      // update previous timestamp
            } else { // "end"
                res[stack.pop()] += time - prevTime + 1; // add inclusive end time
                prevTime = time + 1;                     // next time starts after current end
            }
        }

        return res;
    }

    // Test the solution
    public static void main(String[] args) {
        List<String> logs1 = Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6");
        System.out.println(Arrays.toString(exclusiveTime(2, logs1))); // Output: [3, 4]

        List<String> logs2 = Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7");
        System.out.println(Arrays.toString(exclusiveTime(1, logs2))); // Output: [8]

        List<String> logs3 = Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7");
        System.out.println(Arrays.toString(exclusiveTime(2, logs3))); // Output: [7, 1]
    }
}
