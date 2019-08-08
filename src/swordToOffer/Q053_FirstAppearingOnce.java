package swordToOffer;

import java.util.ArrayList;
import java.util.HashMap;

public class Q053_FirstAppearingOnce {

    /*
     * 问题描述:
     *  请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     *  当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     * 解决思路(初始):
     *  首先，拿到题目的时候，对于题目`
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     */
    HashMap<Character, Integer> map = new HashMap<>();
    ArrayList<Character> list = new ArrayList<>();

    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
        list.add(ch);
    }

    public char FirstAppearingOnce() {
        char res = '#';
        for (char key : list){
            if(map.get(key) == 1)
                return key;
        }
        return res;
    }

}
