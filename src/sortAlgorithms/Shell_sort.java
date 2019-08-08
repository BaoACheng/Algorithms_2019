package sortAlgorithms;

public class Shell_sort {
    /*
     * 算法名称: shell排序
     * 算法思想:
     *   shell排序算法算是对插入排序的改进，但其改进的策略在于其偏向选择距离较远的节点进行排序
     *   在shell排序中,实际的排序过程是多组之间交替进行的，通过不断的减少增量，来调整数组部分有序，最终当增量为1时，实现整体数组有序
     *
     * 算法评估:
     * 时间复杂度: O(n^2)
     *  最好: O(n)
     *  最坏: O(n^2)
     * 空间复杂度: O(1)
     * 稳定性: 不稳定
     * Tips:
     */

    public int[] shell(int[] arr) {
        int len = arr.length;
        if (len <= 1)
            return arr;
        // 每次gap自动缩减为上次的一半
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int current = arr[i];
                int preIndex = i - gap;
                // 同样这里也是关键代码，注意要先判定preIndex >= 0, 其实总的来说，shell排序，就是改变了间隔的插入排序
                while (preIndex >= 0 && arr[preIndex] > current) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = current;
            }
        }
        return arr;
    }


}
