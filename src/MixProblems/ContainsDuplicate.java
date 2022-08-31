package MixProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */

public class ContainsDuplicate {
    private static int[] nums= {1, 2, 3, 4};
    //private static int[] nums= {1, 2, 3, 1};
    //private static int[] nums= {1, 2, 3, 2, 3, 4};
    //private static int[] nums= {7,10,5,5,6,6,4,10,5,4,9,4,9,6,5,9,6,3,6,5,6,7,7,4,9,9,10,5,8,1,8,3,2,7,5,10,1,8,5,8,4,3,6,4,9,4,2,8,3,2,2,1,5,6,3,2,6,1,8,6,2,9,1,4,5,10,8,5,10,5,10,1,4,8,3,6,4,10,9,1,1,1,2,2,9,6,6,8,1,9,2,5,5,2,1,8,5,2,3,10};
    private static boolean haveDuplicate=false;

    public static void main(String[] args) {
        System.out.println("containsDuplicate(nums) = " + containsDuplicate(nums));
        System.out.println("containsDuplicate2(nums) = " + containsDuplicate2(nums));
    }

    public static boolean containsDuplicate(int[] nums) {

        // add the nums as key into map and count the frequency of the key
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //check if the map contains non-single values: map.get(nums[i])!=1 better than map.get(nums[i])==2, some may repeat more than 2 times!
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])!=1){haveDuplicate=true; break;}
            else haveDuplicate=false;
        }

        return haveDuplicate;
    }

    public static boolean containsDuplicate2(int[] nums) {

        // add the nums as key into map and count the frequency of the key
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //check if the map contains non-single values: map.get(nums[i])!=1 better than map.get(nums[i])==2, some may repeat more than 2 times!
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
           // if(map.get(key)>1){haveDuplicate=true; break;}
            if(map.get(key)!=1){haveDuplicate=true; break;}
            else haveDuplicate=false;
        }
        return haveDuplicate;
    }

}
