# Alphabet Triangle Pattern

A simple Java program to print a **right-angled triangle of alphabets** using nested loops. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a right-angled triangle made of uppercase alphabet letters, with `n` rows, where each row prints letters starting from `A` up to the letter corresponding to the current row number.

**Example:** For `n = 5`, the output should be:

```
A
A   B
A   B   C
A   B   C   D
A   B   C   D   E
```

---

## 💡 Approach

1. This pattern is built the same way as the [Number Triangle](#) pattern, except each numeric column value is **converted into its corresponding alphabet letter** before being printed.
2. We use **two nested loops**:
   - The **outer loop** runs once for every row (`1` to `n`) and represents the row number.
   - The **inner loop** runs from `1` to `row` (the current row number), and for each value of `col`, it computes the corresponding letter.
3. **Number-to-letter conversion**: Java characters are internally stored as numeric (ASCII) values, where `'A'` corresponds to `65`. So for a given `col`:
   - `b = 'A' + col - 1` → shifts the ASCII value of `'A'` forward by `(col - 1)` positions, landing on the correct letter (`col = 1` → `'A'`, `col = 2` → `'B'`, etc.).
   - This integer result is then **cast to `char`** to convert it back into a printable letter.
4. After the inner loop finishes printing the letters for one row, we move to the next line using `System.out.println()`.
5. This continues until all `n` rows are printed, forming the alphabet triangle.

---

## 🧮 Pseudocode

```
START
  SET n = 5

  FOR row = 1 to n:
      FOR col = 1 to row:
          SET a = col
          SET b = ASCII('A') + a - 1
          SET ch = CHAR(b)               // convert ASCII value back to a letter
          PRINT ch
      END FOR
      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class AlphaTri {
    public static void main(String[] args) {
        int n = 5;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                int a = col;
                int b = ('A' + a - 1);
                char ch = (char) b;
                System.out.print(ch + "   ");
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
| **Time Complexity** | `O(n²)` | The inner loop runs `row` times for each row, so the total number of print operations is `1 + 2 + 3 + ... + n = n × (n + 1) / 2`, which is `O(n²)`. |
| **Space Complexity** | `O(1)` | Only a fixed number of variables (`n`, `row`, `col`, `a`, `b`, `ch`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

---