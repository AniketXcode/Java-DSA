public class ClassAndObject {

    // Instance Variables
    String name;
    int age;

    // Method
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {

        // Creating First Object
        ClassAndObject obj1 = new ClassAndObject();
        obj1.name = "Aniket";
        obj1.age = 22;

        // Creating Second Object
        ClassAndObject obj2 = new ClassAndObject();
        obj2.name = "Rahul";
        obj2.age = 20;

        // Calling Method
        obj1.display();

        System.out.println();

        obj2.display();
    }
}