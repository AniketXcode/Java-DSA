public class HollowDia {
    public static void main(String[] args) {
         int n = 4;
    for(int row = 1; row <= n; row++){
        for(int col = 1; col <= n - row; col++){
            System.out.print(" ");
        }
        if(row == 1){
            for(int col = 1; col <= row; col++){
                System.out.print("* ");
            }
        }else{
            System.out.print("* ");
            for(int col = 1; col <= row - 2; col++){
                System.out.print("  ");
            }
            System.out.print("* ");
        }
        System.out.println();
    }
    for(int row = n - 1; row >= 1; row--){
        for(int col = 1; col <= n - row; col++){
            System.out.print(" ");
        }
        if(row == 1){
            for(int col = 1; col <= row; col++){
                System.out.print("* ");
            }
        }else{
            System.out.print("* ");
            for(int col = 1; col <= row - 2; col++){
                System.out.print("  ");
            }
            System.out.print("* ");
        }
        System.out.println();
    }
    }
}
