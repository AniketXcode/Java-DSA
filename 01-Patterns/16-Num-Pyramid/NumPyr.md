# Number Pyramid Pattern

A simple Java program to print a **number pyramid pattern** using nested loops. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a pyramid made of numbers, with `n` rows, centered using leading spaces, where each row counts up from `1` to the row number and then counts back down to `1`.

**Example:** For `n = 4`, the output should be:

```
   1
  1 2 1
 1 2 3 2 1
1 2 3 4 3 2 1
```

---

## 💡 Approach

1. A number pyramid combines the **centering logic of a solid pyramid** with a **rise-and-fall numeric sequence** in each row — the numbers increase up to the row number and then decrease back down, forming a peak in the middle of each line.
2. For row `row`:
   - **Leading spaces** = `n - row` → decreases as we move down, keeping the pyramid centred.
   - **Ascending part**: numbers from `1` to `row`, forming the increasing half of the row.
   - **Descending part**: numbers from `row - 1` back down to `1`, forming the decreasing half (mirroring the ascending part without repeating the peak value).
3. We use **three loops per row**:
   - The **outer loop** runs once for every row (`1` to `n`).
   - The **first inner loop** prints `(n - row)` leading spaces.
   - The **second inner loop** prints numbers `1` to `row` (ascending).
   - The **third inner loop** prints numbers `(row - 1)` down to `1` (descending).
4. After all three parts are printed for a row, move to the next line using `System.out.println()`.
5. This continues until all `n` rows are printed, forming the complete number pyramid.

---

## 🧮 Pseudocode

```
START
  SET n = 4

  FOR row = 1 to n:
      FOR col = 1 to (n - row):
          PRINT " "                  // leading spaces for centering
      END FOR

      FOR col = 1 to row:
          PRINT col                  // ascending sequence
      END FOR

      FOR col = (row - 1) downto 1:
          PRINT col                  // descending sequence
      END FOR

      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class NumPyr {
    public static void main(String[] args) {
        int n = 4;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            for (int col = row - 1; col >= 1; col--) {
                System.out.print(col + " ");
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