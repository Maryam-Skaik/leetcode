
// Write a function 'canSum(targetSum, numbers)` that takes in a targetSum and an array of numbers as arguments.

// The function should return a boolean indicating whether or not it is possible to generate the targetSum using numbers from the array.

// You may use an element of the array as many times as needed.

// You may assume that all input numbers are nonnigative.

// canSum(7, [5, 3, 4]) -> true
// fisrt I will create and array of size of my targetSum + 1
// we must return boolean, then I must store boolean in my array, start with false

// 0 1 2 3 4 5 6 7
// f f f f f f f f

// ok, since canSum(0, [...]) -> true, so this our start, by make arr[0] = true
// true here mean that it's possible to generate 0 using the numbers in the array, so we will fill the rest of the array accordingly.

// 0 1 2 3 4 5 6 7
// t f f f f f f f


// then we will look to the first number in the array, which in our example is 5, so we can generate 5
// 0 1 2 3 4 5 6 7
// t f f f f t f f

// so here we fill the position 0 + first number in the array, mean 0 + 5, and we will still adding 5 and make them t, since it's possible to generate them also
// mean if I have index 10, with 5 + 5, then here I must fill it with True

// let's loop and go to second number in our array which 3,
// so will make index 3 = t, and 3 + 3 is also t which 6, mean we walk more 3 steps

// 0 1 2 3 4 5 6 7
// t f f t f t t f

// same with last number in the array which 4

// 0 1 2 3 4 5 6 7
// t f f t t t t f

//  after this we will loop and go to second index in our boolean array, which index 1, we find it contain false, mean that we can't generate 1 from elements in the numbers array
// so I will skip and and keep iterate

// go to index 2 which also contains false, skip it and continue iterate

// we arrive to index , which contain true, that mean we can generate using the numbers array, so we will add the valuse from numbers array to this index,
// first one is which is bigger than the rest of the array, so we will skip
// and add 3, and 4 to 3, so indices 6 and 7 will become true

// 0 1 2 3 4 5 6 7
// t f f t t t t t

// keep doing this process, at the end we have true at last index, mean we can generate true using numbers of array

// complexity

// m = targetSum 
// n = numbers.length

// time: O(mn)
// space: O(m)

