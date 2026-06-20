public class AlphaTri {
    public static void main(String[] args) {
        int n = 5;
        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= row; col++){
               int a = col;
               int b =('A' + a - 1);
               char ch = (char) b;
               System.out.print(ch + "   ");
            }
            System.out.println();
        }
    }    
}
