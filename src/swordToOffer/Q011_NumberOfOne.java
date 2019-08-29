package swordToOffer;

public class Q011_NumberOfOne {
    /*
     * 问题描述:
     *  输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * 解决思路(初始):
     *  由于对位运算不太熟悉，因此，最初的设想是将其转化为2进制数，然后依次去统计1的个数，该方法太过麻烦
     * 解决思路(改进):
     *  可以将该数与数字1进行相与
     * 容易出错的点:
     *
     * Tips:
     */
    public int NumberOf1(int n) {
        int num = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag)!=0){
                num++;
            }
            flag <<= 1;
        }
        return num;
    }
}
