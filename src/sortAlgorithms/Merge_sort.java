package sortAlgorithms;

public class Merge_sort {
    /*
     * 归并排序算法
     * 算法思想：
     * 算法评估：
     * 时间复杂度：O(n^2)
     *  最好：O(n)
     *  最坏：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * Tips:
     */
    public void merge(int[] arr) {
        int len = arr.length;
        merge(arr, 0, len - 1);
    }

    public void merge(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            merge(arr, left, mid);
            merge(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {
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

}
