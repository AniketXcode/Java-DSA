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