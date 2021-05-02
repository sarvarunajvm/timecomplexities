package org.leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/*https://leetcode.com/problems/two-sum/*/
public class TwoSum {

//    Time complexity : O(n)O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1)O(1) time.
//    Space complexity : O(n)O(n). The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.


    public int[] twoSum(int[] nums, int target) {
        // Declaring hash map
        Map<Integer, Integer> intMap = new HashMap<>();

        Character.isAlphabetic('a');

        // traversing through the array
        for (int i = 0; i < nums.length; i++) {
            int balance = target - nums[i];
            if (intMap.containsKey(balance)) {
                return new int[]{intMap.get(balance), i};
            }
            intMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
