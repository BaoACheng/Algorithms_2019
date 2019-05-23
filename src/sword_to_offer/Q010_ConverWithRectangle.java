package sword_to_offer;

public class Q010_ConverWithRectangle {
    /*
     * 问题描述:
     *  我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * 解决思路:
     *  该题目也是斐波那契数列的变形，与🐸跳台子的题目类似
     * 容易出错的点:
     *
     * Tips:
     */

    public static int RectCover(int target) {
        if (target < 0)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;

        return RectCover(target - 1) + RectCover(target - 2);
    }
}
