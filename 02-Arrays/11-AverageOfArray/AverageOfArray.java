public class AverageOfArray {

    static double getAverage(int [] arr){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        int size = arr.length;
        double avg = (double) sum / size;
        return avg;

    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,};
        System.out.println("Average of the array is: " + getAverage(arr));
    }
}
