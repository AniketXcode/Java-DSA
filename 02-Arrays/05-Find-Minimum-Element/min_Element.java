public class min_Element {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        System.out.println("Using for-each loop:");
        System.out.println("Minimum element in the array is: " + min);
        System.out.println("Using traditional for loop:");
        System.out.println("Minimum element in the array is: " + min);
    }
}
