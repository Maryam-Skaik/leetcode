import java.util.HashMap;

/*
 ============================================================================
  canConstruct - Memoization (Top-Down DP)
 ============================================================================
  write a function 'canConstruct(target, wordBank)' that accepts a target string.

  The function should return a boolean indicating whether or not the 'target'
  can be constructed by concatenating elements of the 'wordBank' array.

  You may reuse elements of 'wordBank' as many times as needed.

  Examples:
  canConstruct("abcdef", ["ab","abc","cd","def","abcd"]) -> true (abc + def)
  canConstruct("skateboard", ["bo","rd","ate","t","ska","sk","boar"]) -> false
  canConstruct("", ["cat","dog","mouse"]) -> true (base case)

 ============================================================================
  RECURSION TREE (VISUALIZATION)
 ============================================================================

  canConstruct("abcdef", ["ab","abc","cd","def","abcd"])

              abcdef
      take:   ab     abc     abcd
             cdef    def      ef   <-- ef has no matching → false
      take:  cd      def
              ef      ""      <-- "" is base case → true

  Result → true

 ----------------------------------------------------------------------------

  canConstruct("skateboard", ["bo","rd","ate","t","ska","sk","boar"])

               skateboard
        take:   ska           sk
               teboard        ateboard
        take:     t            ate
                 eboard        board
              (no match)   bo      boar
                            ard      d
                        (no match) (no match)

  Result → false
*/

public class CanConstructMemoization {

    // ------------------------------------------------------------------------
    // BRUTE FORCE RECURSIVE SOLUTION (NO DP)
    // ------------------------------------------------------------------------
    public static boolean canConstruct(String target, String[] wordBank) {
        if (target.equals("")) return true;

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if (canConstruct(suffix, wordBank)) {
                    return true;
                }
            }
        }
        return false;
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
    public static boolean canConstruct(
            String target,
            String[] wordBank,
            HashMap<String, Boolean> memo
    ) {

        // ✅ Check memo FIRST
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        // Base case
        if (target.equals("")) return true;

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());

                if (canConstruct(suffix, wordBank, memo)) {
                    memo.put(target, true); // ✅ store result for THIS target
                    return true;
                }
            }
        }

        memo.put(target, false);
        return false;
    }

    /*
     ============================================================================
      COMPLEXITY (MEMOIZATION)
     ============================================================================
      Time Complexity:  O(n * m^2)
      Space Complexity: O(m^2)

      Why?
      - At most m distinct suffixes
      - Each suffix loops over n words
      - substring operation costs O(m)
    */

    // ------------------------------------------------------------------------
    // MAIN
    // ------------------------------------------------------------------------
    public static void main(String[] args) {

        System.out.println(
                canConstruct("abcdef",
                        new String[]{"ab", "abc", "cd", "def", "abcd"})
        ); // true

        System.out.println(
                canConstruct("skateboard",
                        new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})
        ); // false

        HashMap<String, Boolean> memo = new HashMap<>();

        System.out.println(
                canConstruct(
                        "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                        new String[]{"e","ee","eee","eeee","eeeee","eeeeee"},
                        memo
                )
        ); // false (FAST with memo)
    }
}
