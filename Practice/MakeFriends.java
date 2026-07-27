package Practice;

import java.util.*;

public class MakeFriends {
    public static int find(int[] leader, int node) {
        if(leader[node] != node) {
            leader[node] = find(leader, leader[node]);
        }
        return leader[node];
    }

    public static void join(int[] leader, int left, int right) {
        int leadL = find(leader, left);
        int leadR = find(leader, right);
        leader[leadR] =  leadL;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] leader = new int[N+1];
        int[][] edges = new int[M+1][2];
        for(int i = 1 ; i <= N ; i++) {
            leader[i] = i;
        }
        for(int i = 1 ; i <= M ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges[i] = new int[]{a, b};
            join(leader, a, b);
        }
        int[] groupCount = new int[N+1];
        int[] edgeCount = new int[N+1];
        for(int i = 1 ; i <= N ; i++) {
            groupCount[find(leader, i)]++; 
        }
        for(int i = 1 ; i <= M ; i++) {
            edgeCount[find(leader, edges[i][0])]++;
        }
        long res = 0;
        for(int i = 1 ; i <= N ; i++) {
            int cnt = groupCount[i];
            res += (1L * cnt * (cnt-1)) / 2 - edgeCount[i];
        }
        System.out.println(res);
    }
}
