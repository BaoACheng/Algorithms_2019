package sword_to_offer;

public class Q052_IsNumberic {
    /*
     * 问题描述:
     *  请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     *  但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     * 解决思路(初始):
     *  尝试对其进行划分，根据E的位置，然后就可以判断分别判断前后是否满足
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     */
    public boolean isNumberic(char[] str) {
        if (str == null || str.length == 0)
            return false;
        boolean dot = false, hasE = false, sign = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (hasE || i == str.length - 1) return false;
                hasE = true;
            }else if (str[i] == '.') {
                if (dot || hasE) return false;
                dot = true;
            }else if (str[i] == '+' || str[i] == '-') {
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                sign = true;
            }else if (str[i] < '0' || str[i] > '9') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Q052_IsNumberic number = new Q052_IsNumberic();
        String str = "123.45e+6";
        System.out.println(number.isNumberic(str.toCharArray()));
    }
}
