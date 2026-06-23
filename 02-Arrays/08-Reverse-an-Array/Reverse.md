# Array Reversal — Reverse an Array In-Place

A Java program demonstrating how to **reverse an array in-place** using the two-pointer swapping technique. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, reverse its elements in-place (without using an extra array) and print both the original and reversed arrays.

**Input:**
```
Array: {10, 20, 30, 40, 50}
```

**Expected Output:**
```
Original array:
10 20 30 40 50
Reversed array:
50 40 30 20 10
```

---

## 💡 Approach

The most efficient way to reverse an array is the **in-place two-pointer swap**:

1. Use a single loop running from `i = 0` to `i < arr.length / 2` — this means we only iterate up to the **midpoint** of the array, since each iteration swaps one element from the left with its mirror element from the right. Going beyond the midpoint would un-reverse the already-swapped elements.
2. On each iteration, **swap** `arr[i]` (from the left) with `arr[arr.length - 1 - i]` (its mirror from the right) using a temporary variable `temp`:
   - Save `arr[i]` in `temp`.
   - Overwrite `arr[i]` with `arr[arr.length - 1 - i]`.
   - Write `temp` (the saved original left value) into `arr[arr.length - 1 - i]`.
3. After `arr.length / 2` swaps, the entire array is reversed — no extra array needed.

---

## 🧮 Pseudocode

```
START
  DECLARE arr[] = {10, 20, 30, 40, 50}

  PRINT original array

  FOR i = 0 to (arr.length / 2) - 1:
      SET temp            = arr[i]
      SET arr[i]          = arr[arr.length - 1 - i]
      SET arr[arr.length - 1 - i] = temp
  END FOR

  PRINT reversed array
END
```

---

## 💻 Code

```java
public class Reverse {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Reverse the array in-place
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        System.out.println("Reversed array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
```

---

## 🔍 Dry Run

**Array:** `{10, 20, 30, 40, 50}` | `arr.length / 2 = 2` (loop runs for `i = 0` and `i = 1`)

| `i` | Left (`arr[i]`) | Right (`arr[4-i]`) | After Swap |
|-----|----------------|--------------------|------------|
| 0   | 10             | 50                 | `{50, 20, 30, 40, 10}` |
| 1   | 20             | 40                 | `{50, 40, 30, 20, 10}` |

> The middle element `30` (at index `2`) is never touched since it's already in its correct position after the two swaps.

**Result:** `50 40 30 20 10` ✅

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **In-place** | No second array is used — reversal happens inside the original array, keeping space complexity `O(1)` |
| **`arr.length / 2`** | Integer division automatically floors the result — for even or odd length arrays, this always gives the correct number of swaps needed |
| **`temp` variable** | A temporary holder is necessary to prevent overwriting a value before it's been saved; without it, data is lost during the swap |
| **Mirror index formula** | `arr.length - 1 - i` maps index `i` from the left to its symmetric counterpart from the right |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n/2)` = `O(n)` | The loop runs exactly `n/2` times — each pair of elements is swapped once, covering the entire array in half the iterations. |
| **Space Complexity** | `O(1)` | Reversal is done in-place using only one extra variable (`temp`), regardless of the array size. |

---