package sortAlgorithms;

public class Heap_sort {
    /*
     * 算法名称:堆排序
     * 算法思想:
     *   所使用的数据结构即为完全二叉树，堆顶的数字一定比其子节点的数字大，但左右子节点的大小并无规定
     *   step 1：首先根据大小顺序将初始序列构建为大顶堆，首先从第一个非叶子节点开始排序，定位为len/2-1，然后按照从后到前，从左到右的顺序依次调整，
     *   构建相应的堆。在构建堆的过程中，注意调整后，要检查以其为根节点的树是否符合规则。
     *   step 2：将堆顶的数字与最后一个数字交换，然后堆的长度减一，重新调整堆，重复上述过程len-1次，则数组有序
     * 算法评估:
     * 时间复杂度: O(nlog(n))
     *  最好: O(nlog(n))
     *  最坏: O(nlog(n))
     * 空间复杂度: O(1)
     * 稳定性:
     * Tips:
     */
    public int[] heap_sort(int[] arr) {
        int len = arr.length;
        if (len <= 1)
            return arr;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
        for (int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
        return arr;
    }

    public void adjustHeap(int[] arr, int root, int len) {
        int temp = arr[root];
        for (int k = 2 * root + 1; k < len; k = 2 * k + 1) {
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[root] = arr[k];
                root = k;
            } else {
                break;
            }
        }
        arr[root] = temp;
    }

    public void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
