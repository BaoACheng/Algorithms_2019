package yuan;

import java.util.Scanner;
import java.util.Stack;

public class Q001_decodeString {

    /*
     * 测试用例：
     * A2B = AAB
     * (AB)2C = ABABC
     * ((AB)2D)B2C = ABDABDBBC
     */
    public static String decodeStr(char[] arr) {
        Stack<Character> stackStr = new Stack<>();
        String res = "";
        int i = 0;
        while (i < arr.length) {
            //如果是数字
            if (arr[i] >= '0' && arr[i] <= '9') {
                int sum = 0;
                while (i<arr.length && arr[i] >= '0' && arr[i] <= '9') {
                    sum = sum * 10 + arr[i++] - '0';
                }
                //若数字前，为右括号，则出栈，直到找到匹配的左括号
                if (stackStr.peek() == ')') {
                    String tempStr = "";
                    //出栈左括号
                    stackStr.pop();
                    while (stackStr.peek() != '(') {
                        tempStr = stackStr.pop() + tempStr;
                    }
                    //出栈左括号
                    stackStr.pop();
                    //入栈元素
                    for (int j = 0; j < sum; j++) {
                        for (int k = 0; k < tempStr.length(); k++) {
                            stackStr.push(tempStr.charAt(k));
                        }
                    }
                } else {
                    char tempChar = stackStr.peek();
                    for (int j = 1; j < sum; j++) {
                        stackStr.push(tempChar);
                    }
                }
            } else {
                stackStr.push(arr[i++]);
            }
        }
        while (!stackStr.isEmpty()) {
            res = stackStr.pop() + res;
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            char[] arr = sc.nextLine().toCharArray();
            System.out.print(decodeStr(arr));
        }
    }
}
