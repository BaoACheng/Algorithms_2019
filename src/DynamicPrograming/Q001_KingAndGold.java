package DynamicPrograming;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q001_KingAndGold {

    public static void main(String[] args) throws IOException {
        System.setIn(new BufferedInputStream(new FileInputStream("resource/gold.txt")));
        Scanner sc = new Scanner(System.in);
        int goldNum = sc.nextInt();
        int workNum = sc.nextInt();
        String[] temp;
        int[] gold = new int[goldNum];
        int[] gPer = new int[goldNum];
        sc.nextLine();
        for (int i = 0; i < goldNum; i++) {
            temp = sc.nextLine().split(" ");
            gold[i] = Integer.parseInt(temp[0]);
            gPer[i] = Integer.parseInt(temp[1]);
        }

        System.out.println(getMaxGold(goldNum, workNum, gold, gPer));
    }

    public static int getMaxGold(int n, int w, int[] g, int[] p) {
        int[] preResult = new int[w+1];
        int[] result = new int[w+1];

        //初始化第一行序列
        for (int i = 0; i <= w; i++) {
            if (i < p[0])
                preResult[i] = 0;
            else
                preResult[i] = g[0];
        }
        print(preResult);

        //开始动态规划
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w+1; j++) {
                //如果当前人数不满足第i个金矿所需要的人数
                if (j < p[i])
                    //直接复制上一条记录的内容
                    result[j] = preResult[j];
                else {
                    //反之，若当前人数比第i个金矿所需要的人数多
                    //我们就对比（上一步计算得到的收益）与（加上当前金矿所需人数的收益）（需要提前减去当前金矿所需人数）
                    result[j] = Math.max(preResult[j], preResult[j - p[i]] + g[i]);
                }
            }
            System.out.println(i+":");
            print(result);
            preResult = result.clone();
        }
        return result[w];
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.format("%5s", arr[i])+"\t");
        }
        System.out.println();
    }
}
