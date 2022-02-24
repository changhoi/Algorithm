import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        int[] sortedArr = Arrays.stream(times).sorted().toArray();
        long l = 1;
        long r = (long)sortedArr[sortedArr.length - 1] * (long)n;
        while (l <= r) {
            long mid = (l + r) / 2;


            long total = 0;
            for (int t : times) {
                total += mid / t;
            }

            if (total >= n) {
                r = mid - 1;
            } else if (total < n) {
                l = mid + 1;
            }
        }

        return l;
    }
}