# Multiple Objects & Instance Variables

A Java program demonstrating how **multiple objects of the same class** each maintain their own independent copy of instance variables. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Create a class with instance variables `name` and `age`, create two separate objects of the class, assign different values to each object's fields directly, and display them using a shared `display()` method.

**Expected Output:**
```
Name: Aniket
Age: 22

Name: Rahul
Age: 20
```

---

## 💡 Approach

1. **Declare instance variables** — `String name` and `int age` are declared at the class level (outside any method). They are called **instance variables** because each object gets its **own independent copy** of these fields.

2. **Create two objects** — `obj1` and `obj2` are two separate instances of `ClassAndObject`, each allocated independently on the heap. They share the class blueprint but have **completely separate memory** for their fields.

3. **Assign values directly** — since `name` and `age` have package-private (default) access, they can be directly set using dot notation (`obj1.name = "Aniket"`). This approach is simpler but less encapsulated than using a constructor or setter methods.

4. **Call `display()`** — `obj1.display()` prints `obj1`'s fields, and `obj2.display()` prints `obj2`'s fields. The same method works correctly for both because inside the method, field names (`name`, `age`) always refer to the fields of whichever object the method was called on.

---

## 🧮 Pseudocode

```
START
  DEFINE class ClassAndObject:
      FIELDS: name, age

      METHOD display():
          PRINT name, age

  BEGIN main():
      CREATE obj1
      SET obj1.name = "Aniket"
      SET obj1.age  = 22

      CREATE obj2
      SET obj2.name = "Rahul"
      SET obj2.age  = 20

      CALL obj1.display()     → "Aniket", 22
      CALL obj2.display()     → "Rahul", 20
END
```

---

## 💻 Code

```java
public class ClassAndObject {

    // Instance Variables
    String name;
    int age;

    // Method
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: "  + age);
    }

    public static void main(String[] args) {

        // Creating First Object
        ClassAndObject obj1 = new ClassAndObject();
        obj1.name = "Aniket";
        obj1.age  = 22;

        // Creating Second Object
        ClassAndObject obj2 = new ClassAndObject();
        obj2.name = "Rahul";
        obj2.age  = 20;

        // Calling Method
        obj1.display();
        System.out.println();
        obj2.display();
    }
}
```

---

## 🔍 Dry Run — Object State

| Step | Action | `obj1.name` | `obj1.age` | `obj2.name` | `obj2.age` |
|------|--------|------------|-----------|------------|-----------|
| 1 | `new ClassAndObject()` → obj1 created | `null` | `0` | — | — |
| 2 | `obj1.name = "Aniket"` | `"Aniket"` | `0` | — | — |
| 3 | `obj1.age = 22` | `"Aniket"` | `22` | — | — |
| 4 | `new ClassAndObject()` → obj2 created | `"Aniket"` | `22` | `null` | `0` |
| 5 | `obj2.name = "Rahul"` | `"Aniket"` | `22` | `"Rahul"` | `0` |
| 6 | `obj2.age = 20` | `"Aniket"` | `22` | `"Rahul"` | `20` |
| 7 | `obj1.display()` | prints `"Aniket"` | prints `22` | unchanged | unchanged |
| 8 | `obj2.display()` | unchanged | unchanged | prints `"Rahul"` | prints `20` |

> Changing `obj2`'s fields has **zero effect** on `obj1`'s fields — they are completely independent.

---

## 📌 Memory Diagram

```
Stack                      Heap
────────────────────────   ─────────────────────────────────
obj1 ──────────────────►  [ name = "Aniket" | age = 22 ]
obj2 ──────────────────►  [ name = "Rahul"  | age = 20 ]
```

Both `obj1` and `obj2` are **reference variables** on the stack that point to **separate objects** on the heap. Modifying one does not affect the other.

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Instance variable** | Declared at class level; each object gets its own separate copy |
| **Default values** | `String` defaults to `null`, `int` defaults to `0` before assignment |
| **Object reference** | `obj1` and `obj2` are references (addresses) stored on the stack pointing to objects on the heap |
| **Shared method** | `display()` is defined once but works correctly for any object it's called on |
| **Direct field access** | Setting fields via `obj.field = value` works but breaks encapsulation — using constructors or setters is best practice |

---

## ⚠️ Direct Access vs Encapsulated Approach

```java
// Direct field access (current approach — less encapsulated)
obj1.name = "Aniket";
obj1.age  = 22;

// Better practice — use constructor
ClassAndObject obj1 = new ClassAndObject("Aniket", 22);

// Best practice — use private fields + setters (Encapsulation)
private String name;
public void setName(String name) { this.name = name; }
```

Direct access works fine for learning, but in production code, fields should be `private` and accessed via **getters/setters** to enforce encapsulation.

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | Creating objects, assigning fields, and calling `display()` all take constant time. |
| **Space Complexity** | `O(1)` | Two objects with a fixed number of fields are created — space does not grow with input. |

---