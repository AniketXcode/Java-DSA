# String Operations — Length, Upper, Lower & Reverse

A Java program demonstrating **4 fundamental string operations** — finding length, converting case, and reversing a string. This is part of the Strings section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given a string `"Aniket"`, perform and print the results of the following operations:
1. Find the length of the string
2. Convert to uppercase
3. Convert to lowercase
4. Reverse the string

**Input:**
```
String: "Aniket"
```

**Expected Output:**
```
Length: 6
Uppercase: ANIKET
Lowercase: aniket
Reverse: tekniA
```

---

## 💡 Approach

### 1. Length — `str.length()`
The built-in `length()` method returns the total number of characters in the string including spaces and special characters. Note: unlike arrays (which use `.length` property), strings use `.length()` as a method call.

### 2. Uppercase — `str.toUpperCase()`
The built-in `toUpperCase()` method returns a **new string** with all characters converted to their uppercase equivalents. The original string `str` remains unchanged since strings in Java are **immutable**.

### 3. Lowercase — `str.toLowerCase()`
The built-in `toLowerCase()` method returns a **new string** with all characters converted to their lowercase equivalents. Again, the original string is not modified.

### 4. Reverse — Manual loop
Java's `String` class has no built-in `reverse()` method (unlike `StringBuilder`). So we use a `for` loop:
- Start from the **last index** (`str.length() - 1`) and iterate backwards to `0`.
- On each step, concatenate `str.charAt(i)` to the `reverse` string.
- After the loop, `reverse` holds the characters in reversed order.

> **Note:** String concatenation inside a loop (`reverse += ...`) creates a new `String` object on every iteration due to immutability. For large strings, using `StringBuilder` is preferred for better performance.

---

## 🧮 Pseudocode

```
START
  SET str = "Aniket"

  // 1. Length
  PRINT str.length()

  // 2. Uppercase
  PRINT str.toUpperCase()

  // 3. Lowercase
  PRINT str.toLowerCase()

  // 4. Reverse
  SET reverse = ""
  FOR i = str.length() - 1 downto 0:
      reverse = reverse + str.charAt(i)
  END FOR
  PRINT reverse
END
```

---

## 💻 Code

```java
public class StringOperations {
    public static void main(String[] args) {

        String str = "Aniket";

        // 1. Find Length
        System.out.println("Length: " + str.length());

        // 2. Convert to Uppercase
        System.out.println("Uppercase: " + str.toUpperCase());

        // 3. Convert to Lowercase
        System.out.println("Lowercase: " + str.toLowerCase());

        // 4. Reverse String
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        System.out.println("Reverse: " + reverse);
    }
}
```

---

## 🔍 Dry Run — Reverse

**String:** `"Aniket"` | Indices: `A(0) n(1) i(2) k(3) e(4) t(5)`

| `i` | `str.charAt(i)` | `reverse` after step |
|-----|----------------|---------------------|
| 5   | `t`            | `"t"`               |
| 4   | `e`            | `"te"`              |
| 3   | `k`            | `"tek"`             |
| 2   | `i`            | `"teki"`            |
| 1   | `n`            | `"tekin"`           |
| 0   | `A`            | `"tekniA"`          |

**Result:** `"tekniA"` ✅

---

## 🔑 Key Concepts

| Operation | Method / Technique | Returns New String? |
|-----------|-------------------|-------------------|
| **Length** | `str.length()` | N/A (returns `int`) |
| **Uppercase** | `str.toUpperCase()` | ✅ Yes |
| **Lowercase** | `str.toLowerCase()` | ✅ Yes |
| **Reverse** | Manual loop with `charAt()` | ✅ Yes |

> **String Immutability:** Every string operation in Java returns a **new String object** — the original `str` is never modified. This is why we store results in a separate variable (`reverse`).

---

## ⚡ Better Alternative for Reverse — `StringBuilder`

```java
String reversed = new StringBuilder(str).reverse().toString();
System.out.println("Reverse: " + reversed);  // tekniA
```

`StringBuilder` is mutable and its `reverse()` runs in `O(n)` without creating intermediate objects — more efficient for large strings.

---

## ⏱️ Complexity Analysis

| Operation | Time | Space | Explanation |
|-----------|------|-------|-------------|
| `length()` | `O(1)` | `O(1)` | Stored as a field internally |
| `toUpperCase()` | `O(n)` | `O(n)` | Visits each character once; creates a new string |
| `toLowerCase()` | `O(n)` | `O(n)` | Same as above |
| **Reverse (loop)** | `O(n²)` | `O(n)` | Each `+=` creates a new string — `n` such operations give `O(n²)` |
| **Reverse (StringBuilder)** | `O(n)` | `O(n)` | Single pass; mutable — preferred for large inputs |

---
