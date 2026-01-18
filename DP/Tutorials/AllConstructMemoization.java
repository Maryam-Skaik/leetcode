import java.util.*;

public class AllConstructMemoization {

    /*
     ============================================================================
      Problem:
      Write a function `allConstruct(target, wordBank)` that accepts a target string
      and returns a 2D array containing all ways the target can be constructed by
      concatenating elements of wordBank.
      
      Notes:
      - Elements of wordBank can be reused as many times as needed.
      - Each sub-array in the 2D array represents one valid combination.
      - Base case: if target is empty, return [[]]
    ============================================================================
    */

    // Brute force solution
    public static List<List<String>> allConstruct(String target, String[] wordBank) {
        if (target.equals("")) {
            List<List<String>> base = new ArrayList<>();
            base.add(new ArrayList<>()); // [[]] base case
            return base;
        }

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordBank);

                for (List<String> way : suffixWays) {
                    List<String> targetWay = new ArrayList<>();
                    targetWay.add(word);
                    targetWay.addAll(way);
                    result.add(targetWay);
                }
            }
        }
        return result;
    }

    // Memoized solution
    public static List<List<String>> allConstruct(String target, String[] wordBank, HashMap<String, List<List<String>>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.equals("")) {
            List<List<String>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordBank, memo);

                for (List<String> way : suffixWays) {
                    List<String> targetWay = new ArrayList<>();
                    targetWay.add(word);
                    targetWay.addAll(way);
                    result.add(targetWay);
                }
            }
        }
        memo.put(target, result);
        return result;
    }

    public static void main(String[] args) {
        // Example 1: purple
        String[] bank1 = {"purp", "p", "ur", "le", "purpl"};
        System.out.println("AllConstruct 'purple': " + allConstruct("purple", bank1));

        // Example 2: abcdef
        String[] bank2 = {"ab","abc","cd","def","abcd","ef","c"};
        System.out.println("AllConstruct 'abcdef': " + allConstruct("abcdef", bank2));

        // Example 3: hello (no solution)
        String[] bank3 = {"cat","dog","mouse"};
        System.out.println("AllConstruct 'hello': " + allConstruct("hello", bank3));

        // Example 4: empty target
        System.out.println("AllConstruct '': " + allConstruct("", bank3));

        // Memoized example
        HashMap<String, List<List<String>>> memo = new HashMap<>();
        System.out.println("AllConstruct 'purple' with memo: " + allConstruct("purple", bank1, memo));
    }

    /*
     ============================================================================
      Complexity:

      Brute Force:
      - Let m = target.length(), n = wordBank.length
      - Time: O(n^m * m) 
        (exponential because we explore every combination)
      - Space: O(m^2) 
        (max recursion depth m, storing lists adds extra factor)

      Memoized:
      - Time: O(n * m^2) 
        (each substring computed once, and we copy lists)
      - Space: O(m^2) 
        (memo stores up to m keys, each with a list of size <= m)
    ============================================================================
    */
}
