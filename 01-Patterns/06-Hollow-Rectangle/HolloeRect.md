# Hollow Rectangle Pattern

A simple Java program to print a **hollow rectangle pattern** using nested loops and conditional logic. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a hollow rectangle made of `*` characters, with `n` rows and `m` columns, where only the **border** is filled with stars and the **interior** is left blank.

**Example:** For `n = 4` and `m = 5`, the output should be:

```
* * * * *
*       *
*       *
* * * * *
```

---

## 💡 Approach

1. A hollow rectangle looks like a solid rectangle, but only the **boundary cells** are stars — the **first row, last row, first column, and last column**. Every other cell stays blank.
2. We use **two nested loops** to visit every cell of the grid:
   - The **outer loop** runs once for every row (`1` to `n`).
   - The **inner loop** runs once for every column (`1` to `m`).
3. For each cell `(row, col)`, we check a **border condition**:
   - If `row == 1` (first row) **OR** `row == n` (last row) **OR** `col == 1` (first column) **OR** `col == m` (last column) → print a `*` (it's part of the border).
   - Otherwise → print a blank space (it's part of the interior).
4. After the inner loop finishes printing one full row, move to the next line using `System.out.println()`.
5. This continues until all `n` rows are printed, forming the hollow rectangle.

---

## 🧮 Pseudocode

```
START
  SET n = 4
  SET m = 5

  FOR row = 1 to n:
      FOR col = 1 to m:
          IF row == 1 OR row == n OR col == 1 OR col == m:
              PRINT "* "          // border cell
          ELSE:
              PRINT "  "          // interior cell (blank)
          END IF
      END FOR
      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class HollowRect {
    public static void main(String[] args) {
        int n = 4;
        int m = 5;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                if (row == 1 || row == n || col == 1 || col == m) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
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
| **Time Complexity** | `O(n × m)` | Every cell of the `n × m` grid is visited exactly once via the nested loops, regardless of whether it's a border cell or an interior cell. |
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`n`, `m`, `row`, `col`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

