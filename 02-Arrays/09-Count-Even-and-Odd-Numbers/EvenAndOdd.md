# Even and Odd Count in an Array

A Java program demonstrating how to **count even and odd numbers in an array** using the modulo operator. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, count the number of even elements and odd elements separately and print both counts.

**Input:**
```
Array: {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
```

**Expected Output:**
```
Even numbers count: 5
Odd numbers count: 5
```

---

## 💡 Approach

1. **Initialise two counters** — `evenCount = 0` and `oddCount = 0` — to track the number of even and odd elements respectively.
2. **Traverse the array** using a `for-each` loop, visiting each element exactly once.
3. **Check divisibility** — for each element, apply the **modulo operator** (`%`):
   - If `number % 2 == 0` → the number is even → increment `evenCount`.
   - Otherwise → the number is odd → increment `oddCount`.
4. **Print the results** after the loop finishes.

> The modulo operator `%` returns the **remainder** of a division. Any number divisible by `2` with remainder `0` is even; any number with remainder `1` is odd.

---

## 🧮 Pseudocode

```
START
  DECLARE numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
  SET evenCount = 0
  SET oddCount  = 0

  FOR each number IN numbers:
      IF number % 2 == 0:
          evenCount = evenCount + 1
      ELSE:
          oddCount = oddCount + 1
      END IF
  END FOR

  PRINT "Even numbers count: " + evenCount
  PRINT "Odd numbers count: "  + oddCount
END
```

---

## 💻 Code

```java
public class EvenAndOdd {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int evenCount = 0;
        int oddCount  = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even numbers count: " + evenCount);
        System.out.println("Odd numbers count: "  + oddCount);
    }
}
```

---

## 🔍 Dry Run

**Array:** `{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}`

| Element | `number % 2` | Even? | `evenCount` | `oddCount` |
|---------|-------------|-------|-------------|-----------|
| 1       | 1           | ❌    | 0           | 1         |
| 2       | 0           | ✅    | 1           | 1         |
| 3       | 1           | ❌    | 1           | 2         |
| 4       | 0           | ✅    | 2           | 2         |
| 5       | 1           | ❌    | 2           | 3         |
| 6       | 0           | ✅    | 3           | 3         |
| 7       | 1           | ❌    | 3           | 4         |
| 8       | 0           | ✅    | 4           | 4         |
| 9       | 1           | ❌    | 4           | 5         |
| 10      | 0           | ✅    | 5           | 5         |

**Result:** Even = `5`, Odd = `5` ✅

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Modulo `%`** | Returns the remainder of division; `n % 2 == 0` is the standard even-number check |
| **Two counters** | Maintaining separate counters is cleaner than a single counter + derivation |
| **`oddCount` from `evenCount`** | Since `evenCount + oddCount = n`, you could derive one from the other — but keeping both explicit is clearer |
| **Negative numbers** | In Java, `-3 % 2 == -1` (not `1`), so the check `% 2 == 0` still correctly identifies even negatives; `% 2 != 0` should be used instead of `% 2 == 1` for robust odd-checking with negatives |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | Every element is visited exactly once in a single linear pass through the array. |
| **Space Complexity** | `O(1)` | Only two integer counter variables (`evenCount`, `oddCount`) are used regardless of array size. |

---
