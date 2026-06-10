package Dynamic_Programming.Strings;

import java.util.*;

public class LongestSubstring {
    public static void longestSubstring(char[] s1, char[] s2, int N1, int N2) {
        int[][] dp = new int[N1+1][N2+1];
        int max = 0;
        int end = -1;
        for(int i = 1 ; i <= N1 ; i++) {
            for(int j = 1 ; j <= N2 ; j++) {
                if(s1[i-1] == s2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(dp[i][j] > max) {
                        max = dp[i][j];
                        end = i - 1;
                    }
                }
            }
        }
        System.out.println("Longest Common Substring Length = " + max);
        if(max > 0) {
            int start = end - max + 1;
            System.out.print("Longest Common Substring is: ");
            for(int i = start ; i <= end ; i++) {
                System.out.print(s1[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s1 = sc.nextLine().toCharArray();
        char[] s2 = sc.nextLine().toCharArray();
        int N1 = s1.length, N2 = s2.length;
        longestSubstring(s1, s2, N1, N2);
        sc.close();

    }
}
