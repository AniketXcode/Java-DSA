public class ExtremeElements {
    static void findExtremeElements(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int max = arr[0];
        int min = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        System.out.println("Maximum element in the array: " + max);
        System.out.println("Minimum element in the array: " + min);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        findExtremeElements(arr);
    }
}
