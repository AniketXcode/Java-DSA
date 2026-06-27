// Parent Class
class Animal {

    String name = "Animal";

    Animal() {
        System.out.println("Parent Constructor Called");
    }

    void display() {
        System.out.println("Parent Method");
    }
}

// Child Class
class Dog extends Animal {

    String name = "Dog";

    Dog() {
        super(); // Calls Parent Constructor
        System.out.println("Child Constructor Called");
    }

    void show() {

        // Access Parent Variable
        System.out.println("Parent Name: " + super.name);

        // Access Child Variable
        System.out.println("Child Name: " + this.name);

        // Call Parent Method
        super.display();
    }
}

public class SuperKeyword {
    public static void main(String[] args) {

        Dog obj = new Dog();

        System.out.println();

        obj.show();
    }
}