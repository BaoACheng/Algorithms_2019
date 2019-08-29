package YiTu;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q003_getRelation {

    public static void main(String[] args) throws IOException {
        System.setIn(new BufferedInputStream(new FileInputStream("resource/input4.txt")));
        Scanner sc = new Scanner(System.in);
        int n, m, k;
        String[] temp = sc.nextLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        k = Integer.parseInt(temp[2]);
        int[][] equal = new int[n][n];
        initArr(equal);
        int[][] small = new int[n][n];
        initArr(small);
        for (int i = 0; i < m; i++) {
            temp = sc.nextLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);
            if (c == 0)
                setValue(small, a, b);
            else
                setValue(equal, a, b);
        }
        for (int i = 0; i < k; i++) {
            temp = sc.nextLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            System.out.println(check(a,b,equal, small));
        }
    }

    public static int check(int a, int b, int[][] equal, int[][] small){
        for (int i = 0; i < equal[0].length; i++) {
            if(equal[a-1][i] == b)
                return 0;
        }
        return 0;
    }

    public static void hasValue(int[][] arr, int value){

    }

    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void initArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = -1;
            }
        }
    }

    public static void setValue(int[][] arr, int a, int b) {
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[a-1][i] == -1) {
                arr[a-1][i] = b;
                break;
            }
        }
    }
}
