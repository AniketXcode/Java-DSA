# String Traversal — 6 Ways to Traverse a String

A Java program demonstrating **6 different ways to traverse a String**, covering all common looping techniques applied to characters. This is part of the Strings section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given a string `"Hello, World!"`, traverse and print each character individually using:
1. `for` loop
2. `for-each` loop
3. `while` loop
4. `do-while` loop
5. Reverse traversal
6. Traversal with index

---

## 💡 Approach

### 1. `for` Loop
Uses an index variable `i` from `0` to `str.length() - 1`. Each character is accessed via `str.charAt(i)` — the standard index-based method to read a character at a specific position in a String.

### 2. `for-each` Loop
Java's `String` class does not directly support `for-each` on characters, so `str.toCharArray()` first converts the string into a `char[]` array. Each `char` is then iterated directly without needing an index. Cleanest syntax for read-only traversal.

### 3. `while` Loop
Index variable `i` is declared before the loop and incremented inside the body. Offers more flexibility — the update step can be placed anywhere in the loop body.

### 4. `do-while` Loop
Executes the body **at least once** before checking the condition. For non-empty strings this behaves identically to a `while` loop — useful when at least one character is guaranteed to be processed.

### 5. Reverse Traversal
A `for` loop starting from the **last index** (`str.length() - 1`) and decrementing down to `0`. Prints characters from the end of the string to the beginning — useful for palindrome checks, reversals, etc.

### 6. Traversal with Index
A `for` loop that prints **both the index and the character** at each position. Useful for debugging, searching, or any problem where position matters alongside the character value.

---

## 🧮 Pseudocode

```
START
  SET str = "Hello, World!"

  // 1. for loop
  FOR i = 0 to str.length() - 1:
      PRINT str.charAt(i)

  // 2. for-each loop
  FOR each ch IN str.toCharArray():
      PRINT ch

  // 3. while loop
  SET i = 0
  WHILE i < str.length():
      PRINT str.charAt(i)
      i++

  // 4. do-while loop
  SET j = 0
  DO:
      PRINT str.charAt(j)
      j++
  WHILE j < str.length()

  // 5. Reverse traversal
  FOR k = str.length() - 1 downto 0:
      PRINT str.charAt(k)

  // 6. Traversal with index
  FOR index = 0 to str.length() - 1:
      PRINT index, str.charAt(index)
END
```

---

## 💻 Code

```java
public class Traversal {
    public static void main(String[] args) {

        String str = "Hello, World!";

        // 1. Using for loop
        System.out.println("Using for loop:");
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }

        // 2. Using for-each loop
        System.out.println("\nUsing for-each loop:");
        for (char ch : str.toCharArray()) {
            System.out.println(ch);
        }

        // 3. Using while loop
        System.out.println("\nUsing while loop:");
        int i = 0;
        while (i < str.length()) {
            System.out.println(str.charAt(i));
            i++;
        }

        // 4. Using do-while loop
        System.out.println("\nUsing do-while loop:");
        int j = 0;
        do {
            System.out.println(str.charAt(j));
            j++;
        } while (j < str.length());

        // 5. Reverse traversal
        System.out.println("\nReverse traversal:");
        for (int k = str.length() - 1; k >= 0; k--) {
            System.out.println(str.charAt(k));
        }

        // 6. Traversal with index
        System.out.println("\nTraversal with index:");
        for (int index = 0; index < str.length(); index++) {
            System.out.println("Index: " + index + " Character: " + str.charAt(index));
        }
    }
}
```

---

## 🔑 Key Concepts

| Loop Type | Method Used | Index Available | Best Used When |
|-----------|-------------|----------------|----------------|
| `for` | `str.charAt(i)` | ✅ Yes | Index needed, fixed range |
| `for-each` | `str.toCharArray()` | ❌ No | Just reading characters cleanly |
| `while` | `str.charAt(i)` | ✅ Yes | Condition checked before entry |
| `do-while` | `str.charAt(j)` | ✅ Yes | At least one run always needed |
| Reverse `for` | `str.charAt(k)` | ✅ Yes | Traversing string backwards |
| Index + Char `for` | `str.charAt(index)` | ✅ Yes | Printing position alongside character |

---

## 📌 String vs Array Traversal — Key Difference

| | Array | String |
|--|-------|--------|
| **Access element** | `arr[i]` | `str.charAt(i)` |
| **Length** | `arr.length` (property) | `str.length()` (method — note the `()`) |
| **For-each support** | ✅ Direct | ❌ Needs `.toCharArray()` first |
| **Mutability** | ✅ Mutable | ❌ Immutable in Java |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` per traversal | Each loop visits every character exactly once; with 6 traversals total, it's `O(6n)` = `O(n)`. |
| **Space Complexity** | `O(n)` for `for-each` | `str.toCharArray()` creates a new `char[]` of size `n` in memory. All other loops use `O(1)` extra space. |

---