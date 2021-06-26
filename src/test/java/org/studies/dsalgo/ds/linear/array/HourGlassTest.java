package org.studies.dsalgo.ds.linear.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HourGlassTest {

    @Test
    void testHourGlassSumException() {
        int[][] input = new int[][]{};
        String message = "It's an empty array";

        Exception exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> HourGlassSum.hourglassSum(input));
        Assertions.assertEquals(message, exception.getMessage());
    }

    @Test
    void testHourGlassSum() {
        int[][] input = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 0, 2, 2, 2},
                {0, 0, 0, 0, 2, 0},
                {0, 0, 0, 2, 2, 2}
        };
        int output = 14;

        int result = HourGlassSum.hourglassSum(input);
        Assertions.assertEquals(output, result);

    }

}
