# Right Angle Triangle Pattern

A simple Java program to print a **right-angled triangle pattern** using nested loops. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a right-angled triangle made of `*` characters, with a given number of rows, where row `i` contains `i` stars.

**Example:** For `rows = 5`, the output should be:

```
*
* *
* * *
* * * *
* * * * *
```

---

## 💡 Approach

1. A right-angled triangle has a number of stars in each row equal to the **current row number**.
2. We use **two nested loops**:
   - The **outer loop** runs once for every row (`1` to `rows`) and represents the row number `i`.
   - The **inner loop** runs from `1` to `i` (the current row number), printing a `*` followed by a space — so row `1` prints `1` star, row `2` prints `2` stars, and so on.
3. After the inner loop finishes printing the stars for one row, we move to the next line using `System.out.println()`.
4. This continues until all `rows` rows are printed, forming the triangular shape.

---

## 🧮 Pseudocode

```
START
  SET rows = 5

  FOR i = 1 to rows:
      FOR j = 1 to i:
          PRINT "* "
      END FOR
      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class RightAngleTri {
    public static void main(String[] args) {
        int rows = 5;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
```

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(rows²)` | The inner loop runs `i` times for each row `i`, so the total number of print operations is `1 + 2 + 3 + ... + rows = rows × (rows + 1) / 2`, which is `O(rows²)`. |
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`rows`, `i`, `j`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

---