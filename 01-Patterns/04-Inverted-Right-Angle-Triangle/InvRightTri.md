# Inverted Right Angle Triangle Pattern

A simple Java program to print an **inverted right-angled triangle pattern** using nested loops. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print an inverted right-angled triangle made of `*` characters, with `n` rows, where the number of stars **decreases** as the row number increases.

**Example:** For `n = 5`, the output should be:

```
* * * * *
* * * *
* * *
* *
*
```

---

## 💡 Approach

1. An inverted right-angled triangle is the mirror image (vertically flipped) of a normal right-angled triangle — the **first row has the most stars**, and each subsequent row has **one star less**.
2. We use **two nested loops**:
   - The **outer loop** runs once for every row (`1` to `n`) and represents the row number.
   - The **inner loop** runs from `1` to `(n - row + 1)`, so that:
     - Row `1` prints `n` stars
     - Row `2` prints `n - 1` stars
     - ... and so on, until the last row prints just `1` star
3. After the inner loop finishes printing the stars for one row, we move to the next line using `System.out.println()`.
4. This continues until all `n` rows are printed, forming the inverted triangular shape.

---

## 🧮 Pseudocode

```
START
  SET n = 5

  FOR row = 1 to n:
      FOR col = 1 to (n - row + 1):
          PRINT "* "
      END FOR
      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class InvRightTri {
    public static void main(String[] args) {
        int n = 5;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
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
| **Time Complexity** | `O(n²)` | The inner loop runs `(n - row + 1)` times for each row, so the total number of print operations is `n + (n-1) + (n-2) + ... + 1 = n × (n + 1) / 2`, which is `O(n²)`. |
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`n`, `row`, `col`) are used; no extra data structures are allocated, so space usage does not grow with input size. |
