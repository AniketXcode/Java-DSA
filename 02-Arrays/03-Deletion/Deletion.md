# Array Deletion — Delete an Element at a Specific Index

A Java program demonstrating how to **delete an element at a given index** in an array by shifting elements to the left. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array of 5 elements, delete the element at a specific index by shifting all elements from that index onwards one position to the left, effectively overwriting the deleted element.

**Input:**
```
Array : {10, 20, 30, 40, 50}
Index : 2
```

**Expected Output:**
```
Array after deletion:
10 20 40 50
```

---

## 💡 Approach

1. **Record the logical size** — store `arr.length` in a `size` variable so it can be decremented independently after deletion (since the physical array size in Java cannot change).
2. **Shift elements left** — traverse the array **from `index` to `size - 2`**, and for each position `i`, overwrite `arr[i]` with `arr[i + 1]`. Iterating **left to right** is critical here — going right to left would overwrite elements before they are shifted forward, causing data loss.
3. **Decrement `size`** — reduce the logical size by `1` to reflect that one element has been removed. The last element still physically exists in memory but is ignored in all future operations since it's now out of the logical boundary.
4. **Print the updated array** — traverse from `0` to `size - 1` and print each element.

---

## 🧮 Pseudocode

```
START
  DECLARE arr[] = {10, 20, 30, 40, 50}
  SET size  = arr.length         // 5
  SET index = 2

  // Shift elements left from index onwards
  FOR i = index to (size - 2):
      arr[i] = arr[i + 1]
  END FOR

  size = size - 1

  PRINT "Array after deletion:"
  FOR i = 0 to size - 1:
      PRINT arr[i]
  END FOR
END
```

---

## 💻 Code

```java
public class Deletion {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};
        int size = arr.length;

        int index = 2;

        // Shift elements to the left
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        size--;

        System.out.println("Array after deletion:");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

---

## 🔍 Dry Run

**Before deletion:** `{10, 20, 30, 40, 50}` | size = 5 | index = 2

| Iteration | `i` | Action | Array State |
|-----------|-----|--------|-------------|
| 1 | 2 | `arr[2] = arr[3]` → 40 overwrites 30 | `{10, 20, 40, 40, 50}` |
| 2 | 3 | `arr[3] = arr[4]` → 50 overwrites 40 | `{10, 20, 40, 50, 50}` |
| — | — | `size--` → logical size becomes 4 | `{10, 20, 40, 50, [50]}` |

> The last `50` in brackets is still in memory but **outside the logical boundary** (`size = 4`) so it is never accessed or printed.

**After deletion:** `10 20 40 50` ✅

---

## ⚖️ Insertion vs Deletion — Quick Comparison

| Operation | Direction of Shift | Loop Direction | Extra Space Needed |
|-----------|--------------------|----------------|--------------------|
| **Insertion** | Elements shift **right** | Right to left (`i = size` down to `index + 1`) | Yes — one extra slot |
| **Deletion** | Elements shift **left** | Left to right (`i = index` to `size - 2`) | No |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | In the worst case (deleting at index `0`), all `n - 1` remaining elements must be shifted one position to the left, giving linear time. |
| **Space Complexity** | `O(1)` | The shift is done in-place — no additional data structure is used; only a fixed number of variables (`size`, `index`, `i`) are needed. |

---