# Find Mode of an Array

A Java program finding the **mode** — the most frequently occurring element — in an array using a nested loop approach. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, find and return the element that appears the **most number of times** (the mode).

**Input:**
```
Array: {1, 2, 3, 2, 4, 2, 5}
```

**Expected Output:**
```
Mode of the array is: 2
```

---

## 💡 Approach — Brute Force (Nested Loops)

1. **Initialise trackers** — `maxCount = 0` to track the highest frequency seen so far, and `mode = arr[0]` as the initial candidate.

2. **Outer loop** — picks each element `arr[i]` as the candidate one by one.

3. **Inner loop** — counts how many times `arr[i]` appears across the **entire array** by comparing every `arr[j]` against it.

4. **Update mode** — after the inner loop finishes, if `count > maxCount`, this element appears more than the current mode — update both `maxCount` and `mode`.

5. **Return mode** — after all elements are processed, `mode` holds the element with the highest frequency.

---

## 🧮 Pseudocode

```
START
  FUNCTION findMode(arr):
      SET maxCount = 0
      SET mode     = arr[0]

      FOR i = 0 to arr.length - 1:
          SET count = 0
          FOR j = 0 to arr.length - 1:
              IF arr[j] == arr[i]:
                  count = count + 1
          END FOR

          IF count > maxCount:
              maxCount = count
              mode     = arr[i]
          END IF
      END FOR

      RETURN mode

  BEGIN main():
      DECLARE arr[] = {1, 2, 3, 2, 4, 2, 5}
      PRINT "Mode: " + findMode(arr)
END
```

---

## 💻 Code

```java
public class FindMode {

    static int findMode(int[] arr) {
        int maxCount = 0;
        int mode     = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mode     = arr[i];
            }
        }

        return mode;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 2, 5};
        int mode  = findMode(arr);
        System.out.println("Mode of the array is: " + mode);
    }
}
```

---

## 🔍 Dry Run

**Array:** `{1, 2, 3, 2, 4, 2, 5}`

| `i` | `arr[i]` | Count in full array | `count > maxCount`? | `mode` | `maxCount` |
|-----|---------|---------------------|--------------------|----|-----------|
| 0 | 1 | 1 | ✅ (1 > 0) | 1 | 1 |
| 1 | 2 | 3 | ✅ (3 > 1) | 2 | 3 |
| 2 | 3 | 1 | ❌ (1 > 3) | 2 | 3 |
| 3 | 2 | 3 | ❌ (3 > 3) | 2 | 3 |
| 4 | 4 | 1 | ❌ (1 > 3) | 2 | 3 |
| 5 | 2 | 3 | ❌ (3 > 3) | 2 | 3 |
| 6 | 5 | 1 | ❌ (1 > 3) | 2 | 3 |

**Result:** `Mode = 2` (appears 3 times) ✅

---

## ⚠️ Edge Cases

| Scenario | Input | Mode |
|----------|-------|------|
| Single element | `{5}` | `5` |
| All same | `{3, 3, 3}` | `3` |
| All unique | `{1, 2, 3}` | `1` (first element — all have count 1) |
| Tie (two modes) | `{1, 1, 2, 2}` | `1` (first one encountered wins — `>` not `>=`) |
| Mode at end | `{1, 2, 3, 3, 3}` | `3` |
| Negative numbers | `{-2, -2, 1}` | `-2` |

> **Tie-breaking:** When two elements have the same frequency, this implementation returns the one encountered **first** in the outer loop because `count > maxCount` uses strict greater-than (`>`), not `>=`.

---

## ⚠️ `>` vs `>=` for Tie-breaking

```java
// Current — strictly greater: returns first mode encountered
if (count > maxCount) { ... }
// Tie: {1,1,2,2} → returns 1 (first found)

// Change to >= to return LAST mode encountered
if (count >= maxCount) { ... }
// Tie: {1,1,2,2} → returns 2 (last found)
```

---

## ⚡ Optimised Alternative — HashMap `O(n)`

The nested loop approach is `O(n²)`. A `HashMap` reduces this to `O(n)`:

```java
static int findMode(int[] arr) {
    HashMap<Integer, Integer> freq = new HashMap<>();

    for (int num : arr) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    int mode = arr[0], maxCount = 0;
    for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
        if (entry.getValue() > maxCount) {
            maxCount = entry.getValue();
            mode     = entry.getKey();
        }
    }
    return mode;
}
```

| Approach | Time | Space |
|----------|------|-------|
| Nested loops (current) | `O(n²)` | `O(1)` |
| HashMap | `O(n)` | `O(n)` |

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Mode** | The value that appears most frequently in a dataset |
| **`count` resets each outer iteration** | `int count = 0` is inside the outer loop — fresh count per candidate |
| **`maxCount` persists** | Declared outside both loops — tracks the global best across all candidates |
| **`>` not `>=`** | Strict comparison ensures first-encountered element wins on ties |
| **Brute force** | `O(n²)` — correct but inefficient for large arrays; `HashMap` preferred in interviews |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n²)` | For every element (`n`), the inner loop scans the full array (`n`) — total `n × n` comparisons. |
| **Space Complexity** | `O(1)` | Only fixed variables (`maxCount`, `mode`, `count`, `i`, `j`) used — no extra data structure. |

---

## 🏷️ Tags
`Java` `DSA` `Arrays` `Mode` `Frequency` `Nested Loops` `HashMap` `Brute Force` `Beginner`