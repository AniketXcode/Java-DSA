// Final Class
final class College {

    // Final Variable
    final String collegeName = "TMU";

    // Final Method
    final void displayCollege() {
        System.out.println("College: " + collegeName);
    }
}

public class FinalKeyword {

    public static void main(String[] args) {

        College obj = new College();

        obj.displayCollege();

        System.out.println("College Name: " + obj.collegeName);

        // obj.collegeName = "ABC"; // Error: Cannot change final variable
    }
}