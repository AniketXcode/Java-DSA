# Butterfly Pattern

A simple Java program to print a **butterfly pattern** using nested loops. This is part of a Pattern Printing series under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Print a butterfly pattern made of `*` characters, with `n` rows in the upper wing and `n` rows in the lower wing, where two triangles of stars (left and right) grow towards each other, meet at the middle, and then shrink back apart — resembling a butterfly's wings.

**Example:** For `n = 4`, the output should be:

```
*                           *   
*   *                   *   *   
*   *   *           *   *   *   
*   *   *   *   *   *   *   *   
*   *   *   *   *   *   *   *   
*   *   *           *   *   *   
*   *                   *   *   
*                           * 
```

---

## 💡 Approach

1. A butterfly pattern is made of two symmetric halves — an **upper wing** where the two star-triangles grow towards the centre, and a **lower wing** (its mirror image) where they shrink back apart.
2. Each row in **either wing** has three parts:
   - **Left stars** — count equal to the current row number (`row`), forming the left side of the wing.
   - **Middle gap** — count equal to `2 * (n - row)` blank units, which **shrinks** as `row` increases (so the wings appear to meet in the centre).
   - **Right stars** — same count as the left stars (`row`), forming the right side of the wing, symmetric to the left.
3. **Upper wing** (rows `1` to `n`): `row` increases, so the wings get wider and the gap shrinks — the wings appear to "open."
4. **Lower wing** (rows `n` down to `1`): `row` decreases, so the wings narrow and the gap widens again — the wings appear to "close," forming the mirror image of the upper wing.
5. We use **three loops per row** (left stars, middle gap, right stars), and after each row, move to the next line using `System.out.println()`. Repeating this for both wings produces the complete butterfly.

---

## 🧮 Pseudocode

```
START
  SET n = 4

  // Upper wing
  FOR row = 1 to n:
      FOR col = 1 to row:
          PRINT "*   "                  // left wing stars
      END FOR
      FOR col = 1 to (2 * (n - row)):
          PRINT "    "                  // middle gap
      END FOR
      FOR col = 1 to row:
          PRINT "*   "                  // right wing stars
      END FOR
      PRINT newline
  END FOR

  // Lower wing
  FOR row = n downto 1:
      FOR col = 1 to row:
          PRINT "*   "
      END FOR
      FOR col = 1 to (2 * (n - row)):
          PRINT "    "
      END FOR
      FOR col = 1 to row:
          PRINT "*   "
      END FOR
      PRINT newline
  END FOR
END
```

---

## 💻 Code

```java
public class Butterfly {
    public static void main(String[] args) {
        int n = 4;

        // Upper wing
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*   ");
            }
            for (int col = 1; col <= 2 * (n - row); col++) {
                System.out.print("    ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print("*   ");
            }
            System.out.println();
        }

        // Lower wing
        for (int row = n; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*   ");
            }
            for (int col = 1; col <= 2 * (n - row); col++) {
                System.out.print("    ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print("*   ");
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
| **Time Complexity** | `O(n²)` | Each row across both wings does `O(n)` work (left stars + gap + right stars combine to roughly `n` units), and this is repeated for `2n` rows total, giving `O(n²)`. |
| **Space Complexity** | `O(1)` | Only a fixed number of integer variables (`n`, `row`, `col`) are used; no extra data structures are allocated, so space usage does not grow with input size. |

---
