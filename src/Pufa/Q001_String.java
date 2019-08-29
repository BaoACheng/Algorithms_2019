package Pufa;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Q001_String {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        char[] ch = s.toCharArray();
        int maxTimes = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) {
                map.put(ch[i], map.get(ch[i])+1);
            } else {
                map.put(ch[i], 1);
            }
            maxTimes = maxTimes > map.get(ch[i]) ? maxTimes : map.get(ch[i]);
        }
        ArrayList<Character>[] bucket = new ArrayList[maxTimes+1];
        for (char c: map.keySet()){
            int num = map.get(c);
            if(bucket[num] == null)
                bucket[num] = new ArrayList<>();
            bucket[num].add(c);
        }
        StringBuilder str = new StringBuilder();
        for (int i = maxTimes; i>0 ; i--) {
            if(bucket[i]!=null){
                Collections.sort(bucket[i]);
                for (int j = 0; j < bucket[i].size(); j++) {
                    for (int k = 0; k < i; k++) {
                        str = str.append(bucket[i].get(j));
                    }
                }
            }
        }
        return str.toString();
    }
}
