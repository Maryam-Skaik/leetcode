# Dynamic Programming Notes (Memoization – Top-Down)

These notes summarize the core ideas and patterns used when solving
Dynamic Programming problems using **memoization (top-down DP)**.
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

## Memoization Recipe (Top-Down DP)

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
