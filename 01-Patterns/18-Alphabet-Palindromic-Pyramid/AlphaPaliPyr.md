# Alphabet Palindrome Pyramid Pattern

A simple Java program to print an **alphabet palindrome pyramid pattern** using nested loops. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a pyramid made of uppercase letters, with `n` rows, centered using leading spaces, where each row counts up from `A` to the row's corresponding letter and then counts back down to `A` — forming a palindrome on every line.

**Example:** For `n = 3`, the output should be:

```
  A
 A B A
A B C B A
```

---

## 💡 Approach

1. This pattern is built the same way as the [Number Pyramid](#) pattern, except the **numeric column counter is converted into its corresponding alphabet letter** before being printed — turning the rise-and-fall number sequence into a rise-and-fall letter sequence (a palindrome) on each row.
2. For row `row`:
   - **Leading spaces** = `n - row` → decreases as we move down, keeping the pyramid centred.
   - **Ascending part**: letters from `A` up to the letter at position `row`, forming the increasing half of the row.
   - **Descending part**: letters back down from `(row - 1)` to `A`, forming the decreasing half (mirroring the ascending part without repeating the peak letter).
3. **Number-to-letter conversion**: Java characters are internally stored as numeric (ASCII) values, where `'A'` corresponds to `65`. So for a given `col`:
   - `(char)(col + 'A' - 1)` → shifts the ASCII value of `'A'` forward by `(col - 1)` positions, landing on the correct letter (`col = 1` → `'A'`, `col = 2` → `'B'`, etc.), then casts the result back to a `char`.
4. We use **three loops per row**:
   - The **outer loop** runs once for every row (`1` to `n`).
   - The **first inner loop** prints `(n - row)` leading spaces.
   - The **second inner loop** prints letters for `col = 1` to `row` (ascending).
   - The **third inner loop** prints letters for `col = (row - 1)` down to `1` (descending).
5. After all three parts are printed for a row, move to the next line using `System.out.println()`. This continues until all `n` rows are printed, forming the complete alphabet palindrome pyramid.

---

## 🧮 Pseudocode

```
START
  SET n = 3

  FOR row = 1 to n:
      FOR col = 1 to (n - row):
          PRINT " "                            // leading spaces for centering
      END FOR

      FOR col = 1 to row:
          PRINT CHAR(col + ASCII('A') - 1)      // ascending letters
      END FOR

      FOR col = (row - 1) downto 1:
          PRINT CHAR(col + ASCII('A') - 1)      // descending letters
      END FOR

      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class AlphaPaliPyr {
    public static void main(String[] args) {
        int n = 3;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print((char) (col + 'A' - 1) + " ");
            }
            for (int col = row - 1; col >= 1; col--) {
                System.out.print((char) (col + 'A' - 1) + " ");
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
| **Time Complexity** | `O(n²)` | For each row, the space loop, ascending loop, and descending loop together do `O(n)` work, and this is repeated for `n` rows, giving a total of `O(n²)`. |
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`n`, `row`, `col`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

---