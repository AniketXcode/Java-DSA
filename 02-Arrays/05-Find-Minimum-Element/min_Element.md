# Minimum Element in an Array

A Java program demonstrating how to **find the minimum element in an array** using both a traditional `for` loop and a `for-each` loop. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, find and print the smallest (minimum) element present in it.

**Input:**
```
Array: {10, 20, 30, 40, 50}
```

**Expected Output:**
```
Using for-each loop:
Minimum element in the array is: 10
Using traditional for loop:
Minimum element in the array is: 10
```

---

## 💡 Approach

The standard approach to finding the minimum in an unsorted array is a **single-pass linear scan**:

1. **Initialise `min`** with the first element of the array (`arr[0]`). This is a safe baseline since the minimum must be one of the existing elements.
2. **Scan every remaining element** — for each element, compare it with the current `min`. If the element is smaller, update `min` to that element.
3. After the loop finishes, `min` holds the smallest value seen — which is the minimum of the entire array.
4. Both the **traditional `for` loop** (index-based) and the **`for-each` loop** (element-based) apply the same comparison logic and produce the same result. The `for` loop starts from index `1` since index `0` is already used to initialise `min`.

---

## 🧮 Pseudocode

```
START
  DECLARE arr[] = {10, 20, 30, 40, 50}
  SET min = arr[0]

  // Traditional for loop
  FOR i = 1 to arr.length - 1:
      IF arr[i] < min:
          min = arr[i]
      END IF
  END FOR

  // For-each loop (same logic)
  FOR each num IN arr:
      IF num < min:
          min = num
      END IF
  END FOR

  PRINT "Minimum element: " + min
END
```

---

## 💻 Code

```java
public class min_Element {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int min = arr[0];

        // Traditional for loop
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // For-each loop
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }

        System.out.println("Using for-each loop:");
        System.out.println("Minimum element in the array is: " + min);
        System.out.println("Using traditional for loop:");
        System.out.println("Minimum element in the array is: " + min);
    }
}
```

---

## 🔍 Dry Run

**Array:** `{10, 20, 30, 40, 50}` | Initial `min = 10`

| Step | Element Compared | `arr[i] < min`? | `min` Updated To |
|------|-----------------|-----------------|-----------------|
| i = 1 | 20 | ❌ No | 10 |
| i = 2 | 30 | ❌ No | 10 |
| i = 3 | 40 | ❌ No | 10 |
| i = 4 | 50 | ❌ No | 10 |

**Result:** `min = 10` ✅

> Since the array is already sorted in ascending order, the first element `10` is the minimum and no update is ever triggered.

---

## ⚖️ Max vs Min — Quick Comparison

| | Max Element | Min Element |
|--|-------------|-------------|
| **Initialise with** | `arr[0]` | `arr[0]` |
| **Comparison** | `arr[i] > max` | `arr[i] < min` |
| **Update when** | Current element is larger | Current element is smaller |
| **Time Complexity** | `O(n)` | `O(n)` |
| **Space Complexity** | `O(1)` | `O(1)` |

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Initialise with `arr[0]`** | Never initialise `min` with a large number like `Integer.MAX_VALUE` unless necessary — using the first element is always safe and correct |
| **Single pass** | Only one traversal of the array is needed — no sorting required |
| **`for` vs `for-each`** | `for` loop starts from index `1` (skips initial element); `for-each` visits all elements including `arr[0]`, but `arr[0] < arr[0]` is never true so it's harmless |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | Every element is visited exactly once in a single linear scan; no nested loops. |
| **Space Complexity** | `O(1)` | Only one extra variable (`min`) is used regardless of the array size. |

---
