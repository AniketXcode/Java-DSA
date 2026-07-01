import java.util.Arrays;

public class SortZeroOne {

    static void sortZeroOne(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            while (arr[left] == 0 && left < right) {
                left++;
            }
            while (arr[right] == 1 && left < right) {
                right--;
            }
            if (left < right) {
                // Swap arr[left] and arr[right]
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0, 1, 0};
        System.out.println("Original array: " + Arrays.toString(arr));
        sortZeroOne(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
