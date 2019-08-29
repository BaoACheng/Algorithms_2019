package HomeworkComp;

import java.util.Scanner;

public class Q001_getSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        String[] sum = new String[n];
        for (int i = 0; i < n; i++) {
            if(i==0)
                sum[i] = x+"";
            else
                sum[i] = multi(sum[i-1], x+"");
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            res = simpleAdd(res, sum[i]);
        }
        System.out.println(getRes(res));

    }

    public static String simpleAdd(String str1, String str2){
        if(str1 == null||str1=="")
            return str2;
        if(str2 == null||str2=="")
            return str1;

        StringBuffer res = new StringBuffer();
        StringBuffer s1 = new StringBuffer(str1).reverse();
        StringBuffer s2 = new StringBuffer(str2).reverse();

        int len1 = str1.length();
        int len2 = str2.length();
        int len;
        int isOverFlow = 0;
        int num;

        if(len1<len2){
            len = len2;
            int count = len2-len1;
            while(count-->0)
                s1.append('0');
        }else {
            len = len1;
            int count = len1-len2;
            while(count-->0)
                s2.append('0');
        }
        for (int i = 0; i < len; i++) {
            num = s1.charAt(i)-'0'+s2.charAt(i)-'0'+isOverFlow;
            if(num>=10){
                isOverFlow = 1;
                num-=10;
            }else {
                isOverFlow = 0;
            }
            res.append(String.valueOf(num));
        }
        if(isOverFlow==1){
            res.append(1);
        }
        return res.reverse().toString();
    }

    public static String multi(String str1, String str2){
        String res = "";
        int len1 = str1.length()-1;
        int len2 = str2.length()-1;
        int[] muls = new int[str1.length()+str2.length()];
        for (int i = len1; i >=0; i--) {
            for (int j = len2; j>=0 ; j--) {
                int mul = (str1.charAt(i)-'0')*(str2.charAt(j)-'0');
                mul+=muls[i+j+1];
                muls[i+j+1] = mul%10;
                muls[i+j] = mul/10;
            }

        }
        int start = 0;
        while(start<muls.length&&muls[start]==0){
            start++;
        }
        String r = "";
        while(start<muls.length){
            r+=muls[start++];
        }
        return r;
    }

    public static long getRes(String str){
        long res = 0;
        for (int i = 0; i < str.length(); i++) {
            res = (res*10+str.charAt(i)-'0')%998244353;
        }
        return res;
    }
}
