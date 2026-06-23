public class Insertion {
    public static void main(String[] args) {

        int[] arr = new int[6]; 

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        int size = 5;      
        int index = 2;     
        int element = 25; 

        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = element;
        size++;

        System.out.println("Array after insertion:");

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}