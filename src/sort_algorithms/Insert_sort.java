package sort_algorithms;

public class Insert_sort {
    /*
    @ 插入排序算法
    @ 算法思想：
    @   对未排序的数字，在已排序数组中从后向前索引，找到其在序列中的位置进行插入
    @ 算法评估：
    @ 时间复杂度：O(n^2)
    @  最好：O(n^2)
    @  最坏：O(n^2)
    @ 空间复杂度：O(1)
    @ 稳定性：稳定
    @ Tips:
    */

    public int[] insert_sort(int[] arr){
        int len = arr.length;
        int pre_index, current;
        for(int i=1; i<len; i++){
            pre_index = i-1;
            current = arr[i];
            while(pre_index>=0 && arr[pre_index] > current){
                arr[pre_index + 1] = arr[pre_index];
                pre_index--;
            }
            arr[pre_index + 1] = current;
        }
        return arr;
    }
}
