""" 

    Given an integer x, return true if x is a 
    palindrome, and false otherwise.

    Follow up: Could you solve it without converting the integer to a string?

"""

def is_palindrome_number_version1(number):
    """ 
        First method I tought of is turn the int into a string
        We can use str() function to cast an int to string
        Every string can be manipulated as an array in python
        We can use some python magic to reverse it
        Then we compare the reversed string with the initial one
        We finaly return the result of the comparaison
        To reverse a string you have to go through each of its element
        Time complexity = O(n) , Space Complexit= O(1)
    """
    return str(number)[::-1] == str(number)

number = 121;
print(is_palindrome_number_version1(number))