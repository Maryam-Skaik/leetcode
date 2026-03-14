package Graph.Quest;

import java.util.*;

/**
 * Problem: Add Edges to Make Degrees of All Nodes Even (Hard)
 * LeetCode: https://leetcode.com/problems/add-edges-to-make-degrees-of-all-nodes-even/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Graph
 *
 * Pattern:
 * - Graph
 * - Degree Counting
 *
 * Idea:
 * 1. In an undirected graph, the number of nodes with odd degree is always even.
 * 2. To make all degrees even, we need to fix nodes with odd degree.
 * 3. Possible cases:
 *    - 0 odd nodes → already valid.
 *    - 2 odd nodes → either connect them directly (if edge not present),
 *      or connect both to a third node.
 *    - 4 odd nodes → try pairing them with two edges.
 *    - >4 odd nodes → impossible with only two added edges.
 * 4. Use a set to quickly check if an edge already exists.
 *
 * Time Complexity: O(n + edges)
 * Space Complexity: O(edges)
 */
public class Q2_AddEdgesToMakeDegreesEven {

    public static boolean isPossible(int n, List<List<Integer>> edges) {

        int[] degree = new int[n + 1];
        Set<Long> edgeSet = new HashSet<>();

        // Build degree array and edge set
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            degree[u]++;
            degree[v]++;

            long key1 = ((long) u << 32) | v;
            long key2 = ((long) v << 32) | u;

            edgeSet.add(key1);
            edgeSet.add(key2);
        }

        // Collect nodes with odd degree
        List<Integer> odd = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 1) {
                odd.add(i);
            }
        }

        // Case 1: no odd nodes
        if (odd.size() == 0) return true;

        // Case 2: two odd nodes
        if (odd.size() == 2) {

            int a = odd.get(0);
            int b = odd.get(1);

            // Try connecting them directly
            if (!edgeSet.contains(((long) a << 32) | b)) {
                return true;
            }

            // Try connecting through another node
            for (int i = 1; i <= n; i++) {

                if (i == a || i == b) continue;

                if (!edgeSet.contains(((long) a << 32) | i) &&
                    !edgeSet.contains(((long) b << 32) | i)) {
                    return true;
                }
            }

            return false;
        }

        // Case 3: four odd nodes
        if (odd.size() == 4) {

            int a = odd.get(0);
            int b = odd.get(1);
            int c = odd.get(2);
            int d = odd.get(3);

            if (!edgeSet.contains(((long) a << 32) | b) &&
                !edgeSet.contains(((long) c << 32) | d))
                return true;

            if (!edgeSet.contains(((long) a << 32) | c) &&
                !edgeSet.contains(((long) b << 32) | d))
                return true;

            if (!edgeSet.contains(((long) a << 32) | d) &&
                !edgeSet.contains(((long) b << 32) | c))
                return true;

            return false;
        }

        // More than 4 odd nodes
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {

        int n1 = 5;
        List<List<Integer>> edges1 = new ArrayList<>();
        edges1.add(List.of(1,2));
        edges1.add(List.of(2,3));
        edges1.add(List.of(3,4));
        edges1.add(List.of(4,2));
        edges1.add(List.of(1,4));
        edges1.add(List.of(2,5));

        System.out.println("Input: n = " + n1 + ", edges = " + edges1);
        System.out.println("Output: " + isPossible(n1, edges1));
        System.out.println();

        int n2 = 4;
        List<List<Integer>> edges2 = new ArrayList<>();
        edges2.add(List.of(1,2));
        edges2.add(List.of(3,4));

        System.out.println("Input: n = " + n2 + ", edges = " + edges2);
        System.out.println("Output: " + isPossible(n2, edges2));
        System.out.println();

        int n3 = 4;
        List<List<Integer>> edges3 = new ArrayList<>();
        edges3.add(List.of(1,2));
        edges3.add(List.of(1,3));
        edges3.add(List.of(1,4));

        System.out.println("Input: n = " + n3 + ", edges = " + edges3);
        System.out.println("Output: " + isPossible(n3, edges3));
    }
}
