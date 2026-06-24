public class StringOperations {
    public static void main(String[] args) {

        String str = "Aniket";

        // 1. Find Length
        System.out.println("Length: " + str.length());

        // 2. Convert to Uppercase
        System.out.println("Uppercase: " + str.toUpperCase());

        // 3. Convert to Lowercase
        System.out.println("Lowercase: " + str.toLowerCase());

        // 4. Reverse String
        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }

        System.out.println("Reverse: " + reverse);
    }
}