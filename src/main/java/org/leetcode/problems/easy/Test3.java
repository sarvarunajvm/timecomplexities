package org.leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
        public static void main( String args[] ) {
            System.out.println( "Hello Pramp!" );
            System.out.println( isLoveLetterReproducible("Hello","Pramp"));
        }

        public static boolean isLoveLetterReproducible(String L,String N){
            Map<Integer,Integer> charMap = new HashMap<>();
            int charCount = 0;

            for(int i = 0; i<L.length(); i++){
                int charCode = (int)L.charAt(i);
                if (!charMap.containsKey(charCode)){
                    charMap.put(charCode,0);
                }
                charCount++;
                charMap.put(charCode,charMap.get(charCode)+1);
            }
            for(int i=0; i<N.length(); i++){

                int charCode = (int)N.charAt(i);
                if (charMap.containsKey(charCode) && charMap.get(charCode) >=1){
                    charCount--;
                    charMap.put(charCode,charMap.get(charCode)-1);
                }
            }
            if (charCount == 0){
                return true;
            }
            return false;

        }

}
