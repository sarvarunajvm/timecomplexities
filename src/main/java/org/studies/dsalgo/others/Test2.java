package org.studies.dsalgo.others;


import java.util.HashMap;

public class Test2 {

//    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//    Symbol Value
//    I 1
//    V 5
//    X 10
//    L 50
//    C 100
//    D 500
//    M 1000
//
//    Example 1:
//    Input: s = "III"
//    Output: 3     2-3
//
//    Example 2:
//    Input: s = "IV"
//    Output: 4    4
//
//    Example 3:
//    Input: s = "LVIII"
//    Output: 58
//    Explanation: L = 50, V= 5, III = 3  55-57-58

    // Example 4:
//    input : s= "IL" "XLIX"  1-40-49
//    output: 49


    public static void main(String[] args) {

        // initialize int for result
        int result = 0;
        String str = "IV";

        // for based on the sting length
        for(int i=0; i< str.length(); i++){
            int c1 = getValueFromMap(str.charAt(i));

            if(i+1 < str.length()){
                int c2 = getValueFromMap(str.charAt(i+1));
                // if char1 >= char2 add the both values and add it to result
                if(c1 >= c2){
                    result = result+c1+c2;
                    i++;
                }else{
                    // else result = result + (char2-char1) i++;
                    result = result+c2-c1;
                    i++;
                }
            }else{
                result += c1;
            }
        }
        System.out.println(result);
    }

    private static int getValueFromMap(char charAt) {
//    I 1
//    V 5
//    X 10
//    L 50
//    C 100
        HashMap<Character,Integer> roamanValueMap = new HashMap<>();
        roamanValueMap.put('I',1);
        roamanValueMap.put('V',5);
        roamanValueMap.put('X',10);
        roamanValueMap.put('L',50);
        roamanValueMap.put('C',100);
        return roamanValueMap.getOrDefault(charAt,0);
    }


}
