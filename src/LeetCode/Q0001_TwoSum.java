package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Q0001_TwoSum {

    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int target = 6;
        print(twoSum(arr, target));
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr[arr.length-1]);
    }

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if(map.containsKey(num)){
                return new int[]{map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
