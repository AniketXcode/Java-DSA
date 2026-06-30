

public class HighestLowestFrequency {
    static void highestLowestFrequency(int[] arr) {
        int highestFreq = 0;
        int lowestFreq = Integer.MAX_VALUE;
        int highestNum = 0;
        int lowestNum = 0;

        for (int num : arr) {
            int freq = 0;
            for (int n : arr) {
                if (n == num) {
                    freq++;
                }
            }
            if (freq > highestFreq) {
                highestFreq = freq;
                highestNum = num;
            }
            if (freq < lowestFreq) {
                lowestFreq = freq;
                lowestNum = num;
            }
        }

        System.out.println("Highest Frequency: " + highestFreq + " for number: " + highestNum);
        System.out.println("Lowest Frequency: " + lowestFreq + " for number: " + lowestNum);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 2, 5};
        highestLowestFrequency(arr);
    }
}
