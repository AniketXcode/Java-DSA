public class FirstUnsortedElement {
    static int findFirstUnsortedElement(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return arr[i];
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4, 6};
        int firstUnsortedElement = findFirstUnsortedElement(arr);
        if (firstUnsortedElement != -1) {
            System.out.println("First unsorted element: " + firstUnsortedElement);
        } else {
            System.out.println("Array is sorted.");
        }
    }
}
