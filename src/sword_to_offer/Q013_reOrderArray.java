package sword_to_offer;

public class Q013_reOrderArray {
    /*
     * 问题描述:
     *  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数
     *  和奇数，偶数和偶数之间的相对位置不变。
     * 解决思路(初始):
     *  设立两个指针，分别指向开头，然后指针a记录当前已调整完的数，指针b寻找指针a后的第一个奇数数字，随后调整到指针a的位置，并后移
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *  位运算是很便捷的操作，相对于除法操作和取余操作，其可以节省很多的时间
     *  (n & 1) == 1 表示寻找奇数
     *  n >> 1 表示向右偏移一位
     */

    public static void reOrderArray(int[] arr) {
        int len = arr.length;
        if (len <= 1)
            return;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if ((arr[j] & 1) == 1) {
                    int current = arr[j];
                    while (j > i) {
                        arr[j] = arr[j - 1];
                        j--;
                    }
                    arr[i] = current;
                    break;
                }
            }
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        print(arr);
        reOrderArray(arr);
        System.out.println();
        print(arr);
    }

}
