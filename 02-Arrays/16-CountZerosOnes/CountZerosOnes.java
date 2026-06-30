public class CountZerosOnes {
    static void countZerosOnes(int[] arr) {
        int countZeros = 0;
        int countOnes = 0;

        for (int num : arr) {
            if (num == 0) {
                countZeros++;
            } else if (num == 1) {
                countOnes++;
            }
        }

        System.out.println("Count of Zeros: " + countZeros);
        System.out.println("Count of Ones: " + countOnes);
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0};
        countZerosOnes(arr);
    }
}
