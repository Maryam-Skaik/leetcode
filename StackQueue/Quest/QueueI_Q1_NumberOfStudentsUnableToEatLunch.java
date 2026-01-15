package StackQueue.Quest;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Problem: Number of Students Unable to Eat Lunch (Easy)
 * LeetCode: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Queue I
 *
 * Pattern: Queue Simulation
 *
 * Time Complexity: O(n^2) in worst case
 * Space Complexity: O(n)
 */

public class QueueI_Q1_NumberOfStudentsUnableToEatLunch {

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();

        // Initialize queue with students
        for (int s : students) {
            queue.offer(s);
        }

        int i = 0; // index for sandwiches (top of stack)

        while (!queue.isEmpty() && i < sandwiches.length) {
            int attempts = queue.size(); // number of students to try for this sandwich

            while (attempts > 0) {
                if (queue.peek() == sandwiches[i]) {
                    queue.poll(); // student takes sandwich
                    i++;          // move to next sandwich
                    break;
                } else {
                    queue.offer(queue.poll()); // move student to end
                    attempts--;
                }
            }

            // Full rotation without eating
            if (attempts == 0) {
                break;
            }
        }

        return queue.size(); // students unable to eat
    }

    // Test the solution
    public static void main(String[] args) {
        int[] students1 = {1, 1, 0, 0};
        int[] sandwiches1 = {0, 1, 0, 1};
        System.out.println(countStudents(students1, sandwiches1));
        // Output: 0

        int[] students2 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches2 = {1, 0, 0, 0, 1, 1};
        System.out.println(countStudents(students2, sandwiches2));
        // Output: 3
    }
}
