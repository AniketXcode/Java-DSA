# Space Complexity

A Java program demonstrating **space complexity** — how memory usage grows relative to input size — with three practical examples: `O(1)`, `O(n)`, and `O(n²)`. This is part of the Algorithm Fundamentals section under Data Structures & Algorithms practice.

---

## 📌 What is Space Complexity?

Space complexity measures the **total memory an algorithm uses** as the input size `n` grows. It includes:

- **Auxiliary space** — extra memory used by the algorithm itself (variables, arrays, call stack)
- **Input space** — memory occupied by the input data

> In most interviews, **space complexity refers to auxiliary space** — the extra space used beyond the input.

---

## 📊 Space Complexities Demonstrated

| Complexity | Name | Memory Used | Example in Code |
|------------|------|-------------|----------------|
| `O(1)` | Constant | Fixed — doesn't grow with `n` | `int a`, `int b`, `int sum` |
| `O(n)` | Linear | Grows proportionally with `n` | `int[] arr = new int[n]` |
| `O(n²)` | Quadratic | Grows as square of `n` | `int[][] matrix = new int[n][n]` |

---

## 💻 Code

```java
public class SpaceComplexity {

    public static void main(String[] args) {

        int n = 5;

        // O(1) - Constant Space
        int a   = 10;
        int b   = 20;
        int sum = a + b;
        System.out.println("O(1): " + sum);

        // O(n) - Linear Space
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        System.out.print("\nO(n): ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // O(n²) - Quadratic Space
        int[][] matrix = new int[n][n];
        System.out.println("\n\nO(n²): Matrix Created");
    }
}
```

**Expected Output:**
```
O(1): 30

O(n): 1 2 3 4 5

O(n²): Matrix Created
```

---

## 💡 Approach

### `O(1)` — Constant Space
```java
int a   = 10;
int b   = 20;
int sum = a + b;
```
Three integer variables are declared — **always exactly 3**, regardless of `n`. If `n` becomes 1 million, memory usage stays the same. No data structure grows with the input.

### `O(n)` — Linear Space
```java
int[] arr = new int[n];
```
An array of size `n` is allocated — **memory grows directly with `n`**. If `n` doubles, the array doubles in size. Each `int` in Java takes 4 bytes, so for `n = 5` → 20 bytes; for `n = 1000` → 4000 bytes.

### `O(n²)` — Quadratic Space
```java
int[][] matrix = new int[n][n];
```
A 2D array (matrix) of size `n × n` is allocated — **memory grows as the square of `n`**. For `n = 5` → 25 integers; for `n = 100` → 10,000 integers; for `n = 1000` → 1,000,000 integers.

---

## 🔍 Dry Run — Memory Usage

**With `n = 5`:**

| Section | Variables / Structure | Memory Cells Used |
|---------|----------------------|------------------|
| `O(1)` | `a`, `b`, `sum` + `n` | 4 integers = constant |
| `O(n)` | `arr[0..4]` | 5 integers = `n` |
| `O(n²)` | `matrix[0..4][0..4]` | 25 integers = `n²` |

**Growth comparison as `n` scales:**

| `n` | `O(1)` | `O(n)` | `O(n²)` |
|-----|--------|--------|---------|
| 5 | 1 | 5 | 25 |
| 10 | 1 | 10 | 100 |
| 100 | 1 | 100 | 10,000 |
| 1,000 | 1 | 1,000 | 1,000,000 |
| 10,000 | 1 | 10,000 | 100,000,000 |

---

## 📌 Time vs Space — The Trade-off

In algorithm design, there is often a **time-space trade-off** — you can use more memory to save time, or use less memory at the cost of more computation:

| Approach | Time | Space | Example |
|----------|------|-------|---------|
| Store results in array | Faster (`O(1)` lookups) | More (`O(n)`) | Memoization / DP |
| Recompute each time | Slower (`O(n)` per query) | Less (`O(1)`) | Recursive Fibonacci without cache |
| In-place algorithm | Same or slower | Less (`O(1)`) | Bubble Sort |
| Extra buffer | Faster | More (`O(n)`) | Merge Sort |

> Choosing between time and space depends on the constraints — memory-limited systems prefer `O(1)` space; speed-critical systems may accept `O(n)` space.

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Auxiliary space** | Extra memory used by the algorithm beyond the input |
| **`O(1)` space** | Fixed number of variables — most efficient |
| **`O(n)` space** | One array/list proportional to input size |
| **`O(n²)` space** | 2D matrix — grows fast, used in grid/DP problems |
| **Stack space** | Recursive calls also consume space — each call adds a frame to the call stack |
| **In-place** | Algorithm that uses `O(1)` auxiliary space, modifying input directly |

---

## ⚡ Space Complexity of Common Structures

| Data Structure | Space |
|---------------|-------|
| Single variable | `O(1)` |
| 1D Array of size n | `O(n)` |
| 2D Array of size n×n | `O(n²)` |
| Recursion depth d | `O(d)` |
| HashMap with n entries | `O(n)` |
| Binary Tree with n nodes | `O(n)` |

---

## 📌 Time vs Space Complexity — Summary

| | **Time Complexity** | **Space Complexity** |
|--|--------------------|--------------------|
| **Measures** | How fast an algorithm runs | How much memory it uses |
| **Unit** | Operations / steps | Memory cells (integers, bytes) |
| **Goal** | Minimize execution time | Minimize memory usage |
| **Best case** | `O(1)` — constant time | `O(1)` — constant space |
| **Key rule** | Drop constants and lower-order terms | Same simplification rules apply |

---

## ⏱️ Complexity Analysis of This Program

| Section | Time Complexity | Space Complexity |
|---------|----------------|-----------------|
| `O(1)` block | `O(1)` | `O(1)` |
| `O(n)` block | `O(n)` | `O(n)` |
| `O(n²)` block | `O(1)` (just declaration) | `O(n²)` |
| **Overall** | `O(n)` | `O(n²)` |

---