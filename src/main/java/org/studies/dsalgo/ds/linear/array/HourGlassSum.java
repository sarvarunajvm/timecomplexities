package org.studies.dsalgo.ds.linear.array;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "HourGlassSum")
public class HourGlassSum {

    public static int hourglassSum(int[][] arr) {


        int max = Integer.MIN_VALUE;
        int total = 0;


        // if length is equal to 0 we throw an Exception
        if (arr.length == 0) throw new ArrayIndexOutOfBoundsException("It's an empty array");

        for (int row = 0; row < 4; row++) {

            for (int col = 0; col < 4; col++) {

                total = arr[row][col] + arr[row][col + 1] + arr[row][col + 2]; // 00,01,02
                total += arr[row + 1][col + 1];// 11
                total += arr[row + 2][col] + arr[row + 2][col + 1] + arr[row + 2][col + 2]; //20,21,22
                max = total > max ? total : max;
                log.info("Total at Row : {} Col : {} Total : {}", row, col, total);
                log.info("Total : {} && Max : {}", total, max);
            }
        }
        return max;

    }
}
