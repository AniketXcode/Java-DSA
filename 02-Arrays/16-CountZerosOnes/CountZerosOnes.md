# Count Zeros and Ones in an Array

A Java program that **counts the number of `0`s and `1`s** in a binary array in a single pass using a static method. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given a binary array (containing only `0`s and `1`s), count how many `0`s and how many `1`s are present and print both counts.

**Input:**
```
Array: {0, 1, 0, 1, 1, 0}
```

**Expected Output:**
```
Count of Zeros: 3
Count of Ones: 3
```

---

## 💡 Approach

1. **Initialise two counters** — `countZeros = 0` and `countOnes = 0` to independently track occurrences of each value.

2. **Traverse the array** using a `for-each` loop, visiting each element once.

3. **Classify each element** using an `if-else if` chain:
   - If `num == 0` → increment `countZeros`
   - If `num == 1` → increment `countOnes`

4. **Print both counts** after the loop finishes.

> **Note:** The `if-else if` structure ensures only one branch executes per element. Since the array is binary (only `0`s and `1`s), every element will match exactly one condition.

---

## 🧮 Pseudocode

```
START
  FUNCTION countZerosOnes(arr):
      SET countZeros = 0
      SET countOnes  = 0

      FOR each num IN arr:
          IF num == 0:
              countZeros = countZeros + 1
          ELSE IF num == 1:
              countOnes = countOnes + 1
          END IF
      END FOR

      PRINT "Count of Zeros: " + countZeros
      PRINT "Count of Ones: "  + countOnes

  BEGIN main():
      DECLARE arr[] = {0, 1, 0, 1, 1, 0}
      CALL countZerosOnes(arr)
END
```

---

## 💻 Code

```java
public class CountZerosOnes {

    static void countZerosOnes(int[] arr) {
        int countZeros = 0;
        int countOnes  = 0;

        for (int num : arr) {
            if (num == 0) {
                countZeros++;
            } else if (num == 1) {
                countOnes++;
            }
        }

        System.out.println("Count of Zeros: " + countZeros);
        System.out.println("Count of Ones: "  + countOnes);
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0};
        countZerosOnes(arr);
    }
}
```

---

## 🔍 Dry Run

**Array:** `{0, 1, 0, 1, 1, 0}`

| `num` | `num == 0`? | `num == 1`? | `countZeros` | `countOnes` |
|-------|------------|------------|-------------|------------|
| 0 | ✅ Yes | — | 1 | 0 |
| 1 | ❌ No | ✅ Yes | 1 | 1 |
| 0 | ✅ Yes | — | 2 | 1 |
| 1 | ❌ No | ✅ Yes | 2 | 2 |
| 1 | ❌ No | ✅ Yes | 2 | 3 |
| 0 | ✅ Yes | — | 3 | 3 |

**Result:** Zeros = `3`, Ones = `3` ✅

**Verification:** `countZeros + countOnes = 6 = arr.length` ✅

---

## ⚠️ Edge Cases

| Scenario | Input | Zeros | Ones |
|----------|-------|-------|------|
| All zeros | `{0, 0, 0}` | `3` | `0` |
| All ones | `{1, 1, 1}` | `0` | `3` |
| Single zero | `{0}` | `1` | `0` |
| Single one | `{1}` | `0` | `1` |
| Empty array | `{}` | `0` | `0` |
| Starts with one | `{1, 0, 1}` | `1` | `2` |

---

## ⚡ Smarter Alternative — Single Counter

Since the array is binary, knowing one count gives the other for free:

```java
static void countZerosOnes(int[] arr) {
    int countOnes = 0;

    for (int num : arr) {
        if (num == 1) countOnes++;
    }

    int countZeros = arr.length - countOnes;  // derive zeros from total

    System.out.println("Count of Zeros: " + countZeros);
    System.out.println("Count of Ones: "  + countOnes);
}
```

One counter instead of two — valid because `zeros + ones = arr.length` in a binary array.

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Binary array** | An array containing only `0`s and `1`s — every element matches exactly one condition |
| **Two counters** | Independent variables tracking each value's frequency |
| **`if-else if`** | Mutually exclusive — at most one branch fires per element |
| **Verification** | `countZeros + countOnes` must equal `arr.length` — useful sanity check |
| **Single counter trick** | In binary arrays, `countZeros = arr.length - countOnes` — halves the tracking needed |

---

## 📌 Relation to Sorting — Dutch National Flag

Counting zeros and ones is the foundation of the **Dutch National Flag problem** — sorting a binary or ternary (`0`, `1`, `2`) array efficiently:

```
Input:  {0, 1, 0, 1, 1, 0}
Sorted: {0, 0, 0, 1, 1, 1}

Strategy: Count zeros = 3, ones = 3
          → Fill first 3 positions with 0
          → Fill next  3 positions with 1
```

This produces a sorted binary array in `O(n)` time — better than any comparison sort.

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | Every element is visited exactly once in a single linear pass. |
| **Space Complexity** | `O(1)` | Only two counter variables are used regardless of array size. |

---