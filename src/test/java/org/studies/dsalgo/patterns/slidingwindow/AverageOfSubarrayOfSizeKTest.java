package org.studies.dsalgo.patterns.slidingwindow;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;

@Slf4j
class AverageOfSubarrayOfSizeKTest {


    EasyRandomParameters parameters = new EasyRandomParameters()
            .seed(123L)
            .objectPoolSize(100)
            .randomizationDepth(3)
            .collectionSizeRange(10, 20);
    final EasyRandom easyRandom = new EasyRandom(parameters);

    @RepeatedTest(10)
    void normalApproach() {
        int arr[] = easyRandom.nextObject(int[].class);
        int k = easyRandom.nextInt(9);
        log.info("ArraY: {} K : {}", arr, k);
        double[] expResult = new double[arr.length - k + 1];
        long start = System.nanoTime();
        double[] actResult = AverageOfSubarrayOfSizeK.normalApproach(k, arr);
        long end = System.nanoTime();
        log.info("Averages of subarrays of size K normalApproach : {}  Time Taken : {}", Arrays.toString(actResult), (start - end));
        Assertions.assertEquals(expResult.length, actResult.length);

    }

    @RepeatedTest(10)
    void slidingWindowApproach() {
        int arr[] = easyRandom.nextObject(int[].class);
        int k = easyRandom.nextInt(9);
        log.info("ArraY: {} K : {}", arr, k);
        double[] expResult = new double[arr.length - k + 1];
        long start = System.nanoTime();
        double[] actResult = AverageOfSubarrayOfSizeK.slidingWindowApproach(k, arr);
        long end = System.nanoTime();
        log.info("Averages of subarrays of size K slidingWindowApproach : {}  Time Taken : {}", Arrays.toString(actResult), (start - end));
        Assertions.assertEquals(expResult.length, actResult.length);
    }
}
