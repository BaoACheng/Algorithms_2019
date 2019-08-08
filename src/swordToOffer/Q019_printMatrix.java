package swordToOffer;

import java.util.ArrayList;

public class Q019_printMatrix {

    /*
     * 问题描述:
     *  输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
     *  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16,则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * 解决思路(初始):
     *  最初的设想中，是通过设定边界值，即锁定矩阵的四个角，然后通过不断判断当前的位置，与边界位置，决定是否进行转折
     *  设定四个边角的界限为 (0, 0),(0, cols),(rows, cols),(rows, 0)
     *  每当其到达一个边界值时，就将该边界值改变，逐步的缩小范围，然后输出矩阵的值
     * 解决思路(改进):
     *
     * 容易出错的点:
     *  边界判定：若传出一个空二维数组，或只有一行，或只有一列的二维数组，如何进行输出
     * Tips:
     *  在最开始的第一次代码书写中，犯了如下几个错误：
     *  1、将后续中仍有可能使用到的变量提前进行了修改
     *  2、仅考虑到了有2行数据的数组，而忽略了有2组数据的数组
     */

    public static ArrayList<Integer> printMatrix(int[][] array) {
        if (array == null)
            return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int top = 0, left = 0;
        int right = array[0].length - 1, bottom = array.length - 1;

        while (true) {
            for (int i = left; i <= right; i++)
                list.add(array[top][i]);
            for (int i = top + 1; i <= bottom; i++) {
                list.add(array[i][right]);
            }
            //此处判断下界大于上界，是因为当只有一行时，如果仍从右向左读取数据，则会出现重复读两次的问题
            if (bottom > top) {
                for (int i = right - 1; i >= left; i--) {
                    list.add(array[bottom][i]);
                }
            }
            //此处判断右界大于左界，因为当只有一列时，避免出现重复读入数据的问题
            if (right > left) {
                for (int i = bottom - 1; i > top; i--) {
                    list.add(array[i][left]);
                }
            }
            top++;
            left++;
            bottom--;
            right--;
            if (left > right || top > bottom)
                break;
        }
        return list;
    }

    public static void main(String[] args) {
        //int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //int[][] arr = {{1}, {2}, {3}, {4}, {5}};
        //int[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        int[][] arr = {{1, 2, 3, 4, 5}};
        ArrayList list = printMatrix(arr);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
    }
}
