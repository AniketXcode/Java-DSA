public class StringPractice {
    public static void main(String[] args) {

        // Count Words
        String sentence = "I am learning Java Programming";
        String[] words = sentence.split(" ");
        System.out.println("Sentence: " + sentence);
        System.out.println("Number of Words: " + words.length);

        System.out.println();

        // Compare Two Strings
        String str1 = "Java";
        String str2 = "Java";

        if (str1.equals(str2)) {
            System.out.println("Strings are Equal");
        } else {
            System.out.println("Strings are Not Equal");
        }

        System.out.println();

        // Concatenate Strings
        String firstName = "Aniket";
        String lastName = " Kumar";

        String fullName = firstName + lastName;
        System.out.println("Concatenated String: " + fullName);

        System.out.println();

        // Character Frequency
        String str = "programming";

        System.out.println("Character Frequency:");

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            int count = 1;

            if (ch == ' ') {
                continue;
            }

            for (int j = i + 1; j < str.length(); j++) {
                if (ch == str.charAt(j)) {
                    count++;
                }
            }

            boolean alreadyCounted = false;
            for (int k = 0; k < i; k++) {
                if (ch == str.charAt(k)) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (!alreadyCounted) {
                System.out.println(ch + " = " + count);
            }
        }

        System.out.println();

        // Remove Spaces
        String text = "Hello World Java";

        String result = text.replace(" ", "");

        System.out.println("Original String: " + text);
        System.out.println("After Removing Spaces: " + result);
    }
}