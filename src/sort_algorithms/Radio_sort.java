package sort_algorithms;

public class Radio_sort {

    /*
     * 算法名称:基数排序
     * 算法思想:
     *  类似桶排序，简单来说就是分发，收集的迭代过程
     *  step 1：将数组中的数字按照关键位置进行分发，依次分发到各个桶中去，如数字的话，即为0-9
     * 算法评估:
     * 时间复杂度: O()
     *  最好: O()
     *  最坏: O()
     * 空间复杂度: O()
     * 稳定性:
     * Tips:
     */
    public int[] radio(int[] arr, int max) {
        int n = 1, k = 0;
        int len = arr.length;
        int[][] temp = new int[10][len];
        int[] order = new int[10];

        while (n < max) {
            for (int num : arr) {
                int digit = (num / n) % 10;
                temp[digit][order[digit]] = num;
                order[digit]++;
            }
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        arr[k++] = temp[i][j];
                    }
                    order[i] = 0;
                }
            }
            n *= 10;
            k = 0;
        }
        return arr;
    }
}
