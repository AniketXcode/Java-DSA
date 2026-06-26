# Inheritance in Java

A Java program demonstrating **inheritance** — one of the four core pillars of OOP — where a child class acquires the properties and behaviours of a parent class using the `extends` keyword. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Create a parent class `Animal` with an `eat()` method, and a child class `Dog` that extends `Animal` and adds its own `bark()` method. Create a `Dog` object and demonstrate that it can access both the inherited method and its own method.

**Expected Output:**
```
Animal is eating
Dog is barking
```

---

## 💡 Approach

1. **Define the parent class** — `Animal` is the **superclass** (parent). It defines an `eat()` method that describes general behaviour common to all animals.

2. **Define the child class** — `Dog extends Animal` makes `Dog` a **subclass** (child) of `Animal`. The `extends` keyword establishes an **IS-A relationship**: a Dog IS-A Animal. By inheriting from `Animal`, `Dog` automatically gets access to `eat()` without rewriting it.

3. **Add child-specific behaviour** — `Dog` defines its own `bark()` method that is unique to dogs. The parent class `Animal` does not have this method.

4. **Create a `Dog` object** — `new Dog()` creates an instance of the child class. This single object can call:
   - `obj.eat()` → inherited from `Animal` (no copy — the original `Animal` method is used)
   - `obj.bark()` → defined in `Dog` itself

---

## 🧮 Pseudocode

```
START
  DEFINE class Animal:
      METHOD eat():
          PRINT "Animal is eating"

  DEFINE class Dog EXTENDS Animal:
      METHOD bark():
          PRINT "Dog is barking"

  BEGIN main():
      CREATE obj of type Dog

      CALL obj.eat()     → inherited from Animal → "Animal is eating"
      CALL obj.bark()    → defined in Dog        → "Dog is barking"
END
```

---

## 💻 Code

```java
// Parent Class
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Child Class
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

public class Inheritance {
    public static void main(String[] args) {

        Dog obj = new Dog();

        // Inherited method
        obj.eat();

        // Child class method
        obj.bark();
    }
}
```

---

## 🔍 Inheritance Hierarchy

```
        Animal          ← Superclass (Parent)
          │
        extends
          │
         Dog            ← Subclass (Child)
        /   \
    eat()   bark()
  (inherited) (own)
```

`Dog` inherits everything from `Animal` and adds its own `bark()`. The arrow always points **upward** to the parent in an inheritance hierarchy.

---

## 🔍 Dry Run — Method Resolution

| Call | Defined In | Accessible to `Dog`? | Output |
|------|-----------|---------------------|--------|
| `obj.eat()` | `Animal` | ✅ Yes — inherited | `Animal is eating` |
| `obj.bark()` | `Dog` | ✅ Yes — own method | `Dog is barking` |

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **`extends`** | Keyword used by a child class to inherit from a parent class |
| **IS-A relationship** | `Dog extends Animal` means every Dog IS-A Animal |
| **Superclass** | The parent class whose members are inherited (`Animal`) |
| **Subclass** | The child class that inherits and can extend behaviour (`Dog`) |
| **Code reuse** | Child class uses parent's methods without rewriting them |
| **Single Inheritance** | Java supports only one direct parent class per child (unlike C++) |

---

## 📌 Types of Inheritance in Java

| Type | Description | Supported in Java? |
|------|-------------|-------------------|
| **Single** | One child, one parent | ✅ Yes |
| **Multilevel** | A → B → C (chain of inheritance) | ✅ Yes |
| **Hierarchical** | One parent, multiple children | ✅ Yes |
| **Multiple** | One child, multiple parents | ❌ No (via classes) — ✅ Yes via Interfaces |
| **Hybrid** | Combination of above | ❌ No (via classes) — ✅ Yes via Interfaces |

> Java does **not** support multiple inheritance through classes to avoid the **Diamond Problem** — but it can be achieved using **interfaces**.

---

## ⚠️ What a Child Class Gets (and Doesn't Get)

| Inherited? | Detail |
|-----------|--------|
| ✅ `public` methods | Fully inherited and accessible |
| ✅ `protected` methods | Inherited and accessible in child |
| ✅ `public` / `protected` fields | Inherited but direct access discouraged (use getters) |
| ❌ `private` members | Not inherited — hidden from child |
| ❌ Constructors | Not inherited — but can be invoked using `super()` |

---

## ⚡ Extended Example — Using `super`

```java
class Animal {
    Animal() {
        System.out.println("Animal created");
    }
}

class Dog extends Animal {
    Dog() {
        super();  // Calls Animal's constructor
        System.out.println("Dog created");
    }
}
// Output:
// Animal created
// Dog created
```

`super()` calls the parent constructor and is always the first statement in a child constructor if used explicitly.

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | Both method calls (`eat()` and `bark()`) execute a single print statement each — constant time. |
| **Space Complexity** | `O(1)` | One `Dog` object is created with no data fields — space does not grow with input. |

---