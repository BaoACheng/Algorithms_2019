package swordToOffer;

public class Q009_JumpFloorII {
    /*
     * 问题描述:
     *  一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 解决思路(分析):
     *      f(n) = f(n-1) + f(n-2) + f(n-3) + …… + f(0)
     *    f(n-1) = f(n-2) + f(n-3) + …… + f(0)
     *    故有f(n) = 2 f(n-1)
     * 容易出错的点:
     *
     * Tips:
     */

    public static int JumpFloorII(int target){
        if(target == 1)
            return 1;

        return 2*JumpFloorII(target-1);
    }
}
