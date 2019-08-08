package swordToOffer;

public class Q028_MoreThanHalfNum_Solution {
    /*
     * 问题描述:
     *  数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中
     *  出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     * 解决思路(初始):
     *  暴力破解方法，肯定是直接对每个数字进行计数，即要多次遍历数组，虽能解决问题，但算法复杂度必然很高
     * 解决思路(改进):
     *  问题的关键点在于，该数字出现的次数，是超过数组长度的一半，也就是说，这个数字出现的次数是比数组中其他数字出现的总和还要多，因此当可
     *  以考虑，设置一个number记录当前的数字，times来记录当前数字的次数，然后遍历数组，若遍历的元素不等于该元素，则times-1，相同则
     *  times+1，当times为0时，以当前元素替代number，若存在这样的元素，则必然在遍历后，number是记录的该元素，那么我们在最后统计该元素
     *  出现的次数，并进行判断即可。
     * 容易出错的点:
     *  可能的输入：
     *      空指针，数组长度为0，正常数组
     * Tips:
     */

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int number = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                number = array[i];
                times = 1;
                continue;
            }
            if (array[i] == number)
                times++;
            else
                times--;
        }
        if (CheckNumber(array, number))
            return number;
        else
            return 0;
    }

    public boolean CheckNumber(int[] array, int number) {
        int len = array.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] == number)
                count++;
        }
        if (2 * count > len)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Q028_MoreThanHalfNum_Solution solution = new Q028_MoreThanHalfNum_Solution();
        //int[] array = {1, 2, 3, 2, 5, 3, 4, 3, 1};
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(solution.MoreThanHalfNum_Solution(array));
    }
}
