package yuan;

import java.util.Scanner;

public class Q002_getMazeRes {

    public static int b[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public static int k = 1;
    public static int sum = 1;

    public static void dfs(int q, int p, int a[][], int m, int n, int w) {
        for (int i = 0; i < 4; i++) {
            int x = b[i][0];
            int y = b[i][1];
            if (p + x < m && q + y < n && p + x >= 0 && q + y >= 0) {
                if (a[p + x][q + y] > a[p][q]) {
                    k++;
                    if (sum <= k) {
                        sum = k;
                    }
                    dfs(p + x, q + y, a, m, n, w);
                    k--;
                } else {
                    if (w > 0) {
                        k++;
                        if (sum <= k) {
                            sum = k;
                        }
                        dfs(p + x, q + y, a, m, n, --w);
                        k--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        dfs(0, 0, a, m, n, w);
        System.out.println(sum);
    }
}
