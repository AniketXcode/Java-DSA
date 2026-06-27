# Method Overriding in Java

A Java program demonstrating **method overriding** — where a child class provides its own specific implementation of a method already defined in the parent class. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Create a parent class `Animal` with a `sound()` method, and a child class `Dog` that overrides `sound()` with its own implementation. Create a `Dog` object and observe that the child's version of the method is called.

**Expected Output:**
```
Dog barks
```

---

## 💡 Approach

1. **Define the parent method** — `Animal` has a `sound()` method that prints a generic message applicable to all animals.

2. **Override in the child** — `Dog extends Animal` and redefines `sound()` with the **exact same method signature** (same name, same return type, same parameters). The `@Override` annotation signals the compiler to verify this is a legitimate override — if the signatures don't match, it throws a compile error instead of silently creating a new method.

3. **Runtime method resolution** — when `obj.sound()` is called on a `Dog` object, Java's JVM checks the **actual type of the object** (which is `Dog`) at runtime and calls `Dog`'s version of `sound()` — not `Animal`'s. This is known as **runtime polymorphism** or **dynamic method dispatch**.

4. **`@Override` annotation** — optional but strongly recommended. It makes intent clear and lets the compiler catch mistakes like typos in the method name.

---

## 🧮 Pseudocode

```
START
  DEFINE class Animal:
      METHOD sound():
          PRINT "Animal makes a sound"

  DEFINE class Dog EXTENDS Animal:
      OVERRIDE METHOD sound():
          PRINT "Dog barks"

  BEGIN main():
      CREATE obj of type Dog
      CALL obj.sound()
          → JVM checks actual type = Dog
          → calls Dog's sound()
          → PRINT "Dog barks"
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

// Child Class
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {

        Dog obj = new Dog();
        obj.sound();
    }
}
```

---

## 🔍 Dry Run — Runtime Dispatch

| Step | Action | Method Called | Output |
|------|--------|--------------|--------|
| 1 | `Dog obj = new Dog()` | — | Object created on heap |
| 2 | `obj.sound()` called | JVM checks → `obj` is a `Dog` | — |
| 3 | Dog's `sound()` found | `Dog.sound()` executed | `Dog barks` |

> Animal's `sound()` is **never called** — it is completely replaced by Dog's version for Dog objects.

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Method Overriding** | Child redefines a parent method with the same signature |
| **`@Override`** | Annotation telling the compiler to verify the override is valid |
| **Runtime Polymorphism** | The correct method version is chosen at runtime based on the actual object type |
| **Dynamic Method Dispatch** | JVM mechanism that resolves overridden methods at runtime |
| **Same signature** | Name, return type, and parameters must all match exactly |

---

## 📌 Calling Parent's Version — `super`

Even after overriding, the parent's version can still be called explicitly using `super`:

```java
class Dog extends Animal {

    @Override
    void sound() {
        super.sound();                    // calls Animal's sound()
        System.out.println("Dog barks"); // then Dog's own behaviour
    }
}
// Output:
// Animal makes a sound
// Dog barks
```

`super.sound()` lets the child **extend** the parent's behaviour rather than completely replacing it.

---

## ⚠️ Overriding vs Overloading — The Most Asked Interview Question

| Feature | Method Overriding | Method Overloading |
|---------|------------------|--------------------|
| **Where** | Child class overrides parent | Same class |
| **Method name** | Same | Same |
| **Parameters** | Must be identical | Must differ |
| **Return type** | Must be same (or covariant) | Can differ |
| **Resolved at** | Runtime (JVM) | Compile time (compiler) |
| **Polymorphism** | Runtime / Dynamic | Compile-time / Static |
| **`@Override`** | ✅ Used | ❌ Not applicable |
| **Inheritance needed** | ✅ Yes | ❌ No |

---

## ⚠️ Rules for Method Overriding

```java
// ❌ Cannot override private method
private void sound() { }   // not visible to child — cannot be overridden

// ❌ Cannot override final method
final void sound() { }     // locked — cannot be overridden

// ❌ Cannot override static method
static void sound() { }    // hiding, not overriding

// ✅ Can override public/protected methods
public void sound() { }
protected void sound() { }
```

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | A single method call executing one print statement — constant time. |
| **Space Complexity** | `O(1)` | One `Dog` object with no data fields — space does not grow with input. |

---