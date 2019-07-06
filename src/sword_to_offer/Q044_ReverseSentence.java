package sword_to_offer;


import java.util.ArrayList;

public class Q044_ReverseSentence {
    /*
     * 问题描述:
     *  牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
     *  但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。\
     *  Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     * 解决思路(初始):
     *  1、首先要有一个单词划分函数
     *  2、依次保存单词
     *  3、逆序输出
     * 解决思路(改进):
     *  对String的操作并不熟悉，导致常用的trim()函数与split()函数没想到，因此可以直接利用split()函数进行直接划分，然后逆序输出
     * 容易出错的点:
     *  对边界的错误输入处理不足，具体表现为代码的24-25行的处理不善用
     * Tips:
     *
     */
    public String ReverseSentence(String str) {
        if (str.trim().equals(""))
            return str;
        String[] result = str.split(" ");
        StringBuffer strBu = new StringBuffer();
        for (int i = result.length - 1; i >= 0; i--) {
            strBu.append(result[i]);
            if (i > 0) {
                strBu.append(" ");
            }
        }
        return strBu.toString();
    }

    public static void main(String[] args) {
        Q044_ReverseSentence reverse = new Q044_ReverseSentence();
        String str = "student. a am I";
        System.out.println(reverse.ReverseSentence(str));
    }
}
