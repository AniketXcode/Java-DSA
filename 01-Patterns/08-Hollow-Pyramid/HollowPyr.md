# Hollow Pyramid Pattern

A simple Java program to print a **hollow pyramid pattern** using nested loops and conditional logic. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a hollow pyramid made of `*` characters, with `n` rows, centered using leading spaces, where only the **outer edges** (the two slanted sides and the base) are filled with stars, and the interior is left blank.

**Example:** For `n = 4`, the output should be:

```
   *
  * *
 *   *
* * * *
```

---

## 💡 Approach

1. A hollow pyramid combines the **centering logic of a solid pyramid** with the **hollow border logic of a hollow triangle** — each row needs leading spaces for alignment, and then either a fully filled edge row or a hollow row with just the two side stars.
2. For row `row`:
   - **Leading spaces** = `n - row` → this decreases as we move down, keeping the pyramid centred.
   - **Row content**:
     - If it's the **first row** or the **last row** (`row == n`, the base) → print a **fully filled row** of `row` stars.
     - Otherwise (a **middle row**) → print one `*` (left edge), then `(row - 2)` blank spaces (hollow interior), then one more `*` (right edge).
3. We use **nested loops** per row:
   - The **outer loop** runs once for every row (`1` to `n`).
   - The **first inner loop** prints `(n - row)` leading spaces.
   - A **condition** then decides whether to print a full row of stars or just the two border stars with blanks in between.
4. After processing a row, move to the next line using `System.out.println()`.
5. This continues until all `n` rows are printed, forming the hollow pyramid shape.

---

## 🧮 Pseudocode

```
START
  SET n = 4

  FOR row = 1 to n:
      FOR col = 1 to (n - row):
          PRINT " "                    // leading spaces for centering
      END FOR

      IF row == 1 OR row == n:
          FOR col = 1 to row:
              PRINT "* "                // fully filled row (top, base)
          END FOR
      ELSE:
          PRINT "* "                    // left edge
          FOR col = 1 to (row - 2):
              PRINT "  "                // hollow interior
          END FOR
          PRINT "* "                    // right edge
      END IF

      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class HollowPyr {
    public static void main(String[] args) {
        int n = 4;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print(" ");
            }
            if (row == 1 || row == n) {
                for (int col = 1; col <= row; col++) {
                    System.out.print("* ");
                }
            } else {
                System.out.print("* ");
                for (int col = 1; col <= row - 2; col++) {
                    System.out.print("  ");
                }
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
| **Time Complexity** | `O(n²)` | For each row, the space loop and the star/interior loop together run up to `O(n)` operations, and this is repeated for all `n` rows, giving a total of `O(n²)`. |
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`n`, `row`, `col`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

---