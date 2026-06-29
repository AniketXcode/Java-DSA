public class SpaceComplexity {

    public static void main(String[] args) {

        int n = 5;

        // O(1) - Constant Space
        int a = 10;
        int b = 20;
        int sum = a + b;
        System.out.println("O(1): " + sum);

        // O(n) - Linear Space
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        System.out.print("\nO(n): ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // O(n²) - Quadratic Space
        int[][] matrix = new int[n][n];

        System.out.println("\n\nO(n²): Matrix Created");
    }
}