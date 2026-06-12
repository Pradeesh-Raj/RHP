package Dynamic_Programming;

import java.util.*;

public class C_Sushi_ATC {

    public static int c_sushi(int[] shari, int[] neta, int N, int M) {
        Arrays.sort(shari);
        Arrays.sort(neta);
        int count = 0;
        int i = N - 1, j = M - 1;
        while(i >= 0 && j >= 0) {
            if(neta[j] <= shari[i] * 2) {
                count++;
                i--;j--;
            }else {
                j--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] shari = new int[N];
        int[] neta = new int[M];
        for(int i = 0 ; i < N ; i++) {
            shari[i] = sc.nextInt();
        }
        for(int i = 0 ; i < M ; i++) {
            neta[i] = sc.nextInt();
        }
        System.out.println(c_sushi(shari, neta, N, M));
        sc.close();
    }
}
