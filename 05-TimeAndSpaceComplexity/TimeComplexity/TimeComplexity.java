public class TimeComplexity {

    public static void main(String[] args) {

        int n = 5;

        // O(1) - Constant Time
        System.out.println("O(1)");
        System.out.println(n);

        // O(n) - Linear Time
        System.out.println("\nO(n)");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }

        // O(n²) - Quadratic Time
        System.out.println("\n\nO(n²)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        }

        // O(log n) - Logarithmic Time
        System.out.println("\nO(log n)");
        for (int i = 1; i < n; i *= 2) {
            System.out.print(i + " ");
        }

        // O(n log n)
        System.out.println("\n\nO(n log n)");
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        }
    }
}