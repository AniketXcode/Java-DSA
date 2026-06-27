# Abstraction in Java

A Java program demonstrating **abstraction** — the fourth and final pillar of OOP — using an `abstract` class that defines a contract for child classes while hiding implementation details. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Create an `abstract` class `Animal` with an abstract method `sound()` (no body) and a concrete method `eat()` (with body). Create a child class `Dog` that provides the implementation for `sound()`, and demonstrate calling both methods through a `Dog` object.

**Expected Output:**
```
Dog barks
Animal is eating
```

---

## 💡 Approach

1. **Define the abstract class** — `abstract class Animal` cannot be instantiated directly (`new Animal()` would cause a compile error). It serves as a **blueprint or contract** that all subclasses must follow.

2. **Abstract method** — `abstract void sound()` has **no body** (no curly braces, just a semicolon). It declares *what* every animal must be able to do, but leaves *how* to the specific subclass. Every non-abstract child class that extends `Animal` **must** override `sound()` or it will fail to compile.

3. **Concrete method** — `void eat()` has a full implementation inside `Animal`. Child classes inherit this method as-is and don't need to override it (though they can). This demonstrates that abstract classes can have both abstract and non-abstract members.

4. **Child class provides implementation** — `Dog extends Animal` and overrides `sound()` with `"Dog barks"`. By providing the body, `Dog` fulfils the contract set by `Animal` and becomes a concrete (instantiable) class.

5. **Create a `Dog` object** — `new Dog()` works because `Dog` is concrete. `obj.sound()` calls Dog's implementation, and `obj.eat()` calls the inherited method from `Animal`.

---

## 🧮 Pseudocode

```
START
  DEFINE abstract class Animal:
      ABSTRACT METHOD sound()      // no body — must be implemented by child
      METHOD eat():
          PRINT "Animal is eating"

  DEFINE class Dog EXTENDS Animal:
      OVERRIDE METHOD sound():
          PRINT "Dog barks"

  BEGIN main():
      CREATE obj of type Dog      // ✅ Dog is concrete — can be instantiated

      CALL obj.sound()            → Dog's implementation → "Dog barks"
      CALL obj.eat()              → inherited from Animal → "Animal is eating"
END
```

---

## 💻 Code

```java
// Abstract Class
abstract class Animal {

    // Abstract Method — no body
    abstract void sound();

    // Concrete Method — has body
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Child Class
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Abstraction {
    public static void main(String[] args) {

        Dog obj = new Dog();

        obj.sound();   // Dog's implementation
        obj.eat();     // Inherited from Animal
    }
}
```

---

## 🔍 Dry Run — Method Resolution

| Call | Defined In | Type | Output |
|------|-----------|------|--------|
| `obj.sound()` | `Dog` (overrides `Animal`) | Abstract → implemented | `Dog barks` |
| `obj.eat()` | `Animal` | Concrete — inherited | `Animal is eating` |

---

## 📌 Abstract Class Anatomy

```
abstract class Animal
├── abstract void sound()    ← No body — MUST be overridden by child
│                              (defines WHAT to do)
│
└── void eat()               ← Has body — optionally inherited or overridden
                               (defines HOW to do it for all animals)
```

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **`abstract` class** | Cannot be instantiated; acts as a blueprint for subclasses |
| **`abstract` method** | No body; forces every concrete subclass to provide an implementation |
| **Concrete method** | Has a body; inherited by all child classes automatically |
| **Contract enforcement** | If a child doesn't override all abstract methods, it must also be declared `abstract` |
| **Partial abstraction** | Abstract classes can have a mix of abstract and concrete members (unlike interfaces which are fully abstract) |

---

## ⚠️ Rules for Abstract Classes

```java
// ❌ Cannot instantiate an abstract class
Animal a = new Animal();   // Compile error

// ✅ Can use parent reference for child object (polymorphism)
Animal a = new Dog();
a.sound();   // Dog barks

// ❌ If child doesn't implement all abstract methods, it must be abstract too
class Cat extends Animal { }  // ❌ Error — sound() not implemented
abstract class Cat extends Animal { }  // ✅ OK — Cat is also abstract
```

---

## 📌 Abstract Class vs Interface

| Feature | Abstract Class | Interface |
|---------|---------------|-----------|
| **Instantiation** | ❌ Cannot | ❌ Cannot |
| **Abstract methods** | ✅ Can have | ✅ All methods abstract (pre Java 8) |
| **Concrete methods** | ✅ Can have | ✅ `default` methods (Java 8+) |
| **Fields** | ✅ Any type | ✅ Only `public static final` constants |
| **Constructor** | ✅ Can have | ❌ Cannot |
| **Inheritance** | Single only | Multiple interfaces allowed |
| **`extends` / `implements`** | `extends` | `implements` |
| **Use when** | Shared base with partial behaviour | Full contract, multiple inheritance |

---

## 📌 All 4 Pillars of OOP — Complete ✅

| Pillar | Meaning | Achieved via |
|--------|---------|-------------|
| **Encapsulation** | Hide internal state; expose via methods | `private` fields + getters/setters |
| **Inheritance** | Child acquires parent's properties | `extends` keyword |
| **Polymorphism** | One interface, many behaviours | Method overriding + parent reference |
| **Abstraction** ✅ | Hide implementation; show only essentials | `abstract` class / `interface` |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | Two method calls each executing one print statement — constant time. |
| **Space Complexity** | `O(1)` | One `Dog` object with no data fields — space does not grow with input. |

---