package sort_algorithms;

public class Select_sort {
    /*
    @ 选择排序算法
    @ 算法思想：
    @   将序列分为有序区与无序区，在初始状态下有序区为空，每次迭代中选择一个最小的数字放到有序区，迭代n-1次后整体有序
    @ 算法评估：
    @ 时间复杂度：O(n^2)
    @  最好：O(n^2)
    @  最坏：O(n^2)
    @ 空间复杂度：O(1)
    @ 稳定性：不稳定
    @ Tips:
    */

    public int[] select_sort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int min_index = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[min_index]){
                    min_index = j;
                }
            }
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
        }
        return array;
    }
}
