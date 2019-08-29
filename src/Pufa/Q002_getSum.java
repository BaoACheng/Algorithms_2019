package Pufa;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q002_getSum {

    public static void main(String[] args) throws IOException {
        System.setIn(new BufferedInputStream(new FileInputStream("resource/pufa002.txt")));
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getSum(s));
    }

    public static int getSum(String s) {
        int res = 0;
        char[] ch = s.toCharArray();
        int[] nums = new int[3];
        int index = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                int sum = 0;
                int j = i;
                while (j < ch.length && ch[j] <= '9' && ch[j] >= '0') {
                    sum = sum * 10 + ch[j++] - '0';
                }
                i = j;
                nums[index++] = sum;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }
}
