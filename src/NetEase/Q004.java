package NetEase;

import java.util.*;

public class Q004 {

    public static int BiSearch(int[] array, double num) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (array[mid] < num)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public static void weihu(int[] array, int x){
        int index = BiSearch(array, x - 0.5);
        int count = 0;
        for (int i = index; i < array.length; i++) {
            array[i] -= 1;
            count ++;
        }
        System.out.println(count);
    }

    public static void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void sortArray(int[] arr){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int pnum = sc.nextInt();
        int[] pArray = new int[pnum];
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = sc.nextInt();
        }
        sortArray(array);
        for (int i = 0; i < pnum; i++) {
            pArray[i] = sc.nextInt();
        }
        for (int i = 0; i < pnum; i++) {
            weihu(array, pArray[i]);
        }
    }
}
