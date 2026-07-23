package Practice;

import java.util.*;

public class ManyRepunitSum {
    static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
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
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int max = arr[N - 1];
        List<Long> res = new ArrayList<>();
        long carry = 0;
        for (int i = 1; i <= max; i++) {
            int lb = lowerBound(arr, i);
            int sum = N - lb;
            carry += sum;
            res.add((carry % 10));
            carry /= 10;
        }
        while(carry != 0) {
            res.add(carry % 10);
            carry /= 10;
        }
        Collections.reverse(res);
        
        for(Long i : res) {
            System.out.print(i);
        }
        sc.close();
    }
}
