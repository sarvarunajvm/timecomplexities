package org.studies.dsalgo.patterns.slidingwindow;

public class MaximumSumSubarrayofSizeK {


    //    Time Complexity is O(N∗K)
    private static int normalApproach(int k, int[] arr) {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length - k; i++) {
            int moving = 0;
            for (int j = i; j < i + k; j++) {
                moving += arr[j];
            }
            result = result < moving ? moving : result;
        }

        return result;
    }

    //    Time Complexity is O(N)
    private static int slidingWindowApproach(int k, int[] arr) {
        int result = Integer.MIN_VALUE;
        int winStart = 0;
        int moving = 0;
        for (int winEnd = 0; winEnd < arr.length; winEnd++) {
            moving += arr[winEnd];
            if (winEnd >= k - 1) {
                result = result < moving ? moving : result;
                moving -= arr[winStart];
                winStart++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        long start = System.nanoTime();
        int result = MaximumSumSubarrayofSizeK.normalApproach(2, new int[]{2, 1, 5, 1, 3, 2});
        long end = System.nanoTime();
        System.out.println("MaximumSumSubarrayofSizeK normalApproach : " + result + " Time Taken " + (end - start));
        start = System.nanoTime();
        result = MaximumSumSubarrayofSizeK.slidingWindowApproach(2, new int[]{2, 1, 5, 1, 3, 2});
        end = System.nanoTime();
        System.out.println("MaximumSumSubarrayofSizeK slidingWindowApproach : " + result + " Time Taken " + (end - start));
    }


}
