package swordToOffer;

public class Q001_FindNumInTwoDimArray {
    /*
     * 题目描述：
     *  在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     *  请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 算法思想：
     *  最初考虑：肯定是采用暴力破解的方式，逐个遍历数组中的节点，若查找到，则证明有，若未找到，则说明不存在
     *  简洁思路：在题目中特地描述了数组的特性，同一行中，右边的数字一定比左边大，同一列中下边的数字一定比上边大，因此考虑在这一特性下
     *          能否做出一定的更新改进
     *  思路描述：通过直接取二维数组每行的最后一个元素做判定，若该元素小于目标数字，则该行数字均不需比较，转下一行，若该数字大于目标数字
     *          则说明目标数字若存在，则必定在这一行里，因此遍历向左搜索，存在则输出True，反之则输出False
     */
    public boolean Find(int[][] arr, int target) {
        boolean isExist = false;
        int row = 0, col = arr[0].length - 1;
        while (row < arr.length && col >= 0) {
            int temp = arr[row][col];
            if (temp == target) {
                isExist = true;
                break;
            }
            if (temp < target) {
                row++;
            }
            if (temp > target) {
                col--;
            }
        }
        return isExist;
    }

    public boolean Find_new(int[][] arr, int target) {
        boolean isExist = false;
        int row = arr.length - 1, col = 0;
        while (row >= 0 && col < arr[0].length) {
            if(arr[row][col]==target){
                isExist = true;
                break;
            }
            if(arr[row][col]>target)
                row--;
            else
                col++;
        }

        return isExist;
    }

    public static void main(String[] args) {
        Q001_FindNumInTwoDimArray fn = new Q001_FindNumInTwoDimArray();
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int num = 7;
        if (fn.Find_new(arr, num))
            System.out.printf("True");
        else
            System.out.printf("False");
    }
}
