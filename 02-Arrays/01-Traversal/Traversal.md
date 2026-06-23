# Array Traversal — 6 Ways to Traverse an Array

A Java program demonstrating **6 different ways to traverse an array**, covering all common looping techniques. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array `{10, 20, 30, 40, 50}`, traverse and print all its elements using:
1. `for` loop
2. `for-each` loop
3. `while` loop
4. `do-while` loop
5. Reverse traversal
6. Traversal with index

---

## 💡 Approach

### 1. `for` Loop
The classic approach — uses an index variable `i` starting from `0`, running up to `arr.length - 1`. Gives full control over the index at every step.

### 2. `for-each` Loop
A cleaner, more readable syntax — Java internally handles the index, and each element is directly assigned to a temporary variable (`num`) on each iteration. Best used when the index is not needed.

### 3. `while` Loop
The index variable `i` is declared **before** the loop and incremented **inside** it. More flexible than a `for` loop since the update step can be placed anywhere in the body.

### 4. `do-while` Loop
Similar to `while`, but the loop body executes **at least once** before the condition is checked. Useful when you always need one guaranteed execution before deciding whether to continue.

### 5. Reverse Traversal
A `for` loop starting from the **last index** (`arr.length - 1`) and decrementing down to `0`. Prints elements in reverse order — useful for many DSA problems like reversing arrays, stack operations, etc.

### 6. Traversal with Index
A standard `for` loop that prints **both the index and the value** together. Useful for debugging, searching, or when position information is needed alongside the value.

---

## 🧮 Pseudocode

```
START
  DECLARE arr[] = {10, 20, 30, 40, 50}

  // 1. for loop
  FOR i = 0 to arr.length - 1:
      PRINT arr[i]

  // 2. for-each loop
  FOR each num IN arr:
      PRINT num

  // 3. while loop
  SET i = 0
  WHILE i < arr.length:
      PRINT arr[i]
      i++

  // 4. do-while loop
  SET j = 0
  DO:
      PRINT arr[j]
      j++
  WHILE j < arr.length

  // 5. Reverse traversal
  FOR k = arr.length - 1 downto 0:
      PRINT arr[k]

  // 6. Traversal with index
  FOR index = 0 to arr.length - 1:
      PRINT index, arr[index]
END
```

---

## 💻 Code

```java
public class Traversal {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        // 1. Using for loop
        System.out.println("Using for loop:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // 2. Using for-each loop
        System.out.println("\nUsing for-each loop:");
        for (int num : arr) {
            System.out.println(num);
        }

        // 3. Using while loop
        System.out.println("\nUsing while loop:");
        int i = 0;
        while (i < arr.length) {
            System.out.println(arr[i]);
            i++;
        }

        // 4. Using do-while loop
        System.out.println("\nUsing do-while loop:");
        int j = 0;
        do {
            System.out.println(arr[j]);
            j++;
        } while (j < arr.length);

        // 5. Reverse traversal
        System.out.println("\nReverse traversal:");
        for (int k = arr.length - 1; k >= 0; k--) {
            System.out.println(arr[k]);
        }

        // 6. Traversal with index
        System.out.println("\nTraversal with index:");
        for (int index = 0; index < arr.length; index++) {
            System.out.println("Index: " + index + " Value: " + arr[index]);
        }
    }
}
```

---

## 🔑 Key Concepts

| Loop Type | Index Available | Guaranteed First Run | Best Used When |
|-----------|----------------|----------------------|----------------|
| `for` | ✅ Yes | ❌ No | Index needed, fixed range |
| `for-each` | ❌ No | ❌ No | Just reading elements cleanly |
| `while` | ✅ Yes | ❌ No | Condition checked before entry |
| `do-while` | ✅ Yes | ✅ Yes | At least one run always needed |
| Reverse `for` | ✅ Yes | ❌ No | Traversing backwards |
| Index + Value `for` | ✅ Yes | ❌ No | Printing position alongside value |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` per traversal | Each loop visits every element exactly once; with 6 traversals, the total is `O(6n)` = `O(n)`. |
| **Space Complexity** | `O(1)` | No extra data structures are used — only a fixed number of loop variables (`i`, `j`, `k`, `index`, `num`) that don't scale with input size. |

---
