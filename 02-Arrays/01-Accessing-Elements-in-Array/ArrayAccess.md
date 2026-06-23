# Array Access — Indexing Elements

A simple Java program demonstrating how to **declare, initialize, and access elements of an array** using index-based access. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array of 5 elements, access and print each element individually using its index.

**Input Array:**
```
{10, 20, 30, 40, 50}
```

**Expected Output:**
```
First element: 10
Second element: 20
Third element: 30
Fourth element: 40
Fifth element: 50
```

---

## 💡 Approach

1. **Declare and initialize** an integer array with 5 values — `{10, 20, 30, 40, 50}`. In Java, arrays are **zero-indexed**, meaning the first element sits at index `0`, the second at index `1`, and so on.
2. **Access each element** directly using its index inside square brackets `[ ]`:
   - `numbers[0]` → `10` (first element)
   - `numbers[1]` → `20` (second element)
   - `numbers[2]` → `30` (third element)
   - `numbers[3]` → `40` (fourth element)
   - `numbers[4]` → `50` (fifth element)
3. **Print** each accessed value using `System.out.println()` with a descriptive label.
4. Accessing any index outside the range `0` to `length - 1` would throw an `ArrayIndexOutOfBoundsException` at runtime.

---

## 🧮 Pseudocode

```
START
  DECLARE numbers[] = {10, 20, 30, 40, 50}

  PRINT "First element: "  + numbers[0]
  PRINT "Second element: " + numbers[1]
  PRINT "Third element: "  + numbers[2]
  PRINT "Fourth element: " + numbers[3]
  PRINT "Fifth element: "  + numbers[4]
END
```

---

## 💻 Code

```java
public class ArrayAccess {
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("First element: "  + numbers[0]);
        System.out.println("Second element: " + numbers[1]);
        System.out.println("Third element: "  + numbers[2]);
        System.out.println("Fourth element: " + numbers[3]);
        System.out.println("Fifth element: "  + numbers[4]);
    }
}
```

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Zero Indexing** | Arrays in Java start at index `0`, not `1` |
| **Fixed Size** | Array size is fixed at the time of declaration and cannot change |
| **Type Safety** | An `int[]` array can only hold integer values |
| **Index Bounds** | Valid index range is `0` to `array.length - 1`; going beyond throws `ArrayIndexOutOfBoundsException` |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` per access | Accessing an element by index in an array is a direct memory lookup — it always takes constant time regardless of array size. |
| **Space Complexity** | `O(n)` | Space is proportional to the number of elements stored in the array (`n = 5` here). |

---