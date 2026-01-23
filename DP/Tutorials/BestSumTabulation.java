
// Write a function `bestSum(targetSum, numbers)` that returns the SHORTEST combination of numbers that add up exactly to targetSum.

// If there is a tie, return any one of the shortest combinations.
// If no combination exists, return null.

// bestSum(8, [2,3,5])   -> [2, 2, 2, 2], [2, 3, 3], [3, 5], we need shortest so it [3, 5]

// as we did before, we will build our table as size of targetSum + 1

// to got the base case, we will try to find the bestSum(0, [...]) -> [], empty array, and we fill other indecis with null

// 0   1    2    3    4    5    6    7    8
// [] null null null null null null null null

// ok, now we are ready for iteration on our table, 

// as we work before, start with index 0, and walk steps according numbers array to fill these indeecis
// first number is 2, so we will walk 2 steps, we find it's value is null, so we will copy array from my current position (0 index), and also add the number (2)

// 0   1    2    3    4    5    6    7    8
// [] null [2]  null null null null null null

// same with 3, and 5

// 0   1    2    3    4    5    6    7    8
// [] null [2]  [3]  null [5]  null null null

// keep iterate to go to next index, which 1, we find it null, mean we can't generate using numbers array, so we will skip 

// so we will move ahead to index 2, we find it contain a value [2], so now we know we can generate 2 using our numbers array, so we will walk steps as numbers in array to fill them
// samething, copy array and add number, starting with index 4

// 0   1    2    3     4     5    6    7    8
// [] null [2]  [3]  [2,2]  [5]  null null null

// now when we go to index 5, we find it already contains [5], and our problem care about the shortest combination, so after comapre lengths, we will keep [5]
// so our table won't change

// 0   1    2    3     4     5    6    7    8
// [] null [2]  [3]  [2,2]  [5]  null null null

// we can go ahead to index 7, it's null, so we can copy array, and add number 5 from numders array

// 0   1    2    3     4     5    6     7     8
// [] null [2]  [3]  [2,2]  [5]  null [2,5]  null

// now iterate our loop, at index 3, we find [3], mean we can generate, and can make our steps

// 0   1    2    3     4     5     6     7      8
// [] null [2]  [3]  [2,2]  [5]  [3,3] [2,5]  [3,5]

// ok, here we find that we reach our goal, and if we complete the algorithm we won't find a shorter cominiation than [3,5] to generate 8

// and complexity 
// same as last time
// time: O(m^2n)
// space: O(m^2)

import java.util.ArrayList;
import java.util.List;

public class BestSumTabulation {
  
  public static List<Integer> bestSum(int targetSum, int[] numbers) {
        // Create a table of size targetSum + 1
        List<Integer>[] table = new List[targetSum + 1];

        // Base case: 0 sum -> empty combination
        table[0] = new ArrayList<>();

        // Loop through all the sums up to targetSum
        for (int i = 0; i <= targetSum; i++) {
            if (table[i] != null) { // If we can make sum i, continue processing
                for (int num : numbers) {
                    int nextIndex = i + num;
                    if (nextIndex <= targetSum) {
                        // Copy the current combination and add the new number
                        List<Integer> combination = new ArrayList<>(table[i]);
                        combination.add(num);
                        // If there's no combination for nextIndex or the new combination is shorter, update
                        if (table[nextIndex] == null || combination.size() < table[nextIndex].size()) {
                            table[nextIndex] = combination;
                        }
                    }
                }
            }
        }
        return table[targetSum]; // Return the combination that adds up to targetSum, or null if no combination exists
    }

  public static void main(String [] args){
    // Examples
        System.out.println(bestSum(8, new int[]{2, 3, 5}));  // [3, 5] (shortest combination)
        System.out.println(bestSum(7, new int[]{5, 3, 4}));  // [4, 3]
        System.out.println(bestSum(8, new int[]{1, 2, 5}));  // [2, 2, 2, 2] or [3, 5]
        System.out.println(bestSum(10, new int[]{2, 3, 4})); // [2, 2, 2, 2, 2] or [4, 3, 3]
        System.out.println(bestSum(100, new int[]{1, 50, 25})); // [50, 50]
  }
}
