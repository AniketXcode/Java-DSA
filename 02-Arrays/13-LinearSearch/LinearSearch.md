# Linear Search

A Java program implementing the **Linear Search** algorithm — the simplest searching technique that checks every element one by one until the target is found or the array is exhausted. This is part of the Searching Algorithms section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array and a target value, search for the target and return its index if found, or `-1` if not present.

**Input:**
```
Array  : {5, 3, 8, 4, 2}
Target : 4
```

**Expected Output:**
```
Element found at index: 3
```

---

## 💡 Approach

1. **Traverse the array** — start from index `0` and visit every element one by one.
2. **Compare each element** — at each index `i`, check if `arr[i] == target`.
3. **Found** — if a match is found, immediately `return i` (the index). The search stops early.
4. **Not found** — if the loop completes without finding the target, `return -1` to signal absence.
5. **Check result in `main()`** — if result is not `-1`, print the index; otherwise print "not found."

> Linear Search works on **any array** — sorted or unsorted — making it the most universally applicable search algorithm.

---

## 🧮 Pseudocode

```
START
  FUNCTION linearSearch(arr, target):
      FOR i = 0 to arr.length - 1:
          IF arr[i] == target:
              RETURN i          // found — return index immediately
          END IF
      END FOR
      RETURN -1                 // not found

  BEGIN main():
      DECLARE arr[]  = {5, 3, 8, 4, 2}
      SET target = 4

      SET result = linearSearch(arr, target)

      IF result != -1:
          PRINT "Element found at index: " + result
      ELSE:
          PRINT "Element not found."
      END IF
END
```

---

## 💻 Code

```java
public class LinearSearch {

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;    // target found — return index
            }
        }
        return -1;           // target not found
    }

    public static void main(String[] args) {
        int[] arr   = {5, 3, 8, 4, 2};
        int target  = 4;

        int result = linearSearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
```

---

## 🔍 Dry Run

**Array:** `{5, 3, 8, 4, 2}` | **Target:** `4`

| `i` | `arr[i]` | `arr[i] == 4`? | Action |
|-----|---------|----------------|--------|
| 0 | 5 | ❌ No | Continue |
| 1 | 3 | ❌ No | Continue |
| 2 | 8 | ❌ No | Continue |
| 3 | 4 | ✅ Yes | Return `3` |

**Result:** `Element found at index: 3` ✅

---

## ⚠️ Edge Cases

| Scenario | Input | Output |
|----------|-------|--------|
| Target at first index | `arr={4,1,2}`, target=`4` | `Index: 0` |
| Target at last index | `arr={1,2,4}`, target=`4` | `Index: 2` |
| Target not present | `arr={1,2,3}`, target=`9` | `-1` |
| Empty array | `arr={}`, target=`4` | `-1` |
| Duplicate elements | `arr={4,2,4}`, target=`4` | `Index: 0` (first occurrence) |

---

## 📌 Best, Average & Worst Case

| Case | Condition | Comparisons | Complexity |
|------|-----------|-------------|-----------|
| **Best** | Target is at index `0` | 1 | `O(1)` |
| **Average** | Target is somewhere in the middle | `n/2` | `O(n)` |
| **Worst** | Target is at last index or not present | `n` | `O(n)` |

---

## ⚡ Linear Search vs Binary Search

| Feature | Linear Search | Binary Search |
|---------|--------------|--------------|
| **Array requirement** | Works on any array (sorted or unsorted) | Requires **sorted** array |
| **Time Complexity** | `O(n)` | `O(log n)` |
| **Space Complexity** | `O(1)` | `O(1)` iterative / `O(log n)` recursive |
| **Best for** | Small or unsorted arrays | Large sorted arrays |
| **Early exit** | ✅ Yes — stops when found | ✅ Yes — halves search space |
| **Implementation** | Simple | More complex |

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Return `-1`** | Standard convention to indicate "not found" in search problems |
| **Early return** | `return i` exits the method immediately — no need to check remaining elements |
| **Works unsorted** | No preprocessing required — works on any array as-is |
| **Static method** | `linearSearch()` is reusable and callable without creating an object |
| **First occurrence** | Returns index of first match if duplicates exist |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | In the worst case (target not found or at last index), every element is visited once. |
| **Space Complexity** | `O(1)` | Only a fixed number of variables (`i`, `target`, `result`) are used — no extra data structure. |

---