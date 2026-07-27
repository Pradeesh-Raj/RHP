package Practice;

import java.util.*;

public class OneDCountry {
    static int upperBound(long[] arr, int target) {
        int low = 1, high = arr.length - 1;
        int res = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                res = mid;
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }
        }
        return res;
    }

    static int lowerBound(long[] arr, int target) {
        int low = 1, high = arr.length - 1;
        int res = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                res = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N + 1];
        long[] preSum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            int val = sc.nextInt();
            preSum[i] = preSum[i - 1] + val;
        }
        int Q = sc.nextInt();
        while (Q > 0) {
            int Li = sc.nextInt();
            int Ri = sc.nextInt();
            int start = lowerBound(arr, Li) - 1;
            int end = upperBound(arr, Ri) - 1;
            System.out.println(preSum[end] - preSum[start]);
            Q--;
        }
        sc.close();
    }
}
