# `final` Keyword in Java

A Java program demonstrating the **`final` keyword** applied to a variable, a method, and a class — preventing modification, overriding, and inheritance respectively. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Create a `final` class `College` with a `final` variable `collegeName` and a `final` method `displayCollege()`. Access and display the values from another class, and observe that the `final` variable cannot be reassigned.

**Expected Output:**
```
College: TMU
College Name: TMU
```

---

## 💡 Approach

1. **`final` class** — `final class College` cannot be extended by any other class. Attempting `class XYZ extends College {}` causes a compile error. Used when the class design is complete and should not be altered through inheritance (e.g. `java.lang.String` is a `final` class).

2. **`final` variable** — `final String collegeName = "TMU"` is a constant — its value is assigned once and can **never be changed** after that. Any attempt to reassign (`obj.collegeName = "ABC"`) causes a compile error.

3. **`final` method** — `final void displayCollege()` can be inherited by a child class but **cannot be overridden**. It locks the method's behaviour so no subclass can alter it. (Here, since `College` itself is `final`, this is doubly locked — but the concept applies independently.)

4. **Accessing `final` members** — a `College` object is created normally, its method is called, and the `final` field is read via `obj.collegeName`. Reading is always allowed — only writing is blocked.

---

## 🧮 Pseudocode

```
START
  DEFINE final class College:
      FINAL FIELD collegeName = "TMU"

      FINAL METHOD displayCollege():
          PRINT "College: " + collegeName

  BEGIN main():
      CREATE obj of type College

      CALL obj.displayCollege()             → "College: TMU"
      PRINT "College Name: " + obj.collegeName  → "College Name: TMU"

      // obj.collegeName = "ABC"  → COMPILE ERROR (final variable)
END
```

---

## 💻 Code

```java
// Final Class — cannot be extended
final class College {

    // Final Variable — value cannot be changed after assignment
    final String collegeName = "TMU";

    // Final Method — cannot be overridden in a subclass
    final void displayCollege() {
        System.out.println("College: " + collegeName);
    }
}

public class FinalKeyword {
    public static void main(String[] args) {

        College obj = new College();

        obj.displayCollege();

        System.out.println("College Name: " + obj.collegeName);

        // obj.collegeName = "ABC"; // ❌ Error: Cannot assign a value to final variable
    }
}
```

---

## 🔍 Dry Run

| Step | Action | `collegeName` | Output |
|------|--------|--------------|--------|
| 1 | `College obj = new College()` | `"TMU"` (assigned at declaration) | — |
| 2 | `obj.displayCollege()` | `"TMU"` (read only) | `College: TMU` |
| 3 | `obj.collegeName` accessed | `"TMU"` (read only) | `College Name: TMU` |
| 4 | `obj.collegeName = "ABC"` | ❌ Compile error | — |

---

## 🔑 Three Uses of `final`

| Applied To | Effect | Example |
|-----------|--------|---------|
| **Variable** | Value cannot be changed after assignment (constant) | `final String name = "TMU"` |
| **Method** | Cannot be overridden in a subclass | `final void display() { }` |
| **Class** | Cannot be extended (subclassed) | `final class College { }` |

---

## ⚠️ What `final` Prevents — Code Examples

```java
// ❌ 1. Reassigning a final variable
final int x = 10;
x = 20;  // Compile error: cannot assign a value to final variable x

// ❌ 2. Extending a final class
final class College { }
class XYZ extends College { }  // Compile error: cannot inherit from final College

// ❌ 3. Overriding a final method
class College {
    final void display() { System.out.println("TMU"); }
}
class XYZ extends College {
    void display() { }  // Compile error: display() in XYZ cannot override display() in College
}
```

---

## 📌 `final` vs `static` vs `static final`

| Modifier | Meaning | Example |
|----------|---------|---------|
| `final` | Value fixed after assignment; one copy per object | `final int x = 10` |
| `static` | Shared across all objects; belongs to class | `static int count = 0` |
| `static final` | Class-level constant — shared and immutable | `static final double PI = 3.14` |

> `static final` is the standard way to define **constants** in Java (like `Math.PI`, `Integer.MAX_VALUE`). By convention, constant names are written in `UPPER_SNAKE_CASE`.

```java
static final String COLLEGE_NAME = "TMU";  // ✅ constant best practice
```

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **`final` variable** | Acts as a constant — must be initialised at declaration or in constructor |
| **`final` method** | Inherited but locked — no subclass can override it |
| **`final` class** | Complete and sealed — no inheritance allowed |
| **`final` parameter** | Method parameter cannot be modified inside the method body |
| **`String` is `final`** | `java.lang.String` is a `final` class — that's why strings are immutable in Java |

---

## ⚡ `final` with Constructor Initialisation

```java
class Student {
    final String name;  // not assigned here

    Student(String name) {
        this.name = name;  // ✅ assigned once in constructor — allowed
    }
}
// After object creation, name is permanently fixed
```

A `final` instance variable doesn't have to be initialised at declaration — it can be assigned **once** inside the constructor. After that, any reassignment causes a compile error.

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | Object creation, method call, and field read all execute in constant time. |
| **Space Complexity** | `O(1)` | One object with one fixed string field — space does not grow with input. |

---