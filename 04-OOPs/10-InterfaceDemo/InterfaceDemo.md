# Interface in Java

A Java program demonstrating **interfaces** — a fully abstract contract that enforces implementing classes to provide concrete behaviour for all declared methods. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Define an `Animal` interface with two methods `sound()` and `eat()`, create a `Dog` class that implements both methods, and demonstrate calling both through a `Dog` object.

**Expected Output:**
```
Dog barks
Dog eats food
```

---

## 💡 Approach

1. **Define the interface** — `interface Animal` declares two method signatures: `sound()` and `eat()`. These methods have **no body** — they define *what* a class must be able to do, not *how*. All methods in an interface are implicitly `public` and `abstract` even without those keywords.

2. **Implement the interface** — `class Dog implements Animal` establishes a **CAN-DO relationship**: a `Dog` CAN-DO everything `Animal` requires. `Dog` must provide concrete (`@Override`) implementations for **all** methods declared in the interface — failing to implement even one causes a compile error.

3. **`public` modifier in overrides** — since interface methods are implicitly `public`, the implementing class must use `public` in its overrides. Reducing access (e.g. using package-private or `protected`) would violate the contract and cause a compile error.

4. **Create a `Dog` object** — `new Dog()` works because `Dog` is a concrete class that has fulfilled the `Animal` interface contract. Both `obj.sound()` and `obj.eat()` call `Dog`'s implementations.

---

## 🧮 Pseudocode

```
START
  DEFINE interface Animal:
      METHOD sound()      // no body — implicitly public abstract
      METHOD eat()        // no body — implicitly public abstract

  DEFINE class Dog IMPLEMENTS Animal:
      OVERRIDE sound(): PRINT "Dog barks"
      OVERRIDE eat():   PRINT "Dog eats food"

  BEGIN main():
      CREATE obj of type Dog
      CALL obj.sound()    → "Dog barks"
      CALL obj.eat()      → "Dog eats food"
END
```

---

## 💻 Code

```java
// Interface
interface Animal {
    void sound();
    void eat();
}

// Implementing Class
class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats food");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {

        Dog obj = new Dog();

        obj.sound();
        obj.eat();
    }
}
```

---

## 🔍 Dry Run — Contract Fulfilment

| Interface Method | Implemented in `Dog`? | Output |
|-----------------|----------------------|--------|
| `sound()` | ✅ Yes | `Dog barks` |
| `eat()` | ✅ Yes | `Dog eats food` |

> If either method were missing in `Dog`, the compiler would throw: `Dog is not abstract and does not override abstract method sound() in Animal`.

---

## 📌 Interface Anatomy

```
interface Animal
├── void sound()     ← implicitly: public abstract void sound()
└── void eat()       ← implicitly: public abstract void eat()

         ↓ implements
         
class Dog
├── public void sound() { ... }   ← mandatory implementation
└── public void eat()   { ... }   ← mandatory implementation
```

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **`interface`** | A fully abstract type — only method signatures, no bodies (pre Java 8) |
| **`implements`** | Keyword used by a class to fulfil an interface contract |
| **CAN-DO relationship** | `Dog implements Animal` → Dog CAN-DO what Animal requires (vs IS-A in inheritance) |
| **Implicit modifiers** | Interface methods are `public abstract` by default; interface fields are `public static final` |
| **Full contract** | Every method declared in the interface **must** be implemented in a concrete class |
| **Multiple interfaces** | A class can `implement` multiple interfaces — Java's answer to multiple inheritance |

---

## ⚡ Power of Interfaces — Multiple Implementation

```java
interface Animal  { void sound(); }
interface Pet     { void play();  }

// Dog fulfils BOTH contracts simultaneously
class Dog implements Animal, Pet {
    public void sound() { System.out.println("Dog barks"); }
    public void play()  { System.out.println("Dog plays fetch"); }
}
```

This is how Java achieves **multiple inheritance** safely — a class can implement any number of interfaces without the Diamond Problem that affects multiple class inheritance.

---

## ⚡ Interface Reference — Polymorphism

```java
// Interface reference can hold any implementing class object
Animal obj = new Dog();
obj.sound();   // Dog barks ✅

Animal obj2 = new Cat();
obj2.sound();  // Cat meows ✅
```

Just like a parent class reference, an interface reference enables **runtime polymorphism** — the actual method called depends on the object type at runtime.

---

## 📌 Interface vs Abstract Class — Full Comparison

| Feature | Interface | Abstract Class |
|---------|-----------|---------------|
| **Keyword** | `interface` / `implements` | `abstract class` / `extends` |
| **Instantiation** | ❌ Cannot | ❌ Cannot |
| **Methods** | All abstract (pre Java 8); `default`/`static` allowed (Java 8+) | Mix of abstract and concrete |
| **Fields** | Only `public static final` constants | Any type of fields |
| **Constructor** | ❌ No | ✅ Yes |
| **Inheritance** | `implements` multiple interfaces | `extends` only one class |
| **Relationship** | CAN-DO (capability) | IS-A (identity) |
| **Use when** | Unrelated classes need same capability | Related classes share common base |

---

## 📌 Java 8+ Interface Features

```java
interface Animal {
    void sound();                          // abstract (must implement)

    default void breathe() {              // default method — optional to override
        System.out.println("Breathing");
    }

    static void info() {                  // static method — called on interface directly
        System.out.println("Animal interface");
    }
}

// Call static method
Animal.info();          // ✅

// Dog inherits default method
Dog obj = new Dog();
obj.breathe();          // ✅ "Breathing"
```

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | Two method calls each executing one print statement — constant time. |
| **Space Complexity** | `O(1)` | One `Dog` object with no data fields — space does not grow with input. |

---
