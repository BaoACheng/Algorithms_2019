package swordToOffer;


public class Q049_ParseStringToInt {
    /*
     * 问题描述:
     *  将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换
     *  整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
     * 解决思路(初始):
     *  由于不能使用任何的转换库，那么肯定就是使用ASCII码来进行转换，思路就是逐位的转换，然后依次升位
     * 解决思路(改进):
     *
     * 容易出错的点:
     *  考虑情况容易不周全，如在str中间出现非法字符，或在str开头出现+/-号，以及同样输出结果是0，如何判断到底是真的0，还是因为非法输入造成的0
     *  结果，这些情况都要考虑在内，希望自己在以后写代码的过程中，能先考虑到可能的异常输入情况，考虑并做出处理
     * Tips:
     *
     */
    public boolean islegal = true;
    public int StrToInt(String str) {
        if(str == null||str.length()==0){
            islegal = false;
            return 0;
        }
        int res = 0;
        boolean sign = true;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i ==0){
                if(chars[i] == '+') {
                    continue;
                }
                if(chars[i] == '-') {
                    sign = false;
                    continue;
                }
            }

            int temp = chars[i] - '0';
            if(temp<0||temp>9){
                islegal =false;
                return 0;
            }
            res = res * 10 +temp;
        }
        return sign?res:0-res;
    }

    public static void main(String[] args) {
        Q049_ParseStringToInt parse = new Q049_ParseStringToInt();
        System.out.println(parse.StrToInt("123"));
    }
}
