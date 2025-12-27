package DailyChallenges;

import java.util.*;

/**
 * Problem: Meeting Rooms III
 * Date: 27-12-2025
 * Difficulty: Medium
 * Pattern: Priority Queue / Simulation
 *
 * Problem Link:
 * https://leetcode.com/problems/meeting-rooms-iii/
 *
 * Constraints:
 * 1 <= n <= 100
 * 1 <= meetings.length <= 10^5
 * 0 <= starti < endi <= 5 * 10^5
 * All start times are unique
 *
 * Time Complexity:
 * O(m log n), where m = meetings.length
 *
 * Space Complexity:
 * O(n)
 */

public class _2025_12_27_MeetingRoomsIII {

    public static int mostBooked(int n, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Min-heap of available rooms
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        // Min-heap of busy rooms: [endTime, roomNumber]
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
                (a, b) -> a[0] == b[0]
                        ? Long.compare(a[1], b[1])
                        : Long.compare(a[0], b[0])
        );

        int[] usageCount = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // Free rooms that finished before current meeting starts
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                busyRooms.offer(new long[]{end, room});
                usageCount[room]++;
            } else {
                // Delay meeting
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + duration;
                int room = (int) earliest[1];
                busyRooms.offer(new long[]{newEnd, room});
                usageCount[room]++;
            }
        }

        // Find room with maximum usage
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (usageCount[i] > usageCount[result]) {
                result = i;
            }
        }

        return result;
    }

    // Test examples
    public static void main(String[] args) {
        int[][] meetings1 = {{0,10},{1,5},{2,7},{3,4}};
        System.out.println(mostBooked(2, meetings1)); // 0

        int[][] meetings2 = {{1,20},{2,10},{3,5},{4,9},{6,8}};
        System.out.println(mostBooked(3, meetings2)); // 1
    }
}
