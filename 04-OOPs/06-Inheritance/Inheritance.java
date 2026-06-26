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