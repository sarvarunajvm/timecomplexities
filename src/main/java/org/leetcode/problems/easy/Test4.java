package org.leetcode.problems.easy;

import java.util.*;

public class Test4 {

    ArrayList<Integer> integers = new ArrayList<>();
    LinkedList<Integer> integers2 = new LinkedList<>();
    Vector<Integer> integerVector = new Vector<>();
    Queue<String> strings = new ArrayDeque<>();

    static HashMap<String,String> wordCount(String s) {
        HashMap<String,String> answer = new HashMap<String,String>();

        String[] words = s.replace("!","").replace("'","").replace(".","").split(" ");
        for(int i=0; i< words.length; i++) {
            String c = answer.get(words[i].toLowerCase());
            if(c == null) c = "0";

            answer.put(words[i].toLowerCase(), String.valueOf(Integer.parseInt(c)+1));
        }
        System.out.println(answer);
        return answer;
    }

    static Map<String,String> sortMap(Map<String,String> m) {
        List<Map.Entry<String, String>> entries = new ArrayList<>(m.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        return m;
    }

    public static void main(String []args){
        System.out.println(sortMap(wordCount("Practice makes perfect. you'll only get Perfect by practice. just practice!")));
    }
}
