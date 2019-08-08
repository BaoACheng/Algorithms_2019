package PinDupDuo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q001_orderArray {
    /*
     * A 是几乎完全升序序列
     * B 是随机序列
     * 从 A 中找到不完全位置，然后在B中选择一个合适的序列进行输出
     */

    public static int[] getIndex(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                return new int[]{i, i + 1};
            }
        }
        return new int[]{-1};
    }

    public static List<Integer> getOrderB(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);
        return list;
    }

    public static boolean orderArrayofA(int[] arr, List<Integer> list, int index) {
        for (int i = list.size() - 1; i >= 0; i--) {
            int temp = list.get(i);
            if (index == 0) {
                if (temp < arr[index + 1]) {
                    arr[index] = temp;
                    return true;
                }
            } else if (index == arr.length - 1) {
                if (temp > arr[index - 1]) {
                    arr[index] = temp;
                    return true;
                }
            } else {
                if (temp > arr[index - 1] && temp < arr[index + 1]) {
                    arr[index] = temp;
                    return true;
                }
            }
        }
        return false;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[arr.length - 1]);
    }

    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
        String[] strA = scan.nextLine().split(" ");
        String[] strB = scan.nextLine().split(" ");
        int[] arrA = new int[strA.length];
        int[] arrB = new int[strB.length];

        for (int i = 0; i < strA.length; i++) {
            arrA[i] = Integer.parseInt(strA[i]);
        }
        for (int i = 0; i < strB.length; i++) {
            arrB[i] = Integer.parseInt(strB[i]);
        }*/
        int[] arrA = {1, 3, 7, 10, 10};
        int[] arrB = {5, 7, 9, 12};
        List<Integer> list = getOrderB(arrB);
        int[] index = getIndex(arrA);
        for (int i = index.length - 1; i >= 0; i++) {
            boolean check = orderArrayofA(arrA, list, index[i]);
            if (check) {
                printArr(arrA);
                break;
            }
            if (i == 0 && !check) {
                System.out.print("NO");
            }
        }
    }
}
