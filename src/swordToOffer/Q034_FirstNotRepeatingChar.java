package swordToOffer;


import java.util.LinkedHashMap;

public class Q034_FirstNotRepeatingChar {
    /*
     * 问题描述:
     *  在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
     * 解决思路(初始):
     *  使用一个键值对来存储字符与字符出现的次数，<字符，字符出现的次数>，在Java中，即使用LinkedHashMap来进行存储，遍历字符串结束后，依次检查
     *  哈希表，当找到第一个出现次数为1时，返回其位置。
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *
     */
    public static int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), time + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1)
                return i;
        }
        return index;
    }

    public static void main(String[] args) {
        String str = "google";
        System.out.println(FirstNotRepeatingChar(str));
    }
}
