# Array Insertion — Insert an Element at a Specific Index

A Java program demonstrating how to **insert an element at a given index** in an array by shifting elements to the right. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array of 5 elements with one extra capacity, insert a new element at a specific index by shifting all elements from that index onwards one position to the right.

**Input:**
```
Array  : {10, 20, 30, 40, 50}
Index  : 2
Element: 25
```

**Expected Output:**
```
Array after insertion:
10 20 25 30 40 50
```

---

## 💡 Approach

1. **Allocate extra space** — declare the array with size `6` even though only 5 elements are stored, so there is room to insert a new element without overflow.
2. **Shift elements right** — traverse the array **from the last occupied position (`size`) down to `index + 1`**, and for each position `i`, move the element at `i - 1` one step forward to `i`. Iterating **right to left** is critical here — going left to right would overwrite elements before they are shifted, causing data loss.
3. **Insert the new element** — once the gap at `index` is created by the shift, place the new `element` at `arr[index]`.
4. **Increment `size`** — update the logical size of the array to reflect the newly added element.
5. **Print the updated array** — traverse from `0` to `size - 1` and print each element.

---

## 🧮 Pseudocode

```
START
  DECLARE arr[6] = {10, 20, 30, 40, 50, _}
  SET size    = 5
  SET index   = 2
  SET element = 25

  // Shift elements right from the end down to index+1
  FOR i = size downto (index + 1):
      arr[i] = arr[i - 1]
  END FOR

  // Place the new element at the target index
  arr[index] = element
  size = size + 1

  PRINT "Array after insertion:"
  FOR i = 0 to size - 1:
      PRINT arr[i]
  END FOR
END
```

---

## 💻 Code

```java
public class Insertion {
    public static void main(String[] args) {

        int[] arr = new int[6];

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        int size    = 5;
        int index   = 2;
        int element = 25;

        // Shift elements to the right
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        // Insert the element
        arr[index] = element;
        size++;

        System.out.println("Array after insertion:");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

---

## 🔍 Dry Run

**Before insertion:** `{10, 20, 30, 40, 50, _}` | size = 5 | index = 2 | element = 25

| Iteration | `i` | Action | Array State |
|-----------|-----|--------|-------------|
| 1 | 5 | `arr[5] = arr[4]` → 50 shifts to index 5 | `{10, 20, 30, 40, 50, 50}` |
| 2 | 4 | `arr[4] = arr[3]` → 40 shifts to index 4 | `{10, 20, 30, 40, 40, 50}` |
| 3 | 3 | `arr[3] = arr[2]` → 30 shifts to index 3 | `{10, 20, 30, 30, 40, 50}` |
| — | — | `arr[2] = 25` inserted | `{10, 20, 25, 30, 40, 50}` |

**After insertion:** `{10, 20, 25, 30, 40, 50}` | size = 6 ✅

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | In the worst case (inserting at index `0`), all `n` elements must be shifted one position to the right, giving linear time. |
| **Space Complexity** | `O(1)` | The shift is done in-place — no additional data structure is used; only a fixed number of variables (`size`, `index`, `element`, `i`) are needed. |

---
