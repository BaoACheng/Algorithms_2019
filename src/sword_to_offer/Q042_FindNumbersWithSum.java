package sword_to_offer;

import java.util.ArrayList;

public class Q042_FindNumbersWithSum {
    /*
     * 问题描述:
     *  输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     * 解决思路(初始):
     *
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = array.length - 1;
        while (i < array.length && j >= 0) {
            int res = array[i] + array[j];
            if (res > sum) {
                j--;
            }
            if (res < sum) {
                i++;
            }
            if (res == sum) {
                list.add(array[i]);
                list.add(array[j]);
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Q042_FindNumbersWithSum find = new Q042_FindNumbersWithSum();
        int[] arr = {1, 2, 4, 7, 11, 15};
        System.out.println(find.FindNumbersWithSum(arr, 15));
    }
}
