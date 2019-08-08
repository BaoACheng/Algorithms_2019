package dajiang;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q002_getMazePath {

    public static int[][] dirc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        String filepath = "resource/input.txt";
        System.setIn(new BufferedInputStream(new FileInputStream(filepath)));
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int threshold = sc.nextInt();
        int count = 0;
        int[][] maze = new int[rows][cols];
        maze[0][0] = 1;
        dfs(0, 0, maze, rows, cols, threshold);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == 1)
                    ++count;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int sRow, int sColum, int[][] maze, int rows, int cols, int threshold) {
        for (int i = 0; i < 4; i++) {
            int x = dirc[i][0];
            int y = dirc[i][1];
            if (sRow + x >= 0 && sRow + x < rows && sColum + y >= 0 && sColum + y < cols
                    && threshold >= getSum(sColum+x)+getSum(sColum+y) && maze[sRow + x][sColum + y] == 0) {
                maze[sRow + x][sColum + y] = 1;
                dfs(sRow + x, sColum + y, maze, rows, cols, threshold);
            }
        }
    }

    public static int getSum(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
