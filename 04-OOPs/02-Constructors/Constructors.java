public class Constructors {

    String name;
    int age;

    // Default Constructor
    Constructors() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized Constructor
    Constructors(String n, int a) {
        name = n;
        age = a;
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