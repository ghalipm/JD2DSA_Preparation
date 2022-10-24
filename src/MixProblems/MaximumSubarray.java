package MixProblems;

import lombok.ToString;

import java.util.Arrays;

@ToString
public class MaximumSubarray {
    public static void main(String[] args) {
        //int[] arr = {-1, 2, -3, 4, -1, 2, -1, 5, 4};
        //int[] arr = {-2, 1};
        //int[] arr = {5,-2, -1, 1,-2,8};
        int[] arr = {-2, -1, -3, -4, -1, -2, -1, -5, -4}; // method 1 fails with this input
        System.out.println("============= MaximumSubarray1: ============");
        System.out.println("arr=" + Arrays.toString(arr) + ": max sum = " + maxSubArray(arr));

        System.out.println("============= MaximumSubarray2: ============");
        System.out.println("arr=" + Arrays.toString(arr) + ": max sum = " + maxSubArray2(arr));

        System.out.println("============= MaximumSubarray3: ============");
        System.out.println("arr=" + Arrays.toString(arr) + ": max sum = " + maxSubArraySum(arr, arr.length));

        System.out.println("============= MaximumSubarray4: ============");
        System.out.println("arr=" + Arrays.toString(arr) + ": max sum = " +maxContiguousSubarraySum(arr));
    }

    public static int maxSubArray(int[] arr) {
            int maxSum = 0;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                maxSum = Math.max(maxSum, sum);
//                if (sum < 0) {
//                    sum = 0;
//                }
            }
            return maxSum;
        }

    public static int maxSubArray2(int[] arr) {
        int maxSum = arr[0];//enables method for all negative numbers
        int tempSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            tempSum += arr[i];
            if(tempSum>maxSum) {maxSum = tempSum;}
            if(tempSum<0) {tempSum = 0;}
        }
        return maxSum;
    }

    public static int maxSubArraySum(int a[], int size)
    {
        int max = Integer.MIN_VALUE,
                tempMax = 0,start = 0,
                end = 0, s = 0;
        for (int i = 0; i < size; i++)
        {
            tempMax += a[i];
            if (max < tempMax)
            {
                max = tempMax;
                start = s;
                end = i;
            }

            if (tempMax < 0)
            {
                tempMax = 0;
                s = i + 1;
            }

        }
        return max;
    }

    public static int maxContiguousSubarraySum(int[] nums)
    {

        int maxSum = nums[0];
        int tempSum = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            tempSum +=nums[i];
            tempSum = Math.max(tempSum, nums[i]);
            // the above one line can be replaced by
            // if(tempSum<0) {tempSum = 0;}

            // Did we beat the 'maxSum' with the 'tempSum'?
            maxSum = Math.max(maxSum, tempSum); //  if(tempSum>maxSum) {maxSum = tempSum;}
        }

        return maxSum;
    }

}
