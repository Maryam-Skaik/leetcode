
// Write a function `allConstruct(target, wordBank)` that accepts a target string and returns a 2D array containing 
// all ways the target can be constructed by concatenating elements of wordBank.

// Elements of wordBank can be reused as many times as needed.

// allConstruct(abcdef, [ab, abc, cd, def, abcd, ef, c]) -> [
//                                                           [ ab, cd, ef ],
//                                                           [ ab, c, def ],
//                                                           [ abc, def],
//                                                           [ abcd, ef]
//                                                          ]

// as required, we must return 2d array, so here we know what must our table fill with (2D arrays)

// same, to got base case, we must find the empty string result
// allConstruct('', [cat, dog] -> [[]]

// but for case that we can't generate target string we must return empty 1D array
// allConstruct('brids', [cat, dog] -> []


// allConstruct(abcdef, [ab, abc, cd, def, abcd, ef, c]) 

// generate our table of size = target.length + 1

// 0 1 2 3 4 5 6
// a b c d e f

// fill base case (index 0)

//   0   1  2  3  4  5 6 
// [[]] [] [] [] [] [] []
//   a   b  c  d  e  f

// now, let's start iteration, we are now at index 0, look for all strrings atart with a from wordBank
// first we find ab, so we will walk 2 steps until index 2, copy value from index 0 to index 2, and also add ab on it

//   0   1    2    3  4  5 6 
// [[]] [] [[ab]] [] [] [] []
//   a   b    c    d  e  f

// same with abc, and abcd

//   0   1    2     3         4     5 6 
// [[]] [] [[ab]] [[abc]] [[abcd]] [] []
//   a   b    c     d         e     f

// now we can iterate to index 1, we find an empty array, mean we can't generate, so skip

// next at index 2, it contain [[ab]], so we look at all strings starts with c from wordBank

// firts we find cd, so we walk 2 steps, copy ab, and add cd

//   0   1    2     3         4              5 6 
// [[]] [] [[ab]] [[abc]] [[abcd],[ab,cd]]  [] []
//   a   b    c     d         e              f

// same with c

//   0   1    2     3                   4           5 6 
// [[]] [] [[ab]] [[abc],[ab,c]] [[abcd],[ab,cd]]  [] []
//   a   b    c     d                   e           f

// now, we can do the next iteration to be on index 3, where we find [[abc],[ab,c]], so we look for all strings start with d from wordBank

// we just find def, so walk 3 steps

//   0   1    2     3                   4           5            6 
// [[]] [] [[ab]] [[abc],[ab,c]] [[abcd],[ab,cd]]  [] [[abc, def],[ab,c, def]]
//   a   b    c     d                   e           f

// next iteration, look for all strings start with e, it's only ef, so walk 2 steps

//   0   1    2     3                   4           5                        6 
// [[]] [] [[ab]] [[abc],[ab,c]] [[abcd],[ab,cd]]  [] [[abc, def],[ab,c, def],[abcd, ef],[ab,cd, ef]]
//   a   b    c     d                   e           f

// and we fininshedddd, with result -> [[abc, def],[ab,c, def],[abcd, ef],[ab,cd, ef]]

// Exponential complexity

import java.util.*;

public class AllConstructTabulation{

  public static List<List<Integer>> allConstruct(String target, String [] wordBank){
    // table[i] stores all ways to construct target substring of length i
    List<List<List<String>>> table = new ArrayList<>();

    // initialize table with empty lists
    for (int i = 0; i <= target.length(); i++) {
      table.add(new ArrayList<>());
    }

    // base case: empty string
    table.get(0).add(new ArrayList<>()); // [[]]

    for(int i = 0; i <= target.length(); i++){
      for(String word: wordBank){
        if(i + word.length() <= target.length() && target.substring(i, i + word.length()).equals(word)){
          for (List<String> sublist : table.get(i)) {
            List<String> newCombination = new ArrayList<>(sublist);
            newCombination.add(word);
            table.get(i + word.length()).add(newCombination);
          }
        }
      }
    }
    return table.get(target.length());
  }

  public static void main(String[] args) {
    String[] bank1 = {"purp", "p", "ur", "le", "purpl"};
        System.out.println("allConstruct(\"purple\", bank1) -> " + allConstruct("purple", bank1));

        String[] bank2 = {"ab", "abc", "cd", "def", "abcd", "ef", "c"};
        System.out.println("allConstruct(\"abcdef\", bank2) -> " + allConstruct("abcdef", bank2));

        String[] bank3 = {"cat", "dog", "mouse"};
        System.out.println("allConstruct(\"hello\", bank3) -> " + allConstruct("hello", bank3));

        String[] bank4 = {"cat", "dog", "mouse"};
        System.out.println("allConstruct(\"\", bank4) -> " + allConstruct("", bank4));
  }
}
