
// Write a function `countConstruct(target, wordBank)` that accepts a target string and an array of strings.

// The function should return the number of ways the `target` can be constructed by concatenating elements of the `wordBank` array.

// You may reuse elements of 'wordBank' as many times as needed.

// countConstruct("abcdef", ["ab","abc","cd","def","abcd"]) -> 1 (abc + def)
// countConstruct("purple", ["purp","p","ur","le","purpl"]) -> 2

// as we did before, first is to generate our table, with size = target.length + 1
// and what we will fill it ?? the answer is fill it with zeros at first

// countConstruct("purple", ["purp","p","ur","le","purpl"]) 

// 0 1 2 3 4 5 6
// 0 0 0 0 0 0 0

// and same as previous problem, we will add character under the array to see if we can construct target

// 0 1 2 3 4 5 6
// 0 0 0 0 0 0 0
// p u r p l e

// now to find the base case, we will find countConstruct("", [...]), which give us 1, mean there is a single way to generate empty string, by concatenating nothing.

// 0 1 2 3 4 5 6
// 1 0 0 0 0 0 0
// p u r p l e

// starting our iterations, we now at index 0, we must look at wordBank for all strings starting with p
// first one is "prup", so we walk 4 steps until index 4 and add value in index 0 to value at index 4: 1 + 0 = 1

// 0 1 2 3 4 5 6
// 1 0 0 0 1 0 0
// p u r p l e

// next one is "p", so we walk single step

// 0 1 2 3 4 5 6
// 1 1 0 0 1 0 0
// p u r p l e

// third is "purpl" so we will walk 5 steps

// 0 1 2 3 4 5 6
// 1 1 0 0 1 1 0
// p u r p l e

// next iteration, we now at index 1, where it's values is 1, so we have to check if any strings from wordBank start with u
// we find "ur", so we will walk 2 steps, until index 3

// 0 1 2 3 4 5 6
// 1 1 0 1 1 1 0
// p u r p l e

// next iteration, index 2, it's value is 0, so we skip it

// next, index 3, it's value 1, so we will look for string starts with p from wordBank, so will jsut take "p"
// mean walk single step

// 0 1 2 3 4 5 6
// 1 1 0 1 2 1 0
// p u r p l e

// next iteration, look for l, we find "le", 2 steps

// 0 1 2 3 4 5 6
// 1 1 0 1 2 1 2
// p u r p l e

// so we finish our algorithm

public class CountConstructTabulation{
  
  public static countConstruct(String target, String [] wordBank){
    int table[] = new int[target.length() + 1];

    table[0] = 1;

    for(int i = 0; i <= target.length(); i++){
      if (table[i] > 0) {
        for(String word: wordBank){
          if (i + word.length() <= target.length() && target.substring(i, i + word.length()).equals(word)){
            table[i + word.length()] += table[i] ;
          }
        }
      }
    }
    return table[target.length()];
  }

  public static void main(String [] args){
    // Example 1
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // 1
        // Example 2
        System.out.println(countConstruct("purple", new String[]{"purp","p","ur","le","purpl"})); // 2
        // Example 3
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // 0
        // Example 4 (long example)
        System.out.println(countConstruct(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            new String[]{"e","ee","eee","eeee","eeeee","eeeeee"})); // 0
        // Example 5 (empty string base case)
        System.out.println(countConstruct("", new String[]{"cat","dog","mouse"})); // 1
  }
}
