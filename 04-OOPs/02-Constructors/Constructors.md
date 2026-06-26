# Constructors — Introduction to Constructors in Java

A simple Java program demonstrating the concept of a **constructor** — a special method that is automatically called when an object is created. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Define a class with a constructor that prints a message, then create an object of that class and observe the constructor being called automatically.

**Expected Output:**
```
This is a constructor.
```

---

## 💡 Approach

1. **Define a constructor** — `public Constructors()` is a special method with the **same name as the class** and **no return type** (not even `void`). It is automatically invoked by the JVM every time a new object of the class is created.

2. **Create an object** — `new Constructors()` allocates memory on the heap for a new object. As part of this process, the JVM automatically calls the constructor — no explicit method call is needed.

3. **Observe the output** — the `System.out.println` inside the constructor runs immediately upon object creation, proving that the constructor was invoked automatically.

---

## 🧮 Pseudocode

```
START
  DEFINE class Constructors:
      CONSTRUCTOR Constructors():
          PRINT "This is a constructor."

  BEGIN main():
      CREATE object obj of type Constructors
          → constructor is automatically invoked
          → PRINT "This is a constructor."
END
```

---

## 💻 Code

```java
public class Constructors {

    // Constructor
    public Constructors() {
        System.out.println("This is a constructor.");
    }

    public static void main(String[] args) {

        // Create an object — constructor is called automatically
        Constructors obj = new Constructors();
    }
}
```

---

## 🔍 Execution Flow

```
JVM starts
    │
    ▼
main() is called
    │
    ▼
new Constructors()
    │
    ├── Memory allocated on heap
    │
    └── Constructor Constructors() is AUTO-INVOKED
            │
            ▼
        "This is a constructor." is printed
            │
            ▼
        Object fully created → reference stored in obj
    │
    ▼
Program ends
```

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Constructor name** | Must exactly match the class name (case-sensitive) |
| **No return type** | Constructors have no return type — not even `void` |
| **Auto-invoked** | Called automatically by `new` — you never call a constructor directly |
| **Default constructor** | If no constructor is defined, Java provides a hidden no-arg constructor that does nothing |
| **Purpose** | Used to initialise object fields or run setup logic when the object is created |

---

## 📌 Types of Constructors in Java

| Type | Description | Example |
|------|-------------|---------|
| **Default / No-arg** | Takes no parameters; provided by Java if none is defined | `Constructors()` |
| **Parameterised** | Takes arguments to initialise fields with custom values | `Constructors(String name)` |
| **Copy Constructor** | Takes another object of the same class to copy its values | `Constructors(Constructors other)` |

---

## ⚠️ Constructor vs Method — Key Differences

| Feature | Constructor | Method |
|---------|------------|--------|
| **Name** | Same as class name | Any valid identifier |
| **Return type** | None (not even `void`) | Must have a return type |
| **When called** | Automatically on `new` | Explicitly by programmer |
| **Purpose** | Initialise the object | Perform an action |
| **Inheritance** | Not inherited | Inherited by subclasses |

---

## ⚡ Extended Example — Parameterised Constructor

```java
public class Constructors {
    String name;

    // Parameterised constructor
    public Constructors(String name) {
        this.name = name;
        System.out.println("Object created for: " + name);
    }

    public static void main(String[] args) {
        Constructors obj = new Constructors("Aniket");
        // Output: Object created for: Aniket
    }
}
```

The `this.name = name` inside the constructor initialises the object's `name` field with the value passed during object creation.

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | Object creation and constructor execution both take constant time; a single print statement is executed. |
| **Space Complexity** | `O(1)` | One object reference (`obj`) is stored on the stack; the object itself occupies fixed memory on the heap. |

---