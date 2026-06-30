public class SumPositiveNegative {

    static void sumPositiveNegative(int[] arr) {
        int positiveSum = 0;
        int negativeSum = 0;

        for (int num : arr) {
            if (num > 0) {
                positiveSum += num;
            } else if (num < 0) {
                negativeSum += num;
            }
        }

        System.out.println("Sum of Positive Numbers: " + positiveSum);
        System.out.println("Sum of Negative Numbers: " + negativeSum);
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5};
        sumPositiveNegative(arr);
    }
}
