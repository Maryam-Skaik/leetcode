package DailyChallenges;

/**
 * Problem: Binary Watch
 * Date: 17-02-2026
 * Difficulty: Easy
 * Pattern: Bit Manipulation / Simulation
 *
 * Problem Link:
 * https://leetcode.com/problems/binary-watch/
 *
 * Description:
 * A binary watch has 4 LEDs for hours (0-11) and 6 LEDs for minutes (0-59).
 * Each LED represents 0 or 1, with the least significant bit on the right.
 *
 * Given an integer turnedOn representing the number of LEDs currently on,
 * return all possible times the watch could represent.
 *
 * Constraints:
 * - 0 <= turnedOn <= 10
 * - Hours must not have leading zero.
 * - Minutes must have two digits (leading zero allowed).
 *
 * Time Complexity: O(12 * 60) = O(720) — iterate all possible hours and minutes
 * Space Complexity: O(number of valid times) — output list
 */
public class _2026_02_17_BinaryWatch {

    /**
     * Solution:
     * 1. Loop through hours 0–11.
     * 2. Loop through minutes 0–59.
     * 3. Count the number of 1s in binary representations of hour and minute.
     * 4. If total equals turnedOn, format time and add to result.
     */
    public java.util.List<String> readBinaryWatch(int turnedOn) {
        java.util.List<String> times = new java.util.ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return times;
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {
        _2026_02_17_BinaryWatch solution = new _2026_02_17_BinaryWatch();

        int turnedOn1 = 1;
        int turnedOn2 = 9;

        System.out.println("turnedOn = " + turnedOn1 + " -> " + solution.readBinaryWatch(turnedOn1));
        System.out.println("turnedOn = " + turnedOn2 + " -> " + solution.readBinaryWatch(turnedOn2));
    }
}
