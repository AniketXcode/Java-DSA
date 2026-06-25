# Count Vowels in a String

A Java program to **count the number of vowels in a string** using character comparison. This is part of the Strings section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given a string, count and print the total number of vowels (`a`, `e`, `i`, `o`, `u`) present in it.

**Input:**
```
String: "aniket"
```

**Expected Output:**
```
Vowels: 3
```

---

## 💡 Approach

1. **Initialise a counter** `count = 0` to track the number of vowels found.
2. **Traverse the string** character by character using a `for` loop from index `0` to `str.length() - 1`.
3. **Normalise case** — on each iteration, convert the current character to lowercase using `Character.toLowerCase(str.charAt(i))`. This ensures both uppercase (`A`, `E`, ...) and lowercase (`a`, `e`, ...) vowels are counted without writing two separate conditions.
4. **Check for vowels** — use a chain of `||` (OR) conditions to check if the character is one of `a`, `e`, `i`, `o`, `u`. If it matches, increment `count`.
5. **Print the result** after the loop finishes.

---

## 🧮 Pseudocode

```
START
  SET str   = "aniket"
  SET count = 0

  FOR i = 0 to str.length() - 1:
      SET ch = toLowerCase(str.charAt(i))

      IF ch == 'a' OR ch == 'e' OR ch == 'i' OR ch == 'o' OR ch == 'u':
          count = count + 1
      END IF
  END FOR

  PRINT "Vowels: " + count
END
```

---

## 💻 Code

```java
public class Count_Vowels {
    public static void main(String[] args) {

        String str = "aniket";
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                count++;
            }
        }

        System.out.println("Vowels: " + count);
    }
}
```

---

## 🔍 Dry Run

**String:** `"aniket"` | Expected vowels: `a`, `i`, `e`

| `i` | `str.charAt(i)` | `ch` (lowercase) | Vowel? | `count` |
|-----|----------------|-----------------|--------|---------|
| 0   | `a`            | `a`             | ✅     | 1       |
| 1   | `n`            | `n`             | ❌     | 1       |
| 2   | `i`            | `i`             | ✅     | 2       |
| 3   | `k`            | `k`             | ❌     | 2       |
| 4   | `e`            | `e`             | ✅     | 3       |
| 5   | `t`            | `t`             | ❌     | 3       |

**Result:** `Vowels: 3` ✅

---

## ⚠️ Edge Cases

| Scenario | Input | Vowel Count |
|----------|-------|-------------|
| All vowels | `"aeiou"` | 5 |
| No vowels | `"rhythm"` | 0 |
| Mixed case | `"ANIKET"` | 3 (handled by `toLowerCase`) |
| Empty string | `""` | 0 |
| With spaces & digits | `"a1 E2"` | 2 (spaces/digits skipped automatically) |

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **`str.charAt(i)`** | Returns the character at index `i` in the string |
| **`Character.toLowerCase(ch)`** | Converts a `char` to lowercase — handles both upper and lowercase input in one condition |
| **`\|\|` (OR) chaining** | Each vowel is checked individually; any match increments the counter |
| **Consonants** | Any character that is not a vowel — can be counted with `str.length() - count` |

---

## ⚡ Alternative — Using `String.contains()` or `indexOf()`

```java
String vowels = "aeiou";
int count = 0;

for (char ch : str.toLowerCase().toCharArray()) {
    if (vowels.indexOf(ch) != -1) {
        count++;
    }
}
```

`vowels.indexOf(ch)` returns `-1` if the character is not found in the vowels string — a cleaner way to check membership without writing all 5 `||` conditions manually.

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | The string is traversed exactly once; each character check is `O(1)` with a fixed number of comparisons. |
| **Space Complexity** | `O(1)` | Only a fixed number of variables (`count`, `ch`, `i`) are used regardless of string length. |

---