package DP;

import java.util.ArrayList;
import java.util.HashSet;

class Solution01 {
    private int getNString(int n, int time) {
        if(time >= 1) {
            return Integer.parseInt(String.valueOf(n).repeat(time));
        } else return n;
    }

    public int solution(int N, int number) {
        if (N == number) return 1;

        ArrayList<HashSet<Integer>> dp = new ArrayList<>();
        HashSet<Integer> first = new HashSet<>();
        first.add(N);
        dp.add(first);

        for (int i = 1; i <= 8; i++) {
            int j = i - 1;
            int k = 0;
            HashSet<Integer> h = new HashSet<>();
            h.add(getNString(N, i + 1));
            while(j >= k) {
                HashSet<Integer> h1 = dp.get(j);
                HashSet<Integer> h2 = dp.get(k);

                for (int v1 : h1) {
                    for (int v2 : h2) {
                        if (v1 > 0) h.add(v2 / v1);
                        if (v2 > 0) h.add(v1 / v2);

                        h.add(v1 - v2);
                        h.add(v2 - v1);
                        h.add(v1 + v2);
                        h.add(v1 * v2);
                    }
                }
                j--;
                k++;
            }
            if (h.contains(number)) return i + 1;
            dp.add(h);
        }
        return -1;
    }
}