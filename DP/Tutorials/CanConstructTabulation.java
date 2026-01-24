import java.util.*;

public class CanConstructTabulation {

    // Write a function 'canConstruct(target, wordBank)' that accepts a target string.
    // The function should return a boolean indicating whether or not the 'target' can be constructed by concatenating elements of the 'wordBank' array.
    // You may reuse elements of 'wordBank' as many times as needed.
    // canConstruct("abcdef", ["ab","abc","cd","def","abcd"]) -> true (abc + def)

    // Explanation:
    // as we did before, our table will be with size = target.length + 1
    // mean our target here is abcdef which 6 characters, so our table will be from 0 -> 6 (7)
    // 0 1 2 3 4 5 6
    // also, we want something to connect us with our target string, so our table will become
    // 0 1 2 3 4 5 6
    // a b c d e f
    // also as asked on the problem, we must return a boolean, so logically we must fill our table with boolean
    // so fill it with false
    // 0 1 2 3 4 5 6
    // f f f f f f f
    // a b c d e f

    // Base case:
    // canConstruct("", ["cat","dog","mouse"]) -> true (base case)
    // so we fill 0 index with true, mean we are looking at index 0, mean we are looking at empty string
    // if we are looking at index 1, mean we are looking at string a, and so on
    // mean we look at index 6, we are looking at target string 'abcdef'
    // 0 1 2 3 4 5 6
    // t f f f f f f
    // a b c d e f

    // Algorithm:
    // starting with index 0, where we find true, mean we can generate the empty string using wordBank array
    // now we look ahead using our wordBank
    // if we look at first string from wordBank, it's "ab", and our current position is on "a", next char is "b"
    // that means we can generate "ab" from wordBank, so we walk 2 steps ahead, arrive at index 2, making it true
    // repeat for all words and all indices

    public static boolean canConstruct(String target, String[] wordBank) {
        // Table to store whether target substrings can be constructed
        boolean[] table = new boolean[target.length() + 1];
        table[0] = true; // base case: empty string can always be constructed

        // Iterate through the table, checking each position
        for (int i = 0; i <= target.length(); i++) {
            if (table[i]) { // only consider positions that are reachable
                // Loop through each word in the wordBank
                for (String word : wordBank) {
                    // Check if the word fits starting at position i
                    if (i + word.length() <= target.length() && target.substring(i, i + word.length()).equals(word)) {
                        table[i + word.length()] = true; // mark as reachable
                    }
                }
            }
        }

        // Return the result for the entire target string
        return table[target.length()];
    }

    public static void main(String[] args) {
        // Example 1
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // true
        // Example 2
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // false
        // Example 3
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "t", "o"})); // true
        // Example 4
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e","ee","eee","eeee","eeeee","eeeeee"})); // false
        // Example 5 (base case)
        System.out.println(canConstruct("", new String[]{"cat","dog","mouse"})); // true (base case)
    }
}
