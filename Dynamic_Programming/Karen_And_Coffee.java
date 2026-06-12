package Dynamic_Programming;

import java.util.Scanner;

public class Karen_And_Coffee {

    /*
     * 3 2 4
     * 91 94
     * 92 97
     * 97 99
     * 
     * 92 94
     * 93 97
     * 95 96
     * 90 100
     * 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int Q = sc.nextInt();
        final int MAX_SIZE = 200002;

        int[] diff = new int[MAX_SIZE];

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            diff[start]++;
            diff[end + 1]--;
        }

        int[] prefix = new int[MAX_SIZE];
        int coverage = 0;
        for(int i = 1 ; i <= 200000 ; i++) {
            coverage += diff[i];
            prefix[i] = prefix[i - 1] + (coverage >= K ? 1 : 0);
        }

        for(int i = 0 ; i < Q ; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(start + "-" + end + " = " + (prefix[end] - prefix[start-1]));
        }

        sc.close();
    }
}
