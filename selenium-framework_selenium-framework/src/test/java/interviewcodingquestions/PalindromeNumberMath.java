package interviewcodingquestions;


public class PalindromeNumberMath {

    /**
     * Checks if a given integer is a palindrome.
     * @param number the integer to check
     * @return true if palindrome, false otherwise
     */
	public static boolean isPalindromeMath(int number) {
	    int original = number;
	    int reversed = 0;

	    while (number > 0) {
	        int digit = number % 10;
	        reversed = reversed * 10 + digit;
	        number =number/ 10;
	    }

	    return original == reversed;
	}

    public static void main(String[] args) {
        int number = 10001; // try 10000, 12321, etc.

        if (isPalindromeMath(number)) {
            System.out.println(number + " is a palindrome");
        } else {
            System.out.println(number + " is not a palindrome");
        }
    }
}