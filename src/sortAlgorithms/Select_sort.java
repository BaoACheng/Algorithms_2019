package sortAlgorithms;

public class Select_sort {
    /*
     * 选择排序算法
     * 算法思想：
     *   将序列分为有序区与无序区，在初始状态下有序区为空，每次迭代中选择一个最小的数字放到有序区，迭代n-1次后整体有序
     * 算法评估：
     * 时间复杂度：O(n^2)
     *  最好：O(n^2)
     *  最坏：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * Tips:
     */

    public int[] select(int[] arr){
        int len  = arr.length;
        if(len <= 1)
            return arr;
        for (int i = 0; i < len - 1; i++) {
            int minCurrent = arr[i];
            int minMark = i;
            for (int j = i; j < len; j++) {
                if(minCurrent > arr[j]){
                    minCurrent = arr[j];
                    minMark = j;
                }
            }
            swap(arr, i, minMark);
        }
        return arr;
    }

    public void swap(int[] arr, int indexA, int indexB){
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

}
