package Niuke;

public class Q001_xiaohe {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 2, 5};
        System.out.println(getSmallSum(a, 0, a.length - 1));
    }

    public static int getSmallSum(int[] arr, int left, int right) {
        if (left == right)
            return 0;
        int middle = left + ((right - left) >> 1);
        int leftSum = getSmallSum(arr, left, middle);
        int rightSum = getSmallSum(arr, middle + 1, right);
        int mergeSum = merge(arr, left, middle, right);
        return leftSum + rightSum + mergeSum;
    }

    public static int merge(int[] arr, int left, int middle, int right) {
        int len = right - left + 1;
        int[] help = new int[len];
        int res = 0;
        int i = left, j = middle + 1, index = 0;
        while (i <= middle && j <= right) {
            res += arr[i] < arr[j] ? (right - j + 1) * arr[i] : 0;
            help[index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= middle) {
            help[index++] = arr[i++];
        }
        while (j <= right) {
            help[index++] = arr[j++];
        }
        for (int k = 0; k < len; k++) {
            arr[left + k] = help[k++];
        }
        return res;
    }
}
