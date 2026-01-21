# Dynamic Programming Notes (Memoization – Top-Down)

These notes summarize the core ideas and patterns used when solving
Dynamic Programming problems using **memoization (top-down DP)** and **tabulation (Bottom-Up DP).**
All examples in this repository follow this structure.

---

## What is Dynamic Programming?

Dynamic Programming (DP) is an optimization technique used to solve problems
that have:
- **Overlapping subproblems**
- **Optimal substructure**

Instead of recalculating the same subproblems multiple times,
we store their results and reuse them.

---

## Part 1: Memoization Recipe (Top-Down DP)

This is the standard process used in all memoization problems.

### Step 1️⃣: Make it Work (Brute Force)

Before optimizing, always solve the problem using plain recursion.

- Visualize the problem as a **recursion tree**
- Implement the recursive solution
- Identify **base cases**
- Test with small inputs

At this stage, the solution is usually **slow** but **correct**.

---

### Step 2️⃣: Make it Efficient (Memoization)

Once the recursive solution works, optimize it:

- Add a **memo** (HashMap or array)
- Before computing a value, check if it exists in the memo
- Store computed results in the memo before returning

> Once Step 1 is correct, Step 2 is usually straightforward.

---

## Problem Classification in DP

Dynamic Programming problems often fall into one of these categories:

### 1️⃣ Decision Problems
Return **true / false**

**Example:**

```text
canSum(targetSum, numbers)
```

**Question:**

> Is it possible to reach the target?

---

### 2️⃣ Combinatoric Problems
Return **any valid combination**

**Example:**

```text
howSum(targetSum, numbers)
```

**Question:**

> What is one way to reach the target?

---

### 3️⃣ Optimization Problems

Return the **best** solution according to a rule

(shortest, largest, minimum cost, etc.)

**Example:**

```text
bestSum(targetSum, numbers)
```

**Question:**

> What is the optimal way to reach the target?

---

## Key Observations

- Recursive solutions often have **exponential time complexity**
- Memoization reduces complexity by avoiding repeated work
- Most DP problems follow the same structure:
  - Base cases
  - Recursive relation
  - Memo storage

---

## Common DP Pattern Used in This Repo

1. Solve recursively
2. Identify repeated subproblems
3. Add memo
4. Improve time complexity

---

## Summary

| Problem | Type         | Return Value  |
| ------- | ------------ | ------------- |
| canSum  | Decision     | boolean       |
| howSum  | Combinatoric | List / Array  |
| bestSum | Optimization | Shortest List |


---

## Part 2: Tabulation (Bottom-Up DP)

Tabulation is the **opposite direction** of memoization.
- Memoization → **Top-Down** (problem → base cases)
- Tabulation → **Bottom-Up** (base cases → final answer)

No recursion is used.

---

### Step 1️⃣: Visualize the Problem as a Table

- Each cell represents a **subproblem**
- The final answer is usually found in the **last cell**

Examples:

- Fibonacci → 1D array
- Grid Traveler → 2D array

---

### Step 2️⃣: Size the Table Based on Inputs

- Fibonacci(n) → table size `n + 1`
- gridTraveler(m, n) → table size `(m + 1) × (n + 1)`

> Always be careful with **off-by-one errors**

---

### Step 3️⃣: Initialize the Table with Default Values

- Arrays are initialized with `0` or `false`
- These default values naturally represent **no ways / no contribution**

This helps when adding values later.

---

### Step 4️⃣: Seed the Trivial Answer (Base Case)

This is the most important step.

Examples:
- `fib(1) = 1`
- `gridTraveler(1,1) = 1`

This value starts the flow of the solution.

---

### Step 5️⃣: Iterate Through the Table

- Use loops instead of recursion
- Move left-to-right, top-to-bottom
- Each cell contributes to future cells

---

### Step 6️⃣: Fill Future Positions Using Current Values

At each cell:
- Distribute its value to reachable next states

Examples:
- Fibonacci:
`table[i] → table[i+1], table[i+2]`

- Grid Traveler:
`table[i][j] → table[i+1][j]` (down)
`table[i][j] → table[i][j+1]` (right)

---

## Key Observations (Tabulation)

- No recursion
- No stack overflow risk
- Very fast for large inputs
- Table shows the entire DP process clearly
- Often easier to debug than memoization

---

## Memoization vs Tabulation

| Aspect              | Memoization | Tabulation       |
| ------------------- | ----------- | ---------------- |
| Direction           | Top-Down    | Bottom-Up        |
| Uses recursion      | Yes         | No               |
| Uses table          | Implicit    | Explicit         |
| Stack overflow risk | Yes         | No               |
| Easier to derive    | Yes         | Sometimes harder |
| Easier to optimize  | Moderate    | High             |

---

## Final Takeaway

- Memoization: think recursively, optimize later
- Tabulation: think iteratively, build from base cases
- Both solve the same class of DP problems
- Choice depends on:
  - Problem structure
  - Input size
  - Personal clarity
