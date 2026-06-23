# Average of Array Elements

A Java program demonstrating how to **compute the average of all elements in an array** taken as user input. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Take the size and elements of an integer array as user input, and compute and print the average (arithmetic mean) of all its elements.

**Example Interaction:**
```
Enter size: 5
Enter elements:
10 20 30 40 50
Average = 30.0
```

---

## 💡 Approach

1. **Read the size** `n` from the user and declare an integer array of that size — making the solution dynamic rather than hardcoded.
2. **Populate the array** — use a `for` loop running from `0` to `n - 1` to read each element from the user and store it at the corresponding index.
3. **Compute the sum** — initialise `sum = 0` and iterate through the array, adding each element to `sum` (`sum += arr[i]`).
4. **Compute the average** — divide `sum` by `n`. Since both `sum` and `n` are integers, a **cast to `double`** is applied before the division: `(double) sum / n`. Without this cast, Java would perform **integer division** (truncating the decimal part), producing a wrong result for non-divisible values.
5. **Print the result** — `average` is a `double`, so the decimal portion is preserved in the output.
6. **Close the Scanner** using `sc.close()` to free up system resources.

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

  SET average = (double) sum / n

  PRINT "Average = " + average
END
```

---

## 💻 Code

```java
import java.util.Scanner;

public class AverageOfArray {
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

        double average = (double) sum / n;

        System.out.println("Average = " + average);

        sc.close();
    }
}
```

---

## 🔍 Dry Run

**Input:** `n = 5`, elements = `{10, 20, 30, 40, 50}`

**Sum computation:**

| Step | `i` | `arr[i]` | `sum` after step |
|------|-----|----------|-----------------|
| Init | —   | —        | 0               |
| 1    | 0   | 10       | 10              |
| 2    | 1   | 20       | 30              |
| 3    | 2   | 30       | 60              |
| 4    | 3   | 40       | 100             |
| 5    | 4   | 50       | 150             |

**Average:** `(double) 150 / 5 = 30.0` ✅

---

## ⚠️ Why `(double)` Cast is Needed

```java
// Without cast — integer division (WRONG for non-divisible values)
int sum = 15;
int n = 4;
double avg = sum / n;       // → 3.0  ❌ (truncates decimal)

// With cast — floating point division (CORRECT)
double avg = (double) sum / n;  // → 3.75 ✅
```

Casting `sum` to `double` **before** the division forces Java to treat the entire operation as floating-point arithmetic, preserving the decimal result.

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | Two separate loops each run `n` times — one for input, one for summing — giving a total of `O(2n)` = `O(n)`. The average computation is a single `O(1)` operation. |
| **Space Complexity** | `O(n)` | An array of size `n` is allocated to store the input elements. |

---