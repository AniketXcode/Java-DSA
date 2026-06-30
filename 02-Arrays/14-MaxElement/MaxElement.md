# Maximum Element — Using a Static Helper Method

A Java program finding the **maximum element in an array** by extracting the logic into a clean, reusable static method. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, find and return the largest element using a dedicated static method.

**Input:**
```
Array: {3, 5, 2, 8, 1}
```

**Expected Output:**
```
Maximum element in the array: 8
```

---

## 💡 Approach

1. **Initialise `max`** with `arr[0]` — the first element is the safest baseline since the maximum must be one of the existing elements. Never initialise with `0` or `Integer.MIN_VALUE` unless dealing with all-negative arrays.

2. **Traverse from index `1`** — since `arr[0]` is already stored in `max`, the loop starts at `i = 1` to avoid a redundant comparison.

3. **Update `max`** — on each iteration, if `arr[i] > max`, update `max` to `arr[i]`. After the loop, `max` holds the largest value seen.

4. **Return `max`** — the method returns the result to `main()`, which stores it in `maxElement` and prints it.

---

## 🧮 Pseudocode

```
START
  FUNCTION findMax(arr):
      SET max = arr[0]
      FOR i = 1 to arr.length - 1:
          IF arr[i] > max:
              max = arr[i]
          END IF
      END FOR
      RETURN max

  BEGIN main():
      DECLARE arr[] = {3, 5, 2, 8, 1}
      SET maxElement = findMax(arr)
      PRINT "Maximum element: " + maxElement
END
```

---

## 💻 Code

```java
public class MaxElement {

    static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr    = {3, 5, 2, 8, 1};
        int maxElement = findMax(arr);
        System.out.println("Maximum element in the array: " + maxElement);
    }
}
```

---

## 🔍 Dry Run

**Array:** `{3, 5, 2, 8, 1}` | Initial `max = arr[0] = 3`

| `i` | `arr[i]` | `arr[i] > max`? | `max` updated to |
|-----|---------|-----------------|-----------------|
| 1 | 5 | ✅ Yes (5 > 3) | 5 |
| 2 | 2 | ❌ No (2 > 5) | 5 |
| 3 | 8 | ✅ Yes (8 > 5) | 8 |
| 4 | 1 | ❌ No (1 > 8) | 8 |

**Result:** `Maximum element: 8` ✅

---

## ⚠️ Edge Cases

| Scenario | Input | Output |
|----------|-------|--------|
| Single element | `{7}` | `7` |
| Already sorted ascending | `{1,2,3,4,5}` | `5` |
| Already sorted descending | `{5,4,3,2,1}` | `5` (found at index 0) |
| All same elements | `{4,4,4}` | `4` |
| All negative numbers | `{-5,-1,-3}` | `-1` |
| Max at first index | `{9,2,3}` | `9` (no update triggered) |
| Max at last index | `{1,2,9}` | `9` |

---

## ⚠️ Why NOT initialise `max = 0`?

```java
// ❌ Wrong — fails for all-negative arrays
int max = 0;
int[] arr = {-5, -3, -8};
// Loop: no element is > 0 → max stays 0 → incorrect result

// ✅ Correct — first element is always a valid starting point
int max = arr[0];  // -5
// Loop updates: max = -5 → -3 → stays -3 → correct result: -3
```

---

## 📌 Static Method Approach vs In-line Approach

| | **Static Method (this version)** | **Inline in `main()`** |
|--|----------------------------------|------------------------|
| **Reusability** | ✅ Call `findMax()` anywhere | ❌ Logic tied to `main()` |
| **Readability** | ✅ Clean separation of concerns | 🟡 Mixed logic |
| **Testability** | ✅ Easy to unit test | ❌ Hard to test in isolation |
| **Best for** | Larger programs, utility logic | Quick one-off solutions |

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Initialise with `arr[0]`** | Safe baseline — max must be one of the actual elements |
| **Loop from index `1`** | Skips redundant comparison of `arr[0]` with itself |
| **Single pass** | Only one traversal needed — `O(n)` time, `O(1)` space |
| **Return value** | Method returns `int` — result is captured in `maxElement` in `main()` |
| **Static method** | No object needed; called directly as `findMax(arr)` |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | Every element (except `arr[0]`) is visited exactly once in a single linear pass. |
| **Space Complexity** | `O(1)` | Only one extra variable (`max`) is used — no extra data structure allocated. |

---