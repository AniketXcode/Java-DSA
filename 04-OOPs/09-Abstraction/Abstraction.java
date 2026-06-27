// Abstract Class
abstract class Animal {

    // Abstract Method
    abstract void sound();

    // Normal Method
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

        obj.sound();
        obj.eat();
    }
}