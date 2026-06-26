# Default & Parameterized Constructors

A Java program demonstrating the difference between a **default constructor** and a **parameterized constructor**, and how both are used to initialise object fields. This is part of the OOP section under Data Structures & Algorithms practice.

---

## 📌 Problem Statement

Create a class with two fields (`name`, `age`), define both a default and a parameterized constructor to initialise them, and use a `display()` method to print the values for objects created using each constructor.

**Expected Output:**
```
Name: Unknown
Age: 0

Name: Aniket
Age: 22
```

---

## 💡 Approach

1. **Declare instance fields** — `String name` and `int age` are declared at the class level (outside any method), making them **instance variables** that belong to each object individually.

2. **Default Constructor** — `Constructors()` takes no arguments and sets `name = "Unknown"` and `age = 0`. This provides safe fallback values when no data is supplied at the time of object creation.

3. **Parameterized Constructor** — `Constructors(String n, int a)` accepts values at the time of object creation and assigns them to the instance fields. This allows each object to be initialised with custom data.

4. **`display()` method** — an instance method that reads and prints the current object's `name` and `age` fields. Since it's an instance method, each call prints the data of whichever object it's called on.

5. **Two objects created:**
   - `obj1` → uses the default constructor → fields are `"Unknown"` and `0`
   - `obj2` → uses the parameterized constructor → fields are `"Aniket"` and `22`

---

## 🧮 Pseudocode

```
START
  DEFINE class Constructors:
      FIELDS: name, age

      DEFAULT CONSTRUCTOR():
          name = "Unknown"
          age  = 0

      PARAMETERIZED CONSTRUCTOR(n, a):
          name = n
          age  = a

      METHOD display():
          PRINT name, age

  BEGIN main():
      CREATE obj1 using DEFAULT CONSTRUCTOR
      CALL obj1.display()     → "Unknown", 0

      CREATE obj2 using PARAMETERIZED CONSTRUCTOR("Aniket", 22)
      CALL obj2.display()     → "Aniket", 22
END
```

---

## 💻 Code

```java
public class Constructors {

    String name;
    int age;

    // Default Constructor
    Constructors() {
        name = "Unknown";
        age  = 0;
    }

    // Parameterized Constructor
    Constructors(String n, int a) {
        name = n;
        age  = a;
    }

    // Display Method
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {

        // Calling Default Constructor
        Constructors obj1 = new Constructors();
        obj1.display();

        System.out.println();

        // Calling Parameterized Constructor
        Constructors obj2 = new Constructors("Aniket", 22);
        obj2.display();
    }
}
```

---

## 🔍 Dry Run — Object Creation & Field State

**`obj1` — Default Constructor:**

| Step | Action | `name` | `age` |
|------|--------|--------|-------|
| 1 | `new Constructors()` called | — | — |
| 2 | Default constructor executes | `"Unknown"` | `0` |
| 3 | `obj1.display()` called | prints `"Unknown"` | prints `0` |

**`obj2` — Parameterized Constructor:**

| Step | Action | `name` | `age` |
|------|--------|--------|-------|
| 1 | `new Constructors("Aniket", 22)` called | — | — |
| 2 | Parameterized constructor executes | `"Aniket"` | `22` |
| 3 | `obj2.display()` called | prints `"Aniket"` | prints `22` |

---

## 🔑 Key Concepts

| Concept | Detail |
|---------|--------|
| **Instance variables** | `name` and `age` are declared at class level — each object gets its own separate copy |
| **Constructor overloading** | Defining multiple constructors with different parameter lists in the same class |
| **Default constructor** | No-arg constructor; sets default/fallback values for fields |
| **Parameterized constructor** | Accepts arguments; enables custom initialisation per object |
| **`this` keyword (best practice)** | Using `this.name = name` instead of `name = n` makes the code more readable when parameter names match field names |

---

## ⚠️ Default vs Parameterized — Key Differences

| Feature | Default Constructor | Parameterized Constructor |
|---------|--------------------|--------------------------| 
| **Parameters** | None | One or more |
| **Use case** | When default/placeholder values are sufficient | When the object needs custom data at creation |
| **Example call** | `new Constructors()` | `new Constructors("Aniket", 22)` |
| **Auto-provided by Java?** | ✅ Yes (if no constructor defined) | ❌ No — must be written explicitly |

---

## ⚡ Best Practice — Using `this` Keyword

```java
// Current approach (parameter names differ from field names)
Constructors(String n, int a) {
    name = n;
    age  = a;
}

// Best practice (parameter names match field names — more readable)
Constructors(String name, int age) {
    this.name = name;   // this.name → instance field; name → parameter
    this.age  = age;
}
```

`this` refers to the **current object**, distinguishing instance fields from local parameters when they share the same name.

---

## ⏱️ Complexity Analysis

| Complexity | Value | Explanation |
|------------|-------|-------------|
| **Time Complexity** | `O(1)` | Object creation, field initialisation, and `display()` all execute in constant time. |
| **Space Complexity** | `O(1)` | Two objects (`obj1`, `obj2`) are created, each holding a fixed number of fields — space does not grow with input. |

---