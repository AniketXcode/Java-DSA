public class Traversal {
   public static void main(String[] args) {
    
       String str = "Hello, World!";

       // 1. Using for loop
       System.out.println("Using for loop:");
       for (int i = 0; i < str.length(); i++) {
           System.out.println(str.charAt(i));
       }

       // 2. Using for-each loop
       System.out.println("\nUsing for-each loop:");
       for (char ch : str.toCharArray()) {
           System.out.println(ch);
       }

       // 3. Using while loop
       System.out.println("\nUsing while loop:");
       int i = 0;
       while (i < str.length()) {
           System.out.println(str.charAt(i));
           i++;
       }

       // 4. Using do-while loop
       System.out.println("\nUsing do-while loop:");
       int j = 0;
       do {
           System.out.println(str.charAt(j));
           j++;
       } while (j < str.length());

       // 5. Reverse traversal
       System.out.println("\nReverse traversal:");
       for (int k = str.length() - 1; k >= 0; k--) {
           System.out.println(str.charAt(k));
       }

       // 6. Traversal with index
       System.out.println("\nTraversal with index:");
       for (int index = 0; index < str.length(); index++) {
           System.out.println("Index: " + index + " Character: " + str.charAt(index));
       }
   }  
}
