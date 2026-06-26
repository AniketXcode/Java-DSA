# Encapsulation in Java

A Java program demonstrating **encapsulation** — one of the four core pillars of OOP — by restricting direct access to class fields using `private` and exposing controlled access through `public` getter and setter methods. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Create a class where the data fields `name` and `age` are kept `private`, and provide `public` setter methods to assign values and `public` getter methods to retrieve them — demonstrating full encapsulation.

**Expected Output:**
```
Name: Aniket
Age: 22
```

---

## 💡 Approach

1. **Make fields `private`** — `private String name` and `private int age` can only be accessed from within the `Encapsulation` class itself. Any direct access like `obj.name = "Aniket"` from outside the class causes a **compile error** — the data is fully hidden.

2. **Setter methods** — `setName(String name)` and `setAge(int age)` are `public` methods that allow controlled **write access** to the private fields. Using `this.name = name` assigns the passed value to the instance field. Setters can also include **validation logic** (e.g. rejecting negative ages) before assigning.

3. **Getter methods** — `getName()` and `getAge()` are `public` methods that return the current value of the private fields, allowing controlled **read access**. They follow the naming convention `get` + field name (capitalised).

4. **Access through methods** — `obj.setName("Aniket")` writes, and `obj.getName()` reads — the outside world can interact with the object's data only through these controlled doors.

---

## 🧮 Pseudocode

```
START
  DEFINE class Encapsulation:
      PRIVATE FIELDS: name, age

      SETTER setName(name):   this.name = name
      SETTER setAge(age):     this.age  = age

      GETTER getName():       RETURN name
      GETTER getAge():        RETURN age

  BEGIN main():
      CREATE obj

      CALL obj.setName("Aniket")
      CALL obj.setAge(22)

      PRINT obj.getName()     → "Aniket"
      PRINT obj.getAge()      → 22
END
```

---

## 💻 Code

```java
public class Encapsulation {

    // Private Data Members
    private String name;
    private int age;

    // Setter Methods
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // Getter Methods
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Encapsulation obj = new Encapsulation();

        // Setting values
        obj.setName("Aniket");
        obj.setAge(22);

        // Getting values
        System.out.println("Name: " + obj.getName());
        System.out.println("Age: "  + obj.getAge());
    }
}
```

---

## 🔍 Dry Run — Data Flow

| Step | Action | `name` (private) | `age` (private) |
|------|--------|-----------------|----------------|
| 1 | `new Encapsulation()` | `null` | `0` |
| 2 | `obj.setName("Aniket")` | `"Aniket"` | `0` |
| 3 | `obj.setAge(22)` | `"Aniket"` | `22` |
| 4 | `obj.getName()` → returns `"Aniket"` | `"Aniket"` | `22` |
| 5 | `obj.getAge()` → returns `22` | `"Aniket"` | `22` |

---

## ⚠️ Without Encapsulation — The Problem

```java
// Without encapsulation (public fields — no control)
obj.age = -5;     // ❌ Invalid age — no way to prevent this

// With encapsulation (private field + setter with validation)
public void setAge(int age) {
    if (age > 0) {
        this.age = age;   // ✅ Only valid values accepted
    } else {
        System.out.println("Invalid age!");
    }
}
```

Without encapsulation, invalid or inconsistent data can be set freely. Getters and setters act as **controlled gateways** that can enforce rules before reading or writing data.

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **`private`** | Access modifier — field visible only within the same class |
| **`public`** | Access modifier — method accessible from anywhere |
| **Getter** | Returns the value of a private field; convention: `getFieldName()` |
| **Setter** | Sets the value of a private field; convention: `setFieldName(value)` |
| **Data hiding** | Core principle of encapsulation — internal state is hidden from the outside world |
| **`this` keyword** | Used in setters to distinguish instance field from same-named parameter |

---

## 📌 The 4 Pillars of OOP

| Pillar | Meaning | Achieved via |
|--------|---------|-------------|
| **Encapsulation** ✅ | Bundling data and methods; hiding internal state | `private` fields + getters/setters |
| **Inheritance** | Child class acquires properties of parent class | `extends` keyword |
| **Polymorphism** | One interface, many forms | Overloading & Overriding |
| **Abstraction** | Hiding implementation details; showing only essentials | `abstract` classes & interfaces |

---

## 📌 Access Modifiers — Quick Reference

| Modifier | Same Class | Same Package | Subclass | Outside |
|----------|-----------|-------------|----------|---------|
| `private` | ✅ | ❌ | ❌ | ❌ |
| (default) | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | Each setter assigns a value and each getter returns one — all constant-time operations. |
| **Space Complexity** | `O(1)` | One object with two fixed fields is created — space does not grow with input. |

---