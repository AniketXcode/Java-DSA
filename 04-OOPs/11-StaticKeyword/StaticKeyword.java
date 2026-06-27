public class StaticKeyword {

    // Static Variable
    static String college = "TMU";

    // Instance Variable
    String name;

    // Constructor
    StaticKeyword(String name) {
        this.name = name;
    }

    // Static Method
    static void displayCollege() {
        System.out.println("College: " + college);
    }

    // Instance Method
    void displayStudent() {
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {

        StaticKeyword obj1 = new StaticKeyword("Aniket");
        StaticKeyword obj2 = new StaticKeyword("Rahul");

        // Static Method
        StaticKeyword.displayCollege();

        // Instance Methods
        obj1.displayStudent();
        obj2.displayStudent();
    }
}