package Practice;

import java.util.*;

class HeightComparator implements Comparator<List<Long>> {
    @Override
    public int compare(List<Long> a, List<Long> b) {
        return (int)(b.get(0) - a.get(0));
    }
}


public class TallestMoment {

    static int upperBound(List<Long> arr, int target) {
        int low = 0, high = arr.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) > target) {
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        List<List<Long>> pairs = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            pairs.add(Arrays.asList(sc.nextLong(), sc.nextLong()));
        }
        Collections.sort(pairs, new HeightComparator());
        List<Long> times = new ArrayList<>();
        List<Long> heights = new ArrayList<>();
        long till = 0;
        for(int i = 0 ; i < N ; i++) {
            long height = pairs.get(i).get(0);
            long time = pairs.get(i).get(1);
            if(time <= till) {
                continue;
            }
            till = time;
            heights.add(height);
            times.add(time);
        }
        int Q = sc.nextInt();
        while(Q-- > 0) {
            int Ti = sc.nextInt();
            int UB = upperBound(times, Ti);
            System.out.println(heights.get(UB));
        }
        sc.close();
    }
}

