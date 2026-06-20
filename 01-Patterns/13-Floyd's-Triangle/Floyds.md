# Floyd's Triangle Pattern

A simple Java program to print **Floyd's Triangle** using nested loops. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a right-angled triangle of `n` rows filled with **consecutive natural numbers**, where numbering continues across rows instead of restarting from `1` in each row.

**Example:** For `n = 5`, the output should be:

```
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
```

---

## 💡 Approach

1. Floyd's Triangle differs from a regular number triangle: instead of each row restarting from `1`, a **single running counter** keeps increasing across the entire triangle, row after row.
2. We maintain one variable, `num`, initialised to `1` **before** the loops begin, and it is **never reset** for any row.
3. We use **two nested loops**:
   - The **outer loop** runs once for every row (`1` to `n`) and decides how many numbers go in that row — row `1` has `1` number, row `2` has `2` numbers, and so on.
   - The **inner loop** runs from `1` to `row`, and on every iteration it prints the **current value of `num`** and then increments `num` by `1`.
4. After the inner loop finishes printing the numbers for one row, we move to the next line using `System.out.println()`.
5. Since `num` carries forward across rows, the sequence stays continuous, producing Floyd's Triangle.

---

## 🧮 Pseudocode

```
START
  SET n = 5
  SET num = 1

  FOR row = 1 to n:
      FOR col = 1 to row:
          PRINT num
          num = num + 1
      END FOR
      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class Floyds {
    public static void main(String[] args) {
        int n = 5;
        int num = 1;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(num + " ");
                num++;
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
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`n`, `num`, `row`, `col`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

---