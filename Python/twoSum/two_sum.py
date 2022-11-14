"""

    Problem Statement :

    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

"""

def two_sum_version1(nums,target):

    """
        First version I tought of is brute force, 
        Go through each element of the list
        Check if the sum is equal to target and return the indices in a list
        Time complexity = O(n^2) , Space Complexity = O(1)
    """

    for i in range(len(nums)):
        for j in range(i+1,len(nums)):
            if nums[i] + nums[j] == target :
                return [i,j]
    
    return None


target = 9
nums = [2,7,11,15,18,19,20]
print(two_sum_version1(nums,target))