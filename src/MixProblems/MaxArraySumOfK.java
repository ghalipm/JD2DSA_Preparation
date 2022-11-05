package MixProblems;

public class MaxArraySumOfK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 1, 4, 2};
        int k=3;
        System.out.println("maxArraySum(arr,k) = " + maxArraySum(arr, k));
    }

    private static long maxArraySum(int[] arr, int k) {
        if(arr.length<k) return 0;
        else {
            int right=0;
            int left=0;
            long maxSum = 0;
            long windowSum = 0;
            for(int i=left; i<arr.length; i++) {
                windowSum+=arr[i];
                right++;
                if(right>=k) {
                    maxSum =Math.max(windowSum, maxSum);
                    windowSum-=arr[left];
                    System.out.println("left = " + left);
                    left++;
                }
            }
            return maxSum;
        }
    }


}
