package Practice;

import java.util.*;

public class DisjointSet {
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
        // List<Integer> leader = new ArrayList<>(N+1);
        int[] leader = new int[N+1];
        for(int i = 1 ; i <= N ; i++) leader[i] = i;
        for(int i = 0 ; i < M ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            join(leader, a, b);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 1 ; i <= N ; i++) {
            set.add(find(leader, i));
        }
        System.out.println(set.size());
    }
}
