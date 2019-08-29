package swordToOffer;


import java.util.HashMap;

public class Q050_FindDuplicate {
    /*
     * 问题描述:
     *  在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
     *  请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     * 解决思路(初始):
     *  数组中必然有重复的数字，那么首先想到的办法是对数组进行排序，然后依次对比前一元素与后一元素是否相同，若相同则输出，但算法的复杂度最低为
     *  0(nlogn)
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean res = false;
        duplication[0] = -1;
        if(numbers == null || numbers.length == 0)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }else {
                map.put(numbers[i], 1);
            }
        }
        return res;
    }
}
