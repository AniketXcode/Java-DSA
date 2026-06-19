# Solid Parallelogram Pattern

A simple Java program to print a **solid parallelogram pattern** using nested loops. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a solid parallelogram made of `*` characters, with `n` rows, where each row is shifted to the right by decreasing spaces as the row number increases, giving the shape a slanted (parallelogram) look.

**Example:** For `n = 5`, the output should be:

```
    * * * * *
   * * * * *
  * * * * *
 * * * * *
* * * * *
```

---

## 💡 Approach

1. A solid parallelogram is essentially a solid rectangle of stars, but each row is shifted to the right by a decreasing number of leading spaces — this slant is what gives it the parallelogram shape.
2. For each row, we need:
   - **Leading spaces**: decreasing as the row number increases. For row `row`, the number of spaces required is `n - row`.
   - **Stars**: a fixed count of `n` stars in every row.
3. We use **three loops** per row:
   - The **outer loop** runs once for every row (`1` to `n`).
   - The **first inner loop** prints `n - row` spaces (handles the slant/shift).
   - The **second inner loop** prints `n` stars (handles the solid body).
4. After both inner loops finish for a row, move to the next line using `System.out.println()`.
5. Repeat until all `n` rows are printed, forming the slanted solid parallelogram.

---

## 🧮 Pseudocode

```
START
  SET n = 5

  FOR row = 1 to n:
      FOR col = 1 to (n - row):
          PRINT " "          // leading spaces for the slant
      END FOR

      FOR col = 1 to n:
          PRINT "* "         // solid body of stars
      END FOR

      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class SolidPara {
    public static void main(String[] args) {
        int n = 5;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= n; col++) {
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
| **Time Complexity** | `O(n²)` | For every row, the space loop runs up to `n` times and the star loop runs `n` times, giving a total of `n × n` operations across all rows. |
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`n`, `row`, `col`) are used; no extra data structures are allocated, so space usage does not grow with input size. |
