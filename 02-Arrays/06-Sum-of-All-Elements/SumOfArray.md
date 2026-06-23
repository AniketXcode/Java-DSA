# Sum of Array Elements

A Java program demonstrating how to **compute the sum of all elements in an array** taken as user input. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Take the size and elements of an integer array as user input, and compute and print the sum of all its elements.

**Example Interaction:**
```
Enter size: 5
Enter elements:
10 20 30 40 50
Sum = 150
```

---

## 💡 Approach

1. **Read the size** `n` from the user and declare an integer array of that size — making the solution dynamic rather than hardcoded.
2. **Populate the array** — use a `for` loop running from `0` to `n - 1` to read each element from the user and store it at the corresponding index.
3. **Accumulate the sum** — initialise a variable `sum = 0` and use another `for` loop to iterate through the array, adding each element to `sum` on every step (`sum += arr[i]`).
4. **Print the result** — after the loop finishes, `sum` holds the total of all elements.
5. **Close the Scanner** using `sc.close()` to free up system resources.

---

## 🧮 Pseudocode

```
START
  READ n
  DECLARE arr[n]

  FOR i = 0 to n - 1:
      READ arr[i]
  END FOR

  SET sum = 0

  FOR i = 0 to n - 1:
      sum = sum + arr[i]
  END FOR

  PRINT "Sum = " + sum
END
```

---

## 💻 Code

```java
import java.util.Scanner;

public class SumOfArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        System.out.println("Sum = " + sum);

        sc.close();
    }
}
```

---

## 🔍 Dry Run

**Input:** `n = 5`, elements = `{10, 20, 30, 40, 50}`

| Step | `i` | `arr[i]` | `sum` after step |
|------|-----|----------|-----------------|
| Init | —   | —        | 0               |
| 1    | 0   | 10       | 10              |
| 2    | 1   | 20       | 30              |
| 3    | 2   | 30       | 60              |
| 4    | 3   | 40       | 100             |
| 5    | 4   | 50       | 150             |

**Result:** `Sum = 150` ✅

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Dynamic size** | Array size is taken from user input (`n`) instead of being hardcoded — works for any array length |
| **Accumulator pattern** | `sum` starts at `0` and each element is added to it one at a time — a fundamental pattern used in many DSA problems |
| **`sum += arr[i]`** | Shorthand for `sum = sum + arr[i]` |
| **`sc.close()`** | Closes the Scanner after use to prevent resource leaks |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | Two separate loops each run `n` times — one for input, one for summing — giving a total of `O(2n)` = `O(n)`. |
| **Space Complexity** | `O(n)` | An array of size `n` is allocated to store the input elements. |

---