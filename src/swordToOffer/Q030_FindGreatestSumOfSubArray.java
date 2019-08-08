package swordToOffer;


public class Q030_FindGreatestSumOfSubArray {
    /*
     * 问题描述:
     *  HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的
     *  最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
     *  例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会
     *  被他忽悠住？(子向量的长度至少是1)
     * 解决思路(初始):
     *  从最复杂的思路来讲，即暴力破解法，找到每一个连续子向量，并计算其大小，然后从中选出最大的一个，但算法复杂度过高，执行难度大
     * 解决思路(改进):
     *
     * 容易出错的点:
     *  可能的输入：空数组、正常数组
     * Tips:
     *
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0)
            return 0;

        int curMax = 0, subMax = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if(curMax <= 0){
                curMax = array[i];
            }else {
                curMax += array[i];
            }
            if(curMax>subMax)
                subMax = curMax;
        }
        return subMax;
    }

    public static void main(String[] args) {
        Q030_FindGreatestSumOfSubArray find = new Q030_FindGreatestSumOfSubArray();
        int[] array = {-4,1,2,-3,3,4,5,-10};
        int maxNumber = find.FindGreatestSumOfSubArray(array);
        System.out.println(maxNumber);
    }
}
