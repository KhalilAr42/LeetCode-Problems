""" 

    Given an integer x, return true if x is a 
    palindrome, and false otherwise.

    Follow up: Could you solve it without converting the integer to a string?

"""

def is_palindrome_number_version1(number):

    """ 
        First method I thought of is turn the int into a string
        We can use str() function to cast an int to string
        Every string can be manipulated as an array in python
        We can use some python magic to reverse it
        Then we compare the reversed string with the initial one
        We finally return the result of the comparison
        To reverse a string you have to go through each of its element
        Time complexity = O(n) , Space Complexity = O(n)
        (n being the length of the string number)
    """

    return str(number)[::-1] == str(number)

def is_palindrome_number_version2(number):

    """ 
        The second method I thought of is to turn the number into a string
        check if the first element is equal to the last one
        check if the second element is equal to the second last one ...ect
        until we reach half of the string length
        we then can conclude that the number is a palindrome.
        Time complexity = O(n/2) = O(n) , Space Complexity = O(n)
        (n being the length of the string number)
    """

    string_number = str(number)
    size = len(string_number)

    for i in range(size//2):
        if string_number[i] != string_number[size - i - 1]:
            return False

    return True

def is_palindrome_number_version3(number):

    """ 
        The third method is not use a cast
        For this one I'll explain it using an example this way it's more intuitive
        Let's take the palindromic number 75257
        In the first step we check if 75257 // 10 != 0
        number = temp = 75257 ; remained = 7 ; reversed_number = 0 * 10 + 7 = 7
        Second step we now have temp = 7525
        remainder = 5 ; reversed_number = 7 * 10 + 5 = 70 + 5 = 75
        Third step we now have temp = 752
        ...ect
        Using this methodology we will get the reverse of original number
        We then have to return the result of the comparison
        We divide the number each time by 10 and we stop our loop when the number
        is no longer dividable by 10 which means that it contain 0 digit
        This method can cause a problem if the reverse of the number is superior than int.
        Time complexity : O(number_of_digits) , Space Complexity : O(1)
        or more formally 
        Time complexity : O(log10(n)) , Space Complexity : O(1)
        (n being the number itself)
    """
    
    # Special cases
    # When a number is inferior than 0 it's not a palindrome -121 != 121-
    # Since a number don't start with 0 every number that finish with 0 is not a palindrome (except the number 0 itself)
    if(number < 0 or (number % 10 == 0 and number != 0)):
        return False

    temp = number
    reversed_number = 0

    while temp / 10 != 0:
        reversed_number = reversed_number * 10 + temp % 10
        temp //= 10
    
    return reversed_number == number

def is_palindrome_number_version4(number):

    """ 
        In version 3 we reverse the number then check if it's equal to the original
        In this version we will only go as far as the half of the number (like version 2 using string)
        But how do we know when we reached half of the number
        Since we divide each time by 10, once our reversed_number variable > original_number
        We are sure that we exceeded or reached the middle of the number
        If the number have an odd number of digit we can just get rid of the extra one since it's equal to itself
        Time complexity(O(half_number_of_digits)) = O(log10(n)/2) = O(log10(n)) , Space complexity : O(1)
        (n here being the number itself)
    """

    # Special cases
    # When a number is inferior than 0 it's not a palindrome -121 != 121-
    # Since a number don't start with 0 every number that finish with 0 is not a palindrome (except the number 0 itself)
    if(number < 0 or (number % 10 == 0 and number != 0)):
        return False

    reversed_half = 0
    while number > reversed_half :
        reversed_half = reversed_half * 10 + number % 10
        number = number // 10
    
    return number == reversed_half or number == reversed_half // 10


number = 75257
print(f"First version Solution : {is_palindrome_number_version1(number)}")
print(f"Second version Solution : {is_palindrome_number_version2(number)}")
print(f"Third version Solution : {is_palindrome_number_version3(number)}")
print(f"Fourth version Solution : {is_palindrome_number_version4(number)}")