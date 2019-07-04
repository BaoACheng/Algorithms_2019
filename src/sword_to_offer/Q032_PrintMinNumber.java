package sword_to_offer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q032_PrintMinNumber {

    /*
     * 问题描述:
     *  输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这
     *  三个数字能排成的最小数字为321323。
     * 解决思路(初始):
     *
     * 解决思路(改进):
     *
     * 容易出错的点:
     *  1、对于一个数字来说，其必然是在Int的表示范围内，但两个数字的拼接未必是，因此要考虑一个隐形的大数据问题
     *  2、对数字的直接位操作，相对而言有些困难，因此考虑将数字转换为Stringbuffer对象来进行操作
     * Tips:
     *
     */

    public String PrintMinNumber(int[] numbers) {
        if (numbers.length == 0 || numbers == null)
            return "";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            res.append(list.get(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {

    }
}
