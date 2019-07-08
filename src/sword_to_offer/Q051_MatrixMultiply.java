package sword_to_offer;


public class Q051_MatrixMultiply {
    /*
     * 问题描述:
     *  给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
     *  不能使用除法。
     * 解决思路(初始):
     *  尝试猜测出题人的思路，如果没有最后一句话，那么就是很简单的算法题，而特意加上了不能使用除法，也就是要求我们找到一个比较便捷的方式来找到
     *  除去数A[i]的乘积
     * 解决思路(改进):
     *  看到一个很好的解法，可以省去很多的重复计算，题目的要求，是分开计算A[i]左右两边的数值乘积，因此可以分别计算左右，但改进之处在于，每次保留
     *  上一步的结果留作下一步的使用，因为下一步的目标数值即为当前数值乘以A[i-1]
     * 容易出错的点:
     *
     * Tips:
     *
     */
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0)
            return new int[0];
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int temp = 1;
        for (int i = 0; i < A.length; i++) {
            left[i] = temp;
            temp *= A[i];
        }
        temp = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            right[i] = temp;
            temp *= A[i];
        }
        for (int i = 0; i < A.length; i++) {
            left[i] = left[i] * right[i];
        }
        return left;
    }
}
