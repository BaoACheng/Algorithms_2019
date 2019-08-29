package DynamicPrograming;


public class Q001_KingAndWorker {

    /*
     * 动态规划：
     *    【最优子结构】、【边界】、【状态转移公式】
     */
    public static void main(String[] args) {
        int n = 5;
        int w = 10;
        int[] g = {400, 350, 300, 200, 500};
        int[] p = {5, 3, 4, 3, 5};
        getBestResult(n, w, g, p);
    }

    /*
     *
     */
    public static void getBestResult(int n, int w, int[] g, int[] p) {
        //记录前一步结果
        int[] preResults = new int[p.length];
        //记录新结果
        int[] results = new int[p.length];

        for (int i = 0; i < p.length; i++) {
            if (i < p[0])
                preResults[i] = 0;
            else
                preResults[i] = g[0];
        }
        print(preResults);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (j < p[i])
                    results[j] = preResults[j];
                else
                    results[j] = Math.max(preResults[j], preResults[j - p[i]] + g[i]);

                preResults = results;
            }
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "");
        }
    }
}
