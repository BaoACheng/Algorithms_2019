package sword_to_offer;

public class Q007_Fibonacci {
    /*
     * 问题描述:
     *   大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
     * 解决思路(初始):
     *   首先想到的方法是最常用的递归方法(方法中有大量的重复计算，可以解决问题，但当数据增多时，会引起超时)
     * 解决思路(改进):
     *   考虑可否不使用递归方式来求解问题，即我们通过设置两个值来不断记录第n-1个数与第n-2个数的值，以此来简化重复的计算过程
     * 容易出错的点:
     *
     * Tips:
     *   递归的解决方式思路简单，代码容易书写，但往往容易出现大量的重复计算，在面试过程中需要特别的注意
     */

    public static int Fibonacci(int n) {
        int a = 0, b = 1;
        if (n == 0)
            return a;
        if (n == 1)
            return b;
        for (int i = 1; i < n; i++) {
            int temp = a+b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static int Fibonacci_old(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(30));
    }
}
