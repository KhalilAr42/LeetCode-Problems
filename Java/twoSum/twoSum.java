/*

    Problem Statement :

    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

 */

import java.util.Arrays;

public class twoSum{

    static final int[] nums = {2,7,11,15,18,19,20};

    public static int[] two_sum_version1 (int[] nums,int target) {
        /** 
        *First version I tought of is brute force, 
        *Go through each element of the list
        *Check if the sum is equal to target and return the indices in an array
        *Time complexity = O(n^2) , Space Complexity = O(1)
        */
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        
        System.out.print(Arrays.toString(two_sum_version1(nums, 9)));

    }

}