package sort_algorithms;

public class Merge_sort {
    /*
   @ 归并排序算法
   @ 算法思想：
   @
   @ 算法评估：
   @ 时间复杂度：O(n^2)
   @  最好：O(n)
   @  最坏：O(n^2)
   @ 空间复杂度：O(1)
   @ 稳定性：稳定
   @ Tips:
   */
    public void merge_sort(int[] arr) {
        if (arr.length == 0)
            return;
        merge_sort(arr, 0, arr.length - 1);
    }

    public void merge_sort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            merge_sort(arr, low, mid);
            merge_sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int len = high - low + 1;
        int[] temp = new int[len];
        int i = low, j = mid + 1, index = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j])
                temp[index++] = arr[i++];
            else
                temp[index++] = arr[j++];
        }
        while (i <= mid)
            temp[index++] = arr[i++];
        while (j <= high)
            temp[index++] = arr[j++];
        for (int m = 0; m < len; m++) {
            arr[m + low] = temp[m];
        }
    }
}
