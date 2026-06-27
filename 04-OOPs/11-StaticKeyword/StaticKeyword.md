# `static` Keyword in Java

A Java program demonstrating the **`static` keyword** — how static variables and methods belong to the class itself rather than to any individual object, and how they differ from instance variables and methods. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Create a class with a `static` variable `college` (shared across all objects), an instance variable `name` (unique per object), a static method `displayCollege()`, and an instance method `displayStudent()`. Demonstrate the difference between class-level and object-level members.

**Expected Output:**
```
College: TMU
Name: Aniket
Name: Rahul
```

---

## 💡 Approach

1. **Static variable** — `static String college = "TMU"` belongs to the **class**, not to any specific object. It is created once in memory when the class is loaded and **shared** across all instances. Changing `college` in one place changes it for every object.

2. **Instance variable** — `String name` belongs to **each object individually**. Every `new StaticKeyword(...)` creates its own separate copy of `name` in heap memory.

3. **Static method** — `static void displayCollege()` also belongs to the class. It can be called **without creating an object** using `ClassName.method()`. Static methods can only access other `static` members — they have no `this` reference.

4. **Instance method** — `void displayStudent()` belongs to each object and can access both instance and static members. It requires an object to be called.

5. **Calling patterns:**
   - `StaticKeyword.displayCollege()` → called on the **class** (no object needed)
   - `obj1.displayStudent()` → called on a **specific object**

---

## 🧮 Pseudocode

```
START
  DEFINE class StaticKeyword:
      STATIC FIELD  college = "TMU"     // shared across all objects
      INSTANCE FIELD name               // unique per object

      CONSTRUCTOR(name):
          this.name = name

      STATIC METHOD displayCollege():
          PRINT "College: " + college

      INSTANCE METHOD displayStudent():
          PRINT "Name: " + name

  BEGIN main():
      CREATE obj1 = new StaticKeyword("Aniket")
      CREATE obj2 = new StaticKeyword("Rahul")

      CALL StaticKeyword.displayCollege()   → "College: TMU"
      CALL obj1.displayStudent()            → "Name: Aniket"
      CALL obj2.displayStudent()            → "Name: Rahul"
END
```

---

## 💻 Code

```java
public class StaticKeyword {

    // Static Variable — shared across all objects
    static String college = "TMU";

    // Instance Variable — unique per object
    String name;

    // Constructor
    StaticKeyword(String name) {
        this.name = name;
    }

    // Static Method — belongs to the class
    static void displayCollege() {
        System.out.println("College: " + college);
    }

    // Instance Method — belongs to each object
    void displayStudent() {
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        StaticKeyword obj1 = new StaticKeyword("Aniket");
        StaticKeyword obj2 = new StaticKeyword("Rahul");

        // Call static method on class
        StaticKeyword.displayCollege();

        // Call instance methods on objects
        obj1.displayStudent();
        obj2.displayStudent();
    }
}
```

---

## 🔍 Memory Diagram

```
Class Area (Method Area)              Heap
──────────────────────────────        ──────────────────────────────
StaticKeyword.college = "TMU"  ←───  shared by all instances
StaticKeyword.displayCollege()

                                      obj1 → [ name = "Aniket" ]
                                      obj2 → [ name = "Rahul"  ]
```

- `college` lives in the **class/method area** — one copy for the entire class.
- `name` lives in the **heap** — a separate copy inside each object.

---

## 🔍 Dry Run

| Step | Action | `college` | `obj1.name` | `obj2.name` |
|------|--------|-----------|------------|------------|
| 1 | Class loaded | `"TMU"` | — | — |
| 2 | `new StaticKeyword("Aniket")` | `"TMU"` | `"Aniket"` | — |
| 3 | `new StaticKeyword("Rahul")` | `"TMU"` | `"Aniket"` | `"Rahul"` |
| 4 | `StaticKeyword.displayCollege()` | prints `"TMU"` | — | — |
| 5 | `obj1.displayStudent()` | — | prints `"Aniket"` | — |
| 6 | `obj2.displayStudent()` | — | — | prints `"Rahul"` |

---

## ⚠️ Static vs Instance — Key Restrictions

```java
static void displayCollege() {
    System.out.println(college);   // ✅ static accessing static
    System.out.println(name);      // ❌ compile error — cannot access instance variable from static context
    displayStudent();              // ❌ compile error — cannot call instance method from static method
}

void displayStudent() {
    System.out.println(name);      // ✅ instance accessing instance
    System.out.println(college);   // ✅ instance can access static too
    displayCollege();              // ✅ instance can call static method
}
```

---

## 🔑 Static vs Instance — Full Comparison

| Feature | `static` Member | Instance Member |
|---------|----------------|----------------|
| **Belongs to** | Class | Object |
| **Memory** | Class/Method Area — one copy | Heap — one copy per object |
| **Created when** | Class is loaded by JVM | `new` keyword is used |
| **Access without object** | ✅ `ClassName.member` | ❌ Needs an object |
| **Access via object** | ✅ (allowed but not recommended) | ✅ `obj.member` |
| **`this` keyword** | ❌ Not available | ✅ Available |
| **Can access static?** | ✅ Yes | ✅ Yes |
| **Can access instance?** | ❌ No | ✅ Yes |
| **Use case** | Shared data (counters, constants) | Per-object data (name, age) |

---

## ⚡ Real-world Use of `static`

```java
// 1. Static counter — counts total objects created
class Student {
    static int count = 0;
    String name;

    Student(String name) {
        this.name = name;
        count++;  // increments the shared counter
    }
}

Student s1 = new Student("Aniket");
Student s2 = new Student("Rahul");
System.out.println(Student.count);  // 2

// 2. Constants
static final double PI = 3.14159;   // Math.PI equivalent

// 3. Utility methods (no object needed)
static int add(int a, int b) { return a + b; }
```

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | Object creation, field assignment, and all method calls execute in constant time. |
| **Space Complexity** | `O(1)` | One static variable (shared), two objects each with one instance field — fixed space. |

---