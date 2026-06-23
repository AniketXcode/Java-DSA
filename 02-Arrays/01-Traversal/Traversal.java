public class Traversal {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        // 1. Using for loop
        System.out.println("Using for loop:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // 2. Using for-each loop
        System.out.println("\nUsing for-each loop:");
        for (int num : arr) {
            System.out.println(num);
        }

        // 3. Using while loop
        System.out.println("\nUsing while loop:");
        int i = 0;
        while (i < arr.length) {
            System.out.println(arr[i]);
            i++;
        }

        // 4. Using do-while loop
        System.out.println("\nUsing do-while loop:");
        int j = 0;
        do {
            System.out.println(arr[j]);
            j++;
        } while (j < arr.length);

        // 5. Reverse traversal
        System.out.println("\nReverse traversal:");
        for (int k = arr.length - 1; k >= 0; k--) {
            System.out.println(arr[k]);
        }

        // 6. Traversal with index
        System.out.println("\nTraversal with index:");
        for (int index = 0; index < arr.length; index++) {
            System.out.println("Index: " + index + " Value: " + arr[index]);
        }
    }
}