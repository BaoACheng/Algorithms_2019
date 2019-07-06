package sword_to_offer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q045_isContinuous {
    /*
     * 问题描述:
     *  LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的
     *  手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不
     *  高兴了,他想了想,决定大小王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2
     *  和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出
     *  true，否则就输出false。为了方便起见,你可以认为大小王是0。
     * 解决思路(初始):
     *
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *
     */
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return false;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list);
        int numberOfZeros = 0;
        int numberOfGaps = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0)
                numberOfZeros++;
        }
        int small = numberOfZeros;
        int big = small + 1;
        while (big < list.size()) {
            if (list.get(small) == list.get(big))
                return false;
            numberOfGaps += list.get(big) - list.get(small) - 1;
            small = big;
            big++;
        }
        return (numberOfZeros >= numberOfGaps) ? true : false;
    }

    public static void main(String[] args) {
        Q045_isContinuous con = new Q045_isContinuous();
        int[] numbers = {0, 1, 4, 5, 3};
        System.out.println(con.isContinuous(numbers));
    }
}
