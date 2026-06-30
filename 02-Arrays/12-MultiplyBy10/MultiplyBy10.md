# Multiply Array Elements by 10 — Pass by Reference

A Java program demonstrating how **arrays are passed by reference** to methods — modifications made inside the method directly affect the original array in the caller. This is part of the Arrays section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Given an integer array, multiply every element by `10` using a static method, and print the modified array back in `main()`.

**Input:**
```
Array: {1, 2, 3, 4, 5}
```

**Expected Output:**
```
Array after multiplying by 10: 10 20 30 40 50
```

---

## 💡 Approach

1. **Define a static method** — `multiplyBy10(int[] arr)` takes an integer array as a parameter and multiplies each element by `10` using `arr[i] *= 10`.

2. **Pass the array to the method** — `multiplyBy10(arr)` is called from `main()`. In Java, arrays are **objects** stored on the heap. When passed to a method, the **reference (memory address)** is passed — not a copy of the array. Both `main()`'s `arr` and the method's `arr` parameter point to the **same array in memory**.

3. **In-place modification** — since the method works on the same memory, changes made inside `multiplyBy10()` are visible back in `main()` after the method returns — no return value needed.

4. **Print result in `main()`** — after calling `multiplyBy10(arr)`, the original array is already modified. A `for-each` loop in `main()` prints the updated values.

---

## 🧮 Pseudocode

```
START
  FUNCTION multiplyBy10(arr):
      FOR i = 0 to arr.length - 1:
          arr[i] = arr[i] * 10
      END FOR

  BEGIN main():
      DECLARE arr[] = {1, 2, 3, 4, 5}

      CALL multiplyBy10(arr)      // original arr is modified in place

      PRINT arr[]                 // prints modified array
END
```

---

## 💻 Code

```java
public class MultiplyBy10 {

    static void multiplyBy10(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 10;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        multiplyBy10(arr);

        System.out.print("Array after multiplying by 10: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
```

---

## 🔍 Dry Run

**Before call:** `arr = {1, 2, 3, 4, 5}`

**Inside `multiplyBy10()`:**

| `i` | `arr[i]` before | `arr[i] *= 10` | `arr[i]` after |
|-----|----------------|----------------|----------------|
| 0 | 1 | 1 × 10 | 10 |
| 1 | 2 | 2 × 10 | 20 |
| 2 | 3 | 3 × 10 | 30 |
| 3 | 4 | 4 × 10 | 40 |
| 4 | 5 | 5 × 10 | 50 |

**After call (back in `main()`):** `arr = {10, 20, 30, 40, 50}` ✅

---

## 📌 Pass by Reference — Memory Diagram

```
main()                           Heap
──────────────────────           ──────────────────────────────
arr  ──────────────────────────► [ 1 | 2 | 3 | 4 | 5 ]
                                          ▲
multiplyBy10(arr)                         │
──────────────────────           ─────────┘
arr (parameter) ─────────────── same memory address
```

Both `main()`'s `arr` and the method's `arr` parameter are **two different variables pointing to the same array**. When the method writes `arr[i] *= 10`, it modifies the actual array on the heap — and `main()` sees those changes immediately.

---

## ⚠️ Pass by Value vs Pass by Reference in Java

Java is technically **always pass by value** — but for objects and arrays, the *value* being passed is the **reference (memory address)**, not the data itself:

```java
// Primitives — true pass by value (copy made)
static void change(int x) {
    x = 100;  // only local copy changes
}
int a = 5;
change(a);
System.out.println(a);  // still 5 — original unchanged ✅

// Arrays — reference passed (same memory)
static void change(int[] arr) {
    arr[0] = 100;  // modifies original array
}
int[] arr = {1, 2, 3};
change(arr);
System.out.println(arr[0]);  // 100 — original changed ✅
```

| Type | What is passed | Original changed? |
|------|---------------|------------------|
| Primitive (`int`, `double`) | Copy of value | ❌ No |
| Array / Object | Copy of reference (address) | ✅ Yes |

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **`arr[i] *= 10`** | Shorthand for `arr[i] = arr[i] * 10` |
| **Pass by reference** | Arrays are passed as a memory address — method works on the original |
| **In-place modification** | Array is changed inside the method without needing a return value |
| **`void` return type** | No value is returned because the original array is modified directly |
| **Static method** | Called without creating an object — `multiplyBy10(arr)` directly |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(n)` | The loop inside `multiplyBy10()` visits every element exactly once. |
| **Space Complexity** | `O(1)` | Modification is done in-place — no extra array is created; only the loop variable `i` is used. |

---