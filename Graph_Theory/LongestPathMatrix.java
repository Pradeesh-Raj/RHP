package Graph_Theory;

import java.util.Scanner;

public class LongestPathMatrix {
    final static int[][] diff = {
        {0,-1},{0,1},{-1,0},{1,0}
    };

    public static int dfs(int[][] matrix, int[][] dp, int R, int C, int row, int col) {
        if(dp[row][col] != 0) {
            return dp[row][col];
        }
        int adjMax = 0;
        for(int i = 0 ; i < R ; i++) {
            int adjR = row + diff[i][0];
            int adjC = col + diff[i][1];
            if(adjR >= 0 && adjR < R && adjC >= 0 && adjC < C && matrix[adjR][adjC] > matrix[row][col]) {
                dfs(matrix, dp, R, C, adjR, adjC);
            }
        }
        dp[row][col] = 1 + adjMax;
        return dp[row][col];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int maxL = 0;
        int[][] dp = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                maxL = Math.max(maxL, dfs(matrix, dp, N, M, i, j));
            }
        }
        System.out.println(maxL);
        sc.close();
    }
}
