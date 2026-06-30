# Sum of Positive and Negative Numbers

A Java program that **separates and sums positive and negative numbers** in an array in a single pass using a static method. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array containing both positive and negative numbers, compute and print the sum of all positive numbers and the sum of all negative numbers separately.

**Input:**
```
Array: {1, -2, 3, -4, 5}
```

**Expected Output:**
```
Sum of Positive Numbers: 9
Sum of Negative Numbers: -6
```

---

## 💡 Approach

1. **Initialise two accumulators** — `positiveSum = 0` to collect the sum of all positive numbers, and `negativeSum = 0` to collect the sum of all negative numbers.

2. **Traverse the array** using a `for-each` loop, visiting each element once.

3. **Classify each element** using an `if-else if` chain:
   - If `num > 0` → it is positive → add to `positiveSum`.
   - If `num < 0` → it is negative → add to `negativeSum`.
   - If `num == 0` → it is neither positive nor negative → both conditions are skipped, `0` is not added to either sum (no effect anyway since adding `0` changes nothing).

4. **Print both sums** after the loop completes.

---

## 🧮 Pseudocode

```
START
  FUNCTION sumPositiveNegative(arr):
      SET positiveSum = 0
      SET negativeSum = 0

      FOR each num IN arr:
          IF num > 0:
              positiveSum = positiveSum + num
          ELSE IF num < 0:
              negativeSum = negativeSum + num
          END IF

      PRINT "Sum of Positive Numbers: " + positiveSum
      PRINT "Sum of Negative Numbers: " + negativeSum

  BEGIN main():
      DECLARE arr[] = {1, -2, 3, -4, 5}
      CALL sumPositiveNegative(arr)
END
```

---

## 💻 Code

```java
public class SumPositiveNegative {

    static void sumPositiveNegative(int[] arr) {
        int positiveSum = 0;
        int negativeSum = 0;

        for (int num : arr) {
            if (num > 0) {
                positiveSum += num;
            } else if (num < 0) {
                negativeSum += num;
            }
        }

        System.out.println("Sum of Positive Numbers: " + positiveSum);
        System.out.println("Sum of Negative Numbers: " + negativeSum);
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5};
        sumPositiveNegative(arr);
    }
}
```

---

## 🔍 Dry Run

**Array:** `{1, -2, 3, -4, 5}`

| `num` | `num > 0`? | `num < 0`? | `positiveSum` | `negativeSum` |
|-------|-----------|-----------|--------------|--------------|
| 1 | ✅ Yes | — | 1 | 0 |
| -2 | ❌ No | ✅ Yes | 1 | -2 |
| 3 | ✅ Yes | — | 4 | -2 |
| -4 | ❌ No | ✅ Yes | 4 | -6 |
| 5 | ✅ Yes | — | 9 | -6 |

**Result:** Positive Sum = `9`, Negative Sum = `-6` ✅

**Verification:** `1 + 3 + 5 = 9` ✅ | `-2 + (-4) = -6` ✅

---

## ⚠️ Edge Cases

| Scenario | Input | Positive Sum | Negative Sum |
|----------|-------|-------------|-------------|
| All positive | `{1, 2, 3}` | `6` | `0` |
| All negative | `{-1, -2, -3}` | `0` | `-6` |
| Contains zero | `{0, 2, -3}` | `2` | `-3` |
| All zeros | `{0, 0, 0}` | `0` | `0` |
| Single element (positive) | `{5}` | `5` | `0` |
| Single element (negative) | `{-5}` | `0` | `-5` |

> **Zero handling:** `0` is classified as neither positive nor negative — the `if (num > 0)` and `else if (num < 0)` conditions both skip it cleanly. No separate `else` needed.

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Two accumulators** | `positiveSum` and `negativeSum` track separate running totals in one pass |
| **`if-else if` chain** | Only one branch executes per element — mutually exclusive conditions |
| **Zero handling** | `0` is skipped by both conditions naturally — no special case needed |
| **`negativeSum` starts at `0`** | Adding negatives makes it decrease — final result is correctly negative |
| **Single pass** | Both sums are computed in one `O(n)` traversal — no need for two separate loops |
| **`void` return** | Results are printed inside the method — no return value needed |

---

## ⚡ Extended Version — Also Count & Find Average

```java
static void analyse(int[] arr) {
    int positiveSum = 0, negativeSum = 0;
    int posCount    = 0, negCount    = 0;

    for (int num : arr) {
        if (num > 0) { positiveSum += num; posCount++; }
        else if (num < 0) { negativeSum += num; negCount++; }
    }

    System.out.println("Positive Sum: " + positiveSum + " | Count: " + posCount);
    System.out.println("Negative Sum: " + negativeSum + " | Count: " + negCount);

    if (posCount > 0)
        System.out.println("Positive Avg: " + (double) positiveSum / posCount);
    if (negCount > 0)
        System.out.println("Negative Avg: " + (double) negativeSum / negCount);
}
```

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | Every element is visited exactly once — single linear pass. |
| **Space Complexity** | `O(1)` | Only two accumulator variables are used regardless of array size. |

---