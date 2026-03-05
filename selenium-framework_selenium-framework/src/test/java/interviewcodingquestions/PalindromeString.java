package interviewcodingquestions;

/**
 * The {@code PalindromeString} class checks whether a given string
 * is a palindrome (reads the same forward and backward).
 *
 * <p>Steps performed:
 * <ul>
 *   <li>Convert the string into a character array</li>
 *   <li>Reverse the string manually using a loop</li>
 *   <li>Compare the original string with the reversed string</li>
 *   <li>Print whether the string is a palindrome or not</li>
 * </ul>
 *
 * <p>Example:
 * <pre>
 * Input: madam
 * Output:
 * madam
 * -------------------
 * Its a palindrome
 * </pre>
 *
 * Author: Siddesha
 */
public class PalindromeString {

    /**
     * The entry point of the program.
     * <p>
     * Demonstrates palindrome checking by:
     * <ol>
     *   <li>Printing the original string</li>
     *   <li>Reversing the string</li>
     *   <li>Comparing with the original string</li>
     * </ol>
     *
     * @param args command-line arguments (not used here)
     */
    public static void main(String[] args) {
        String data = "madam"; // test input

        // Convert string to character array
        char[] dataChar = data.toCharArray();

        // Print original string characters
        for (int index = 0; index < data.length(); index++) {
            System.out.print(dataChar[index]);
        }

        System.out.println("\n-------------------");

        // Reverse the string manually
        String reverseString = "";
        for (int index = data.length() - 1; index >= 0; index--) {
            reverseString = reverseString + dataChar[index];
        }

        // Compare original and reversed (case-insensitive)
        if (data.equalsIgnoreCase(reverseString)) {
            System.out.println("Its a palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}