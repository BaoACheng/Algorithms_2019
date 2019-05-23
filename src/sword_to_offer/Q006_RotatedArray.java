package sword_to_offer;

public class Q006_RotatedArray {
    /*
     * 问题描述:
     *    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * 解决思路(初始):
     *    题目中有给出，旋转数组是初始有序的数组(非减排序)，即在原始状态中，前一个元素必然不大于后一个元素，那么我们根据这一特点，可以寻找
     *  不满足这一条件的元素，即当找到第一个元素i其值大于i+1位置的值时，即找到了该数组中的最小元素,该方法的时间复杂度为O(n)
     * 解决思路(改进):
     *    还是根据已知条件，旋转数组是初始有序的，而旋转数组可以较为明确的划分为两部分，而两部分数组又是有序的，最小的目标元素将两者分割，
     *  那么我们可以尝试利用二分查找来进行，
     * 容易出错的点:
     *  1、传入数组为空
     *  2、传入数组本身即为有序，即旋转了数组前0个元素
     *  3、二分查找中出现了pre,mid,end所指向的元素均相同时
     * Tips:
     *  当我们遇到查找问题时，若查找对象可以分为较为明显的两部分，且有一固定边界，则可以考虑二分查找实现O(logn)的效率
     */


    public static int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0)
            return 0;
        if (len == 1 || array[0] < array[len - 1])
            return array[0];

        int pre = 0, end = len - 1, mid;

        while (pre < end) {
            if (end - pre == 1)
                return array[end];

            mid = (pre + end) / 2;
            if (array[mid] == array[end] && array[mid] == array[pre])
                return findMin(array, pre, end);
            if (array[mid] > array[end]) {
                pre = mid;
                continue;
            }
            if (array[mid] < array[pre]) {
                end = mid;
                continue;
            }
        }
        return 0;
    }

    public static int findMin(int[] array, int pre, int end) {
        int min = array[pre];
        int len = end - pre + 1;
        for (int i = 1; i < len; i++) {
            if (array[pre + i] < array[pre + i - 1]) {
                return array[pre + i];
            }
        }
        return min;
    }

    public int minNumberInRotateArray_original(int[] array) {
        int len = array.length;
        if (len == 0)
            return 0;
        int min = array[0];
        for (int i = 1; i < len; i++) {
            if (array[i] < array[i - 1])
                return array[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 1, 2};
        int[] b = {1, 2, 3, 4, 5};
        int[] c = {1, 0, 1, 1, 1};
        int[] d = {2, 3, 4, 5, 6, 7, 9, 1};
        int[] e = {8, 9, 10, 5, 6, 7};
        System.out.println(minNumberInRotateArray(a));
        System.out.println(minNumberInRotateArray(b));
        System.out.println(minNumberInRotateArray(c));
        System.out.println(minNumberInRotateArray(d));
        System.out.println(minNumberInRotateArray(e));
    }
}
