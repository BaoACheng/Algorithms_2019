package Beike;

import java.util.Scanner;

public class Q001_getMinK {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    public static String GetResult(int K) {
        double jiecheng;
        double sum;
        jiecheng = 1;
        sum = 1;
        for (long num = 1; ; num++) {
            System.out.println("num=" + num);
            //判断是否符合要求
            if (sum > K * jiecheng) {
                return num + "";
            } else {
                //获取新的阶乘与新的和
                sum = sum * (num + 1) + jiecheng;
                jiecheng *= num + 1;
            }
        }
    }

    public static int getRes(int k){
        double sum = 0;
        for (double i = 1; ; i++) {
            sum+=1/i;
            if(sum>k)
                return (int)i;
        }
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        //int num = 20;
        //System.out.println(getJieCheng(num));
        //System.out.println(getSum(num, getJieCheng(num)));
        Scanner in = new Scanner(System.in);
        //String res;

        int _K;
        _K = Integer.parseInt(in.nextLine().trim());

        long res = getRes(_K);
        System.out.println(res);
    }
}
