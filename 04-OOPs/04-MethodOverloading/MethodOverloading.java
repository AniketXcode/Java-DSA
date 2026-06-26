public class MethodOverloading {

    // Method with no parameters
    void display() {
        System.out.println("No Parameters");
    }

    // Method with one int parameter
    void display(int a) {
        System.out.println("Integer: " + a);
    }

    // Method with two int parameters
    void display(int a, int b) {
        System.out.println("Sum: " + (a + b));
    }

    // Method with one String parameter
    void display(String name) {
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {

        MethodOverloading obj = new MethodOverloading();

        obj.display();
        obj.display(10);
        obj.display(10, 20);
        obj.display("Aniket");
    }
}