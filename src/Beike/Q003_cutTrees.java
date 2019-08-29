package Beike;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q003_cutTrees {

    public static void main(String[] args) throws IOException {
        System.setIn(new BufferedInputStream(new FileInputStream("resource/input5.txt")));
        Scanner sc =  new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int[][] trees=new int[num][3];
        for (int i = 0; i < num; i++) {
            String[] temp = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                trees[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int sum = 0;
        int gongju = 1;
        for (int i = 0; i < num; i++) {
            //当前工具耗时小，选择当前工具，当前工具耗时较大，但转换工具+工具用时相比之下工具较小
            if(trees[i][gongju]<=trees[i][1-gongju]||trees[i][1-gongju]+trees[i][2]>=trees[i][gongju]){
                sum+=trees[i][gongju];
            }else{
                //转换工具，用时加上转换后的工具用时以及转换用时
                gongju = 1-gongju;
                sum+=trees[i][gongju]+trees[i][2];
            }
        }
        System.out.println(sum);
    }


}
