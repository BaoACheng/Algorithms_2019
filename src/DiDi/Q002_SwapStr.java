package DiDi;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q002_SwapStr {

    public static void main(String[] args) throws IOException {
        System.setIn(new BufferedInputStream(new FileInputStream("resource/didi001.txt")));
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        int[] numbers = new int[num];
        char[] operaotrs = new char[num - 1];
        for (int i = 0, j = 0; i < num; i++) {
            // 最后一个位置的话，只保存数字
            if (i == num - 1){
                numbers[i] = Integer.parseInt(str[j]);
                continue;
            }
            numbers[i] = Integer.parseInt(str[j++]);
            operaotrs[i] = str[j++].charAt(0);
        }
        print(numbers);
        swapMain(numbers, operaotrs);
        print(numbers);

    }

    public static void swapMain(int[] nums, char[] ops){
        int i = 0;
        int pre = 0;
        boolean isAdd = false;
        while(i<ops.length){
            if(ops[i] == '+'){
                if(pre == 0)
                    pre = i;
                isAdd = true;
                i++;
            }else {
                // 第一次进入非'+'位置，则对前面进行排序
                if(isAdd == true){
                    isAdd = false;
                    //对所有的加号运算符进行排序
                    merge(nums, pre, i);
                    pre = i-1;
                }
                i++;
            }
        }
    }

    public static void merge(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            merge(arr, left, mid);
            merge(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int len = right - left + 1;
        int[] temp = new int[len];
        int i = left, j = mid + 1, index = 0;
        while (i <= mid && j <= right) {
            if(arr[i]<arr[j])
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

    public static void print(char[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr[arr.length-1]);
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr[arr.length-1]);
    }
}
