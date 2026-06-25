# Check Palindrome — Is a String a Palindrome?

A Java program to **check whether a given string is a palindrome** by reversing it and comparing with the original. This is part of the Strings section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given a string, determine whether it reads the same forwards and backwards. If yes, print `"Palindrome"`, otherwise print `"Not Palindrome"`.

**Example 1:**
```
Input : "madam"
Output: Palindrome
```

**Example 2:**
```
Input : "hello"
Output: Not Palindrome
```

---

## 💡 Approach

**Reverse and Compare** — the simplest and most intuitive approach:

1. **Reverse the string** — initialise an empty string `rev = ""` and iterate through `str` from the last index (`str.length() - 1`) down to `0`, appending each character to `rev` using `rev += str.charAt(i)`.
2. **Compare** — use `str.equals(rev)` to check if the original and the reversed string are identical:
   - If equal → the string is a **palindrome** (same forwards and backwards).
   - If not equal → the string is **not a palindrome**.
3. **Why `.equals()` and not `==`?** — In Java, `==` compares **object references** (memory addresses), not content. `.equals()` compares the **actual character content** of two strings, which is what we need here.

---

## 🧮 Pseudocode

```
START
  SET str = "madam"
  SET rev = ""

  FOR i = str.length() - 1 downto 0:
      rev = rev + str.charAt(i)
  END FOR

  IF str.equals(rev):
      PRINT "Palindrome"
  ELSE:
      PRINT "Not Palindrome"
  END IF
END
```

---

## 💻 Code

```java
public class Check_Palindrome {
    public static void main(String[] args) {

        String str = "madam";
        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }

        if (str.equals(rev)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
```

---

## 🔍 Dry Run

**String:** `"madam"` | Indices: `m(0) a(1) d(2) a(3) m(4)`

**Reverse construction:**

| `i` | `str.charAt(i)` | `rev` after step |
|-----|----------------|-----------------|
| 4   | `m`            | `"m"`           |
| 3   | `a`            | `"ma"`          |
| 2   | `d`            | `"mad"`         |
| 1   | `a`            | `"mada"`        |
| 0   | `m`            | `"madam"`       |

**Comparison:** `"madam".equals("madam")` → `true` → **Palindrome** ✅

---

## ⚠️ Edge Cases

| Scenario | Input | Output |
|----------|-------|--------|
| Single character | `"a"` | Palindrome |
| Empty string | `""` | Palindrome |
| All same characters | `"aaaa"` | Palindrome |
| Even-length palindrome | `"abba"` | Palindrome |
| Case sensitive | `"Madam"` | Not Palindrome (`M` ≠ `m`) |
| With spaces | `"race car"` | Not Palindrome (spaces matter) |

> To make the check **case-insensitive**, use `str.equalsIgnoreCase(rev)` instead of `str.equals(rev)`.

---

## ⚡ Alternative — Two Pointer Approach (More Efficient)

Instead of building a reversed string, compare characters from both ends:

```java
boolean isPalindrome = true;
int left = 0, right = str.length() - 1;

while (left < right) {
    if (str.charAt(left) != str.charAt(right)) {
        isPalindrome = false;
        break;
    }
    left++;
    right--;
}
System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
```

This stops early on the first mismatch — more efficient in practice.

---

## ⏱️ Complexity Analysis

| Approach | Time | Space | Explanation |
|----------|------|-------|-------------|
| **Reverse & Compare (current)** | `O(n²)` | `O(n)` | `+=` creates a new string each iteration giving `O(n²)`; reversed string takes `O(n)` space |
| **Two Pointer** | `O(n)` | `O(1)` | Single pass with no extra string created — optimal |

---