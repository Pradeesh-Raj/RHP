package Practice;

import java.util.*;

public class TwoDigitStrings {
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String n1 = sc.nextLine();
            String n2 = sc.nextLine();
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            int sum = 0;
            for (char ch : n1.toCharArray()) {
                sum = (sum + (ch - '0')) % 10;
                s1.append(sum);
            }
            sum = 0;
            for (char ch : n2.toCharArray()) {
                sum = (sum + (ch - '0')) % 10;
                s2.append(sum);
            }

            if (s1.charAt(s1.length() - 1) != s2.charAt(s2.length() - 1)) {
                System.out.println(-1);
                continue;
            }

            System.out.println(longestCommonSubsequence(s1.toString(), s2.toString()));
        }
        sc.close();
    }
}
