package sword_to_offer;

public class Q008_JumpFloor {
    /*
     * 问题描述:
     *   一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * 解决思路(初始):
     *   解决思路类似汉诺塔，当我们知道n-1,求解到最后，会发现，其实斐波那契数列的变形
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     */

    public static int JumpFloor(int target) {
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;

        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
    }
}
