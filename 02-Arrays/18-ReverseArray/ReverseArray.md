# Reverse Array — Two Pointer Technique

A Java program reversing an array **in-place using the two pointer technique** with a `while` loop and `Arrays.toString()` for clean output. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, reverse its elements in-place and print both the original and reversed arrays.

**Input:**
```
Array: {1, 2, 3, 4, 5}
```

**Expected Output:**
```
Original array: [1, 2, 3, 4, 5]
Reversed array: [5, 4, 3, 2, 1]
```

---

## 💡 Approach — Two Pointer Technique

1. **Set two pointers** — `start = 0` (pointing to the first element) and `end = arr.length - 1` (pointing to the last element).

2. **Swap and move** — while `start < end`:
   - Swap `arr[start]` and `arr[end]` using a temporary variable.
   - Move `start` forward (`start++`) and `end` backward (`end--`).

3. **Stop condition** — when `start >= end`, the pointers have met or crossed the centre — all pairs have been swapped and the array is fully reversed.

4. **In-place** — no extra array is used; the original array is modified directly.

5. **`Arrays.toString()`** — prints the array in a clean `[1, 2, 3, 4, 5]` format without writing a manual print loop.

---

## 🧮 Pseudocode

```
START
  FUNCTION reverseArray(arr):
      SET start = 0
      SET end   = arr.length - 1

      WHILE start < end:
          SWAP arr[start] and arr[end]
          start = start + 1
          end   = end - 1
      END WHILE

  BEGIN main():
      DECLARE arr[] = {1, 2, 3, 4, 5}
      PRINT original array
      CALL reverseArray(arr)
      PRINT reversed array
END
```

---

## 💻 Code

```java
public class ReverseArray {

    static void reverseArray(int[] arr) {
        int start = 0;
        int end   = arr.length - 1;

        while (start < end) {
            // Swap arr[start] and arr[end]
            int temp   = arr[start];
            arr[start] = arr[end];
            arr[end]   = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Original array: " + java.util.Arrays.toString(arr));
        reverseArray(arr);
        System.out.println("Reversed array: " + java.util.Arrays.toString(arr));
    }
}
```

---

## 🔍 Dry Run

**Array:** `{1, 2, 3, 4, 5}` | `start = 0`, `end = 4`

| Iteration | `start` | `end` | `start < end`? | Swap | Array State |
|-----------|---------|-------|---------------|------|-------------|
| 1 | 0 | 4 | ✅ Yes | `arr[0]` ↔ `arr[4]` (1 ↔ 5) | `{5, 2, 3, 4, 1}` |
| 2 | 1 | 3 | ✅ Yes | `arr[1]` ↔ `arr[3]` (2 ↔ 4) | `{5, 4, 3, 2, 1}` |
| 3 | 2 | 2 | ❌ No | — | Loop ends |

> `arr[2]` (value `3`) is the middle element — it never needs to be swapped as it is already in its correct position.

**Result:** `[5, 4, 3, 2, 1]` ✅

---

## 📌 Two Pointer Visualisation

```
Initial:   [ 1 | 2 | 3 | 4 | 5 ]
            ↑               ↑
          start             end

Step 1:   [ 5 | 2 | 3 | 4 | 1 ]
                ↑       ↑
              start     end

Step 2:   [ 5 | 4 | 3 | 2 | 1 ]
                    ↑
               start = end → STOP
```

---

## ⚠️ Even vs Odd Length Arrays

| Length | Middle handled? | Example |
|--------|----------------|---------|
| **Odd** (n=5) | ✅ Middle element stays — `start == end` stops loop | `{1,2,3,4,5}` → `3` stays |
| **Even** (n=4) | ✅ No middle — `start > end` stops loop | `{1,2,3,4}` → all swapped |

Both cases work correctly with `while (start < end)`.

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Two Pointer** | `start` and `end` converge to the centre — classic pattern used in many array problems |
| **In-place swap** | `temp` variable prevents overwriting before saving — essential for correct swap |
| **`while (start < end)`** | Correct termination — `==` means both pointers are at the centre (odd length), no swap needed |
| **`Arrays.toString()`** | `java.util.Arrays.toString(arr)` formats array as `[1, 2, 3]` — cleaner than a manual loop |
| **Pass by reference** | `reverseArray()` modifies the original array directly — no return value needed |

---

## 📌 `for` Loop vs `while` Loop — Two Reversal Styles

```java
// Style 1 — for loop with arr.length / 2
for (int i = 0; i < arr.length / 2; i++) {
    int temp = arr[i];
    arr[i] = arr[arr.length - 1 - i];
    arr[arr.length - 1 - i] = temp;
}

// Style 2 — while loop with two explicit pointers (this version)
int start = 0, end = arr.length - 1;
while (start < end) {
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end]   = temp;
    start++; end--;
}
```

| | `for` loop style | `while` loop style |
|--|-----------------|-------------------|
| **Readability** | Compact | Explicit pointer names |
| **Two Pointer clarity** | 🟡 Index math (`arr.length - 1 - i`) | ✅ Named `start` / `end` |
| **Extensibility** | Same | Easier to adapt for other two-pointer problems |

Both produce identical results — the `while` style with named pointers is preferred in interviews.

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n/2)` = `O(n)` | Only `n/2` swaps are performed — each pair is swapped once. |
| **Space Complexity** | `O(1)` | One `temp` variable used — reversal is completely in-place. |

---

## 🏷️ Tags
`Java` `DSA` `Arrays` `Reverse` `Two Pointer` `In-place` `while loop` `Arrays.toString` `Swap` `Beginner`