public class Diamond {

    public static void main(String[] args) {

        int n = 4;

        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= (2 * row - 1); star++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int row = n - 1; row >= 1; row--) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= (2 * row - 1); star++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}