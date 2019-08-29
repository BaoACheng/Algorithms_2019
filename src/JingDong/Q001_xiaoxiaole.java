package JingDong;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class location {
    int row;
    int col;

    public location(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Q001_xiaoxiaole {

    static int MIN_VALUE = 25;

    public static void main(String[] args) throws IOException {
        System.setIn(new BufferedInputStream(new FileInputStream("resource/xiaoxiaole.txt")));
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        print(matrix);
        down(matrix);
        System.out.println();
        print(matrix);
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void xiaoxiaole(int[][] matrix) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int[][] copy = Arrays.copyOf(matrix,25);
            }
        }
    }

    public static void checkNumber(int[][] matrix, int i, int j) {
        int[][] mark = new int[5][5];
        mark[i][j] = 1;
        int count = 1;
        Queue<location> queue = new LinkedList<>();
        Queue<location> res = new LinkedList<>();
        queue.offer(new location(i, j));
        res.offer(new location(i, j));
        while (!queue.isEmpty()) {
            location l = queue.poll();
            int a = l.row, b = l.col;
            if (mark[a + 1][b] == 0 && mark[a + 1][b] == matrix[i][j]) {
                mark[a + 1][b] = 1;
                location newl = new location(a + 1, b);
                queue.offer(newl);
                res.offer(newl);
            }
            if (mark[a - 1][b] == 0 && mark[a - 1][b] == matrix[i][j]) {
                mark[a - 1][b] = 1;
                location newl = new location(a - 1, b);
                queue.offer(newl);
                res.offer(newl);
            }
            if (mark[a][b + 1] == 0 && mark[a][b + 1] == matrix[i][j]) {
                mark[a][b + 1] = 1;
                location newl = new location(a, b + 1);
                queue.offer(newl);
                res.offer(newl);
            }
            if (mark[a][b - 1] == 0 && mark[a][b - 1] == matrix[i][j]) {
                mark[a][b - 1] = 1;
                location newl = new location(a, b - 1);
                queue.offer(newl);
                res.offer(newl);
            }
        }
    }

    public static void down(int[][] matrix) {
        for (int i = 0; i < 5; i++) {
            for (int j = 4; j >= 0; j--) {
                if (matrix[j][i] != -1) {
                    // 找到下面的格子
                    int p1 = j + 1;
                    int p2 = j;
                    // 判断一下是否越界
                    while (p1 <= 4) {
                        // 不越界且下方格子被消除
                        if (matrix[p1][i] == -1) {
                            //实现下沉
                            matrix[p1][i] = matrix[p2][i];
                            matrix[p2][i] = -1;
                            ++p1;
                            ++p2;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

}
