package Dynamic_Programming;

import java.util.Scanner;

public class MaxSum_Col {
    private static long[] getFsMax(long[][] dp, int col, int ROW) {
        long fmax = dp[0][col];
        long smax = dp[0][col];
        for(int i = 1 ; i < ROW ; i++) {
            if(dp[i][col] > fmax) {
                smax = fmax;
                fmax = dp[i][col];
            }
            else if(dp[i][col] > smax) {
                smax = dp[i][col];
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
                if(j == 0) {
                    dp[i][j] = matrix[i][j];
                }
            }
        }

        for(int i = 1 ; i < M ; i++) {
            long[] fsMax = getFsMax(dp, i-1, N);
            for(int j = 0 ; j < N ; j++) {
                dp[j][i] = matrix[j][i] + (dp[j][i - 1] == fsMax[0] ? fsMax[1] : fsMax[0]);
            }
        }

        System.out.println(getFsMax(dp, M-1, N)[0]);

        sc.close();
    }
}
