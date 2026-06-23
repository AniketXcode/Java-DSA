public class max_Element {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Using for-each loop:");
        System.out.println("Maximum element in the array is: " + max);
        System.out.println("Using traditional for loop:");
        System.out.println("Maximum element in the array is: " + max);
    }
}
