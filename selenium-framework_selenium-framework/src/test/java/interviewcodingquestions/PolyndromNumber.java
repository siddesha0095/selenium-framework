package interviewcodingquestions;

/**
 * The {@code PolyndromNumber} class demonstrates how to check whether
 * a given integer is a palindrome (reads the same forward and backward).
 *
 * <p>Steps performed:
 * <ul>
 *   <li>Convert the integer into a string</li>
 *   <li>Reverse the string manually using a loop</li>
 *   <li>Convert the reversed string back into an integer</li>
 *   <li>Compare the original number with the reversed number</li>
 *   <li>Print whether the number is a palindrome or not</li>
 * </ul>
 *
 * <p>Example:
 * <pre>
 * Input: 1233211
 * Output: 
 * 1123321
 * 1123321
 * not polyndrome
 * </pre>
 *
 * Author: Siddesha
 */
public class PolyndromNumber {

    /**
     * The entry point of the program.
     * <p>
     * Demonstrates palindrome checking by:
     * <ol>
     *   <li>Reversing the digits of a number</li>
     *   <li>Printing the reversed string and integer</li>
     *   <li>Comparing with the original number</li>
     * </ol>
     *
     * @param args command-line arguments (not used here)
     */
    public static void main(String[] args) {
        int number = 1233211; // test input

        // Convert number to string
        String data = number + "";
        String reversedata = "";

        // Reverse the string manually
        char[] dataarr = data.toCharArray();
        for (int i = dataarr.length - 1; i >= 0; i--) {
            reversedata = reversedata + dataarr[i];
        }

        // Print reversed string
        System.out.println(reversedata);

        // Convert reversed string back to integer
        int reverseNumber = Integer.parseInt(reversedata);
        System.out.println(reverseNumber);

        // Compare original and reversed
        if (number == reverseNumber) {
            System.out.println("polyndrome");
        } else {
            System.out.println("not polyndrome");
        }
    }
}