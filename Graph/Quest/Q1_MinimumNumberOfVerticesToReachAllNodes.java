package Graph.Quest;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Minimum Number of Vertices to Reach All Nodes (Medium)
 * LeetCode: https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Graph
 *
 * Pattern:
 * - Graph
 * - In-Degree Counting
 *
 * Idea:
 * 1. In a Directed Acyclic Graph (DAG), a node with an incoming edge can already
 *    be reached from another node.
 * 2. Therefore, only nodes with in-degree = 0 must be included in the answer.
 * 3. Compute the in-degree of each node using the edges list.
 * 4. Collect all nodes whose in-degree is 0.
 * 5. These nodes form the smallest set of vertices that can reach all nodes.
 *
 * Time Complexity: O(n + edges)
 * Space Complexity: O(n)
 */
public class Q1_MinimumNumberOfVerticesToReachAllNodes {

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int[] inDegree = new int[n];

        // Compute in-degree of each node
        for (List<Integer> edge : edges) {
            int to = edge.get(1);
            inDegree[to]++;
        }

        List<Integer> result = new ArrayList<>();

        // Nodes with in-degree 0 must be starting points
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {

        int n1 = 6;
        List<List<Integer>> edges1 = new ArrayList<>();
        edges1.add(List.of(0, 1));
        edges1.add(List.of(0, 2));
        edges1.add(List.of(2, 5));
        edges1.add(List.of(3, 4));
        edges1.add(List.of(4, 2));

        List<Integer> result1 = findSmallestSetOfVertices(n1, edges1);
        System.out.println("Input: n = " + n1 + ", edges = " + edges1);
        System.out.println("Output: " + result1);
        System.out.println();

        int n2 = 5;
        List<List<Integer>> edges2 = new ArrayList<>();
        edges2.add(List.of(0, 1));
        edges2.add(List.of(2, 1));
        edges2.add(List.of(3, 1));
        edges2.add(List.of(1, 4));
        edges2.add(List.of(2, 4));

        List<Integer> result2 = findSmallestSetOfVertices(n2, edges2);
        System.out.println("Input: n = " + n2 + ", edges = " + edges2);
        System.out.println("Output: " + result2);
    }
}
