package org.studies.dsalgo.patterns.slidingwindow;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {

    /*    Time complexity: Since for every element of the input array, we are calculating the sum of its
    next ‘K’ elements, the time complexity of the above algorithm will be O(N*K)O(N∗K)
    where ‘N’ is the number of elements in the input array.*/
    public static double[] normalApproach(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        for (int i = 0; i <= arr.length - k; i++) {
            // sum till Kth elements
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            // adding the average of sum
            result[i] = sum / k;
        }
        return result;
    }

    /* Time complexity: Since we are iterating the input array for only one time we can say this is O(N) */
    public static double[] slidingWindowApproach(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k - 1) {
                result[windowStart] = windowSum / k; // calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        double[] result = AverageOfSubarrayOfSizeK.normalApproach(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        long end = System.nanoTime();
        start = System.nanoTime();
        double[] result2 = AverageOfSubarrayOfSizeK.slidingWindowApproach(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        end = System.nanoTime();
        System.out.println("Averages of subarrays of size K slidingWindowApproach : " + Arrays.toString(result2) + " Time Taken " + (start - end));
    }

}
