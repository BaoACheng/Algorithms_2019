package swordToOffer;

import java.util.ArrayList;
import java.util.List;

public class Q033_GetUglyNumber {
    /*
     * 问题描述:
     *  把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。
     *  求按从小到大的顺序的第N个丑数。
     * 解决思路(初始):
     *
     * 解决思路(改进):
     *
     * 容易出错的点:
     *  1、在最开始的思路，是判断每一个数是否为丑数，但在最开始，只考虑到了10以内质子，后反应过来实际应该有很多数都为质数，但又不是2、3、5，因此
     *  这种思路是错误的。
     * Tips:
     *
     */
    public int GetUglyNumber_Solution(int index) {
        if (index < 7)
            return index;
        List<Integer> list = new ArrayList<>(index);
        list.add(1);
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            int num2 = list.get(t2) * 2;
            int num3 = list.get(t3) * 3;
            int num5 = list.get(t5) * 5;
            list.add(Math.min(num2, Math.min(num3, num5)));
            if (list.get(i) == num2)
                t2++;
            if (list.get(i) == num3)
                t3++;
            if (list.get(i) == num5)
                t5++;
        }
        return list.get(index - 1);
    }

    public static void main(String[] args) {

    }
}
