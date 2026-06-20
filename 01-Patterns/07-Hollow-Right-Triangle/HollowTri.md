# Hollow Right Angle Triangle Pattern

A simple Java program to print a **hollow right-angled triangle pattern** using nested loops and conditional logic. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a hollow right-angled triangle made of `*` characters, with `n` rows, where only the **outer edges** of the triangle (the hypotenuse, the left side, and the base) are filled with stars, and the interior is left blank.

**Example:** For `n = 5`, the output should be:

```
*
* *
*  *
*   *
* * * * *
```

---

## 💡 Approach

1. A hollow right-angled triangle is a right-angled triangle where only the **boundary** is filled — the left vertical edge, the diagonal (hypotenuse), and the bottom base — while the inside is left blank.
2. For a right-angled triangle, the **first row** naturally has just `1` star and the **second row** has `2` stars (these rows are too narrow to have a hollow interior, so they stay fully filled). The **last row** is the base and must be fully filled with stars too.
3. We use an **outer loop** running from `1` to `n` for each row, and within it check the row type:
   - If the row is the **first row**, the **second row**, or the **last row** (`row == n`) → print a **full row** of `row` stars (these rows form the triangle's solid edges).
   - Otherwise (any **middle row**) → print:
     - One `*` (left edge),
     - `(row - 2)` blank spaces (hollow interior),
     - One more `*` (the diagonal/hypotenuse edge).
4. After processing a row, move to the next line using `System.out.println()`.
5. This continues until all `n` rows are printed, forming the hollow triangular shape.

---

## 🧮 Pseudocode

```
START
  SET n = 5

  FOR row = 1 to n:
      IF row == 1 OR row == n OR row == 2:
          FOR col = 1 to row:
              PRINT "* "              // fully filled row (top, second, base)
          END FOR
      ELSE:
          PRINT "* "                  // left edge
          FOR col = 1 to (row - 2):
              PRINT "  "              // hollow interior
          END FOR
          PRINT "* "                  // diagonal edge
      END IF
      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class HollowTri {
    public static void main(String[] args) {
        int n = 5;

        for (int row = 1; row <= n; row++) {
            if (row == 1 || row == n || row == 2) {
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
| **Time Complexity** | `O(n²)` | In the worst case (fully filled rows), the inner loop runs up to `row` times for each row, summing to `1 + 2 + ... + n = O(n²)`; the hollow rows take less work but don't change the overall order. |
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`n`, `row`, `col`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

---