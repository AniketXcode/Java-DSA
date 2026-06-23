# Maximum Element in an Array

A Java program demonstrating how to **find the maximum element in an array** using both a traditional `for` loop and a `for-each` loop. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, find and print the largest (maximum) element present in it.

**Input:**
```
Array: {10, 20, 30, 40, 50}
```

**Expected Output:**
```
Using for-each loop:
Maximum element in the array is: 50
Using traditional for loop:
Maximum element in the array is: 50
```

---

## 💡 Approach

The standard approach to finding the maximum in an unsorted array is a **single-pass linear scan**:

1. **Initialise `max`** with the first element of the array (`arr[0]`). This is a safe baseline since the maximum must be one of the existing elements.
2. **Scan every remaining element** — for each element, compare it with the current `max`. If the element is greater, update `max` to that element.
3. After the loop finishes, `max` holds the largest value seen so far — which is the maximum of the entire array.
4. Both the **traditional `for` loop** (index-based) and the **`for-each` loop** (element-based) apply the same comparison logic and produce the same result. The `for` loop starts from index `1` since index `0` is already used to initialise `max`.

---

## 🧮 Pseudocode

```
START
  DECLARE arr[] = {10, 20, 30, 40, 50}
  SET max = arr[0]

  // Traditional for loop
  FOR i = 1 to arr.length - 1:
      IF arr[i] > max:
          max = arr[i]
      END IF
  END FOR

  // For-each loop (same logic)
  FOR each num IN arr:
      IF num > max:
          max = num
      END IF
  END FOR

  PRINT "Maximum element: " + max
END
```

---

## 💻 Code

```java
public class max_Element {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int max = arr[0];

        // Traditional for loop
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // For-each loop
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println("Using for-each loop:");
        System.out.println("Maximum element in the array is: " + max);
        System.out.println("Using traditional for loop:");
        System.out.println("Maximum element in the array is: " + max);
    }
}
```

---

## 🔍 Dry Run

**Array:** `{10, 20, 30, 40, 50}` | Initial `max = 10`

| Step | Element Compared | `arr[i] > max`? | `max` Updated To |
|------|-----------------|-----------------|-----------------|
| i = 1 | 20 | ✅ Yes | 20 |
| i = 2 | 30 | ✅ Yes | 30 |
| i = 3 | 40 | ✅ Yes | 40 |
| i = 4 | 50 | ✅ Yes | 50 |

**Result:** `max = 50` ✅

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Initialise with `arr[0]`** | Never initialise `max` with `0` or `Integer.MIN_VALUE` unless necessary — using the first element is always safe and correct |
| **Single pass** | Only one traversal of the array is needed — no sorting required |
| **`for` vs `for-each`** | `for` loop starts from index `1` (skipping the initial element); `for-each` visits all elements including `arr[0]`, but `arr[0] > arr[0]` is never true so it's harmless |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | Every element is visited exactly once in a single linear scan; no nested loops. |
| **Space Complexity** | `O(1)` | Only one extra variable (`max`) is used regardless of the array size. |

---