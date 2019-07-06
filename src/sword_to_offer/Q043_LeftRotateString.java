package sword_to_offer;


public class Q043_LeftRotateString {
    /*
     * 问题描述:
     *  汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其
     *  循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     * 解决思路(初始):
     *  1、首先要对循环的n位进行提前保存
     *  2、从后向前逐次复制过去，避免出现下一步要使用的数据被前一步覆盖
     *  3、将提前保存的数据放到空出来的位置
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *  1、在Java中，String类型是不可修改的，因此我们需要使用一个StringBuilder
     */
    public String LeftRotateString(String str, int n) {
        int len = str.length();
        if (len == 0 || len < n)
            return "";
        StringBuilder strBu = new StringBuilder();
        strBu.setLength(len);
        for (int i = 0; i < len - n; i++) {
            strBu.setCharAt(i, str.charAt(i + n));
        }
        for (int i = 0; i < n; i++) {
            strBu.setCharAt(len - n + i, str.charAt(i));
        }
        return strBu.toString();
    }

    public static void main(String[] args) {
        Q043_LeftRotateString left = new Q043_LeftRotateString();
        String str = "abcdef";
        System.out.println(left.LeftRotateString(str, 2));
    }
}
