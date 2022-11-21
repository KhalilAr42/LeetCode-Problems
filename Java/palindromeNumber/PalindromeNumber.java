/*

    Given an integer x, return true if x is a 
    palindrome, and false otherwise.

    Follow up: Could you solve it without converting the integer to a string?

*/

public class PalindromeNumber {
    
    public static boolean isPalindromNumberVersion1(int number){ 

        /*
         * First method I thought of is turn the int into a string
         * I wrap it using the Integer class in order to convert it to a string
         * Reverse it using StringBuilder API
         * Return the result of comparison between the initial and reversed string
         * To reverse a string you have to go through each of its element
         * Time complexity = O(n) , Space Complexity = O(1)
        */

        String stringX = Integer.toString(number);
        String reversedX = new StringBuilder(stringX).reverse().toString();

        return reversedX.equals(stringX);
    }

    public static boolean isPalindromNumberVersion2(long number) {

        /**
         * The second method I thought of is to turn the number into a string
         * check if the first element is equal to the last one
         * check if the second element is equal to the second last one ...ect
         * until we reach half of the string length
         * we then can conclude that the number is a palindrome.
         * Time complexity = O(n/2) = O(n) , Space Complexity = O(n)
         * (n being the length of the string number)
        */

        if (number < 0){
            return false;
        }
        
        String stringNumber = Long.toString(number);
        int size = stringNumber.length();

        if (size > 1) {
            for (int i = 0; i < (size / 2); i++) {
                if (stringNumber.charAt(i) != stringNumber.charAt(size-1-i)) {
                    return false;
                }
            }
            return true;
        }   

        return true;
    }

    public static boolean isPalindromNumberVersion3(int number) {

        /**
         * The third method is not use a cast
         * For this one I'll explain it using an example this way it's more intuitive
         * Let's take the palindromic number 75257
         * In the first step we check if 75257 // 10 != 0
         * number = temp = 75257 ; remained = 7 ; reversed_number = 0 * 10 + 7 = 7
         * Second step we now have temp = 7525
         * remainder = 5 ; reversed_number = 7 * 10 + 5 = 70 + 5 = 75
         * Third step we now have temp = 752
         * ...ect
         * Using this methodology we will get the reverse of original number
         * We then have to return the result of the comparison
         * We divide the number each time by 10 and we stop our loop when the number
         * is no longer dividable by 10 which means that it contain 0 digit
         * This method can cause a problem if the reverse of the number is superior than int.
         * Time complexity : O(number_of_digits) , Space Complexity : O(1)
         * or more formally 
         * Time complexity : O(log10(n)) , Space Complexity : O(1)
         * (n being the number itself)
        */

        // Special cases
        // When a number is inferior than 0 it's not a palindrome -121 != 121-
        // Since a number don't start with 0 every number that finish with 0 is not a palindrome (except the number 0 itself)
        if(number < 0 || (number % 10 == 0 && number != 0)){
            return false;
        }

        int temp = number;
        int reversedNumber = 0;

        while (temp != 0){
            reversedNumber = (reversedNumber * 10) + (temp % 10);
            temp = temp / 10;
        }
        
        return reversedNumber == number;
    }

    public static boolean isPalindromNumberVersion4(int number) {

        /**
         * In version 3 we reverse the number then check if it's equal to the original
         * In this version we will only go as far as the half of the number (like version 2 using string)
         * But how do we know when we reached half of the number
         * Since we divide each time by 10, once our reversed_number variable > original_number
         * We are sure that we exceeded or reached the middle of the number
         * If the number have an odd number of digit we can just get rid of the extra one since it's equal to itself
         * Time complexity(O(half_number_of_digits)) = O(log10(n)/2) = O(log10(n)) , Space complexity : O(1)
         * (n here being the number itself)
        */

        // Special cases
        // When a number is inferior than 0 it's not a palindrome -121 != 121-
        // Since a number don't start with 0 every number that finish with 0 is not a palindrome (except the number 0 itself)
        if(number < 0 || (number % 10 == 0 && number != 0)){
            return false;
        }


        int reversedNumber = 0;
        while (number > reversedNumber){
            reversedNumber = (reversedNumber * 10) + (number % 10);
            number = number / 10;
        }
        
        return reversedNumber == number || number == reversedNumber / 10;
    }
    
    

    public static void main(String[] args){
        int number = 75257;
        System.out.printf("First version Solution%b\n",isPalindromNumberVersion1(number));
        System.out.printf("Second version Solution%b\n",isPalindromNumberVersion2(number));
        System.out.printf("Third version Solution%b\n",isPalindromNumberVersion3(number));
        System.out.printf("Fourth version Solution%b\n",isPalindromNumberVersion4(number));
    }

}
