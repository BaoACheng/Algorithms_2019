package swordToOffer;

import java.util.ArrayList;

public class Q041_FindContinuousSequence {
    /*
     * 问题描述:
     *  小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的
     *  正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快
     *  的找出所有和为S的连续正数序列? Good Luck!
     * 解决思路(初始):
     *
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum < 0)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int i = 1, j = 2;
        int margin = (1 + sum) / 2;
        while (i <= margin && i < j) {
            if (getSumBetweenTwoNumber(i, j) > sum)
                i++;
            if (getSumBetweenTwoNumber(i, j) < sum)
                j++;
            if (getSumBetweenTwoNumber(i, j) == sum) {
                ArrayList<Integer> tempList = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    tempList.add(k);
                }
                list.add(tempList);
                j++;
            }
        }
        return list;
    }

    public int getSumBetweenTwoNumber(int start, int end) {
        if(start == end)
            return 0;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Q041_FindContinuousSequence find = new Q041_FindContinuousSequence();
        ArrayList<ArrayList<Integer>> res = find.FindContinuousSequence(1000);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
