package Practice;

import java.util.*;

public class NotAllCovered {
    // Mark the ranges and calculate the prefix sum
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] hash = new int[N + 2];
        for (int i = 0; i < M; i++) {
            int Li = sc.nextInt();
            int Ri = sc.nextInt();
            hash[Li]++;
            hash[Ri + 1]--;
        }
        int min = Integer.MAX_VALUE;
        int preSum = 0;
        for (int i = 1; i <= N; i++) {
            preSum += hash[i];
            min = Math.min(preSum, min);
        }
        System.out.println(min);
        sc.close();
    }
}