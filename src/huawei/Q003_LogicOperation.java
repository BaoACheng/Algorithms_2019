package huawei;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Q003_LogicOperation {

    public static void main(String[] args) throws IOException {
        System.setIn(new BufferedInputStream(new FileInputStream("resource\\input.txt")));
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        System.out.println(arr);
        System.out.println(opeartion(arr));
    }

    public static int opeartion(char[] array) {
        int i = 0;
        Stack<Character> help = new Stack<>();
        int index = 0;
        while (i < array.length) {
            //提取括号内的内容，并转交函数处理，得到返回结果，继续压栈
            if (array[i] == ')') {
                //遇到')'就不断出栈，直到遇到'('
                String str = "";
                while (help.peek() != null) {
                    char chTemp = help.pop();
                    if (chTemp == '(')
                        break;
                    else
                        str = chTemp + str;
                }
                //
                help.push(getRes(str.toCharArray(), 0, str.length() - 1));
                i++;
            } else {
                //没有遇到')'就直接入压栈
                help.push(array[i++]);
            }
        }
        if(help.size() == 1)
            return help.pop() - '0';
        char[] finalChar = getChars(help);
        return getRes(finalChar, 0, finalChar.length - 1) - '0';
    }

    //对不含括号的逻辑运算进行处理
    public static char getRes(char[] array, int l, int r) {
        Stack<Character> stack = new Stack<>();
        int index = l;
        //优先处理掉'！'运算符
        while (index <= r) {
            if (array[index] == '!') {
                Object nothing = array[++index] == '0' ? stack.push('1') : stack.push('0');
                index++;
            } else {
                stack.push(array[index++]);
            }
        }
        //取出栈内数据并放入新数组
        char[] help = getChars(stack);
        index = 0;
        //循环遍历处理'|'和'&'运算符
        while (index < help.length) {
            if (help[index] == '&') {
                char num1 = stack.pop();
                char num2 = help[++index];
                Object nothing = (num1 == num2) && (num1 == '1')?stack.push('1'):stack.push('0');
                index++;
            } else if (help[index] == '|') {
                char num1 = stack.pop();
                char num2 = help[++index];
                Object nothing = (num2 == '1') || (num1 == '1')?stack.push('1'):stack.push('0');
                index++;
            } else {
                stack.push(help[index++]);
            }
        }
        return stack.pop();
    }

    public static char[] getChars(Stack<Character> stack) {
        char[] help = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            help[i] = stack.pop();
        }
        return help;
    }
}
