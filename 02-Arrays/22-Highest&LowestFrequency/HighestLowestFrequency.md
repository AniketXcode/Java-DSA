# Highest and Lowest Frequency Element

A Java program finding **both the most and least frequently occurring elements** in an array in a single nested loop pass. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, find the element with the **highest frequency** and the element with the **lowest frequency**, and print both along with their counts.

**Input:**
```
Array: {1, 2, 3, 2, 4, 2, 5}
```

**Expected Output:**
```
Highest Frequency: 3 for number: 2
Lowest Frequency: 1 for number: 1
```

---

## 💡 Approach — Brute Force (Nested For-Each)

1. **Initialise trackers:**
   - `highestFreq = 0` — tracks maximum frequency seen so far
   - `lowestFreq = Integer.MAX_VALUE` — initialised to the largest possible int so any real frequency will be smaller
   - `highestNum` / `lowestNum` — store the corresponding elements

2. **Outer loop** — picks each element `num` as the candidate.

3. **Inner loop** — counts how many times `num` appears in the full array by comparing every `n` against it.

4. **Two independent `if` checks** — after counting frequency for `num`:
   - If `freq > highestFreq` → update highest
   - If `freq < lowestFreq` → update lowest

   Both checks run every iteration (not `if-else`) — a single element's frequency could update both (e.g. in a single-element array).

5. **Print results** — after both loops complete.

---

## 🧮 Pseudocode

```
START
  FUNCTION highestLowestFrequency(arr):
      SET highestFreq = 0
      SET lowestFreq  = Integer.MAX_VALUE
      SET highestNum  = 0
      SET lowestNum   = 0

      FOR each num IN arr:
          SET freq = 0
          FOR each n IN arr:
              IF n == num: freq++
          END FOR

          IF freq > highestFreq:
              highestFreq = freq
              highestNum  = num
          END IF

          IF freq < lowestFreq:
              lowestFreq = freq
              lowestNum  = num
          END IF
      END FOR

      PRINT "Highest Frequency: " + highestFreq + " for number: " + highestNum
      PRINT "Lowest Frequency: "  + lowestFreq  + " for number: " + lowestNum

  BEGIN main():
      DECLARE arr[] = {1, 2, 3, 2, 4, 2, 5}
      CALL highestLowestFrequency(arr)
END
```

---

## 💻 Code

```java
public class HighestLowestFrequency {

    static void highestLowestFrequency(int[] arr) {
        int highestFreq = 0;
        int lowestFreq  = Integer.MAX_VALUE;
        int highestNum  = 0;
        int lowestNum   = 0;

        for (int num : arr) {
            int freq = 0;
            for (int n : arr) {
                if (n == num) freq++;
            }

            if (freq > highestFreq) {
                highestFreq = freq;
                highestNum  = num;
            }
            if (freq < lowestFreq) {
                lowestFreq = freq;
                lowestNum  = num;
            }
        }

        System.out.println("Highest Frequency: " + highestFreq + " for number: " + highestNum);
        System.out.println("Lowest Frequency: "  + lowestFreq  + " for number: " + lowestNum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 2, 5};
        highestLowestFrequency(arr);
    }
}
```

---

## 🔍 Dry Run

**Array:** `{1, 2, 3, 2, 4, 2, 5}`

| `num` | `freq` | `freq > highestFreq`? | `highestFreq` | `highestNum` | `freq < lowestFreq`? | `lowestFreq` | `lowestNum` |
|-------|--------|----------------------|--------------|-------------|---------------------|-------------|------------|
| 1 | 1 | ✅ (1>0) | 1 | 1 | ✅ (1<MAX) | 1 | 1 |
| 2 | 3 | ✅ (3>1) | 3 | 2 | ❌ (3<1) | 1 | 1 |
| 3 | 1 | ❌ (1>3) | 3 | 2 | ❌ (1<1) | 1 | 1 |
| 2 | 3 | ❌ (3>3) | 3 | 2 | ❌ (3<1) | 1 | 1 |
| 4 | 1 | ❌ (1>3) | 3 | 2 | ❌ (1<1) | 1 | 1 |
| 2 | 3 | ❌ (3>3) | 3 | 2 | ❌ (3<1) | 1 | 1 |
| 5 | 1 | ❌ (1>3) | 3 | 2 | ❌ (1<1) | 1 | 1 |

**Result:** Highest = `2` (freq 3), Lowest = `1` (freq 1) ✅

---

## ⚠️ Why `lowestFreq = Integer.MAX_VALUE`?

```java
// ❌ Wrong initialisation
int lowestFreq = 0;
// No real frequency will ever be less than 0
// → lowestFreq never updates → lowestNum stays 0 → wrong result

// ✅ Correct
int lowestFreq = Integer.MAX_VALUE;  // 2,147,483,647
// First real frequency (e.g. 1) is always < MAX_VALUE → updates immediately
```

`Integer.MAX_VALUE` guarantees that the **first frequency encountered** will always be smaller, triggering the first update correctly.

---

## ⚠️ Edge Cases

| Scenario | Input | Highest | Lowest |
|----------|-------|---------|--------|
| All same | `{3, 3, 3}` | `3` (freq 3) | `3` (freq 3) |
| All unique | `{1, 2, 3}` | `1` (first, freq 1) | `1` (first, freq 1) |
| Single element | `{5}` | `5` (freq 1) | `5` (freq 1) |
| Two elements tied | `{1,1,2,2}` | `1` (first) | `1` (first) |
| Clear winner | `{1,2,2,2,3}` | `2` (freq 3) | `1` or `3` (freq 1) |

---

## ⚡ Optimised Alternative — HashMap `O(n)`

```java
static void highestLowestFrequency(int[] arr) {
    HashMap<Integer, Integer> freq = new HashMap<>();

    for (int num : arr)
        freq.put(num, freq.getOrDefault(num, 0) + 1);

    int highestFreq = 0, lowestFreq = Integer.MAX_VALUE;
    int highestNum  = arr[0], lowestNum = arr[0];

    for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
        int num = entry.getKey(), f = entry.getValue();
        if (f > highestFreq) { highestFreq = f; highestNum = num; }
        if (f < lowestFreq)  { lowestFreq  = f; lowestNum  = num; }
    }

    System.out.println("Highest Frequency: " + highestFreq + " for number: " + highestNum);
    System.out.println("Lowest Frequency: "  + lowestFreq  + " for number: " + lowestNum);
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
| **`Integer.MAX_VALUE`** | Safe initialiser for minimum tracking — guarantees first update always fires |
| **`freq` resets each outer iteration** | `int freq = 0` inside outer loop — fresh count per candidate |
| **Two independent `if` checks** | Both highest and lowest updated independently — `else if` would skip one |
| **Brute force** | `O(n²)` — correct but use HashMap for `O(n)` in interviews |
| **Tie-breaking** | First encountered element wins (strict `>` and `<`) |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n²)` | Outer loop runs `n` times; inner loop scans all `n` elements each time. |
| **Space Complexity** | `O(1)` | Only fixed variables used — no extra data structure. |

---

## 🏷️ Tags
`Java` `DSA` `Arrays` `Frequency` `Mode` `Integer.MAX_VALUE` `HashMap` `Brute Force` `Beginner`