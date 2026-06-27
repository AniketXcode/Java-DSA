# Polymorphism in Java

A Java program demonstrating **runtime polymorphism** — where a single parent class reference variable holds different child class objects at different times, and the correct overridden method is resolved dynamically at runtime. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Create a parent class `Animal` with a `sound()` method, and two child classes `Dog` and `Cat` that each override `sound()`. Use a single `Animal` reference variable to hold both child objects at different times and observe that the correct version of `sound()` is called based on the actual object type.

**Expected Output:**
```
Dog barks
Cat meows
```

---

## 💡 Approach

1. **Define the parent and children** — `Animal` has a generic `sound()` method. `Dog` and `Cat` each override it with their own specific implementation using `@Override`.

2. **Declare an `Animal` reference** — `Animal obj` is a reference variable of the **parent type**. In Java, a parent reference can hold an object of any child class — this is the foundation of polymorphism.

3. **Assign a `Dog` object** — `obj = new Dog()` stores a `Dog` object in the `Animal` reference. When `obj.sound()` is called, the JVM checks the **actual object type** at runtime (which is `Dog`) and calls `Dog`'s `sound()` — not `Animal`'s.

4. **Reassign to a `Cat` object** — `obj = new Cat()` now makes the same reference point to a `Cat`. Calling `obj.sound()` again triggers `Cat`'s version. The **reference type is `Animal` throughout** — only the actual object changes.

5. This is **runtime polymorphism (dynamic method dispatch)** — "one interface (`Animal`), multiple behaviours (`Dog`, `Cat`)."

---

## 🧮 Pseudocode

```
START
  DEFINE class Animal:
      METHOD sound(): PRINT "Animal makes a sound"

  DEFINE class Dog EXTENDS Animal:
      OVERRIDE sound(): PRINT "Dog barks"

  DEFINE class Cat EXTENDS Animal:
      OVERRIDE sound(): PRINT "Cat meows"

  BEGIN main():
      DECLARE obj of type Animal

      obj = new Dog()
      CALL obj.sound()     → JVM sees Dog → "Dog barks"

      obj = new Cat()
      CALL obj.sound()     → JVM sees Cat → "Cat meows"
END
```

---

## 💻 Code

```java
// Parent Class
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Child Class 1
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

// Child Class 2
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Polymorphism {
    public static void main(String[] args) {

        Animal obj;

        obj = new Dog();
        obj.sound();       // Dog barks

        obj = new Cat();
        obj.sound();       // Cat meows
    }
}
```

---

## 🔍 Dry Run — Dynamic Dispatch

| Step | `obj` reference type | Actual object | `obj.sound()` resolves to | Output |
|------|---------------------|--------------|--------------------------|--------|
| 1 | `Animal` | `Dog` | `Dog.sound()` | `Dog barks` |
| 2 | `Animal` | `Cat` | `Cat.sound()` | `Cat meows` |

> The **reference type** (`Animal`) never changes — only the **object it points to** changes. The JVM always looks at the actual object to resolve the method call.

---

## 📌 Memory Diagram

```
Step 1:                          Step 2:
Stack        Heap                Stack        Heap
──────────   ──────────────      ──────────   ──────────────
obj ───────► [ Dog object  ]     obj ───────► [ Cat object  ]
  (Animal)    sound() → Dog        (Animal)    sound() → Cat
```

The reference `obj` on the stack is always typed as `Animal`, but the heap object it points to changes — and the JVM follows the pointer to find the actual method to run.

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Polymorphism** | "Many forms" — one reference, multiple behaviours |
| **Runtime Polymorphism** | Method version is decided at runtime based on actual object type |
| **Dynamic Method Dispatch** | JVM mechanism that resolves overridden methods at runtime |
| **Upcasting** | Assigning a child object to a parent reference (`Animal obj = new Dog()`) — happens implicitly |
| **Reference type vs Object type** | Reference type (`Animal`) determines what methods are accessible; object type (`Dog`) determines which version runs |

---

## ⚠️ Reference Type Restriction

```java
Animal obj = new Dog();

obj.sound();   // ✅ works — sound() is in Animal
obj.bark();    // ❌ compile error — bark() is not in Animal reference type
```

Even though `obj` actually holds a `Dog`, the compiler only allows methods that exist in the **reference type** (`Animal`). To access `Dog`-specific methods, **downcast** is needed:

```java
Dog dog = (Dog) obj;
dog.bark();    // ✅ works after downcasting
```

---

## 📌 Types of Polymorphism in Java

| Type | Also Called | Resolved At | Achieved Via |
|------|------------|-------------|-------------|
| **Compile-time** | Static / Early binding | Compile time | Method Overloading |
| **Runtime** | Dynamic / Late binding | Runtime (JVM) | Method Overriding |

---

## 📌 The 4 Pillars of OOP — Progress

| Pillar | Covered |
|--------|---------|
| **Encapsulation** | ✅ `private` fields + getters/setters |
| **Inheritance** | ✅ `extends` — parent/child relationship |
| **Polymorphism** | ✅ One reference, many forms |
| **Abstraction** | 🔜 `abstract` classes & interfaces |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | Two method calls each executing one print statement — constant time. |
| **Space Complexity** | `O(1)` | Two objects created sequentially (not simultaneously) — one reference variable, fixed space. |

---