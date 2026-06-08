package Dynamic_Programming;

import java.util.Scanner;

public class MaxSum_Row {

    private static long[] getFsMax(long[][] dp, int row, int COL) {
        long fmax = dp[row][0];
        long smax = dp[row][0];
        for(int i = 1 ; i < COL ; i++) {
            if(dp[row][i] > fmax) {
                smax = fmax;
                fmax = dp[row][i];
            }
            else if(dp[row][i] > smax) {
                smax = dp[row][i];
            }
        }

        return new long[]{fmax, smax};
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] matrix = new int[N][M];
        long[][] dp = new long[N][M];

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                matrix[i][j] = sc.nextInt();
                if(i == 0) {
                    dp[i][j] = matrix[i][j];
                }
            }
        }

        for(int i = 1 ; i < N ; i++) {
            long[] fsMax = getFsMax(dp, i-1, M);
            for(int j = 0 ; j < M ; j++) {
                dp[i][j] = matrix[i][j] + (dp[i - 1][j] == fsMax[0] ? fsMax[1] : fsMax[0]);
            }
        }

        System.out.println(getFsMax(dp, N-1, M)[0]);

        sc.close();
    }
}
