package swordToOffer;

public class Q000_AllTestFile {
    /*
     * 简单的代码测试
     */
    int a = 3;

    public void change() {
        a = 5;
    }

    public void testString() {
        String a = "Hello";
        String b = "Hello";
        if (a == b)
            System.out.println("a = b");
        String c = new String("Hello");
        if (a == c)
            System.out.println("a = c");
        else
            System.out.println("a != c");
    }

    public void testChangString(StringBuffer str, int indexA, int indexB) {
        System.out.println("str = " + str);
        char temp = str.charAt(indexA);
        str.setCharAt(indexA, str.charAt(indexB));
        str.setCharAt(indexB, temp);
        System.out.println("str = " + str);
    }

    public static void getMaxNumber(double a, double b) {
        double res = a % b;
        System.out.println(res);
    }

    public static void main(String[] args) {
        Q000_AllTestFile test = new Q000_AllTestFile();
        StringBuffer buff = new StringBuffer("abc");
        test.testChangString(buff, 1, 2);
        getMaxNumber(100,33);
    }
}
