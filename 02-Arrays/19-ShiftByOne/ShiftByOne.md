# Shift Array by One — Right Rotation

A Java program performing a **right circular shift** on an array by one position — the last element wraps around to the front. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, shift all elements one position to the right. The last element wraps around and becomes the first element.

**Input:**
```
Array: {1, 2, 3, 4, 5}
```

**Expected Output:**
```
Original array: [1, 2, 3, 4, 5]
Array after shifting by one: [5, 1, 2, 3, 4]
```

---

## 💡 Approach

1. **Save the last element** — before any shifting, store `arr[arr.length - 1]` in `last`. Without this, the last element would be overwritten and lost during the shift.

2. **Shift right to left** — traverse from the **last index down to index `1`**, and at each position `i`, copy `arr[i - 1]` into `arr[i]`. Iterating **right to left** is critical — going left to right would overwrite values before they are moved forward.

3. **Place saved element at front** — after the shift, set `arr[0] = last` to complete the circular rotation.

> This is a **right rotation by 1** — every element moves one step to the right, and the last element wraps to index `0`.

---

## 🧮 Pseudocode

```
START
  FUNCTION shiftByOne(arr):
      SET last = arr[arr.length - 1]   // save last element

      FOR i = arr.length - 1 downto 1:
          arr[i] = arr[i - 1]          // shift each element right
      END FOR

      arr[0] = last                    // wrap last to front

  BEGIN main():
      DECLARE arr[] = {1, 2, 3, 4, 5}
      PRINT original array
      CALL shiftByOne(arr)
      PRINT shifted array
END
```

---

## 💻 Code

```java
public class ShiftByOne {

    static void shiftByOne(int[] arr) {
        int last = arr[arr.length - 1];       // save last element

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];              // shift right
        }

        arr[0] = last;                        // wrap to front
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Original array:           " + java.util.Arrays.toString(arr));
        shiftByOne(arr);
        System.out.println("Array after shifting by one: " + java.util.Arrays.toString(arr));
    }
}
```

---

## 🔍 Dry Run

**Array:** `{1, 2, 3, 4, 5}` | `last = arr[4] = 5`

**Shift loop (right to left):**

| `i` | Action | Array State |
|-----|--------|-------------|
| 4 | `arr[4] = arr[3]` → 4 moves to index 4 | `{1, 2, 3, 4, 4}` |
| 3 | `arr[3] = arr[2]` → 3 moves to index 3 | `{1, 2, 3, 3, 4}` |
| 2 | `arr[2] = arr[1]` → 2 moves to index 2 | `{1, 2, 2, 3, 4}` |
| 1 | `arr[1] = arr[0]` → 1 moves to index 1 | `{1, 1, 2, 3, 4}` |

**Place saved element:** `arr[0] = last = 5`

**Final:** `{5, 1, 2, 3, 4}` ✅

---

## 📌 Visual — Before and After

```
Before:  [ 1 | 2 | 3 | 4 | 5 ]
           ↓   ↓   ↓   ↓   ↓
           →   →   →   →   ↓
                            └──────────────┐
After:   [ 5 | 1 | 2 | 3 | 4 ]           │
           ↑                              │
           └──────────────────────────────┘
                  (wraps around)
```

---

## ⚠️ Why Traverse Right to Left?

```java
// ✅ Right to left — correct (current approach)
for (int i = arr.length - 1; i > 0; i--) {
    arr[i] = arr[i - 1];  // reads from left, writes to right — safe
}

// ❌ Left to right — WRONG
for (int i = 1; i < arr.length; i++) {
    arr[i] = arr[i - 1];  // arr[i-1] already overwritten — all elements become arr[0]
}
// Result: {1, 1, 1, 1, 1} ❌
```

Traversing **left to right** overwrites each element before it is moved — resulting in every position filled with `arr[0]`.

---

## ⚠️ Edge Cases

| Scenario | Input | Output |
|----------|-------|--------|
| Single element | `{7}` | `{7}` (no change) |
| Two elements | `{1, 2}` | `{2, 1}` |
| All same | `{3, 3, 3}` | `{3, 3, 3}` |
| Already rotated | `{5, 1, 2, 3, 4}` | `{4, 5, 1, 2, 3}` |

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Right rotation** | Every element shifts one step to the right; last wraps to front |
| **Save before shift** | `last = arr[n-1]` must be saved first — it gets overwritten during the shift |
| **Right to left traversal** | Prevents overwriting elements before they are moved |
| **Circular shift** | Different from regular shift — no element is lost, last wraps to position `0` |
| **In-place** | No extra array used — only one `temp` variable (`last`) |

---

## 📌 Left Shift vs Right Shift

| | Right Shift (this program) | Left Shift |
|--|---------------------------|------------|
| **Direction** | Elements move → right | Elements move ← left |
| **Wrap element** | Last → First (`arr[0] = last`) | First → Last (`arr[n-1] = first`) |
| **Loop direction** | Right to left (`i--`) | Left to right (`i++`) |
| **Example** | `{1,2,3,4,5}` → `{5,1,2,3,4}` | `{1,2,3,4,5}` → `{2,3,4,5,1}` |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | Every element except the last is shifted once — `n-1` operations. |
| **Space Complexity** | `O(1)` | Only one extra variable (`last`) used — fully in-place. |

---

## 🏷️ Tags
`Java` `DSA` `Arrays` `Rotation` `Right Shift` `Circular Shift` `In-place` `Beginner`