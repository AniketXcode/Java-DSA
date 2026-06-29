# Big O Notation

A Java program demonstrating **Big O Notation** — the standard way to describe how an algorithm's time or space requirements grow as the input size increases. This is part of the Algorithm Fundamentals section under Data Structures & Algorithms practice.

---

## 📌 What is Big O Notation?

Big O Notation describes how the **running time or memory usage** of an algorithm grows as the input size (`n`) increases. It focuses on the **worst-case scenario** and expresses performance in terms of growth rate — not exact execution time.

> **Goal:** Compare algorithms and choose the most efficient solution, especially for large inputs.

---

## 📊 Common Big O Complexities

| Big O | Name | Example | Speed |
|-------|------|---------|-------|
| `O(1)` | Constant | Access an array element | ⚡ Fastest |
| `O(log n)` | Logarithmic | Binary Search | 🔥 Very Fast |
| `O(n)` | Linear | Array Traversal | ✅ Good |
| `O(n log n)` | Linearithmic | Merge Sort | 🟡 Acceptable |
| `O(n²)` | Quadratic | Nested Loops | 🟠 Slow |
| `O(2ⁿ)` | Exponential | Recursive Fibonacci | 🔴 Very Slow |
| `O(n!)` | Factorial | Generating Permutations | ❌ Worst |

---

## 📈 Complexity Order (Best → Worst)

```
O(1)          ← Best: constant, doesn't grow with input
   ↓
O(log n)      ← Cuts problem in half each step
   ↓
O(n)          ← Grows linearly with input
   ↓
O(n log n)    ← Slightly worse than linear
   ↓
O(n²)         ← Grows as square of input
   ↓
O(2ⁿ)         ← Doubles with each added element
   ↓
O(n!)         ← Worst: explodes incredibly fast
```

---

## 🔑 Key Rules of Big O

| Rule | Explanation | Example |
|------|-------------|---------|
| **Drop constants** | Constants don't affect growth rate | `O(2n)` → `O(n)` |
| **Drop lower-order terms** | Only the dominant term matters | `O(n² + n)` → `O(n²)` |
| **Worst case** | Always consider the maximum input scenario | Last element in a search |
| **Focus on growth** | Big O is about rate of change, not exact time | `O(n + 100)` → `O(n)` |

**Simplification Examples:**
```
O(2n)        = O(n)      — constant 2 dropped
O(n + 100)   = O(n)      — constant 100 dropped
O(n² + n)    = O(n²)     — lower term n dropped
O(3n² + 5n)  = O(n²)     — constant 3 and lower term 5n dropped
```

---

## 💻 Code

```java
public class BigONotation {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        // O(1) - Constant Time
        System.out.println("O(1): " + arr[2]);

        // O(n) - Linear Time
        System.out.println("\nO(n):");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // O(n²) - Quadratic Time
        System.out.println("\n\nO(n²):");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
            }
        }
    }
}
```

**Expected Output:**
```
O(1): 30

O(n):
10 20 30 40 50

O(n²):
(10, 10)
(10, 20)
...
(50, 50)
```

---

## 🔍 Code Breakdown — Three Complexities Demonstrated

### `O(1)` — Constant Time
```java
System.out.println("O(1): " + arr[2]);
```
- Accessing `arr[2]` is a **direct memory lookup** — it takes the same time regardless of whether the array has 5 elements or 5 million.
- **Operations:** Always exactly `1`.

### `O(n)` — Linear Time
```java
for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + " ");
}
```
- The loop runs once for every element — if the array doubles in size, the time doubles.
- **Operations:** Exactly `n` (where `n = arr.length`).

### `O(n²)` — Quadratic Time
```java
for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < arr.length; j++) {
        System.out.println("(" + arr[i] + ", " + arr[j] + ")");
    }
}
```
- The inner loop runs `n` times for **each** of the outer loop's `n` iterations — total operations = `n × n = n²`.
- For `n = 5`: `25` pairs printed. For `n = 100`: `10,000` pairs. Grows very fast.
- **Operations:** `n²` — every pair of elements is processed.

---

## 📌 Dry Run — Operation Count

**Array:** `{10, 20, 30, 40, 50}` | `n = 5`

| Complexity | Operations for n=5 | Operations for n=100 | Operations for n=1000 |
|------------|-------------------|---------------------|----------------------|
| `O(1)` | 1 | 1 | 1 |
| `O(log n)` | ~2 | ~7 | ~10 |
| `O(n)` | 5 | 100 | 1,000 |
| `O(n log n)` | ~12 | ~664 | ~9,966 |
| `O(n²)` | 25 | 10,000 | 1,000,000 |
| `O(2ⁿ)` | 32 | 1.27 × 10³⁰ | 🔥 Astronomical |
| `O(n!)` | 120 | 9.3 × 10¹⁵⁷ | ❌ Impossible |

---

## 📌 Real-World Algorithm Examples

| Algorithm | Time Complexity | Space Complexity |
|-----------|----------------|-----------------|
| Array access by index | `O(1)` | `O(1)` |
| Linear Search | `O(n)` | `O(1)` |
| Binary Search | `O(log n)` | `O(1)` |
| Bubble Sort | `O(n²)` | `O(1)` |
| Merge Sort | `O(n log n)` | `O(n)` |
| Quick Sort (avg) | `O(n log n)` | `O(log n)` |
| Recursive Fibonacci | `O(2ⁿ)` | `O(n)` |

---

## 💡 Why Big O Matters in Interviews

- Interviewers always ask: **"What is the time and space complexity of your solution?"**
- Two solutions that produce the same output can differ vastly in performance — Big O lets you justify *why* one is better.
- Knowing Big O helps you **optimize** before writing code, not after.

> A solution that works for `n = 100` but fails for `n = 1,000,000` is not a good solution in production.

---

## 📂 Folder Structure

```
Java-DSA/
└── 05-Algorithm-Fundamentals/
    └── 01-Big-O-Notation/
        ├── BigONotation.java
        └── BigONotation.md
```

---

## 🚀 How to Run

```bash
javac BigONotation.java
java BigONotation
```

---

## 🏷️ Tags
`Java` `DSA` `Big O Notation` `Time Complexity` `Space Complexity` `Algorithm Analysis` `Interview Prep` `Beginner`