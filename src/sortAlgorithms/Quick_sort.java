package sortAlgorithms;

public class Quick_sort {
    /*
    * 快速排序算法
    * 算法思想：
    *   快速排序算法的思想总体在于分而治之，其关键就在于，将数组进行划分，是基准元素的左边都是比它小的数字，右边都是比它大的数字，然后
    * 再对其划分得到的子序列进行迭代。那么快速排序算法的关键就在于如何将数组划分成为我们想要的样子，首先，我们需要确定一个基准元素，一
    * 般原则下，我们选取给出数组中的left元素的位置作为pivot基准。我们定义i，j两个标记，i初始为pivot后的第一个元素位置，j初始为right
    * ，在划分中，我们可以认为，将基准元素从数组中挖出，然后从给出的right往前依次查找，找到第一个比pivot小的数字时，我们将这个位置的元
    * 素拷贝过去，放在pivot的位置，然后从pivot后第一个位置开始，寻找比其大的第一个元素，放到之前记录的位置，依次进行，直到i=j，然后将
    * pivot的值放在这个位置，返回pivot的新位置。在实际操作中，我们会使用较为简单的代码。注释已加入代码中。
    * 算法评估：
    * 时间复杂度：O(n^2)
    *  最好：O(n)
    *  最坏：O(n^2)
    * 空间复杂度：O(1)
    * 稳定性：稳定
    * Tips:
    */
    public int[] quick_sort(int[] arr, int left, int right) {
        if (arr.length == 0)
            return arr;
        if(left > right)
            return arr;
        // 找到pivot在数组中的实际位置
        int partitionIndex = partition(arr, left, right);
        // 对划分得到的两个子序列依次进行快排
        quick_sort(arr, left, partitionIndex - 1);
        quick_sort(arr, partitionIndex + 1, right);

        return arr;
    }

    public int partition(int[] arr, int left, int right) {
        // 记录pivot的位置，从pivot后的一个元素开始
        int pivot = left, index = pivot + 1;
        for (int i = index; i <= right; i++) {
            // 在每次对比中，若当前元素小于pivot，则会进行交换
            // index记录的是当前第一个不小于pivot的元素
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        // 当所有操作完成时，数组会变为如下形式 pivot (小于pivot的序列) (大于pivot的序列)
        // 在该操作进行后，将pivot与小于pivot序列的最后一个元素进行交换，变为 (小于pivot的序列) pivot (大于pivot的序列)
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    public void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    public int[] quick(int[] arr, int left, int right){
        if(arr.length <= 1)
            return arr;
        if(left > right)
            return arr;

        int partitionIndex = getPartition(arr, left, right);
        quick(arr, left, partitionIndex -1);
        quick(arr, partitionIndex + 1, right);

        return arr;
    }

    public int getPartition(int[] arr, int left, int right){
        int pivot =  left, index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if(arr[i] < arr[pivot]){
                swap(arr, i, index);
                index++;
            }
        }

        swap(arr, pivot, index - 1);
        return index - 1;
    }
}
