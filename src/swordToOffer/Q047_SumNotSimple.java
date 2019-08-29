package swordToOffer;


public class Q047_SumNotSimple {
    /*
     * 问题描述:
     *  求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * 解决思路(初始):
     *
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *
     */
    public int Sum_Solution(int n) {
        int res = n;
        boolean bool = res>0 && (res += Sum_Solution(n-1))>0;
        return res;
    }

    public static void main(String[] args) {
        Q047_SumNotSimple sum = new Q047_SumNotSimple();
        System.out.println(sum.Sum_Solution(10));
    }
}
