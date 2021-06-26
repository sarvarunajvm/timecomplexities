package org.studies.dsalgo.ds.linear.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseArrayTest {

    @Test
    void testReverseArray() {
        int[] input = new int[]{1, 2, 3, 4};
        int[] reversed = new int[]{4, 3, 2, 1};

        int[] result = ReverseArray.reverseArray(input);

        Assertions.assertArrayEquals(reversed, result);
    }

    @Test
    void testReverseArrayWithOneElement() {
        int[] input = new int[]{1};
        int[] reversed = new int[]{1};

        int[] result = ReverseArray.reverseArray(input);

        Assertions.assertArrayEquals(reversed, result);
    }

    @Test
    void testReverseArrayException() {
        int[] input = new int[]{};
        String message = "It's an empty array";

        Exception exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> ReverseArray.reverseArray(input));
        Assertions.assertEquals(message, exception.getMessage());
    }

}
