# Solid Rectangle Pattern

A simple Java program to print a **solid rectangle pattern** using nested loops. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a solid rectangle made of `*` characters, with a given number of rows and columns.

**Example:** For `rows = 5` and `columns = 10`, the output should be:

```
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * * * *
```

---

## 💡 Approach

1. A solid rectangle has a fixed number of rows and a fixed number of columns, and **every cell is filled** with a `*`.
2. We use **two nested loops**:
   - The **outer loop** runs once for every row (`1` to `rows`).
   - The **inner loop** runs once for every column (`1` to `columns`) and prints a `*` followed by a space.
3. After the inner loop finishes printing one full row, we move the cursor to the next line using `System.out.println()`.
4. This repeats until all rows are printed, forming a complete rectangle.

---

## 🧮 Pseudocode

```
START
  SET rows = 5
  SET columns = 10

  FOR i = 1 to rows:
      FOR j = 1 to columns:
          PRINT "* "
      END FOR
      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class SolidRectangle {
    public static void main(String[] args) {
        int rows = 5;
        int columns = 10;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
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
| **Time Complexity** | `O(rows × columns)` | The inner loop runs `columns` times for every row, and this is repeated `rows` times, giving a total of `rows × columns` print operations. |
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`rows`, `columns`, `i`, `j`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

---