package YiTu;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q001_getNumbers {

    public static void main(String[] args) throws IOException {
        System.setIn(new BufferedInputStream(new FileInputStream("resource/input3.txt")));
        Scanner sc = new Scanner(System.in);
        int numofT = sc.nextInt();
        sc.nextLine();
        int numofN, numofM;
        String[] temp;
        for (int i = 0; i < numofT; i++) {
            //读入N个点的坐标
            temp = sc.nextLine().split(" ");
            numofN = Integer.parseInt(temp[0]);
            numofM = Integer.parseInt(temp[1]);
            long[] dots = new long[numofN];
            temp = sc.nextLine().split(" ");
            for (int j = 0; j < numofN; j++) {
                dots[j] = Long.parseLong(temp[j]);
            }
            //读入M个区域的坐标
            int[][] areas = new int[numofM][2];
            for (int j = 0; j < numofM; j++) {
                temp = sc.nextLine().split(" ");
                areas[j][0] = Integer.parseInt(temp[0]);
                areas[j][1] = Integer.parseInt(temp[1]);
            }
            getRange(dots, areas, i + 1);
            if(i!=numofT-1)
                System.out.println();
        }
    }

    public static void getRange(long[] dots, int[][] area, int index) {
        int[] nums = new int[area.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = BiSearch(dots, area[i][1]+0.5) - BiSearch(dots,area[i][0]-0.5);
        }
        System.out.println("Case #" + index + ":");
        print(nums);
    }

    public static int BiSearch(long[] arr, double num){
        int left = 0, right = arr.length-1;
        while(left<=right){
            int mid = (left+right)>>1;
            if(arr[mid]<num)
                left = mid+1;
            else
                right = mid -1;
        }
        return left;
    }


    public static void print(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            System.out.println(arr[i]);
        }
        System.out.print(arr[arr.length-1]);
    }
}
