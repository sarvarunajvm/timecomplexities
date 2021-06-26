package org.studies.dsalgo.ds.linear.array;


import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ReverseArray")
public class ReverseArray {

    public static int[] reverseArray(int[] a) {
        // if length is equal to 0 we throw an Exception
        if(a.length == 0){
            throw new ArrayIndexOutOfBoundsException("It's an empty array");
        }
        // if the length is 1 we dont need to reverse it
        if(a.length == 1){
            return a;
        }
        int[] reversedArray = new int[a.length];
        int count = 0;

        // Minus one to avoid the AIOOB exception
        for (int i = a.length - 1; i >= 0; i--) {
            log.info(String.valueOf(a[i]));
            reversedArray[count] = a[i];
            count++;
        }
        return reversedArray;
    }
}
