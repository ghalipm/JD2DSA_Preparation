package MixProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicate_II {
    public static void main(String[] args) {
        //int[] nums = {1,2,3,1,2,3};
        //int[] nums = {1,0,1,1}; //nums[2]==nums[3] && abs(2-3)==1<=1
        //int[] nums = {1}; //nums[2]==nums[3] && abs(2-3)==1<=1
        int[] nums = null; //nums[2]==nums[3] && abs(2-3)==1<=1
        //int[] nums = {1, 2}; //nums[2]==nums[3] && abs(2-3)==1<=1
        int k = 1;//k=0; k=2; k=3; k=4; k=5;
        System.out.println("============= ContainsDuplicate_II: ============");
        System.out.println("nums=" + Arrays.toString(nums) + ", k=" + k + ": " + containsNearbyDuplicate(nums, k));
        System.out.println("nums=" + Arrays.toString(nums) + ", k=" + k + ": " + containsNearbyDuplicate2(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        if(nums==null || nums.length<2 || k==0)
            return false;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int nextIndex = map.get(nums[i]);
                if (i - nextIndex <= k){
                    System.out.println("(i, nextIndex) = " + "("+i+","+nextIndex+")");
                    return true;
                }
            }

            map.put(nums[i], i);
        }

        return false;

    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        if(nums==null || nums.length<2 || k==0)
            return false;

        int i=0;

        HashSet<Integer> set = new HashSet<Integer>();

        for(int j=0; j<nums.length; j++){
            if(!set.add(nums[j])){
                return true;
            }

            if(set.size()>=k+1){
                set.remove(nums[i++]);
            }
        }

        return false;
    }

}
