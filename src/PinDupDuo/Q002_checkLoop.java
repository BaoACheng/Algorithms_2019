package PinDupDuo;

import java.util.*;

public class Q002_checkLoop {

    /*
     * 依次对比两个字符串是否有相同字母，若有，则选取，并从字符中删除，然后继续判断下一组，直至所有的都可以匹配，则返回true，否则false
     */
    public static int judge(String[] str){
        List<String> list = new ArrayList<>(Arrays.asList(str));
        for (int i = 0; i < list.size(); i++) {
            List<String> newList = new ArrayList<>(list);
            newList.remove(i);

        }
        return 0;
    }

    public static void judgeCore(List<String> list, List<String> newList){

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] strs = scan.nextLine().split(" ");
        judge(strs);
        //String[] str = {"CAT", "TIGER", "RPC"};
    }
}
