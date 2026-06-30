public class MultiplyBy10 {
    static void multiplyBy10(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 10;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        multiplyBy10(arr);
        System.out.print("Array after multiplying by 10: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
