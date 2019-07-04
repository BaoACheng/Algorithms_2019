package sword_to_offer;


public class Q035_InversePairs {
    /*
     * 问题描述:
     *  在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
     *  并将P对1000000007取模的结果输出。 即输出P%1000000007
     * 解决思路(初始):
     *  O(n^2)复杂度算法可以写出，因此此处略去不计
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *  1、当前代码存在问题，但目前没找到原因，代码提交平台AC结果是50%(20190703)
     *     经过排查找到问题：代码逻辑本身没有问题，问题在于当数据过多时，可能会超过int的表示范围，因此需要在对count操作时，先进行取余操作
     *
     */
    public int InversePairs(int[] array) {
        if (array.length == 0 || array == null)
            return 0;

        return InversePairs(array, 0, array.length - 1) % 1000000007;
    }

    public int InversePairs(int[] array, int left, int right) {
        int mid = (left + right) >> 1;
        if (right > left) {
            int left_count = InversePairs(array, left, mid)%1000000007;
            int right_count = InversePairs(array, mid + 1, right)%1000000007;
            int count = InversePairs_main(array, left, mid, right)%1000000007;
            return (count + left_count + right_count)%1000000007;
        }
        return 0;
    }

    public int InversePairs_main(int[] array, int left, int mid, int right) {
        int len = right - left + 1;
        int[] temp = new int[len];
        int i = mid, j = right, index = len - 1, count = 0;
        while (i >= left && j >= mid + 1) {
            if (array[i] > array[j]) {
                temp[index--] = array[i--];
                if(count >= 1000000007)
                    count %= 1000000007;
                count += j - mid;
            } else {
                temp[index--] = array[j--];
            }
        }
        while (i >= left)
            temp[index--] = array[i--];
        while (j >= mid + 1)
            temp[index--] = array[j--];
        for (int k = 0; k < len; k++) {
            array[left + k] = temp[k];
        }
        return count;
    }

    public static void main(String[] args) {
        Q035_InversePairs paris = new Q035_InversePairs();
        int[] arr = {7, 5, 6, 4};
        System.out.println(paris.InversePairs(arr));
    }
}
