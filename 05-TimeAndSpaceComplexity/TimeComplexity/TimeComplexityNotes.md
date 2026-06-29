# Time Complexity

A Java program demonstrating **5 fundamental time complexities** — `O(1)`, `O(n)`, `O(n²)`, `O(log n)`, and `O(n log n)` — with concrete code patterns that produce each complexity. This is part of the Algorithm Fundamentals section under Data Structures & Algorithms practice.

---

## 📌 What is Time Complexity?

Time complexity measures **how the number of operations an algorithm performs grows** as the input size `n` increases. It does not measure actual clock time — it measures the **rate of growth** of operations.

> **Focus:** Worst-case scenario. Drop constants and lower-order terms.

---

## 💻 Code

```java
public class TimeComplexity {

    public static void main(String[] args) {

        int n = 5;

        // O(1) - Constant Time
        System.out.println("O(1)");
        System.out.println(n);

        // O(n) - Linear Time
        System.out.println("\nO(n)");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }

        // O(n²) - Quadratic Time
        System.out.println("\n\nO(n²)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        }

        // O(log n) - Logarithmic Time
        System.out.println("\nO(log n)");
        for (int i = 1; i < n; i *= 2) {
            System.out.print(i + " ");
        }

        // O(n log n)
        System.out.println("\n\nO(n log n)");
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        }
    }
}
```

---

## 💡 Approach — All 5 Complexities Explained

### 1. `O(1)` — Constant Time
```java
System.out.println(n);
```
A single statement that executes **exactly once** regardless of `n`. Whether `n = 5` or `n = 5,000,000`, only one operation is performed.

**Pattern:** Any fixed number of statements with no loops.

---

### 2. `O(n)` — Linear Time
```java
for (int i = 0; i < n; i++) {
    System.out.print(i + " ");
}
```
The loop runs **once for every unit of `n`**. If `n` doubles, the number of operations doubles — a direct, linear relationship.

**Pattern:** A single loop from `0` to `n`.

---

### 3. `O(n²)` — Quadratic Time
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.print("(" + i + "," + j + ") ");
    }
}
```
The inner loop runs `n` times for **each** of the outer loop's `n` iterations → total = `n × n = n²` operations.

**Pattern:** Two nested loops both running `0` to `n`.

---

### 4. `O(log n)` — Logarithmic Time
```java
for (int i = 1; i < n; i *= 2) {
    System.out.print(i + " ");
}
```
Instead of incrementing by `1` each step, `i` is **multiplied by `2`** (`i *= 2`). This means the loop reaches `n` in approximately `log₂(n)` steps — the problem size is **halved** (or doubled, from the other direction) each iteration.

**Pattern:** Loop variable multiplied (or divided) each iteration instead of added/subtracted.

| `n` | Steps (`i` values) | Total Steps |
|-----|-------------------|-------------|
| 8 | 1, 2, 4 | 3 = log₂(8) |
| 16 | 1, 2, 4, 8 | 4 = log₂(16) |
| 32 | 1, 2, 4, 8, 16 | 5 = log₂(32) |

---

### 5. `O(n log n)` — Linearithmic Time
```java
for (int i = 0; i < n; i++) {           // runs n times
    for (int j = 1; j < n; j *= 2) {   // runs log n times
        System.out.print("(" + i + "," + j + ") ");
    }
}
```
The outer loop runs `n` times; the inner loop runs `log n` times for each outer iteration → total = `n × log n` operations.

**Pattern:** Outer linear loop + inner logarithmic loop (or merge sort's divide & conquer).

---

## 🔍 Dry Run — Operation Count

**With `n = 5`:**

| Complexity | Loop Pattern | Operations for n=5 |
|------------|-------------|-------------------|
| `O(1)` | No loop | 1 |
| `O(n)` | `i = 0,1,2,3,4` | 5 |
| `O(n²)` | all `(i,j)` pairs | 25 |
| `O(log n)` | `i = 1,2,4` | 3 |
| `O(n log n)` | 5 rows × 3 cols | 15 |

**`O(log n)` trace for n=5:**
```
i=1  → 1 < 5 ✅ → print 1 → i = 1×2 = 2
i=2  → 2 < 5 ✅ → print 2 → i = 2×2 = 4
i=4  → 4 < 5 ✅ → print 4 → i = 4×2 = 8
i=8  → 8 < 5 ❌ → loop ends
Output: 1 2 4
```

---

## 📊 Growth Comparison Table

| `n` | `O(1)` | `O(log n)` | `O(n)` | `O(n log n)` | `O(n²)` |
|-----|--------|-----------|--------|-------------|---------|
| 1 | 1 | 0 | 1 | 0 | 1 |
| 8 | 1 | 3 | 8 | 24 | 64 |
| 16 | 1 | 4 | 16 | 64 | 256 |
| 64 | 1 | 6 | 64 | 384 | 4,096 |
| 1,024 | 1 | 10 | 1,024 | 10,240 | 1,048,576 |
| 1,000,000 | 1 | 20 | 1,000,000 | 20,000,000 | 10¹² |

---

## 📌 Loop Pattern → Complexity Cheatsheet

```java
// O(1) — no loop
statement;

// O(n) — single loop, i++
for (int i = 0; i < n; i++) { }

// O(n²) — nested loops, both i++ and j++
for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) { }

// O(log n) — loop variable multiplied/divided
for (int i = 1; i < n; i *= 2) { }
for (int i = n; i > 1; i /= 2) { }

// O(n log n) — outer linear + inner logarithmic
for (int i = 0; i < n; i++)
    for (int j = 1; j < n; j *= 2) { }

// O(n²) — nested with different bounds (still n²)
for (int i = 0; i < n; i++)
    for (int j = i; j < n; j++) { }  // n(n+1)/2 = O(n²)
```

---

## 📌 Real Algorithm Examples

| Algorithm | Time Complexity | Loop Pattern |
|-----------|----------------|-------------|
| Array access | `O(1)` | No loop |
| Linear Search | `O(n)` | Single loop |
| Binary Search | `O(log n)` | Halve each iteration |
| Bubble Sort | `O(n²)` | Two nested loops |
| Merge Sort | `O(n log n)` | Divide + linear merge |
| Quick Sort (avg) | `O(n log n)` | Partition + recurse |

---

## ⏱️ Complexity Analysis of This Program

| Block | Time | Space |
|-------|------|-------|
| `O(1)` block | `O(1)` | `O(1)` |
| `O(n)` block | `O(n)` | `O(1)` |
| `O(n²)` block | `O(n²)` | `O(1)` |
| `O(log n)` block | `O(log n)` | `O(1)` |
| `O(n log n)` block | `O(n log n)` | `O(1)` |
| **Overall** | **`O(n²)`** (dominant term) | **`O(1)`** |

---
