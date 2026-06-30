# Extreme Elements — Max and Min in a Single Pass

A Java program finding **both the maximum and minimum elements** of an array simultaneously in a single linear traversal. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, find and print both the largest (maximum) and smallest (minimum) elements in a single pass.

**Input:**
```
Array: {1, 2, 3, 4, 5}
```

**Expected Output:**
```
Maximum element in the array: 5
Minimum element in the array: 1
```

---

## 💡 Approach

1. **Handle empty array** — check `arr.length == 0` first and return early to avoid `ArrayIndexOutOfBoundsException` when accessing `arr[0]`.

2. **Initialise both trackers** — set `max = arr[0]` and `min = arr[0]`. Using the first element as baseline is always safe since both the maximum and minimum must be actual elements of the array.

3. **Single pass** — traverse the entire array with a `for-each` loop. For each element, run **two independent `if` checks** (not `if-else`):
   - `if (num > max)` → update `max`
   - `if (num < min)` → update `min`

   Using two separate `if` statements (not `if-else if`) ensures both checks always run — a single element could theoretically trigger both (e.g. in a one-element array), and using `else if` would skip the second check whenever the first fires.

4. **Print results** after the loop — both `max` and `min` are found in one pass rather than two separate traversals.

---

## 🧮 Pseudocode

```
START
  FUNCTION findExtremeElements(arr):
      IF arr.length == 0:
          PRINT "Array is empty."
          RETURN
      END IF

      SET max = arr[0]
      SET min = arr[0]

      FOR each num IN arr:
          IF num > max: max = num
          IF num < min: min = num
      END FOR

      PRINT "Maximum: " + max
      PRINT "Minimum: " + min

  BEGIN main():
      DECLARE arr[] = {1, 2, 3, 4, 5}
      CALL findExtremeElements(arr)
END
```

---

## 💻 Code

```java
public class ExtremeElements {

    static void findExtremeElements(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int max = arr[0];
        int min = arr[0];

        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        System.out.println("Maximum element in the array: " + max);
        System.out.println("Minimum element in the array: " + min);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        findExtremeElements(arr);
    }
}
```

---

## 🔍 Dry Run

**Array:** `{1, 2, 3, 4, 5}` | Initial: `max = 1`, `min = 1`

| `num` | `num > max`? | `max` | `num < min`? | `min` |
|-------|-------------|-------|-------------|-------|
| 1 | ❌ (1 > 1) | 1 | ❌ (1 < 1) | 1 |
| 2 | ✅ (2 > 1) | 2 | ❌ (2 < 1) | 1 |
| 3 | ✅ (3 > 2) | 3 | ❌ (3 < 1) | 1 |
| 4 | ✅ (4 > 3) | 4 | ❌ (4 < 1) | 1 |
| 5 | ✅ (5 > 4) | 5 | ❌ (5 < 1) | 1 |

**Result:** Max = `5`, Min = `1` ✅

---

## ⚠️ Edge Cases

| Scenario | Input | Max | Min |
|----------|-------|-----|-----|
| Single element | `{7}` | `7` | `7` |
| All same | `{3, 3, 3}` | `3` | `3` |
| Empty array | `{}` | — | "Array is empty." |
| All negative | `{-5, -1, -3}` | `-1` | `-5` |
| Mixed pos/neg | `{-3, 0, 5, -1}` | `5` | `-3` |
| Already sorted asc | `{1, 2, 3, 4}` | `4` | `1` |
| Already sorted desc | `{4, 3, 2, 1}` | `4` | `1` |

---

## ⚠️ Why Two Separate `if` Statements?

```java
// ✅ Two separate if — both checks always run
if (num > max) max = num;
if (num < min) min = num;

// ❌ if-else if — second check skipped when first fires
if (num > max) {
    max = num;
} else if (num < min) {  // skipped if num > max was true
    min = num;
}
```

With `else if`, if `num > max` is true, the `num < min` check is skipped entirely. For a single-element array or when a new max is also a new min (not possible for same element, but conceptually) this causes issues. Using two `if` statements ensures correctness in all cases.

---

## 📌 Single Pass vs Two Separate Passes

| Approach | Traversals | Time | Space |
|----------|-----------|------|-------|
| **Single pass (this)** | 1 | `O(n)` | `O(1)` |
| Two separate loops | 2 | `O(2n)` = `O(n)` | `O(1)` |

Both are `O(n)` — but single pass is more efficient in practice: fewer iterations, better cache utilisation, and cleaner code.

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Initialise with `arr[0]`** | Safe baseline — both max and min must be actual elements |
| **Two separate `if`** | Both checks run every iteration — `if-else if` would skip the min check when max updates |
| **Empty array guard** | Always check `arr.length == 0` before accessing `arr[0]` to prevent exceptions |
| **Single pass** | Both extremes found in one traversal — efficient and clean |
| **`for-each` loop** | Used since index is not needed — just the values |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | Every element is visited exactly once; two constant-time comparisons per element. |
| **Space Complexity** | `O(1)` | Only two variables (`max`, `min`) used regardless of array size. |

---

## 🏷️ Tags
`Java` `DSA` `Arrays` `Max` `Min` `Extreme Elements` `Single Pass` `Edge Case` `Beginner`