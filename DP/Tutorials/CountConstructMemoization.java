import java.util.HashMap;

/*
 ============================================================================
  countConstruct - Memoization (Top-Down DP)
 ============================================================================
  Write a function `countConstruct(target, wordBank)` that accepts a target string
  and an array of strings.

  The function should return the number of ways the `target` can be constructed
  by concatenating elements of the `wordBank` array.

  You may reuse elements of 'wordBank' as many times as needed.

  Examples:
  countConstruct("abcdef", ["ab","abc","cd","def","abcd"]) -> 1 (abc + def)
  countConstruct("purple", ["purp","p","ur","le","purpl"]) -> 2

 ============================================================================
  RECURSION TREES
 ============================================================================

  Example 1: countConstruct("abcdef", ["ab","abc","cd","def","abcd"])

              abcdef
      take:   ab      abc     abcd
             cdef     def      ef  <-- ef has no matching → 0
      take:  cd       def
             ef       ""       <-- "" is base case → 1

  Result → 1

 ----------------------------------------------------------------------------

  Example 2: countConstruct("purple", ["purp","p","ur","le","purpl"])

              purple
      take:   purp        p
             ple         urple
           /   \         ...
         le    ...       ...
       (base)  (base)

  Result → 2
*/

public class CountConstructMemoization {

    // ------------------------------------------------------------------------
    // BRUTE FORCE RECURSIVE SOLUTION
    // ------------------------------------------------------------------------
    public static int countConstruct(String target, String[] wordBank) {
        if (target.equals("")) return 1;

        int totalCount = 0;

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                int numWays = countConstruct(suffix, wordBank);
                totalCount += numWays;
            }
        }

        return totalCount;
    }

    /*
     ============================================================================
      COMPLEXITY (BRUTE FORCE)
     ============================================================================
      m = target.length
      n = wordBank.length

      Height of recursion tree = m

      Time Complexity:  O(n^m * m)
      Space Complexity: O(m^2)
    */

    // ------------------------------------------------------------------------
    // MEMOIZED SOLUTION (TOP-DOWN DP)
    // ------------------------------------------------------------------------
    public static int countConstruct(
            String target,
            String[] wordBank,
            HashMap<String, Integer> memo
    ) {
        // ✅ Check memo FIRST
        if (memo.containsKey(target)) return memo.get(target);

        if (target.equals("")) return 1;

        int totalCount = 0;

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                int numWays = countConstruct(suffix, wordBank, memo);
                totalCount += numWays;
            }
        }

        memo.put(target, totalCount);
        return totalCount;
    }

    /*
     ============================================================================
      COMPLEXITY (MEMOIZATION)
     ============================================================================
      Time Complexity:  O(n * m^2)
      Space Complexity: O(m^2)

      Reason:
      - At most m distinct suffixes
      - Each suffix loops over n words
      - substring operation costs O(m)
    */

    // ------------------------------------------------------------------------
    // MAIN
    // ------------------------------------------------------------------------
    public static void main(String[] args) {

        // Brute force examples
        System.out.println(
                countConstruct("abcdef",
                        new String[]{"ab", "abc", "cd", "def", "abcd"})
        ); // 1

        System.out.println(
                countConstruct("purple",
                        new String[]{"purp","p","ur","le","purpl"})
        ); // 2

        // Memoized examples
        HashMap<String, Integer> memo = new HashMap<>();

        System.out.println(
                countConstruct(
                        "abcdef",
                        new String[]{"ab", "abc", "cd", "def", "abcd"},
                        memo
                )
        ); // 1 (FAST)

        memo.clear();

        System.out.println(
                countConstruct(
                        "purple",
                        new String[]{"purp","p","ur","le","purpl"},
                        memo
                )
        ); // 2 (FAST)

        memo.clear();

        System.out.println(
                countConstruct(
                        "skateboard",
                        new String[]{"bo","rd","ate","t","ska","sk","boar"},
                        memo
                )
        ); // 0 (FAST)

        memo.clear();

        System.out.println(
                countConstruct(
                        "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                        new String[]{"e","ee","eee","eeee","eeeee","eeeeee"},
                        memo
                )
        ); // 0 (FAST)
    }
}
