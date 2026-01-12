# Memoization Recipe - Dynamic Programming

The essential steps to solve a problem using memoization:

## 1️⃣ Make it work
- Visualize the problem as a recursion tree.
- Implement the tree using recursion.
- Test it with small examples.

## 2️⃣ Make it efficient
- Add a memo object (e.g., HashMap or array).
- Check the memo first and return stored values if available.
- Store computed return values into the memo.

> Note: Step 2 becomes very easy once step 1 works correctly.
