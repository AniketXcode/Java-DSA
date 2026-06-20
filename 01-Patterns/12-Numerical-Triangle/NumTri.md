# Number Triangle Pattern

A simple Java program to print a **number triangle pattern** using nested loops. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a right-angled triangle made of numbers, with `n` rows, where each row prints numbers from `1` up to the current row number.

**Example:** For `n = 5`, the output should be:

```
1
1   2
1   2   3
1   2   3   4
1   2   3   4   5
```

---

## 💡 Approach

1. This pattern is similar to a right-angled triangle made of stars, except instead of printing a fixed symbol (`*`) we print the **column counter itself**, which naturally produces an increasing sequence in each row.
2. We use **two nested loops**:
   - The **outer loop** runs once for every row (`1` to `n`) and represents the row number.
   - The **inner loop** runs from `1` to `row` (the current row number), printing the value of `col` at each step — so row `1` prints `1`, row `2` prints `1 2`, and so on.
3. After the inner loop finishes printing the numbers for one row, we move to the next line using `System.out.println()`.
4. This continues until all `n` rows are printed, forming the increasing numeric triangle.

---

## 🧮 Pseudocode

```
START
  SET n = 5

  FOR row = 1 to n:
      FOR col = 1 to row:
          PRINT col
      END FOR
      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class NumTri {
    public static void main(String[] args) {
        int n = 5;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + "   ");
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
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`n`, `row`, `col`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

---