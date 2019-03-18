package sword_to_offer;

public class Q002_Replace_whitespace {
    /*
     * 题目描述：
     *  请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为 We%20Are%20Happy
     * 算法思想：
     *  最初考虑：从头到尾扫描字符串，当遇到空格字符时则对其进行替换，但若是在同一字符内进行操作，则涉及到大量的移动操作，'%20'是三位字符，
     *          需要添加2位字符，则需要大量后移，因此会复杂度较高
     *  简洁思路：若从前到后扫描，则在第一个空格后的字符需要多次移动，复杂度较高，运用反向思维，我们从后向前移动，以简化大量操作
     *  思路描述：首先预先扫描字符串，检查其中存在的空格数，因此字符串的长度会增加2*空格数。同时设立两个指针，p1在替换前的字符串末尾，p2在替换
     *          后的字符串末尾，然后每次移动时，若未到空格，则将p1指向的数据移动到p2指向的位置，当p1指向空格时，p1向前移动一位，然后p2开始进
     *          行添加%20，直到p1指向字符串的头部则结束。
     *  问题1：在同一字符串，如何添加长度？
     *  问题2：如何判定最后算法截止条件？
     *  Tips：
     *      StringBuffer与String的区别：StringBuffer是变量，即其数据是可以更改的，当我们对StringBuffer进行更改时，更改的是其存储在内存
     *  中的值。String对象在Java的规定中是一经创建则不可修改，即当我们调用String a = "123"时，在内存中开辟了一个新的空间来存储"123"，但当
     *  我们继续使用a = a + "45"时，实际上是创建一个一个新的String对象a，然后将原先a的值与"45"进行拼接，得到"12345"，然后将这个值赋给了新
     *  的a对象，原先的a对象则会被JVM的垃圾回收机制回收，也就是说原先的str对象并没有被更改，因此速度会较慢。
     *  存在的失误：
     *      在开始的时候没有对数据进行检查，应首先检查传入的StringBuffer对象是否为空或长度是否为0.（及其重要！！！）
     */
    public static String replaceSpace(StringBuffer str) {

        if(str == null || str.length() == 0)
            return str.toString();
        int len = str.length();
        int count = checkSpace(str);
        // 根据空格的数目添加定量字符
        for (int i = 0; i < 2 * count; i++) {
            str.append(' ');
        }
        int p1 = len-1, p2 = str.length()-1;
        while (p1 >= 0 && p1!=p2) {
            if (str.charAt(p1) != ' ') {
                str.setCharAt(p2--, str.charAt(p1));
                str.setCharAt(p1--,' ');
            }else {
                p1--;
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }
        }
        return str.toString();
    }

    public static int checkSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer().append("we are happy.");
        System.out.println(replaceSpace(str));
    }
}
