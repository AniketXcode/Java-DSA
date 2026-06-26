# Method Overloading in Java

A Java program demonstrating **method overloading** — defining multiple methods with the same name but different parameter lists in the same class. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Create a class with four overloaded versions of a `display()` method — one with no parameters, one with a single `int`, one with two `int`s, and one with a `String` — and call each version through a single object.

**Expected Output:**
```
No Parameters
Integer: 10
Sum: 30
Name: Aniket
```

---

## 💡 Approach

Method overloading lets you define **multiple methods with the same name** as long as their **parameter lists differ** (in number, type, or order). The Java compiler determines which version to call at **compile time** based on the arguments provided — this is known as **compile-time polymorphism** or **static dispatch**.

The four overloaded versions here differ as follows:

| Version | Parameters | Distinguishing Factor |
|---------|-----------|----------------------|
| `display()` | None | No arguments |
| `display(int a)` | One `int` | Single integer |
| `display(int a, int b)` | Two `int`s | Two integers |
| `display(String name)` | One `String` | Different type from `int` |

When `obj.display(10)` is called, the compiler sees one `int` argument and routes to `display(int a)`. When `obj.display("Aniket")` is called, it sees a `String` and routes to `display(String name)` — all resolved at compile time without any ambiguity.

---

## 🧮 Pseudocode

```
START
  DEFINE class MethodOverloading:

      METHOD display():
          PRINT "No Parameters"

      METHOD display(a: int):
          PRINT "Integer: " + a

      METHOD display(a: int, b: int):
          PRINT "Sum: " + (a + b)

      METHOD display(name: String):
          PRINT "Name: " + name

  BEGIN main():
      CREATE obj
      CALL obj.display()            → "No Parameters"
      CALL obj.display(10)          → "Integer: 10"
      CALL obj.display(10, 20)      → "Sum: 30"
      CALL obj.display("Aniket")    → "Name: Aniket"
END
```

---

## 💻 Code

```java
public class MethodOverloading {

    // Method with no parameters
    void display() {
        System.out.println("No Parameters");
    }

    // Method with one int parameter
    void display(int a) {
        System.out.println("Integer: " + a);
    }

    // Method with two int parameters
    void display(int a, int b) {
        System.out.println("Sum: " + (a + b));
    }

    // Method with one String parameter
    void display(String name) {
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        MethodOverloading obj = new MethodOverloading();
        obj.display();
        obj.display(10);
        obj.display(10, 20);
        obj.display("Aniket");
    }
}
```

---

## 🔍 Dry Run — Compiler Resolution

| Call | Argument(s) | Compiler Matches To | Output |
|------|------------|--------------------|----|
| `obj.display()` | none | `display()` | `No Parameters` |
| `obj.display(10)` | `int` | `display(int a)` | `Integer: 10` |
| `obj.display(10, 20)` | `int, int` | `display(int a, int b)` | `Sum: 30` |
| `obj.display("Aniket")` | `String` | `display(String name)` | `Name: Aniket` |

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Method Overloading** | Same method name, different parameter lists in the same class |
| **Compile-time Polymorphism** | The correct method version is resolved by the compiler — not at runtime |
| **Parameter list** | Methods are differentiated by number, type, or order of parameters |
| **Return type alone** | Changing only the return type does NOT constitute overloading — it causes a compile error |
| **`void` is the same** | All four versions here return `void`; the difference lies entirely in the parameters |

---

## ⚠️ What Does NOT Count as Overloading

```java
// ❌ Changing only return type — compile error (ambiguous)
int display()    { return 1; }
void display()   { }          // Error: duplicate method

// ✅ Different parameter types — valid overloading
void display(int a)    { }
void display(double a) { }

// ✅ Different parameter order — valid overloading
void display(int a, String s) { }
void display(String s, int a) { }
```

---

## 📌 Overloading vs Overriding — Quick Comparison

| Feature | Method Overloading | Method Overriding |
|---------|--------------------|-------------------|
| **Where** | Same class | Subclass (child) overrides parent |
| **Method name** | Same | Same |
| **Parameters** | Must differ | Must be identical |
| **Resolved at** | Compile time | Runtime |
| **Polymorphism type** | Static / Compile-time | Dynamic / Runtime |
| **Inheritance needed** | ❌ No | ✅ Yes |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | Each method call performs a constant-time operation (a single print statement). |
| **Space Complexity** | `O(1)` | Only one object is created with no data fields; no extra memory scales with input. |

---
