# Hollow Diamond Pattern

A simple Java program to print a **hollow diamond pattern** using nested loops and conditional logic. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a hollow diamond made of `*` characters, with `n` rows in the upper half and `n - 1` rows in the lower half, centered using leading spaces, where only the **outer edges** of the diamond are filled with stars and the interior is left blank.

**Example:** For `n = 4`, the output should be:

```
   *
  * *
 *   *
*     *
 *   *
  * *
   *
```

---

## 💡 Approach

1. A hollow diamond is built the same way as a solid diamond — an **upper (growing) half** followed by a **lower (shrinking) half** — but instead of filling every cell with a star, only the **two slanted edges** of each row are starred, leaving the middle blank.
2. Both halves share the **same row logic**, just with the row counter moving in opposite directions:
   - **Upper half**: `row` goes from `1` to `n` (the diamond widens).
   - **Lower half**: `row` goes from `n - 1` down to `1` (the diamond narrows back to a point).
3. For each row:
   - **Leading spaces** = `n - row` → keeps the row centred.
   - **Row content**:
     - If it's the **tip row** (`row == 1`) → print a single `*` (too narrow to be hollow).
     - Otherwise → print one `*` (left edge), then `(row - 2)` blank double-spaces (hollow interior), then one more `*` (right edge).
4. We use **nested loops** per row:
   - The **outer loop** controls the current row (for each half).
   - The **first inner loop** prints the leading spaces.
   - A **condition** then decides whether to print just the tip star, or the two edge stars with blanks in between.
5. After processing a row, move to the next line using `System.out.println()`. Repeating this for both halves produces the complete hollow diamond.

---

## 🧮 Pseudocode

```
START
  SET n = 4

  // Upper half
  FOR row = 1 to n:
      FOR col = 1 to (n - row):
          PRINT " "                    // leading spaces for centering
      END FOR
      IF row == 1:
          PRINT "* "                   // tip of the diamond
      ELSE:
          PRINT "* "                   // left edge
          FOR col = 1 to (row - 2):
              PRINT "  "                // hollow interior
          END FOR
          PRINT "* "                   // right edge
      END IF
      PRINT newline
  END FOR

  // Lower half
  FOR row = (n - 1) downto 1:
      FOR col = 1 to (n - row):
          PRINT " "
      END FOR
      IF row == 1:
          PRINT "* "
      ELSE:
          PRINT "* "
          FOR col = 1 to (row - 2):
              PRINT "  "
          END FOR
          PRINT "* "
      END IF
      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class HollowDia {
    public static void main(String[] args) {
        int n = 4;

        // Upper half
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print(" ");
            }
            if (row == 1) {
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

        // Lower half
        for (int row = n - 1; row >= 1; row--) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print(" ");
            }
            if (row == 1) {
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
| **Time Complexity** | `O(n²)` | The upper half does `O(n)` work per row across `n` rows (`O(n²)` total), and the lower half does the same across `n - 1` rows; the combined total remains `O(n²)`. |
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`n`, `row`, `col`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

---