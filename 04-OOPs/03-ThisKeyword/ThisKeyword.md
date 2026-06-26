# `this` Keyword in Java

A Java program demonstrating the use of the **`this` keyword** to distinguish instance variables from constructor/method parameters when they share the same name. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Create a class with `name` and `age` fields, use a parameterized constructor with same-named parameters, and apply the `this` keyword to correctly assign values to instance variables. Display the data for two different objects.

**Expected Output:**
```
Name: Aniket
Age: 22

Name: Rahul
Age: 20
```

---

## 💡 Approach

1. **Declare instance fields** — `String name` and `int age` are declared at the class level, belonging to each object individually.

2. **Parameterized constructor with `this`** — the constructor parameters are intentionally named `name` and `age` — the **same as the instance fields**. Without `this`, Java cannot tell which `name` refers to the field and which refers to the parameter. The `this` keyword resolves this:
   - `this.name = name` → assign the **parameter** `name` to the **instance field** `this.name`
   - `this.age = age` → assign the **parameter** `age` to the **instance field** `this.age`

3. **`this` in `display()`** — `this.name` and `this.age` explicitly refer to the **current object's** fields. While optional here (no naming conflict), it makes clear that the fields belong to the object being acted on.

4. **Two objects** — `obj1` and `obj2` are two independent instances. Each has its own copy of `name` and `age`, proving that `this` always refers to **whichever object the method is currently running on**.

---

## 🧮 Pseudocode

```
START
  DEFINE class ThisKeyword:
      FIELDS: name, age

      CONSTRUCTOR(name, age):
          this.name = name        // instance field = parameter
          this.age  = age

      METHOD display():
          PRINT this.name
          PRINT this.age

  BEGIN main():
      CREATE obj1 = new ThisKeyword("Aniket", 22)
      CALL obj1.display()

      CREATE obj2 = new ThisKeyword("Rahul", 20)
      CALL obj2.display()
END
```

---

## 💻 Code

```java
public class ThisKeyword {

    String name;
    int age;

    // Parameterized Constructor
    ThisKeyword(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    // Display Method
    void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: "  + this.age);
    }

    public static void main(String[] args) {

        ThisKeyword obj1 = new ThisKeyword("Aniket", 22);
        obj1.display();

        System.out.println();

        ThisKeyword obj2 = new ThisKeyword("Rahul", 20);
        obj2.display();
    }
}
```

---

## 🔍 Dry Run — `this` in Action

**`obj1` = `new ThisKeyword("Aniket", 22)`:**

| Inside Constructor | `this` refers to | Parameter | Instance Field after assignment |
|--------------------|-----------------|-----------|-------------------------------|
| `this.name = name` | `obj1` | `"Aniket"` | `obj1.name = "Aniket"` |
| `this.age  = age`  | `obj1` | `22`       | `obj1.age  = 22`       |

**`obj2` = `new ThisKeyword("Rahul", 20)`:**

| Inside Constructor | `this` refers to | Parameter | Instance Field after assignment |
|--------------------|-----------------|-----------|-------------------------------|
| `this.name = name` | `obj2` | `"Rahul"` | `obj2.name = "Rahul"` |
| `this.age  = age`  | `obj2` | `20`      | `obj2.age  = 20`      |

> `this` dynamically refers to the **object that triggered the constructor/method call** — `obj1` when creating the first object, `obj2` when creating the second.

---

## ⚠️ What Happens Without `this`?

```java
ThisKeyword(String name, int age) {
    name = name;   // ❌ assigns parameter to itself — instance field unchanged!
    age  = age;    // ❌ same problem
}
```

Without `this`, both `name` and `age` on the left side refer to the **local parameter**, not the instance field. The instance fields remain at their default values (`null` for `String`, `0` for `int`) — a silent bug.

---

## 🔑 Key Uses of `this` in Java

| Use Case | Syntax | Purpose |
|----------|--------|---------|
| **Resolve naming conflict** | `this.field = param` | Distinguish instance field from same-named parameter |
| **Call another constructor** | `this()` or `this(args)` | Constructor chaining within the same class |
| **Pass current object** | `method(this)` | Pass the current object as an argument to another method |
| **Return current object** | `return this` | Used in method chaining / builder pattern |

---

## 📌 Memory Diagram

```
Stack                    Heap
──────────────────────   ──────────────────────────────
obj1 ──────────────────► [ name = "Aniket" | age = 22 ]
obj2 ──────────────────► [ name = "Rahul"  | age = 20 ]
```

Each object on the heap has its **own copy** of `name` and `age`. `this` inside any method points to the object on the heap that the method was called on.

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | Object creation, field assignment via `this`, and `display()` all execute in constant time. |
| **Space Complexity** | `O(1)` | Two objects with a fixed number of fields — space does not grow with input. |

---