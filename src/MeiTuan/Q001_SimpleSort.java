package MeiTuan;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q001_SimpleSort {

    public static void main(String[] args) throws IOException {
        System.setIn(new BufferedInputStream(new FileInputStream("resource/meituan01.txt")));
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(",");
        print(arr);
        merge(arr, 0, arr.length-1);
        print(arr);
    }

    public static void print(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }

    public static void merge(String[] arr, int left, int right){
        int mid = (left+right)>>1;
        if (left < right) {
            merge(arr, left, mid);
            merge(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(String[] arr, int left, int mid, int right){
        int len = right - left + 1;
        String[] temp = new String[len];
        int i = left, j = mid + 1, index = 0;
        while (i <= mid && j <= right) {
            // 对比两个单词
            if(compare(arr[i], arr[j]))
                temp[index++] = arr[i++];
            else
                temp[index++] = arr[j++];
        }
        while(i<=mid)
            temp[index++] = arr[i++];
        while(j<=right)
            temp[index++] = arr[j++];
        for (int k = 0; k < len; k++) {
            arr[left + k] = temp[k];
        }
    }

    public static boolean compare(String str1, String str2){
        //处理空字符串排在最前面的情况
        if(str1.length()==0&&str2.length()!=0)
            return true;
        if(str1.length()!=0&&str2.length()==0)
            return false;
        int i = 0,j = 0;
        while(i<str1.length()&&j<str2.length()){
            if(str1.charAt(i)>str2.charAt(j))
                return true;
            else if(str1.charAt(i)<str2.charAt(j))
                return false;
            else {
                i++;
                j++;
            }
        }
        //str2是str1的前缀，则交换顺序
        if(i<str1.length())
            return false;
        if(j<str2.length())
            return true;
        return true;
    }
}
