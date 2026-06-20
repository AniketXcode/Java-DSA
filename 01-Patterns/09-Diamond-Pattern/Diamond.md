# Diamond Pattern

A simple Java program to print a **solid diamond pattern** using nested loops. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a solid diamond made of `*` characters, with `n` rows in the upper half and `n - 1` rows in the lower half, centered using leading spaces.

**Example:** For `n = 4`, the output should be:

```
   *
  * * *
 * * * * *
* * * * * * *
 * * * * *
  * * *
   *
```

---

## 💡 Approach

1. A diamond is simply **two pyramids joined together** — an **upper pyramid** that grows wider row by row, followed by a **lower (inverted) pyramid** that shrinks row by row.
2. **Upper half** (rows `1` to `n`):
   - **Leading spaces** = `n - row` → keeps each row centred.
   - **Stars** = `2 * row - 1` → always odd, increasing with each row, so the shape widens going down.
3. **Lower half** (rows `n - 1` down to `1`):
   - Same formulas as above are reused, but the row variable counts **downward** from `n - 1` to `1`, so the shape narrows back to a point.
4. For both halves, we use **three loops per row**:
   - The **outer loop** controls the current row.
   - The **first inner loop** prints the leading spaces.
   - The **second inner loop** prints the stars.
5. After printing a row, move to the next line using `System.out.println()`. Repeating this for both halves produces the complete diamond.

---

## 🧮 Pseudocode

```
START
  SET n = 4

  // Upper half
  FOR row = 1 to n:
      FOR space = 1 to (n - row):
          PRINT " "
      END FOR
      FOR star = 1 to (2 * row - 1):
          PRINT "* "
      END FOR
      PRINT newline
  END FOR

  // Lower half
  FOR row = (n - 1) downto 1:
      FOR space = 1 to (n - row):
          PRINT " "
      END FOR
      FOR star = 1 to (2 * row - 1):
          PRINT "* "
      END FOR
      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class Diamond {
    public static void main(String[] args) {
        int n = 4;

        // Upper half
        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= (2 * row - 1); star++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Lower half
        for (int row = n - 1; row >= 1; row--) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= (2 * row - 1); star++) {
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
| **Time Complexity** | `O(n²)` | The upper half does `O(n²)` work (sum of spaces and stars across `n` rows), and the lower half does another `O(n²)` work across `n - 1` rows; the combined total is still `O(n²)`. |
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`n`, `row`, `space`, `star`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

---