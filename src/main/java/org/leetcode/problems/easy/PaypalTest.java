package org.leetcode.problems.easy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PaypalTest {

    public static void main(String[] args) {
        // List of integers
//        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//
//        // Filter the list if thats even number
//        Predicate<Integer> integerPredicate = obj-> (obj % 2) == 0 ? true : false;
//
//        List<Integer> filteredInts = integers.stream().filter(integerPredicate).map(integer -> integer*3).collect(Collectors.toList());
//
////        // multiply the list by 3
////        List<Integer> integerList = filteredInts.stream().map(integer -> integer*3).collect(Collectors.toList());
//
//        System.out.println(filteredInts);

        // STring
//        String s = new String("hello");
//
//        // split to character
//        char splitted[] = s.toCharArray();
//
//        Map<Character, Integer> characterIntegerMap = new TreeMap<>();
//        for(int i=0; i<splitted.length; i++){
//            if(!characterIntegerMap.containsKey(splitted[i])){
//                characterIntegerMap.put(splitted[i],0);
//            }
//            characterIntegerMap.put(splitted[i],characterIntegerMap.get(splitted[i])+1);
//        }


//        // sort that array in acsending
//        Arrays.sort(splitted);
//        System.out.println(new String(splitted));
//
//        // count the occurences
//        for(int i=0; i<splitted.length; i++){
//            int finalI = i;
//            System.out.println("The Char : "+splitted[i]+ "count in this string is"+s.chars().filter(value -> value == splitted[finalI]).count());
//        }

//        System.out.println(characterIntegerMap);
        //output is a character with count in asending order

        AtomicInteger i = new AtomicInteger();

        List<Integer> integerList = IntStream.range(0,5).boxed().collect(Collectors.toList());


        integerList.forEach(integer -> i.addAndGet(integer));


    }

}
