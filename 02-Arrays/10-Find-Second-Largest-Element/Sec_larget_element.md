# Second Largest Element in an Array

A Java program demonstrating how to **find the second largest element in an array** in a single pass without sorting. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, find and print the second largest distinct element present in it. If no such element exists (all elements are equal or array has only one element), print an appropriate message.

**Input:**
```
Array: {5, 2, 9, 1, 7, 6}
```

**Expected Output:**
```
The second largest element is: 7
```

---

## 💡 Approach

A brute force approach would be to sort the array and pick the second last element — but that costs `O(n log n)`. The optimal approach tracks both the largest and second largest in a **single linear pass**:

1. **Initialise both trackers** with `Integer.MIN_VALUE` — the smallest possible integer in Java — so any real array element will immediately replace them on the first comparison.
2. **Traverse the array** and for each element, apply two checks in order:
   - **Check 1 — New largest found:** If `number > largest`, the current `largest` is demoted to `secondLargest`, and `number` becomes the new `largest`.
   - **Check 2 — New second largest found:** Else if `number > secondLargest` AND `number != largest` — the element is strictly between `secondLargest` and `largest`, so it becomes the new `secondLargest`. The `number != largest` guard ensures **duplicate values of the largest** don't get promoted to second largest.
3. **After the loop**, if `secondLargest` is still `Integer.MIN_VALUE`, no valid second largest was found (e.g. all elements are the same). Otherwise, print `secondLargest`.

---

## 🧮 Pseudocode

```
START
  DECLARE numbers[] = {5, 2, 9, 1, 7, 6}
  SET largest       = Integer.MIN_VALUE
  SET secondLargest = Integer.MIN_VALUE

  FOR each number IN numbers:
      IF number > largest:
          secondLargest = largest
          largest       = number
      ELSE IF number > secondLargest AND number != largest:
          secondLargest = number
      END IF
  END FOR

  IF secondLargest == Integer.MIN_VALUE:
      PRINT "There is no second largest element."
  ELSE:
      PRINT "The second largest element is: " + secondLargest
  END IF
END
```

---

## 💻 Code

```java
public class Sec_larget_element {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 7, 6};
        int largest       = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > largest) {
                secondLargest = largest;
                largest       = number;
            } else if (number > secondLargest && number != largest) {
                secondLargest = number;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("There is no second largest element.");
        } else {
            System.out.println("The second largest element is: " + secondLargest);
        }
    }
}
```

---

## 🔍 Dry Run

**Array:** `{5, 2, 9, 1, 7, 6}` | Initial: `largest = MIN`, `secondLargest = MIN`

| Element | Condition Hit | `largest` | `secondLargest` |
|---------|--------------|-----------|----------------|
| 5       | `5 > MIN` → new largest | 5 | MIN |
| 2       | `2 > MIN && 2 != 5` → new 2nd largest | 5 | 2 |
| 9       | `9 > 5` → new largest | 9 | 5 |
| 1       | `1 > 2`? ❌  `1 > 5`? ❌ — no update | 9 | 5 |
| 7       | `7 > 5 && 7 != 9` → new 2nd largest | 9 | 7 |
| 6       | `6 > 7`? ❌ — no update | 9 | 7 |

**Result:** Second largest = `7` ✅

---

## ⚠️ Edge Cases

| Scenario | Input | Output |
|----------|-------|--------|
| All elements same | `{5, 5, 5}` | No second largest |
| Only one element | `{9}` | No second largest |
| Duplicates of largest | `{9, 9, 7}` | `7` (not `9` again) |
| Negative numbers | `{-1, -3, -2}` | `-2` |
| Two distinct elements | `{4, 8}` | `4` |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | The array is traversed exactly once in a single linear pass — no sorting needed. |
| **Space Complexity** | `O(1)` | Only two extra variables (`largest`, `secondLargest`) are used regardless of array size. |

---
