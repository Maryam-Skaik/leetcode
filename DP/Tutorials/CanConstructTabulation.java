
// write a function 'canConstruct(target, wordBank)' that accepts a target string.

// The function should return a boolean indicating whether or not the 'target' can be constructed by concatenating elements of the 'wordBank' array.

// You may reuse elements of 'wordBank' as many times as needed.

// canConstruct("abcdef", ["ab","abc","cd","def","abcd"]) -> true (abc + def)

// as we did before, our table will be with size = target.length + 1
// mean our target here is abcdef which 6 characters, so our table will be from 0 -> 6 (7)

// 0 1 2 3 4 5 6

// also, we want sothing to connect us with our target string, so our table will become

// 0 1 2 3 4 5 6
// a b c d e f

// also as asked on the problem, we must return a boolean, so logically we must fill our table with boolean
// so fill it with false

// 0 1 2 3 4 5 6
// f f f f f f f

// now we have to find the base case, looking at this example
//canConstruct("", ["cat","dog","mouse"]) -> true (base case)

// so we fill 0 index with true, mean we are looking at index 0, mean we are looking at empty string
// if we are looking at index 1, mean we are looking at string a, ant so on
// mean we look at intix 6, we are looking at target string 'abcdef'

// 0 1 2 3 4 5 6
// t f f f f f f
// a b c d e f


// now we can begin our iteration
// starting with index 0, where we find true, mean we can generate the empty string using wordBank array
// now how we can look ahead using our wordBank
