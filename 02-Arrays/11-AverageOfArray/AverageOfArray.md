# Average of Array — Using a Static Helper Method

A Java program demonstrating how to compute the **average of an array** by extracting the logic into a dedicated **static method**. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, compute and return its average using a reusable static method.

**Input:**
```
Array: {1, 2, 3, 4, 5, 6, 7, 8}
```

**Expected Output:**
```
Average of the array is: 4.5
```

---

## 💡 Approach

1. **Extract logic into a static method** — `getAverage(int[] arr)` is a `static` method that takes the array as a parameter, computes the sum using a `for-each` loop, divides by the array length, and returns the result as a `double`.

2. **Compute sum** — initialise `sum = 0` and use a `for-each` loop to iterate through every element, adding each to `sum`.

3. **Compute average** — divide `sum` by `arr.length` to get the average.

4. **Call from `main()`** — since `getAverage()` is `static`, it can be called directly without creating an object: `getAverage(arr)`.

---

## 🧮 Pseudocode

```
START
  FUNCTION getAverage(arr):
      SET sum = 0
      FOR each element IN arr:
          sum = sum + element
      END FOR
      SET size = arr.length
      RETURN (double) sum / size

  BEGIN main():
      DECLARE arr[] = {1, 2, 3, 4, 5, 6, 7, 8}
      PRINT "Average: " + getAverage(arr)
END
```

---

## 💻 Code

```java
public class AverageOfArray {

    static double getAverage(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int size = arr.length;
        double avg = (double) sum / size;   
        return avg;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Average of the array is: " + getAverage(arr));
    }
}
```

---

## 🔍 Dry Run

**Array:** `{1, 2, 3, 4, 5, 6, 7, 8}` | `size = 8`

**Sum computation:**

| Step | Element | `sum` after step |
|------|---------|-----------------|
| 1 | 1 | 1 |
| 2 | 2 | 3 |
| 3 | 3 | 6 |
| 4 | 4 | 10 |
| 5 | 5 | 15 |
| 6 | 6 | 21 |
| 7 | 7 | 28 |
| 8 | 8 | 36 |

**Average:** `(double) 36 / 8 = 4.5` ✅

---

## 🐛 Bug Fix — Integer Division Trap

The original code contains a **silent bug** on this line:

```java
double avg = sum / size;   // ❌ integer division — decimal part lost
```

Since both `sum` and `size` are `int`, Java performs **integer division** first — the decimal result is truncated — and then assigns the truncated result to `double`.

```java
// With arr = {1,2,3,4,5,6,7,8}:
// sum = 36, size = 8
double avg = 36 / 8;        // → 4 (int division) → stored as 4.0 ❌
double avg = (double)36 / 8; // → 4.5 ✅
```

**Fix:** Cast `sum` to `double` before dividing:

```java
double avg = (double) sum / size;   // ✅ correct — forces floating-point division
```

> **Rule:** In Java, if both operands of `/` are `int`, the result is always truncated to `int` — even if assigned to a `double`. Cast **before** dividing, not after.

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Static method** | Belongs to the class, not an object — called directly as `getAverage(arr)` without `new` |
| **Method parameter** | Array is passed by reference — the method receives a pointer to the same array in memory |
| **`for-each` loop** | Cleanest way to sum elements when index is not needed |
| **Integer division** | `int / int` always truncates in Java — cast one operand to `double` before dividing |
| **`(double)` cast** | Applied to `sum` before the `/` operator to force floating-point division |
| **Return type** | `double` used to preserve decimal precision of the average |

---

## ⚡ Static Method vs Scanner Approach

| | **This version (Static method)** | **Scanner version** |
|--|----------------------------------|---------------------|
| **Input** | Hardcoded array | User input at runtime |
| **Reusability** | ✅ `getAverage()` can be called anywhere | ❌ Logic inside `main()` only |
| **Testability** | ✅ Easy to unit test | ❌ Harder to test |
| **Best for** | Utility/helper functions | Interactive programs |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | The `for-each` loop visits every element exactly once to compute the sum. |
| **Space Complexity** | `O(1)` | Only a fixed number of variables (`sum`, `size`, `avg`) are used — no extra data structure is allocated. |

---