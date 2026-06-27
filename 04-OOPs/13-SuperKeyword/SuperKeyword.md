# `super` Keyword in Java

A Java program demonstrating all three uses of the **`super` keyword** — calling the parent constructor, accessing a hidden parent variable, and invoking an overridden parent method from the child class. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Create a parent class `Animal` and a child class `Dog`, both with a field named `name` and a method. Use `super()` to call the parent constructor, `super.name` to access the shadowed parent field, and `super.display()` to call the parent method from within the child.

**Expected Output:**
```
Parent Constructor Called
Child Constructor Called

Parent Name: Animal
Child Name: Dog
Parent Method
```

---

## 💡 Approach

The `super` keyword has **three distinct uses** in Java, and this program demonstrates all three:

1. **`super()` — Call parent constructor** — the first statement in `Dog()`'s constructor is `super()`, which explicitly calls `Animal()`'s constructor. This prints `"Parent Constructor Called"` before the child's own constructor body continues. Even without writing `super()`, Java inserts it implicitly — but writing it explicitly makes the intent clear.

2. **`super.name` — Access shadowed parent field** — both `Animal` and `Dog` declare a field named `name`. Inside `Dog`, the child's `name` **shadows** (hides) the parent's `name`. Using `super.name` reaches past the child's field to read the **parent's version** directly.

3. **`super.display()` — Call parent method** — if `Dog` had overridden `display()`, calling `display()` inside `Dog` would call Dog's version. Using `super.display()` explicitly calls the **parent's version** regardless of overriding.

---

## 🧮 Pseudocode

```
START
  DEFINE class Animal:
      FIELD name = "Animal"
      CONSTRUCTOR Animal():
          PRINT "Parent Constructor Called"
      METHOD display():
          PRINT "Parent Method"

  DEFINE class Dog EXTENDS Animal:
      FIELD name = "Dog"
      CONSTRUCTOR Dog():
          super()                            // calls Animal()
          PRINT "Child Constructor Called"
      METHOD show():
          PRINT "Parent Name: " + super.name    // Animal's name
          PRINT "Child Name: "  + this.name     // Dog's name
          super.display()                        // Animal's display()

  BEGIN main():
      CREATE obj = new Dog()          // triggers both constructors
      CALL obj.show()
END
```

---

## 💻 Code

```java
// Parent Class
class Animal {
    String name = "Animal";

    Animal() {
        System.out.println("Parent Constructor Called");
    }

    void display() {
        System.out.println("Parent Method");
    }
}

// Child Class
class Dog extends Animal {
    String name = "Dog";

    Dog() {
        super();  // Calls Parent Constructor
        System.out.println("Child Constructor Called");
    }

    void show() {
        System.out.println("Parent Name: " + super.name);  // Animal's name
        System.out.println("Child Name: "  + this.name);   // Dog's name
        super.display();                                     // Animal's display()
    }
}

public class SuperKeyword {
    public static void main(String[] args) {

        Dog obj = new Dog();

        System.out.println();

        obj.show();
    }
}
```

---

## 🔍 Dry Run — Execution Flow

**Phase 1: `new Dog()` — Constructor chain**

| Step | What Happens | Output |
|------|-------------|--------|
| 1 | `Dog()` constructor starts | — |
| 2 | `super()` → `Animal()` constructor runs | `Parent Constructor Called` |
| 3 | Control returns to `Dog()` | — |
| 4 | `Dog()` body continues | `Child Constructor Called` |

**Phase 2: `obj.show()` — Field and method access**

| Statement | Resolved To | Output |
|-----------|------------|--------|
| `super.name` | `Animal.name` | `Parent Name: Animal` |
| `this.name` | `Dog.name` | `Child Name: Dog` |
| `super.display()` | `Animal.display()` | `Parent Method` |

---

## 📌 Memory Diagram — Field Shadowing

```
Dog object in Heap
┌──────────────────────────────┐
│  [Inherited from Animal]     │
│  name = "Animal"  ← super.name reaches here
│                              │
│  [Dog's own fields]          │
│  name = "Dog"     ← this.name reaches here
└──────────────────────────────┘
```

Both fields coexist in the same object. `this.name` picks up the child's copy; `super.name` reaches the parent's copy.

---

## 🔑 Three Uses of `super`

| Use | Syntax | Purpose |
|-----|--------|---------|
| **Call parent constructor** | `super()` or `super(args)` | Invoke parent's constructor from child's constructor |
| **Access parent field** | `super.fieldName` | Read parent's field when child has a same-named field (shadowing) |
| **Call parent method** | `super.methodName()` | Invoke parent's method when child has overridden it |

---

## ⚠️ Rules for `super()`

```java
Dog() {
    super();                          // ✅ must be the FIRST statement
    System.out.println("Child");
}

Dog() {
    System.out.println("Child");
    super();  // ❌ Compile error — super() must be first statement
}
```

> If you don't explicitly write `super()`, Java **automatically inserts** a no-arg `super()` call as the first line of every child constructor. If the parent has no no-arg constructor, you **must** call the correct parameterized `super(args)` explicitly.

---

## 📌 `super` vs `this` — Full Comparison

| Feature | `super` | `this` |
|---------|---------|--------|
| **Refers to** | Parent class | Current object |
| **Constructor call** | `super()` — calls parent constructor | `this()` — calls another constructor in same class |
| **Field access** | `super.field` — parent's shadowed field | `this.field` — current object's field |
| **Method call** | `super.method()` — parent's version | `this.method()` — current object's version |
| **In `static` context** | ❌ Not allowed | ❌ Not allowed |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | Constructor calls, field access, and method calls all execute in constant time. |
| **Space Complexity** | `O(1)` | One `Dog` object holding two `name` fields (parent + child) — fixed space. |

---
