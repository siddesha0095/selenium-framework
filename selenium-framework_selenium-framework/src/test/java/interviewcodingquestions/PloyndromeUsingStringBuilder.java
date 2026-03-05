package interviewcodingquestions;



public class PloyndromeUsingStringBuilder {

    /**
     * Checks if a given integer is a palindrome.
     * @param number the integer to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(int number) {
        String data = String.valueOf(number);
        String reversed = new StringBuilder(data).reverse().toString();
        return data.equals(reversed);
    }

    public static void main(String[] args) {
        int number = 1000; // try 10000, 12321, etc.

        if (isPalindrome(number)) {
            System.out.println(number + " is a palindrome");
        } else {
            System.out.println(number + " is not a palindrome");
        }
    }
}