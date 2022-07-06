package MixProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the
 * non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Input: intervals = [[8,10],[1,3],[2,6],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

public class MergingIntervals {

    public static void main(String[] args) {
        int[][] intervals={{1,9},{2,6},{5,7},{8,28}};
        System.out.println(Arrays.deepToString(intervals));
        System.out.println(Arrays.deepToString(merge(intervals)));

        System.out.println("mergeIntervals2(intervals) = " + Arrays.deepToString(mergeIntervals2(intervals)));
    }
 public static int[][] merge(int[][] intervalOfArray){
     ArrayList<int[]> mergedList=new ArrayList<>();
        int[] current=intervalOfArray[0];
        int start=current[0];
        int end=current[1];

     for (int i = 1; i < intervalOfArray.length; i++) {
         if(end<intervalOfArray[i][0]) {
             mergedList.add(new int[] {start,end});
             start=intervalOfArray[i][0];
             end=intervalOfArray[i][1];
         }else{
             end=Math.max(intervalOfArray[i][1], end);
         }
     }
     mergedList.add(new int[] {start, end});
        return mergedList.toArray(new int[mergedList.size()][]);
 }

    public static int[][] mergeIntervals2(int[][] intervals) {
        // sort intervals based on starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //Arrays.sort(intervals);

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            System.out.println("interval[0] = " + interval[0]);
            if(!merged.isEmpty()) {
                System.out.println("merged.getLast()[1] = " + merged.getLast()[1]);
            }
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


}
