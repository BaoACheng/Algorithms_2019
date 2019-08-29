package sortAlgorithms;

public class Insert_sort {
    /*
     * 插入排序算法
     * 算法思想：
     *   对未排序的数字，在已排序数组中从后向前索引，找到其在序列中的位置进行插入
     *   假定第一个数字有序，从第二个数字开始进行插入，插入时，将前面的元素后移复制，然后找到插入元素的位置后，将该元素放在该位置
     *   Ps: 注意数组越界问题,
     * 算法评估：
     * 时间复杂度：O(n^2)
     *  最好：O(n^2)
     *  最坏：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * Tips:
     */

    public int[] insert_sort(int[] arr) {
        int len = arr.length;
        if (len <= 1)
            return arr;
        int pre_index, current;
        for (int i = 1; i < len; i++) {
            pre_index = i - 1;
            current = arr[i];
            // 这里是插入排序的关键
            // 必须将判定pre_index的判定写在前面，因为若将判定arr[pre_index]与current大小的判定写在前面，当值为-1时会遇到越界错误
            // 在java中，当两个条件相与时进行判定时，即A&&B，那么当A条件不满足时，则直接退出判定，所以B的条件并不会进行，需注意
            while (pre_index >= 0 && arr[pre_index] > current) {
                arr[pre_index + 1] = arr[pre_index];
                pre_index--;
            }
            arr[pre_index + 1] = current;
        }
        return arr;
    }

}
