/*

    Given an integer x, return true if x is a 
    palindrome, and false otherwise.

    Follow up: Could you solve it without converting the integer to a string?

*/

public class PalindromeNumber {
    
    public static boolean isPalindromNumberVersion1(int number){
        /*
         * First method I tought of is turn the int into a string
         * I wrap it using the Integer class in order to convert it to a string
         * Reverse it using StringBuilder API
         * Return the result of comparaison between the initial and reversed string
         * To reverse a string you have to go through each of its element
         * Time complexity = O(n) , Space Complexit= O(1)
         */
        String stringX = Integer.toString(number);
        String reversedX = new StringBuilder(stringX).reverse().toString();

        return reversedX.equals(stringX);
    }

    public static void main(String[] args){
        int number = 121;
        System.out.printf("%b",isPalindromNumberVersion1(number));
    }

}
