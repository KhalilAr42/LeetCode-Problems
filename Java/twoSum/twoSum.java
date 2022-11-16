/*

    Problem Statement :

    Given an array of integers numbers and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.


*/

import java.util.Arrays;
import java.util.HashMap;

public class twoSum{

    static final int[] numbers = {2,7,11,15,18,19,20};

    public static int[] twoSumVersion1(int[] numbers, int target) {

        /** 
         * First version I thought of is brute force, 
         * Go through each element of the list
         * Check if the sum is equal to target and return the indices in an array
         * Time complexity = O(n^2) , Space Complexity = O(1)
        */

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumVersion2(int[] numbers, int target) {

        /**  
         * 
         * In the second version I thought of using binary search.
         * This will reduce the search of the complement from O(n) to a log2(n) Complexity
         * But we will have to make sure that the list is sorted which take at best O(nlog2(n))
         * Time complexity = O(nlog2(n)) , Space Complexity = O(1)
         *
        */

        Arrays.sort(numbers);
        
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            int start = 0;
            int end = numbers.length - 1;
            int mid = 0;
            while (start < end) {
                mid = (start + end) / 2;
                if (numbers[mid] == complement && numbers[mid] != numbers[i]){
                    return new int[] {i,mid};
                } else if (numbers[mid] < complement) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSumVersion3(int[] numbers, int target) {
       
            /**
             * 
             * Since we want to reduce our search time it could be interesting to use hashmaps
             * Hashmaps have an access time complexity of O(1)
             * We can fill the hashmap with the values of the list as keys and and the indexes as (hashamp) values
             * If the complement is in the keys return the answer.
             * Time complexity = O(n) , Space Complexity = O(n)
             *
            */ 

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        int complement;
        for (int i = 0; i < numbers.length; i++) {
            complement = target - numbers[i];
            if (map.containsKey(complement)) {
                int complementIndex = map.get(complement);
                return new int[] {i,complementIndex};
            }
            
        }
        return new int[0];
    }

    public static int[] twoSumVersion4(int[] numbers, int target) {

        /**
         * 
         * To optimize even more our algorithm we could get rid of the first part in version3
         * We calculate our complement and look for it in the hashmap 
         * if he's there we return our result else we add it to the hashmap 
         * Time complexity = O(n) , Space Complexity = O(n)
         * 
        */

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int complement;
        for (int i = 0; i < numbers.length; i++) {
            complement = target - numbers[i];
            if (map.containsKey(complement)) {
                int complementIndex = map.get(complement);
                return new int[] {i,complementIndex};
            } 

            map.put(numbers[i],i);
            
        }
        return new int[0];
    }

    public static void main(String[] args) {

        //Testing the different solution output
        
        System.out.println("First version Solution : " + Arrays.toString(twoSumVersion1(numbers, 9)));
        System.out.println("Second version Solution : " + Arrays.toString(twoSumVersion2(numbers, 9)));
        System.out.println("Third version Solution : " + Arrays.toString(twoSumVersion3(numbers, 9)));
        System.out.println("Fourth version Solution : " + Arrays.toString(twoSumVersion4(numbers, 9)));

    }

}