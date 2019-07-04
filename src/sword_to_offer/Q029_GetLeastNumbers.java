package sword_to_offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q029_GetLeastNumbers {

    /*
     * 问题描述:
     *  输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * 解决思路(初始):
     *  使用排序算法来对数组排序，前k个元素即为最小的k个数，最优算法复杂度为O(nlgn)
     * 解决思路(改进):
     *  在查看剑指Offer之后，了解了红黑树的数据结构，即可以在O(lg n)的复杂度下完成数据的插入与删除
     * 容易出错的点:
     *
     * Tips:
     */

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(input.length < k || input.length == 0 || k<=0)
            return list;

        PriorityQueue<Integer> leastNumbers = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < input.length; i++) {
            leastNumbers.offer(input[i]);
        }

        for (int i = 0; i < k; i++) {
            list.add(leastNumbers.poll());
        }

        return list;
    }

    public static void main(String[] args) {
        Q029_GetLeastNumbers get = new Q029_GetLeastNumbers();
        int[] list = {10, 9, 5, 11, 4, 7, 2, 9, 10, 111, 1023};
        ArrayList<Integer> res = get.GetLeastNumbers_Solution(list, 10);
        for(Integer integer: res)
            System.out.print(integer + " ");
    }
}
