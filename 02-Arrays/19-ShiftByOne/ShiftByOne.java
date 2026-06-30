public class ShiftByOne {
    static void shiftByOne(int[] arr) {
        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));
        shiftByOne(arr);
        System.out.println("Array after shifting by one: " + java.util.Arrays.toString(arr));
    }
}
