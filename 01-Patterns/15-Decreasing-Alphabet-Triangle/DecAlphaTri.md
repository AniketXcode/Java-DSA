# Decreasing Alphabet Triangle Pattern

A simple Java program to print a **right-angled triangle of alphabets in decreasing order** using nested loops. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a right-angled triangle made of uppercase alphabet letters, with `n` rows, where every row starts from the same letter and the letters **decrease** as you move across each row.

**Example:** For `n = 5`, the output should be:

```
E
E   D
E   D   C
E   D   C   B
E   D   C   B   A
```

---

## 💡 Approach

1. Unlike a regular increasing alphabet triangle, here **every row starts from the same (highest) letter** and steps **downward** as the column increases — the starting letter is determined by `n`, the total number of rows.
2. We use **two nested loops**:
   - The **outer loop** runs once for every row (`1` to `n`) and represents the row number.
   - The **inner loop** runs from `1` to `row` (the current row number), and for each value of `col`, it computes a letter that **decreases** as `col` increases.
3. **Number-to-letter conversion**: Java characters are internally stored as numeric (ASCII) values, where `'A'` corresponds to `65`. So for a given `col`:
   - `a = n - col` → as `col` increases, `a` decreases, which is the key to making the letters count down.
   - `ans = a + 'A'` → shifts the ASCII value of `'A'` forward by `a` positions (e.g. for `n = 5`, `col = 1` gives `a = 4`, landing on `'E'`).
   - This integer result is then **cast to `char`** to convert it back into a printable letter.
4. After the inner loop finishes printing the letters for one row, we move to the next line using `System.out.println()`.
5. This continues until all `n` rows are printed, forming the decreasing alphabet triangle.

---

## 🧮 Pseudocode

```
START
  SET n = 5

  FOR row = 1 to n:
      FOR col = 1 to row:
          SET a = n - col
          SET b = ASCII('A')
          SET ans = a + b
          SET finalAns = CHAR(ans)        // convert ASCII value back to a letter
          PRINT finalAns
      END FOR
      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class DecAlphaTri {
    public static void main(String[] args) {
        int n = 5;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                int a = n - col;
                int b = 'A';
                int ans = a + b;
                char finalAns = (char) ans;
                System.out.print(finalAns + "   ");
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
| **Space Complexity** | `O(1)` | Only a fixed number of variables (`n`, `row`, `col`, `a`, `b`, `ans`, `finalAns`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

---