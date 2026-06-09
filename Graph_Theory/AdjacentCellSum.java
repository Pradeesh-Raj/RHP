package Graph_Theory;

import java.util.*;

public class AdjacentCellSum {
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
        int[][] adjSum = new int[N][M];
        int[][] diff = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };
        for (int i = 0; i < N; i++) {
            for(int j = 0 ; j < M ; j++) {
                for(int k = 0 ; k < 8 ; k++) {
                    int adjR = i + diff[k][0];
                    int adjC = j + diff[k][1];
                    if(adjR >= 0 && adjR < N && adjC >= 0 && adjC < M) {
                        adjSum[i][j] += matrix[adjR][adjC];
                    }
                }
            }
        }

        for(int[] i : adjSum) {
            for(int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
        sc.close();

    }
}