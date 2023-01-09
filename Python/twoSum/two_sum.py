"""

    Problem Statement :

    Given an array of integers numbers and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

"""


def two_sum_version1(numbers, target):
    """
        First version I thought of is brute force, 
        Go through each element of the list
        Check if the sum is equal to the target and return the indices in a list
        Time complexity = O(n^2) , Space Complexity = O(1)
    """

    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            if numbers[i] + numbers[j] == target:
                return [i, j]

    return None


def two_sum_version2(numbers, target):
    """ 
        In the second version I thought of using binary search.
        This will reduce the search of the complement to a log2(n) Complexity
        But we will have to make sure that the list is sorted which take at best O(nlog2(n))
        Time complexity = O(nlog2(n)) , Space Complexity = O(1)
    """

    numbers.sort()
    for i in range(len(numbers)):
        complement = target - numbers[i]
        start = 0
        end = len(numbers) - 1
        while start < end:
            mid = (start + end) // 2
            if (numbers[mid] == complement and numbers[mid] != numbers[i]):
                return [i, mid]
            elif (numbers[mid] < complement):
                start = mid + 1
            else:
                end = mid - 1
    return None


def two_sum_version3(numbers, target):
    """ 
        Since we want to reduce our search time it could be interesting to use hashmaps
        Hashmaps have an access time complexity of O(1)
        We first fill a hashmap with the values as keys and indexes as values
        And then we look for our complement in the hashmap keys
        Time complexity = O(n) , Space Complexity = O(n)
    """

    hashmap = {}
    for i in range(len(numbers)):
        hashmap[numbers[i]] = i

    for i in range(len(numbers)):
        complement = target - numbers[i]
        if complement in hashmap.keys():
            return [i, hashmap[complement]]

    return None


def two_sum_version4(numbers, target):
    """ 
        To optimize even more our algorithm we could get rid of the first part in version3
        We calculate our complement and look for it in the hashmap 
        if he's there we return our result else we add it to the hashmap 
        Time complexity = O(n) , Space Complexity = O(n)
    """

    hashmap = {}

    for i in range(len(numbers)):
        complement = target - numbers[i]
        if complement in hashmap.keys():
            return [i, hashmap[complement]]
        hashmap[numbers[i]] = i

    return None


# Testing the different solution output

target = 9
numbers = [2, 7, 11, 15, 18, 19, 20]
print(f"First version Solution : {two_sum_version1(numbers,9)}")
print(f"Second version Solution : {two_sum_version1(numbers,9)}")
print(f"Third version Solution : {two_sum_version1(numbers,9)}")
print(f"Fourth version Solution : {two_sum_version1(numbers,9)}")
