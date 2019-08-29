package YiTu;

import java.util.HashMap;
import java.util.Timer;

public class Q000_testHashMap {

    public static HashMap<Integer, Integer> hashMap = new HashMap<>();
    public static int[] mark;

    public static void main(String[] args) {

        int[] list = getRandomArr(1000000);
        //int[] list = {8, -4, 5, 6, -5, -7, 7, 6, -6, 6};
        //循环遍历数组
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.length; i++) {
            min = Math.min(list[i], min);
            max = Math.max(list[i], max);
            if (hashMap.containsKey(list[i]))
                hashMap.put(list[i], hashMap.get(list[i]) + 1);
            else
                hashMap.put(list[i], 1);
        }
        //计算数组长度
        mark = new int[Math.abs(max - min + 1)];
        //这里min可能是负数或正数，因此需要做偏移量
        int sum = 0;
        int m = min;
        for (int i = 0; i < mark.length; i++) {
            if (hashMap.containsKey(m)) {
                sum += hashMap.get(m);
            }
            m++;
            mark[i] = sum;
        }
        long sTime = System.nanoTime();
        System.out.println("\n" + getRange(-7, 8, min));
        long eTime = System.nanoTime();
        System.out.println("程序用时：" + (eTime - sTime) + "ns");
    }

    public static int getRange(int a, int b, int min) {
        return mark[b - min - 1] - mark[a - min] + hashMap.get(b) + hashMap.get(a);
    }

    public static int[] getRandomArr(int num) {
        int[] list = new int[num];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) ((Math.random() - 0.5) * 20000);
        }
        return list;
    }
}

