package swordToOffer;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Q027_Permutation {
    /*
     * 问题描述:
     *  输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有
     *  字符串abc,acb,bac,bca,cab和cba。
     *  [ 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。]
     * 解决思路(初始):
     *  所使用思想为将大问题划分为几个小问题，并递归的去解决小问题。首先将第一位字符与其它位置的字符依次进行调换，将每次得到的字符除第一位
     *  后依次进行新的交换，直到字符仅剩一位，就得到了所有的字符排列；
     *  对于存在重复字符的问题，可以通过判定集合中是否已经有该排列，若有，则跳过
     *  那么这样我们需要一个变量allList来记录所有的字符排列组合，还需要一个index变量来记录当前需要交换的字符位置；
     * 解决思路(改进):
     *
     * 容易出错的点:
     *  可能的异常输入：空字符串 或 null
     * Tips:
     *  在第一次书写代码时，犯了逻辑错误，以abc字符串为例，结果输出为 bac bca cba cab，即交换无问题，但忽略了初始字符串
     *  出错原因：在书写时没有考虑到自身也是需要向下一步传递的，因此首先传入的index为0，0需要与0进行交换
     */


    public ArrayList<String> Permutation(String str) {
        List<String> allList = new ArrayList<>();
        if(str.length() == 0)
            return (ArrayList)allList;
        getAllArrange(new StringBuffer(str), 0, allList);
        Collections.sort(allList);
        return (ArrayList)allList;
    }

    public List<String> getAllArrange(StringBuffer str, int index, List<String> allList) {
        if(index == str.length() -1){
            if(!allList.contains(str.toString()))
                allList.add(str.toString());
            return allList;
        }
        for (int i = index; i < str.length(); i++) {
            swap(str, index, i);
            getAllArrange(str, index + 1, allList);
            swap(str, index, i);
        }
        return allList;
    }

    public String swap(StringBuffer str, int indexA, int indexB) {
        char temp = str.charAt(indexA);
        str.setCharAt(indexA, str.charAt(indexB));
        str.setCharAt(indexB, temp);
        return str.toString();
    }

    public static void main(String[] args) {
        Q027_Permutation permutation = new Q027_Permutation();
        String str = new String("abc");
        List<String> list = permutation.Permutation(str);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
