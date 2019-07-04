package sword_to_offer;


public class Q037_GetNumberOfK {
    /*
     * 问题描述:
     *  统计一个数字在排序数组中出现的次数。
     * 解决思路(初始):
     *  在最初读题时，没有太理解到题目所考察的侧重点，初步的想法就是遍历数组，找到该节点，然后统计其出现的次数，这样的时间复杂度为O(n),后想到可以
     *  使用折半查找来寻找目标数字，然后向前向后统计次数，这样的时间复杂度为O(logn)
     * 解决思路(改进):
     *  剑指OFFER中所给的思路过于复杂，在剑指OFFER的讨论区，有一个很简洁的思路，因为这是一个排序数组（貌似所有的数据都是整数）,因此我们对二分
     *  查找方法进行改动，不在最后判定该元素是否为目标元素，则会找到最接近该元素的位置，因此我们将目标元素分别设定为(k+0.5)与(k-0.5),因此我们
     *  会得到前后的位置，将输出两元素之间的数据数目即可。
     * 容易出错的点:
     *
     * Tips:
     *
     */
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int right = BiSearch(array, k + 0.5);
        int left = BiSearch(array, k - 0.5);
        return right - left;
    }

    public int BiSearch(int[] array, double num) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (array[mid] < num)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Q037_GetNumberOfK num = new Q037_GetNumberOfK();
        int[] array = {1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        System.out.println(num.GetNumberOfK(array, 3));
    }
}
