package Practice;

import java.util.*;

public class NikitaBooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            long balance = 0;
            boolean ok = true;
            for (int j = 1; j <= n; j++) {
                int val = sc.nextInt();
                if (val > j) {
                    balance += (val - j);
                } else {
                    int needed = j - val;
                    if (balance < needed) {
                        ok = false;
                    } else {
                        balance -= needed;
                    }
                }
            }
            System.out.println(ok ? "YES" : "NO");
        }
        sc.close();
    }
}
