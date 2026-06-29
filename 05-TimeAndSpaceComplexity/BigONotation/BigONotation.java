public class BigONotation {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        // O(1) - Constant Time
        System.out.println("O(1): " + arr[2]);

        // O(n) - Linear Time
        System.out.println("\nO(n):");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // O(n²) - Quadratic Time
        System.out.println("\n\nO(n²):");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
            }
        }
    }
}