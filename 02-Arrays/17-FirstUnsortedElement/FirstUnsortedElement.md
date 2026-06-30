# First Unsorted Element in an Array

A Java program to **find the first element that breaks the sorted order** in an array using a single linear pass. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, find and return the first element that is out of ascending sorted order. If the array is fully sorted, return `-1`.

**Input:**
```
Array: {1, 2, 3, 5, 4, 6}
```

**Expected Output:**
```
First unsorted element: 4
```

---

## 💡 Approach

1. **Start from index `1`** — to detect an out-of-order element, we need to compare each element with its predecessor. Starting from index `1` lets us safely look back at `arr[i - 1]`.

2. **Compare adjacent elements** — at each index `i`, check if `arr[i] < arr[i - 1]`. In a sorted ascending array, every element must be greater than or equal to the previous one. If this condition is violated, `arr[i]` is the first unsorted element.

3. **Return immediately** — as soon as the first violation is found, return `arr[i]` (the value, not the index). Early return means no unnecessary comparisons.

4. **Return `-1`** — if the loop completes without finding any violation, the array is fully sorted — return `-1` as a sentinel value.

---

## 🧮 Pseudocode

```
START
  FUNCTION findFirstUnsortedElement(arr):
      FOR i = 1 to arr.length - 1:
          IF arr[i] < arr[i - 1]:
              RETURN arr[i]       // first element out of order
          END IF
      END FOR
      RETURN -1                   // array is sorted

  BEGIN main():
      DECLARE arr[] = {1, 2, 3, 5, 4, 6}
      SET result = findFirstUnsortedElement(arr)

      IF result != -1:
          PRINT "First unsorted element: " + result
      ELSE:
          PRINT "Array is sorted."
      END IF
END
```

---

## 💻 Code

```java
public class FirstUnsortedElement {

    static int findFirstUnsortedElement(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4, 6};
        int firstUnsortedElement = findFirstUnsortedElement(arr);

        if (firstUnsortedElement != -1) {
            System.out.println("First unsorted element: " + firstUnsortedElement);
        } else {
            System.out.println("Array is sorted.");
        }
    }
}
```

---

## 🔍 Dry Run

**Array:** `{1, 2, 3, 5, 4, 6}`

| `i` | `arr[i]` | `arr[i-1]` | `arr[i] < arr[i-1]`? | Action |
|-----|---------|-----------|---------------------|--------|
| 1 | 2 | 1 | ❌ No | Continue |
| 2 | 3 | 2 | ❌ No | Continue |
| 3 | 5 | 3 | ❌ No | Continue |
| 4 | 4 | 5 | ✅ Yes (4 < 5) | Return `4` |

**Result:** `First unsorted element: 4` ✅

> Index `5` (value `6`) is never even checked — early return stops the loop at the first violation.

---

## ⚠️ Edge Cases

| Scenario | Input | Output |
|----------|-------|--------|
| Already sorted | `{1, 2, 3, 4, 5}` | `-1` → "Array is sorted." |
| Fully reverse sorted | `{5, 4, 3, 2, 1}` | `4` (index 1, first violation) |
| Single element | `{7}` | `-1` → "Array is sorted." |
| Two elements sorted | `{3, 5}` | `-1` |
| Two elements unsorted | `{5, 3}` | `3` |
| Duplicate elements | `{1, 2, 2, 3}` | `-1` (equal is not unsorted) |
| Unsorted at start | `{3, 1, 2}` | `1` |
| Unsorted at end | `{1, 2, 4, 3}` | `3` |

---

## ⚠️ Returns Value, Not Index

```java
return arr[i];   // ✅ returns the element value — e.g. 4
return i;        // ❌ would return index 4 — different meaning
```

The method returns the **actual element** that is out of order, not its position. If the index is also needed, the return type can be changed to `int[]` returning `{arr[i], i}`, or the method can be split.

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Adjacent comparison** | `arr[i] < arr[i-1]` checks if current element breaks ascending order |
| **Start from index `1`** | Index `0` has no predecessor — loop must begin at `1` |
| **Early return** | Stops as soon as first violation found — no wasted comparisons |
| **Returns `-1`** | Sentinel value meaning "not found" / "array is sorted" |
| **Equal elements** | `arr[i] == arr[i-1]` is allowed — only strictly less than triggers return |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | In the worst case (sorted array), every adjacent pair is compared — `n-1` comparisons total. Best case is `O(1)` if first two elements are out of order. |
| **Space Complexity** | `O(1)` | Only the loop variable `i` is used — no extra data structure allocated. |