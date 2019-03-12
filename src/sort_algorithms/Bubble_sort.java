package sort_algorithms;

public class Bubble_sort {
    /*
    @ 冒泡排序算法
    @ 算法思想：
    @   在每次排序中选择出最小/最大的元素移动到队列的最前/最后端，最终使得序列变为有序
    */

    // 每次迭代从后向前冒泡选出一个最小的数放在序列最前
    public int[] bubble_sort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j-1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    // 每次迭代从前向后冒泡选出一个最大的数放在序列末尾
    public int[] bubble_sort_rev(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i -1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
