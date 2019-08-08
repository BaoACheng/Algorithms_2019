package learning;

public class kml_Algorithm {

    /*
     * KMP算法的核心在于计算next数组，一切的简化都基于这个神奇的next数组
     * 算法复杂度O(N+M)
     */

    public static void main(String[] args) {
        String str = "ssdfgasdbababa";
        String dest = "ababa";
        int[] next = getNext(dest);
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i]+" ");
        }
        System.out.println();
        System.out.print(kmp(str, dest, next));
    }

    //实现找到模式串的next
    public static int[] getNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(j) != dest.charAt(i)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j))
                j++;
            next[i] = j;
        }
        return next;
    }

    public static int kmp(String str, String dest, int[] next) {
        for (int i = 0, j = 0; i < str.length(); i++) {
            //当不匹配时，循环的将模式串后移
            while (j > 0 && str.charAt(i) != dest.charAt(j))
                j = next[j - 1];
            //若目标串与模式串相同，则共同后移
            if (str.charAt(i) == dest.charAt(j))
                j++;
            //若j循环到最后，表示找到子串
            if (j == dest.length())
                return i - j + 1;
        }
        return 0;
    }
}
