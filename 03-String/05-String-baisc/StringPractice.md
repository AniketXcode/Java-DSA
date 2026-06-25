# String Practice — 5 Essential String Operations

A Java program covering **5 essential string operations** in one place — word count, string comparison, concatenation, character frequency, and space removal. This is part of the Strings section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Demonstrate the following string operations:
1. Count the number of words in a sentence
2. Compare two strings for equality
3. Concatenate two strings
4. Find the frequency of each character in a string
5. Remove all spaces from a string

**Expected Output:**
```
Sentence: I am learning Java Programming
Number of Words: 5

Strings are Equal

Concatenated String: Aniket Kumar

Character Frequency:
p = 1
r = 2
o = 1
g = 2
a = 1
m = 2
i = 1
n = 1

Original String: Hello World Java
After Removing Spaces: HelloWorldJava
```

---

## 💡 Approach

### 1. Count Words — `split()`
`sentence.split(" ")` splits the string at every space and returns a `String[]` array where each element is a word. The number of words is simply `words.length`.

### 2. Compare Strings — `.equals()`
`str1.equals(str2)` compares the **content** of two strings character by character. Using `==` instead would compare **object references** (memory addresses), not content — a common Java pitfall.

### 3. Concatenate Strings — `+` operator
The `+` operator joins two strings and returns a new `String`. Since strings are immutable in Java, `firstName + lastName` creates a brand new `String` object holding the combined result.

### 4. Character Frequency — Nested loops
Three loops work together:
- **Outer loop** (`i`): picks each character `ch` one at a time.
- **Inner loop** (`j`): counts how many times `ch` appears after position `i`.
- **Backward check loop** (`k`): checks if `ch` was already counted in a previous iteration of the outer loop. If yes, `alreadyCounted = true` and the character is skipped — preventing duplicate output.
- Spaces are skipped using `continue` to avoid counting whitespace.

### 5. Remove Spaces — `.replace()`
`text.replace(" ", "")` replaces every occurrence of a single space `" "` with an empty string `""`, effectively removing all spaces. The original string is untouched (immutability).

---

## 🧮 Pseudocode

```
START

  // 1. Count Words
  SET sentence = "I am learning Java Programming"
  SET words[] = sentence.split(" ")
  PRINT words.length                          // 5

  // 2. Compare Strings
  SET str1 = "Java", str2 = "Java"
  IF str1.equals(str2): PRINT "Strings are Equal"
  ELSE: PRINT "Strings are Not Equal"

  // 3. Concatenate
  SET firstName = "Aniket", lastName = " Kumar"
  SET fullName = firstName + lastName
  PRINT fullName

  // 4. Character Frequency
  SET str = "programming"
  FOR i = 0 to str.length() - 1:
      SET ch = str.charAt(i)
      IF ch == ' ': CONTINUE
      SET count = 1
      FOR j = i+1 to str.length()-1:
          IF str.charAt(j) == ch: count++
      END FOR
      SET alreadyCounted = false
      FOR k = 0 to i-1:
          IF str.charAt(k) == ch: alreadyCounted = true; BREAK
      END FOR
      IF NOT alreadyCounted: PRINT ch + " = " + count
  END FOR

  // 5. Remove Spaces
  SET text = "Hello World Java"
  SET result = text.replace(" ", "")
  PRINT result

END
```

---

## 💻 Code

```java
public class StringPractice {
    public static void main(String[] args) {

        // 1. Count Words
        String sentence = "I am learning Java Programming";
        String[] words = sentence.split(" ");
        System.out.println("Sentence: " + sentence);
        System.out.println("Number of Words: " + words.length);
        System.out.println();

        // 2. Compare Two Strings
        String str1 = "Java";
        String str2 = "Java";
        if (str1.equals(str2)) {
            System.out.println("Strings are Equal");
        } else {
            System.out.println("Strings are Not Equal");
        }
        System.out.println();

        // 3. Concatenate Strings
        String firstName = "Aniket";
        String lastName  = " Kumar";
        String fullName  = firstName + lastName;
        System.out.println("Concatenated String: " + fullName);
        System.out.println();

        // 4. Character Frequency
        String str = "programming";
        System.out.println("Character Frequency:");
        for (int i = 0; i < str.length(); i++) {
            char ch    = str.charAt(i);
            int  count = 1;

            if (ch == ' ') continue;

            for (int j = i + 1; j < str.length(); j++) {
                if (ch == str.charAt(j)) count++;
            }

            boolean alreadyCounted = false;
            for (int k = 0; k < i; k++) {
                if (ch == str.charAt(k)) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (!alreadyCounted) {
                System.out.println(ch + " = " + count);
            }
        }
        System.out.println();

        // 5. Remove Spaces
        String text   = "Hello World Java";
        String result = text.replace(" ", "");
        System.out.println("Original String: " + text);
        System.out.println("After Removing Spaces: " + result);
    }
}
```

---

## 🔍 Dry Run — Character Frequency

**String:** `"programming"`

| Char | Frequency | Already Counted Before? | Printed? |
|------|-----------|------------------------|---------|
| `p`  | 1         | ❌                     | ✅ `p = 1` |
| `r`  | 2         | ❌                     | ✅ `r = 2` |
| `o`  | 1         | ❌                     | ✅ `o = 1` |
| `g`  | 2         | ❌                     | ✅ `g = 2` |
| `r`  | —         | ✅ (seen at index 1)   | ❌ skipped |
| `a`  | 1         | ❌                     | ✅ `a = 1` |
| `m`  | 2         | ❌                     | ✅ `m = 2` |
| `m`  | —         | ✅ (seen at index 6)   | ❌ skipped |
| `i`  | 1         | ❌                     | ✅ `i = 1` |
| `n`  | 1         | ❌                     | ✅ `n = 1` |
| `g`  | —         | ✅ (seen at index 3)   | ❌ skipped |

---

## 🔑 Key Concepts

| Operation | Method | Note |
|-----------|--------|------|
| **Word count** | `split(" ")` | Splits on single space; use `split("\\s+")` for multiple spaces |
| **String compare** | `.equals()` | Never use `==` for string content comparison |
| **Concatenation** | `+` operator | Creates a new String; use `StringBuilder` for performance in loops |
| **Char frequency** | Nested loops + backward check | `O(n²)` — use `HashMap` for `O(n)` approach |
| **Remove spaces** | `.replace(" ", "")` | Use `.replaceAll("\\s+", "")` to remove all whitespace types |

---

## ⚡ Better Alternative — Character Frequency with `HashMap`

```java
HashMap<Character, Integer> freq = new HashMap<>();
for (char ch : str.toCharArray()) {
    freq.put(ch, freq.getOrDefault(ch, 0) + 1);
}
freq.forEach((k, v) -> System.out.println(k + " = " + v));
```

`O(n)` time — each character is processed exactly once.

---

## ⏱️ Complexity Analysis

| Operation | Time | Space | Explanation |
|-----------|------|-------|-------------|
| Count Words | `O(n)` | `O(n)` | `split()` scans the string once; stores `n` words |
| Compare Strings | `O(n)` | `O(1)` | `.equals()` compares character by character |
| Concatenation | `O(n)` | `O(n)` | Creates a new string of combined length |
| Char Frequency (loops) | `O(n²)` | `O(1)` | Three nested/sequential loops over the string |
| Char Frequency (HashMap) | `O(n)` | `O(n)` | Single pass; HashMap stores up to `n` unique chars |
| Remove Spaces | `O(n)` | `O(n)` | `.replace()` scans once and builds a new string |

---