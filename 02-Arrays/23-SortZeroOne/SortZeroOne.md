# Sort Array of 0s and 1s — Two Pointer Technique

A Java program sorting a binary array (containing only `0`s and `1`s) **in-place using the two pointer technique** — all `0`s to the left, all `1`s to the right. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given a binary array, sort it so all `0`s come before all `1`s, without using any built-in sort function.

**Input:**
```
Array: {0, 1, 0, 1, 1, 0, 1, 0}
```

**Expected Output:**
```
Original array: [0, 1, 0, 1, 1, 0, 1, 0]
Sorted array:   [0, 0, 0, 0, 1, 1, 1, 1]
```

---

## 💡 Approach — Two Pointer

1. **Set two pointers** — `left = 0` starts at the front; `right = arr.length - 1` starts at the back.

2. **Advance `left`** — move `left` forward as long as `arr[left] == 0` (already in correct position) and `left < right`.

3. **Retreat `right`** — move `right` backward as long as `arr[right] == 1` (already in correct position) and `left < right`.

4. **Swap** — when `left` lands on a `1` and `right` lands on a `0` (both out of place), swap them. Then move both pointers inward.

5. **Stop** — when `left >= right`, all elements are in the correct position.

> The algorithm places `0`s on the left and `1`s on the right without ever needing to count or use extra space.

---

## 🧮 Pseudocode

```
START
  FUNCTION sortZeroOne(arr):
      SET left  = 0
      SET right = arr.length - 1

      WHILE left < right:
          WHILE arr[left] == 0 AND left < right:
              left++                    // skip 0s from left

          WHILE arr[right] == 1 AND left < right:
              right--                   // skip 1s from right

          IF left < right:
              SWAP arr[left] and arr[right]
              left++
              right--
          END IF
      END WHILE

  BEGIN main():
      DECLARE arr[] = {0, 1, 0, 1, 1, 0, 1, 0}
      PRINT original array
      CALL sortZeroOne(arr)
      PRINT sorted array
END
```

---

## 💻 Code

```java
import java.util.Arrays;

public class SortZeroOne {

    static void sortZeroOne(int[] arr) {
        int left  = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Skip 0s from left — already in place
            while (arr[left] == 0 && left < right) {
                left++;
            }
            // Skip 1s from right — already in place
            while (arr[right] == 1 && left < right) {
                right--;
            }
            // Swap misplaced 1 (left) with misplaced 0 (right)
            if (left < right) {
                int temp   = arr[left];
                arr[left]  = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0, 1, 0};
        System.out.println("Original array: " + Arrays.toString(arr));
        sortZeroOne(arr);
        System.out.println("Sorted array:   " + Arrays.toString(arr));
    }
}
```

---

## 🔍 Dry Run

**Array:** `{0, 1, 0, 1, 1, 0, 1, 0}` | `left = 0`, `right = 7`

| Step | Action | `left` | `right` | Array State |
|------|--------|--------|---------|-------------|
| Init | — | 0 | 7 | `[0, 1, 0, 1, 1, 0, 1, 0]` |
| Advance `left` | `arr[0]=0` → skip | 1 | 7 | `[0, 1, 0, 1, 1, 0, 1, 0]` |
| Advance `left` | `arr[1]=1` → stop | 1 | 7 | — |
| Retreat `right` | `arr[7]=0` → stop | 1 | 7 | — |
| Swap `arr[1]` ↔ `arr[7]` | 1 ↔ 0 | 2 | 6 | `[0, 0, 0, 1, 1, 0, 1, 1]` |
| Advance `left` | `arr[2]=0` → skip | 3 | 6 | — |
| Advance `left` | `arr[3]=1` → stop | 3 | 6 | — |
| Retreat `right` | `arr[6]=1` → skip | 3 | 5 | — |
| Retreat `right` | `arr[5]=0` → stop | 3 | 5 | — |
| Swap `arr[3]` ↔ `arr[5]` | 1 ↔ 0 | 4 | 4 | `[0, 0, 0, 0, 1, 1, 1, 1]` |
| `left >= right` | Loop ends | 4 | 4 | — |

**Result:** `[0, 0, 0, 0, 1, 1, 1, 1]` ✅

---

## 📌 Two Pointer Visualisation

```
Step 1:  [ 0 | 1 | 0 | 1 | 1 | 0 | 1 | 0 ]
               L                       R
           arr[L]=1 (out of place), arr[R]=0 (out of place) → SWAP

Step 2:  [ 0 | 0 | 0 | 1 | 1 | 0 | 1 | 1 ]
                       L           R
           arr[L]=1 (out of place), arr[R]=0 (out of place) → SWAP

Step 3:  [ 0 | 0 | 0 | 0 | 1 | 1 | 1 | 1 ]
                           L=R → STOP ✅
```

---

## ⚠️ Edge Cases

| Scenario | Input | Output |
|----------|-------|--------|
| Already sorted | `{0,0,1,1}` | `{0,0,1,1}` (no swaps needed) |
| Reverse sorted | `{1,1,0,0}` | `{0,0,1,1}` |
| All zeros | `{0,0,0}` | `{0,0,0}` |
| All ones | `{1,1,1}` | `{1,1,1}` |
| Single element | `{1}` | `{1}` |
| Two elements | `{1,0}` | `{0,1}` |

---

## 📌 Comparison with Count-Based Approach

```java
// Count approach — simpler but two passes
static void sortZeroOne(int[] arr) {
    int countZeros = 0;
    for (int num : arr) if (num == 0) countZeros++;
    for (int i = 0; i < arr.length; i++) arr[i] = (i < countZeros) ? 0 : 1;
}
```

| Approach | Time | Space | Passes | Swaps |
|----------|------|-------|--------|-------|
| **Two Pointer (current)** | `O(n)` | `O(1)` | 1 | Minimum |
| Count-based | `O(n)` | `O(1)` | 2 | 0 (overwrites) |

Both are `O(n)` — two pointer uses **fewer total operations** and is the standard interview answer.

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Two Pointer** | `left` hunts for misplaced `1`s; `right` hunts for misplaced `0`s |
| **Inner `while` loops** | Skip already-correct elements without counting them |
| **Guard `left < right`** | Prevents `left` overtaking `right` inside inner loops |
| **Single pass** | Array is sorted in one traversal — no sorting algorithm overhead |
| **In-place** | No extra array — only `temp` variable for swapping |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | Each element is visited at most once by either `left` or `right` — total movements across both pointers ≤ `n`. |
| **Space Complexity** | `O(1)` | Only `left`, `right`, and `temp` used — fully in-place. |

---

## 🏷️ Tags
`Java` `DSA` `Arrays` `Sorting` `Binary Array` `Two Pointer` `In-place` `Dutch National Flag` `Beginner`