package swordToOffer;


public class Q040_FindNumsAppearOnce {
    /*
     * 问题描述:
     *  一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * 解决思路(初始):
     *  对于这种问题，简单来说，可以考虑对数组进行排序，算法的时间复杂度为0(nlogn)
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length == 0)
            return;
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res = array[i] ^ res;
        }
        num1[0] = 0;
        num2[0] = 0;
        int indexOf1 = FindFirstNumberof1(res);
        for (int i = 0; i < array.length; i++) {
            if (isBit(array[i], indexOf1)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    public int FindFirstNumberof1(int num) {
        int index = 0;
        while ((num & 1) == 0) {
            num = num >> 1;
            index++;
        }
        return index;
    }

    public boolean isBit(int num, int index) {
        num = num >> index;
        if ((num & 1) == 1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Q040_FindNumsAppearOnce find = new Q040_FindNumsAppearOnce();
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        find.FindNumsAppearOnce(array, num1, num2);
    }
}
