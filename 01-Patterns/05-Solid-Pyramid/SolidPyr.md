# Solid Pyramid Pattern

A simple Java program to print a **solid pyramid pattern** using nested loops. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a solid pyramid made of `*` characters, with `n` rows, centered using leading spaces, where each row has an odd number of stars that increases as we go down.

**Example:** For `n = 4`, the output should be:

```
* * * * * * *
 * * * * *
  * * *
   *
```

---

## 💡 Approach

1. A solid pyramid is built row by row, where each row needs two things — **leading spaces** (to centre-align the row) and **stars** (which form the body of the pyramid).
2. For row `row`:
   - **Leading spaces** = `row - 1` → this decreases the indentation as we move down, giving the pyramid its centred shape.
   - **Stars** = `2 * n - 2 * row + 1` → this is always an odd number and increases as `row` increases, since each level of the pyramid is wider than the one above it.
3. We use **three loops** per row:
   - The **outer loop** runs once for every row (`1` to `n`).
   - The **first inner loop** prints `(row - 1)` spaces.
   - The **second inner loop** prints `(2*n - 2*row + 1)` stars.
4. After both inner loops finish for a row, move to the next line using `System.out.println()`.
5. Repeat until all `n` rows are printed, forming the complete solid pyramid.

---

## 🧮 Pseudocode

```
START
  SET n = 4

  FOR row = 1 to n:
      FOR col = 1 to (row - 1):
          PRINT " "                       // leading spaces for centering
      END FOR

      FOR col = 1 to (2*n - 2*row + 1):
          PRINT "* "                      // stars for current row
      END FOR

      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class SolidPyr {
    public static void main(String[] args) {
        int n = 4;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row - 1; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * n - 2 * row + 1; col++) {
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
| **Time Complexity** | `O(n²)` | For each row, the space loop runs up to `n` times and the star loop runs up to `2n` times, so the total work across all `n` rows sums to `O(n²)`. |
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`n`, `row`, `col`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

---