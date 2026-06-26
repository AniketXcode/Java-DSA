public class ThisKeyword {

    String name;
    int age;

    // Parameterized Constructor
    ThisKeyword(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Display Method
    void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }

    public static void main(String[] args) {

        ThisKeyword obj1 = new ThisKeyword("Aniket", 22);
        obj1.display();

        System.out.println();

        ThisKeyword obj2 = new ThisKeyword("Rahul", 20);
        obj2.display();
    }
}